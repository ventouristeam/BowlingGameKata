import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames;

    public BowlingGame() {
        this.frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int pins) {
        throw new RuntimeException("not yet implemented");
    }

    public int score() {
        throw new RuntimeException("not yet implemented");
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
