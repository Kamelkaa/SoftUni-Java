package exercise.task_06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String infoData = scanner.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!infoData.equals("Tournament")) {
            String[] information = infoData.split("\\s+");
            String trainerName = information[0];
            String pokemonName = information[1];
            String pokemonElement = information[2];
            int pokemonHealth = Integer.parseInt(information[3]);

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).getPokemons().add(pokemon);

            infoData = scanner.nextLine();
        }

        String element = scanner.nextLine();
        while (!element.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                if (trainer.getPokemons().size() > 0) {
                    trainerWhitUpdateParameters(trainer, element);
                }
            }
            element = scanner.nextLine();
        }

        trainers.values()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getNumberOfBadges(), e1.getNumberOfBadges()))
                .forEach(System.out::println);
    }

    public static boolean isContainsTheElement(Trainer trainer, String element) {
        for (Pokemon pokemon : trainer.getPokemons()) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static void trainerWhitUpdateParameters(Trainer trainer, String element) {
        if (isContainsTheElement(trainer, element)) {
            trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
        } else {
            for (Pokemon pokemon : trainer.getPokemons()) {
                pokemon.setHealth(pokemon.getHealth() - 10);
                if (pokemon.getHealth() <= 0) {
                    trainer.getPokemons().remove(pokemon);
                    break;
                }
            }
        }
    }
}
