import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FrameHolder {

    private final List<Frame> frames;
    private Optional<Frame> waitingFrame;

    private final static int MAXIMUM_AANTAL_FRAMES = 10;

    public FrameHolder() {
        frames = new ArrayList<>();
        waitingFrame = Optional.of(new Frame());
    }

    public void verwerkWorp(int kegels) {
        valideerDatDeFrameListNogNietVolZit();
        waitingFrame.ifPresent(frame -> {
            frame.gooi(kegels);
            verplaatsVerwerkteFrameIndienKansenOpgebruiktZijn(frame);
        });
    }

    public List<Frame> getFrames() {
        List<Frame> terugTegevenFrames = new ArrayList<>(frames);
        waitingFrame.ifPresent(terugTegevenFrames::add);
        return terugTegevenFrames;
    }

    private void verplaatsVerwerkteFrameIndienKansenOpgebruiktZijn(Frame verwerkteFrame) {
        if (verwerkteFrame.getAantalNietGebruikteKansen() == 0) {
            frames.add(verwerkteFrame);
            waitingFrame = frameListZitVol() ? Optional.empty() : Optional.of(new Frame());
        }
    }

    private void valideerDatDeFrameListNogNietVolZit() {
        if(frameListZitVol()) {
            throw new IllegalStateException("Alle frames zijn opgebruikt");
        }
    }

    private boolean frameListZitVol() {
        return frames.size() == MAXIMUM_AANTAL_FRAMES;
    }
}
