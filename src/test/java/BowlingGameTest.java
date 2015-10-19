import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void eenGameBestaatUit10Frames() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        assertThat(bowlingGame.getFrames()).hasSize(10);
    }
}
