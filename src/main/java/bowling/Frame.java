package bowling;

public class Frame {

    private int score;

    public void roll(int pins) {
        score = pins;
    }

    public int score() {
        return score;
    }
}
