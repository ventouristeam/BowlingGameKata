public class Frame {

    private int pointsFirstRoll;
    private int pointsSecondRoll;

    public void roll(int pins) {
        pointsFirstRoll +=pins;
    }

    public int getScore() {
        return pointsFirstRoll + pointsSecondRoll;
    }
}
