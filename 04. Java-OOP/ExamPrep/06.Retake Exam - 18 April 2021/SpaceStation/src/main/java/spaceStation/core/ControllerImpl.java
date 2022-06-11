package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private List<Astronaut> astronauts;
    private List<Planet> planets;
    private List<Planet> exploredPlanets;
    private Mission mission;

    public ControllerImpl() {
        this.astronauts = new ArrayList<>();
        this.planets = new ArrayList<>();
        this.exploredPlanets = new ArrayList<>();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronauts.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        Arrays.stream(items).forEach(item -> planet.getItems().add(item));

        planets.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        boolean isNotExist = astronauts.stream()
                .noneMatch(astronaut -> astronaut.getName().equals(astronautName));
        if (isNotExist) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        Astronaut astronautForRetire = astronauts.stream()
                .filter(astronaut -> astronaut.getName().equals(astronautName))
                .findFirst()
                .orElse(null);
        
        astronauts.remove(astronautForRetire);

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        boolean isNoOneHaveNeededOxygen = astronauts.stream().noneMatch(astronaut -> astronaut.getOxygen() > 60);
        if (isNoOneHaveNeededOxygen) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        List<Astronaut> astronautsWithNeededOxygen = astronauts.stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());

        Planet planetForExplore = planets.stream()
                .filter(planet -> planet.getName().equals(planetName))
                .findFirst()
                .orElse(null);

        mission.explore(planetForExplore, astronautsWithNeededOxygen);

        exploredPlanets.add(planetForExplore);
        List<Astronaut> deadAstronauts = astronautsWithNeededOxygen.stream()
                .filter(astronaut -> astronaut.getOxygen() <= 0)
                .collect(Collectors.toList());

        return String.format(PLANET_EXPLORED, planetName, deadAstronauts.size());
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets.size()))
                .append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        for (Astronaut astronaut : astronauts) {
            String bagInfo = astronaut.getBag().getItems().isEmpty()
                    ? "none"
                    : astronaut.getBag().getItems().stream()
                    .collect(Collectors.joining(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER));

            builder.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator())
                    .append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, bagInfo))
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
