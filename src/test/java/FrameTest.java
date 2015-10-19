import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void testGetScore() {
        frame.roll(5);
        frame.roll(4);

        assertThat(frame.getScore()).isEqualTo(9);
    }

}