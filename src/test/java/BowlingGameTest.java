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
        assertThat(bowlingGame.berekenScore()).isZero();
    }

    @Test
    public void gooi1keer_omgegooideKegels_WordenAanScoreToegevoegd() {
        bowlingGame.gooi(5);

        assertThat(bowlingGame.berekenScore()).isEqualTo(5);
    }

    @Test
    public void gooi5keer_omgegooideKegels_WordenAanScoreToegevoegd() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(2);
        bowlingGame.gooi(6);

        assertThat(bowlingGame.berekenScore()).isEqualTo(13);
    }

    @Test
    public void gooi_10_Frames_ScoreWordtOpgeteld() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(2);

        bowlingGame.gooi(6);
        bowlingGame.gooi(0);

        bowlingGame.gooi(10);

        bowlingGame.gooi(6);
        bowlingGame.gooi(3);

        bowlingGame.gooi(1);
        bowlingGame.gooi(4);

        bowlingGame.gooi(6);
        bowlingGame.gooi(4);

        bowlingGame.gooi(8);
        bowlingGame.gooi(0);

        bowlingGame.gooi(1);
        bowlingGame.gooi(2);

        bowlingGame.gooi(10);

        bowlingGame.gooi(6);
        bowlingGame.gooi(2);

        assertThat(bowlingGame.berekenScore()).isEqualTo(76);
    }

    @Test(expected = IllegalStateException.class)
    public void gooi_11_Frames_IsNietToegelaten() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(2);

        bowlingGame.gooi(6);
        bowlingGame.gooi(0);

        bowlingGame.gooi(10);

        bowlingGame.gooi(6);
        bowlingGame.gooi(3);

        bowlingGame.gooi(1);
        bowlingGame.gooi(4);

        bowlingGame.gooi(6);
        bowlingGame.gooi(4);

        bowlingGame.gooi(8);
        bowlingGame.gooi(0);

        bowlingGame.gooi(1);
        bowlingGame.gooi(2);

        bowlingGame.gooi(10);

        bowlingGame.gooi(6);
        bowlingGame.gooi(2);

        bowlingGame.gooi(0);
    }

    @Test
    public void gooiStrike_VolgendeGooiZitInVolgendeFrame() {
        bowlingGame.gooi(10);
        bowlingGame.gooi(8);

        assertThat(bowlingGame.berekenScore()).isEqualTo(18);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gooiInTweeKeerMeerDanTienKegelsOm_IsNietToegelaten() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(8);
    }

    @Test(expected=IllegalArgumentException.class)
    public void gooi_MeerDan10KegelsInEenFrame_IsNietToegelaten() {
        bowlingGame.gooi(5);
        bowlingGame.gooi(8);
    }
}
