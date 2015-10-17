import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BowlingGame {

    private final static int AANTAL_FRAMES = 10;

    private final List<Frame> unUsedframes;
    private final List<Frame> usedFrames;

    public BowlingGame() {
        unUsedframes = new ArrayList<>();
        usedFrames = new ArrayList<>();
        fillUnusedFrames();
    }

    public void gooi(int kegels) {
        valideerDatErNogUnUsedFramesZijn();
        Frame firstUnusedFrame = unUsedframes.iterator().next();
        firstUnusedFrame.gooi(kegels);
        if (firstUnusedFrame.getAantalNietGebruikteKansen() == 0) {
            usedFrames.add(firstUnusedFrame);
            unUsedframes.remove(firstUnusedFrame);
        }
    }

    private void valideerDatErNogUnUsedFramesZijn() {
        if(unUsedframes.isEmpty()) {
            throw new IllegalStateException("Er zijn geen unused frames meer");
        }
    }

    public int getScore() {
        return Stream.concat(usedFrames.stream(), unUsedframes.stream()).mapToInt(Frame::getOmgegooideKegels).sum();
    }

    private void fillUnusedFrames() {
        for (int i = 0; i < AANTAL_FRAMES; i++) {
            unUsedframes.add(new Frame());
        }
    }

}
