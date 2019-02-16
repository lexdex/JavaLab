package tasks.task1;

import java.util.Random;

class Player implements Comparable<Player> {
    private String name;
    private int points;
    private Random random = new Random();


    Player(String name) {
        this.name = name;
    }

    int getPoints() {
        return points;
    }

    void addPoint(int point) {
        this.points += point;
    }

    String getName() {
        return name;
    }

    int tryToScore() {
        return random.nextBoolean() ? 1 : 0;
    }

    @Override
    public int compareTo(Player p) {
        return Integer.compare(this.points, p.points);
    }
}
