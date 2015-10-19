public class BowlingGame {

    private int points;

    public void roll(int pins) {
        points +=pins;
    }

    public int getScore() {
        return points;
    }

}
