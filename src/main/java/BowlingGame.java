import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BowlingGame {

    private final List<Frame> frames;
    private Frame waitingFrame;

    private final static int MAXIMUM_AANTAL_FRAMES = 10;

    public BowlingGame() {
        frames = new ArrayList<>();
        waitingFrame = new Frame();
    }

    public void gooi(int kegels) {
        valideerDatDeFrameListNogNietVolZit();
        waitingFrame.gooi(kegels);
        verplaatsVerwerkteFrameIndienKansenOpgebruiktZijn(waitingFrame);
    }

    public int getScore() {
        return Stream.concat(frames.stream(), Stream.of(waitingFrame)).mapToInt(Frame::getOmgegooideKegels).sum();
    }

    private void verplaatsVerwerkteFrameIndienKansenOpgebruiktZijn(Frame verwerkteFrame) {
        if (verwerkteFrame.getAantalNietGebruikteKansen() == 0) {
            frames.add(waitingFrame);
            waitingFrame = new Frame();
        }
    }

    private void valideerDatDeFrameListNogNietVolZit() {
        if(frames.size() == MAXIMUM_AANTAL_FRAMES) {
            throw new IllegalStateException("Alle frames zijn opgebruikt");
        }
    }


}
