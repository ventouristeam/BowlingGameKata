import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void test_1Kegel_1Punt() {
        BowlingGame game = new BowlingGame();

        game.roll(1);

        Assertions.assertThat(game.score()).isEqualTo(1);
    }



}
