package score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FrameTest {

    @Test
    public void testRoll() {
        Frame frame = new Frame();
        frame.roll(1);
        frame.roll(1);

        assertThatThrownBy(() -> frame.roll(1)).isExactlyInstanceOf(IllegalStateException.class);
    }

    @Test
    public void testGetters() {
        assertThat(new Frame(1, 2).isSpare()).isFalse();
        assertThat(new Frame(2, 8).isSpare()).isTrue();
        assertThat(new Frame(0, 10).isSpare()).isTrue();
        assertThat(new Frame(10, 0).isSpare()).isFalse();

        assertThat(new Frame(1, 2).isStrike()).isFalse();
        assertThat(new Frame(0, 10).isStrike()).isFalse();
        assertThat(new Frame(10, 0).isStrike()).isTrue();
    }

}