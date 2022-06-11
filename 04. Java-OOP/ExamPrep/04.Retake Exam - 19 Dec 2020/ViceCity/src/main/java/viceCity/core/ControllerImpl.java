package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private List<Player> players;
    private List<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new ArrayList<>();
        this.guns = new ArrayList<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        players.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }

        guns.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns == null || guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun = guns.stream().findFirst().get();

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            guns.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        if (players.stream().noneMatch(player -> player.getName().equals(name))) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        Player playerFind = players.stream().
                filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);
//
//        playerFind.getGunRepository().add(gun);
//        guns.remove(gun);

        for (Player player : players) {
            if (player.getName().equals(name)) {
                player.getGunRepository().add(gun);
                guns.remove(gun);
                break;
            }
        }

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, players);

        if (mainPlayer.getLifePoints() == 100 && players.stream().allMatch(player -> player.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }
        StringBuilder builder = new StringBuilder();

        List<Player> deadPlayers = players.stream()
                .filter(player -> !player.isAlive())
                .collect(Collectors.toList());

        List<Player> alivePlayers = players.stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());

        builder.append(FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, alivePlayers.size()));

        return builder.toString().trim();
    }
}

