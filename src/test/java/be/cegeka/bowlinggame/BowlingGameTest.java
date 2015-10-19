package be.cegeka.bowlinggame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void eenGameBestaatUit10Frames() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        assertThat(bowlingGame.getFrames()).hasSize(10);
    }

    @Test
    public void roll_geenSpare_geenStrike_scoreWordtBerekend() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(5);
        bowlingGame.roll(4);
        assertThat(bowlingGame.score()).isEqualTo(9);
    }
}
