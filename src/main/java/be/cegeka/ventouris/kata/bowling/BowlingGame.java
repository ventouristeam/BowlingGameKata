package be.cegeka.ventouris.kata.bowling;

public class BowlingGame {

    private int score;

    public void roll(int pins) {
        score = score + pins;
    }

    public int score() {
        return score;
    }

}
