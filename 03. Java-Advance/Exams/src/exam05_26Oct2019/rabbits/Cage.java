package exam05_26Oct2019.rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    //⦁	name: String
    //⦁	capacity: int
    //⦁	data: List<Rabbit> that holds added rabbits
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    //⦁	add(Rabbit rabbit) method - adds an entity to the data if there is room for it
    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            data.add(rabbit);
        }
    }

    //⦁	removeRabbit(String name) method - removes a rabbit by given name, if such exists, and returns boolean
    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                this.data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    //⦁	removeSpecies(String species) method - removes all rabbits by given species
    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    //⦁	sellRabbit(String name) method - sell (set its available property to
    //false without removing it from the collection) the first rabbit with the given name, also return the rabbit
    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    //⦁	sellRabbitBySpecies(String species) method - sells and returns all rabbits from that species as a List
    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> sellRabbits = data.stream()
                .filter(r -> r.getSpecies().equals(species))
                .collect(Collectors.toList());
        data = data.stream().filter(r -> !r.getSpecies().equals(species)).collect(Collectors.toList());
        return sellRabbits;
    }

    //⦁	count() - returns the number of rabbits
    public int count() {
        return this.data.size();
    }

    //⦁	report() - returns a String in the following format, including only not sold rabbits:
    //⦁	"Rabbits available at {cageName}:
    //{Rabbit 1}..
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Rabbits available at %s:", getName())).append(System.lineSeparator());
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                builder.append(rabbit).append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
