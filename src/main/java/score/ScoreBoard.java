package score;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private Player player;

    private List<Integer> scores = new ArrayList<>();

    public void roll(int pins) {
        scores.add(pins);
    }

    public int getScore() {
        return scores.stream().mapToInt(i -> i).sum();
    }
}
