import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void test_1Kegel_1Punt() {
        BowlingGame game = new BowlingGame();

        game.roll(1);

        Assertions.assertThat(game.score()).isEqualTo(1);
    }


    @Test
    public void test_2Kegels_2Punten() {
        BowlingGame game = new BowlingGame();

        game.roll(2);

        Assertions.assertThat(game.score()).isEqualTo(2);
    }

    @Test
    public void test_1Worp_1Frame() {
        BowlingGame game = new BowlingGame();

        game.roll(1);

        Assertions.assertThat(game.getFrames()).hasSize(1);
    }

}
