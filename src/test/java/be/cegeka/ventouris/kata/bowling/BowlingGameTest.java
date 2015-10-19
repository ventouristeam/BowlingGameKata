package be.cegeka.ventouris.kata.bowling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class BowlingGameTest {

    @Test
    public void rollZero_ScoreIsZero() {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(0);

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void rollFrame_ScoreIsSomVanDe2Rolls() {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(1);
        bowlingGame.roll(2);

        assertThat(bowlingGame.score()).isEqualTo(3);
    }

}
