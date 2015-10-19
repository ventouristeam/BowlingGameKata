package score;

import player.Player;

public class ScoreBoard {

    private Player player;
    private int score;

    public void roll(int pins) {
        score += pins;
    }

    public int getScore() {
        return score;
    }
}
