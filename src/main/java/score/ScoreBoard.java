package score;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private Player player;

    private List<Frame> scores = new ArrayList<>();

    private Frame currentFrame;

    public void roll(int pins) {
        if (currentFrame == null) {
            currentFrame = new Frame();
        }


        currentFrame.roll(pins);
//        scores.add(pins);
    }

    public int getScore() {
        return 0;
//        return scores.stream().mapToInt(i -> i).sum();
    }
}
