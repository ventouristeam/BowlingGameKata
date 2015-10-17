import java.util.List;

public class ScoreCalculator {

    private final List<Frame> frames;

    public ScoreCalculator(List<Frame> frames) {
        this.frames = frames;
    }

    public int berekenScore() {
        return frames.stream().mapToInt(Frame::getOmgegooideKegels).sum();
    }
}
