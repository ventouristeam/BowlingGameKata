import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

public class FrameTest extends TestCase {

    private Frame frame;

    public void testGetTotaalVanFrame() throws Exception {
        Worp worp1 = new Worp(1);
        Worp worp2 = new Worp(4);
        frame = new Frame(worp1, worp2);
        Assertions.assertThat(frame.getTotaalVanFrame()).isEqualTo(5);
    }


}