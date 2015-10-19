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
    public void roll_GeenSpare_GeenStrike_1Frame_ScoreIsScoreVan1Frame() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(5);
        bowlingGame.roll(4);
        assertThat(bowlingGame.score()).isEqualTo(9);
    }

    @Test
    public void roll_GeenSpare_GeenStrike_10Frames_ScoreIsSomVanScoreVanAlleFrames() throws Exception {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 10; i++) {
            bowlingGame.roll(2);
            bowlingGame.roll(1);
        }
        
        assertThat(bowlingGame.score()).isEqualTo(30);
    }

}
