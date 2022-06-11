package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();

        Deque<Player> players = new ArrayDeque<>(civilPlayers);
        Deque<Gun> guns = new ArrayDeque<>(gunRepository.getModels());

        Player player = players.poll();
        Gun gun = guns.poll();

        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int fire = gun.fire();
                player.takeLifePoints(fire);
            }

            if (gun.canFire()) {
                player = players.poll();
            } else { //if(player != null && player.isAlive())
                gun = guns.poll();
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Deque<Gun> gunsCivil = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun civilGun = gunsCivil.poll();

                while (civilGun != null) {
                    while (civilGun.canFire() && mainPlayer.isAlive()) {
                        mainPlayer.takeLifePoints(civilGun.fire());
                    }

                    if (!mainPlayer.isAlive()) {
                        return;
                    }

                    civilGun = gunsCivil.poll();
                }
            }
        }
    }
}
