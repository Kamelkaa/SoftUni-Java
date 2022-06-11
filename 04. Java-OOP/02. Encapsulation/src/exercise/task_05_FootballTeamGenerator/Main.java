package exercise.task_05_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] infoCommands = line.split(";");
            String command = infoCommands[0];
            String teamName = infoCommands[1];
            try {
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add": {
                        String playerName = infoCommands[2];
                        int endurance = Integer.parseInt(infoCommands[3]);
                        int sprint = Integer.parseInt(infoCommands[4]);
                        int dribble = Integer.parseInt(infoCommands[5]);
                        int passing = Integer.parseInt(infoCommands[6]);
                        int shooting = Integer.parseInt(infoCommands[7]);
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        }
                        break;
                    }
                    case "Remove": {
                        String playerName = infoCommands[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    }
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.println(teams.get(teamName).toString());
                        }
                        break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }
}
