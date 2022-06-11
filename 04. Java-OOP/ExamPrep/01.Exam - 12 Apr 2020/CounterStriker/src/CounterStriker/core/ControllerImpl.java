package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type) {
            case "Pistol":
                guns.add(new Pistol(name, bulletsCount));
                break;
            case "Rifle":
                guns.add(new Rifle(name, bulletsCount));
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if (this.guns.findByName(gunName) == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Gun gun = this.guns.findByName(gunName);

        switch (type) {
            case "Terrorist":
                players.add(new Terrorist(username, health, armor, gun));
                break;
            case "CounterTerrorist":
                players.add(new CounterTerrorist(username, health, armor, gun));
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }

    @Override
    public String report() {
        List<Player> terrorists = this.players.getModels().stream()
                .filter(p -> p instanceof Terrorist)
                .collect(Collectors.toCollection(ArrayList::new));
        List<Player> counterTerrorists = this.players.getModels().stream()
                .filter(p -> p instanceof CounterTerrorist)
                .collect(Collectors.toCollection(ArrayList::new));

        terrorists = getSortedPlayers(terrorists);
        counterTerrorists = getSortedPlayers(counterTerrorists);

        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();

        printOutput(counterTerrorists, builder, separator);

        printOutput(terrorists, builder, separator);

        return builder.toString().trim();
    }

    private ArrayList<Player> getSortedPlayers(List<Player> models) {
        return models.stream()
                .sorted(Comparator
                        .comparingInt(Player::getHealth)
                        .reversed()
                        .thenComparing(Player::getUsername))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void printOutput(List<Player> models, StringBuilder builder, String separator) {
        for (Player player : models) {
            builder.append(String.format("%s: %s", player.getClass().getSimpleName(), player.getUsername()))
                    .append(separator)
                    .append(String.format("--Health: %d", player.getHealth()))
                    .append(separator)
                    .append(String.format("--Armor: %d", player.getArmor()))
                    .append(separator)
                    .append(String.format("--Gun: %s", player.getGun().getName()))
                    .append(separator);
        }
    }
}
