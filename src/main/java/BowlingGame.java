import bowling.Frame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
        Frame frame = new Frame();
        frames.add(frame);
        frame.roll(pins);
    }

    public int score() {
        return frames.stream().map(Frame::score).reduce(Integer::sum).get();
    }

    List<Frame> getFrames() {
        return frames;
    }
}
