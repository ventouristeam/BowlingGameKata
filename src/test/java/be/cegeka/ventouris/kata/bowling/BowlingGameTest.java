package be.cegeka.ventouris.kata.bowling;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BowlingGameTest {

    @Test
    public void rollZero_ScoreIsZero() {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(0);

        Assertions.assertThat(bowlingGame.score()).isEqualTo(0);
    }

}
