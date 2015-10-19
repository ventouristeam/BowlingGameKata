public class BowlingGame {

    int totalScore = 0;

    public void roll(int pins) {
        totalScore = totalScore + pins;
    }

    public int score() {
        return totalScore;
    }

}
