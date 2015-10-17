import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void gooi0keer_omgegooideKegels_WordenAanScoreToegevoegd() {
        assertThat(bowlingGame.getScore()).isZero();
    }

    @Test
    public void gooi1keer_omgegooideKegels_WordenAanScoreToegevoegd() {
        bowlingGame.gooi(5);

        assertThat(bowlingGame.getScore()).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gooiInTweeKeerMeerDanTienKegelsOm_IsNietToegelaten() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(8);

        assertThat(bowlingGame.getScore()).isEqualTo(19);
    }

    @Test
    public void gooi5keer_omgegooideKegels_WordenAanScoreToegevoegd() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(2);
        bowlingGame.gooi(6);

        assertThat(bowlingGame.getScore()).isEqualTo(13);
    }

    @Test(expected=IllegalArgumentException.class)
    public void gooi_MeerDan10KegelsInEenFrame_IsNietToegelaten() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(8);
    }
}
