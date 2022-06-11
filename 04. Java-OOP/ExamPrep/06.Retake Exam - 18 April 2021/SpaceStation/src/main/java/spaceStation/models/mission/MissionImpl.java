package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;


public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Deque<String> items = new ArrayDeque<>(planet.getItems());
        Deque<Astronaut> astronautsSet = new ArrayDeque<>(astronauts);


        while (!astronautsSet.isEmpty() && !items.isEmpty()) {
            String item = items.poll();
            Astronaut astronaut = astronautsSet.poll();

            while (astronaut != null && item != null) {
                if (astronaut.getOxygen() > 0) {
                    astronaut.breath();
                    astronaut.getBag().getItems().add(item);
                    item = items.poll();
                } else {
                    astronaut = astronautsSet.poll();
                }
            }
        }
    }
}
