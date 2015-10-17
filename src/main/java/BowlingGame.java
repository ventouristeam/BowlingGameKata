import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class BowlingGame {

    private final FrameHolder frameHolder;

    public BowlingGame() {
        frameHolder = new FrameHolder();
    }

    public void gooi(int kegels) {
        frameHolder.verwerkWorp(kegels);
    }

    public int berekenScore() {
        return new ScoreCalculator(frameHolder.getFrames()).berekenScore();
    }
}
