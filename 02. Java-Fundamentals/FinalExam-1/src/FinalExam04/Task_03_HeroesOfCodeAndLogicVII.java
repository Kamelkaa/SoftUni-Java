package FinalExam04;

import java.util.*;

public class Task_03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroInfo = scanner.nextLine().split(" ");
            String nameHero = heroInfo[0];
            int healthHero = Integer.parseInt(heroInfo[1]);
            int manaHero = Integer.parseInt(heroInfo[2]);

            heroes.put(nameHero, Arrays.asList(healthHero, manaHero)); //0 -> HP, 1 -> MP
        }

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("End")) {
            String[] tokens = commandInput.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    if (heroes.get(heroName).get(1) >= manaNeeded) {
                        int manaLeft = heroes.get(heroName).get(1) - manaNeeded;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, manaLeft);
                        heroes.get(heroName).set(1, manaLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    int healthLeft = heroes.get(heroName).get(0) - damage;
                    heroes.get(heroName).set(0, healthLeft);
                    if (healthLeft > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, healthLeft);
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int newMana = heroes.get(heroName).get(1) + amount;

                    if (newMana > 200) {
                        newMana = 200;
                        amount = 200 - heroes.get(heroName).get(1);//X
                    }

                    heroes.get(heroName).set(1, newMana);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);//newMana - heroes.get(heroName).get(1) вместо amount
                    break;
                case "Heal":
                    int amountHeal = Integer.parseInt(tokens[2]);
                    int newHealth = heroes.get(heroName).get(0) + amountHeal;

                    if (newHealth > 100) {
                        newHealth = 100;
                        amountHeal = 100 - heroes.get(heroName).get(0);//X
                    }

                    heroes.get(heroName).set(0, newHealth);
                    System.out.printf("%s healed for %d HP!%n", heroName, amountHeal);//newHealth - heroes.get(heroName).get(0) вместо amountHeal
                    break;
            }

            commandInput = scanner.nextLine();
        }

        heroes.entrySet().stream().sorted((n1, n2) -> {
            int result = n2.getValue().get(0).compareTo(n1.getValue().get(0));
            if (result == 0) {
                result = n1.getKey().compareTo(n2.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s%n" +
                        "  HP: %d%n" +
                        "  MP: %d%n",
                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

        //TreeMap;
        //heroes.entrySet().stream()
        //.sorted((n1, n2) -> Integer.compare(n2.getValue(), n1.getValue()))
        //.forEach(entry -> System.out.printf("%s%n" +
        //                        "  HP: %d%n" +
        //                        "  MP: %d%n",
        //                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

        //thenby
    }
}
