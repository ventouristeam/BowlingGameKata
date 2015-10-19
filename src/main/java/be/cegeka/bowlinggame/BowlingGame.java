package be.cegeka.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames;
    private int currentFrame = 0;

    public BowlingGame() {
        this.frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int pins) {
        frames.get(currentFrame).roll(pins);
    }

    public int score() {
        return frames.get(currentFrame).score();
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
