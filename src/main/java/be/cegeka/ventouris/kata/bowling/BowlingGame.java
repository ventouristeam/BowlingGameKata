package be.cegeka.ventouris.kata.bowling;

// TODO validatie aantal fames max 10
// TODO validatie per frame niet meer dan 10 kegels (behalve bij laatste frame)
// TODO speciaal gedrag laatste frame
// TODO bonus bij spare
// TODO bonus bij strike
// TODO bonus bij meerdere strikes/spares na mekaar
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
