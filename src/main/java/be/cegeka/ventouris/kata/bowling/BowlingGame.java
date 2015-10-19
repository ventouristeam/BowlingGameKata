package be.cegeka.ventouris.kata.bowling;

public class BowlingGame {

    private int score;

    public void roll(int pins) {
        valideerRoll(pins);

        score = score + pins;
    }

    public int score() {
        return score;
    }

    private void valideerRoll(int pins) {
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException("aantal kegels: " + pins + " moet tussen 0 en 10 liggen");
        }
    }

}
