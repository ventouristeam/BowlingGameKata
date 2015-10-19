package be.cegeka.bowlinggame;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void roll_verhoogtScoreMetGegevenPins() throws Exception {
        Frame frame = new Frame();
        frame.roll(9);
        assertThat(frame.score()).isEqualTo(9);
    }

    @Test
    public void roll_maximaal10PinsPerWorp() throws Exception {
        expected.expect(IllegalStateException.class);
        expected.expectMessage("error.too.many.pins");

        Frame frame = new Frame();
        frame.roll(11);
    }

    @Test
    public void roll_maximaal10PinsPer2Worpen() throws Exception {
        expected.expect(IllegalStateException.class);
        expected.expectMessage("error.too.many.pins");

        Frame frame = new Frame();
        frame.roll(9);
        frame.roll(2);
    }

        @Test
    public void roll_minimum0PinsPerWorp() throws Exception {
        expected.expect(IllegalStateException.class);
        expected.expectMessage("error.not.enough.pins");

        Frame frame = new Frame();
        frame.roll(-1);
    }
}