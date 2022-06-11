package exercise.task_05_JediGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        this.stars = new Star[rows][cols];
        this.fillStars();

    }

    private void fillStars() {
        int value = 0;
        for (int row = 0; row < this.stars.length; row++) {
            for (int col = 0; col < this.stars[row].length; col++) {
                this.stars[row][col] = new Star(value++);
            }
        }
    }

    private boolean isInRange(int row, int col) {
        return row >= 0 && row < this.stars.length
                && col >= 0 && col < this.stars[row].length;
    }

    public int getRows() {
        return this.stars.length;
    }

    public int getColumns(int row) {
        return this.stars[row].length;
    }

    public void setStar(int row, int col, Star star) {
        if (isInRange(row, col)) {
            this.stars[row][col] = star;
        }
    }

    public long getStarValue(int row, int col) {
        int result = 0;
        if (isInRange(row, col)) {
            result = this.stars[row][col].getValue();
        }
        return result;
    }
}
