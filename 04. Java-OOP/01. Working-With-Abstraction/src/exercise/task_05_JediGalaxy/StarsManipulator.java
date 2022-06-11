package exercise.task_05_JediGalaxy;

public class StarsManipulator {
    private Galaxy galaxy;

    public StarsManipulator(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int[] enemyPositions) {
        int rowEnemy = enemyPositions[0];
        int colEnemy = enemyPositions[1];

        while (rowEnemy >= 0 && colEnemy >= 0) {
            if (isInRange(rowEnemy, colEnemy)) {
                this.galaxy.setStar(rowEnemy, colEnemy, new Star(0));
            }
            rowEnemy--;
            colEnemy--;
        }
    }

    public long sumOfStars(int[] playerPositions) {
        int rowPlayer = playerPositions[0];
        int colPlayer = playerPositions[1];
        long sum = 0;

        while (rowPlayer >= 0 && colPlayer < this.galaxy.getColumns(0)) {
            if (isInRange(rowPlayer, colPlayer)) {
                sum += this.galaxy.getStarValue(rowPlayer, colPlayer);
            }
            colPlayer++;
            rowPlayer--;
        }
        return sum;
    }

    private boolean isInRange(int enemyRow, int enemyCol) {
        return enemyRow >= 0 && enemyRow < this.galaxy.getRows()
                && enemyCol >= 0 && enemyCol < this.galaxy.getColumns(enemyRow);
    }
}
