package exercise.task_05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    //-	name: String
    //-	players: List<Player>
    private String name;
    private List<Player> players;

    //+ 	Team (String)
    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    //-	setName(String) : void
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    //+	getName(): String
    public String getName() {
        return name;
    }

    //+	addPlayer(Player) : void
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    //+	removePlayer(String) : void
    public void removePlayer(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                return;
            }
        }
        String msg = String.format("Player %s is not in %s team.", name, this.name);
        throw new IllegalArgumentException(msg);
    }

    //+	getRating() : double
    public double getRating() {
        return Math.round(players.stream().mapToDouble(Player::overallSkillLevel).sum());
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.getName(), this.getRating());
    }
}
