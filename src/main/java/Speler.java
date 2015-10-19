import java.util.ArrayList;
import java.util.Collection;

public class Speler {

    private Collection<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
        //TODO implement second roll en nieuwe frame bij strike
        Frame frame = new Frame();
        frame.roll(pins);
        frames.add(frame);
    }

    public int getScore() {
        int score = 0;
        for (Frame frame : frames) {
            score =+frame.getScore();
        }
        return score;
    }

    public int getAantalFrames() {
        return frames.size();
    }
}
