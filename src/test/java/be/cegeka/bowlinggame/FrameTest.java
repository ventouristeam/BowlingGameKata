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

    @Test
    public void roll_Maximum2Rolls() throws Exception {
        Frame frame = new Frame();
        frame.roll(1);
        frame.roll(1);

        expected.expect(IllegalStateException.class);
        expected.expectMessage("error.max.2.rolls");
        frame.roll(1);
    }

    @Test
    public void rolls_TwoRollsHappened_Returns2() throws Exception {
        Frame frame = new Frame();
        frame.roll(1);
        frame.roll(1);
        assertThat(frame.rolls()).isEqualTo(2);
    }

    @Test
    public void rolls_OneRollHappened_Returns1() throws Exception {
        Frame frame = new Frame();
        frame.roll(1);
        assertThat(frame.rolls()).isEqualTo(1);
    }

    @Test
    public void rolls_ZeroRollsHappened_Returns0() throws Exception {
        assertThat(new Frame().rolls()).isEqualTo(0);

    }
}