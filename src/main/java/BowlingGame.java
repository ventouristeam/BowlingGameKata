import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BowlingGame {

    private final static int AANTAL_FRAMES = 10;

    private final List<Frame> teGebruikenFrames;
    private final List<Frame> opGebruikteFrames;

    public BowlingGame() {
        teGebruikenFrames = new ArrayList<>();
        opGebruikteFrames = new ArrayList<>();
        fillUnusedFrames();
    }

    public void gooi(int kegels) {
        valideerDatErNogUnUsedFramesZijn();
        Frame firstUnusedFrame = teGebruikenFrames.iterator().next();
        firstUnusedFrame.gooi(kegels);
        verplaatsFrameIndienHetOpgebruiktIs(firstUnusedFrame);
    }

    private void verplaatsFrameIndienHetOpgebruiktIs(Frame firstUnusedFrame) {
        if (firstUnusedFrame.getAantalNietGebruikteKansen() == 0) {
            opGebruikteFrames.add(firstUnusedFrame);
            teGebruikenFrames.remove(firstUnusedFrame);
        }
    }

    private void valideerDatErNogUnUsedFramesZijn() {
        if(teGebruikenFrames.isEmpty()) {
            throw new IllegalStateException("Er zijn geen unused frames meer");
        }
    }

    public int getScore() {
        return Stream.concat(opGebruikteFrames.stream(), teGebruikenFrames.stream()).mapToInt(Frame::getOmgegooideKegels).sum();
    }

    private void fillUnusedFrames() {
        for (int i = 0; i < AANTAL_FRAMES; i++) {
            teGebruikenFrames.add(new Frame());
        }
    }

}
