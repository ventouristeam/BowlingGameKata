package score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TurnTest {

    @Test
    public void testGetters() {
        assertThat(new Turn(1, 2).isSpare()).isFalse();
        assertThat(new Turn(2, 8).isSpare()).isTrue();
        assertThat(new Turn(0, 10).isSpare()).isTrue();
        assertThat(new Turn(10, 0).isSpare()).isTrue();

        assertThat(new Turn(1, 2).isStrike()).isFalse();
        assertThat(new Turn(0, 10).isStrike()).isFalse();
        assertThat(new Turn(10, 0).isStrike()).isTrue();
    }

}