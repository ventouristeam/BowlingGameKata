package be.cegeka.bowlinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Frame frame = frames.get(currentFrame);
        frame.roll(pins);
        if (frame.rolls() == 2){
            currentFrame++;
        }
    }

    public int score() {
        return frames.stream().collect(Collectors.summingInt(Frame::score));
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
