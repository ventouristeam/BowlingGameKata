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
        getFirstUnusedFrame().gooi(kegels);
        verplaatstEersteFrameIndienHetOpgebruiktIs();
    }

    private Frame getFirstUnusedFrame() {
        valideerDatErNogUnUsedFramesZijn();
        return teGebruikenFrames.get(0);
    }

    private void verplaatstEersteFrameIndienHetOpgebruiktIs() {
        if (getFirstUnusedFrame().getAantalNietGebruikteKansen() == 0) {
            opGebruikteFrames.add(getFirstUnusedFrame());
            teGebruikenFrames.remove(getFirstUnusedFrame());
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
