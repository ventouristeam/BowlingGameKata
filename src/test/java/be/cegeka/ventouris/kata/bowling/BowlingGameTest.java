package be.cegeka.ventouris.kata.bowling;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void rollZero_ScoreIsZero() {
        roll(0);

        assertScore(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void roll_teveelKegels() {
        roll(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void roll_teWeinigKegels() {
        roll(-1);
    }

    @Test
    public void rollFrame_ScoreIsSomVanDe2Rolls() {
        rollFrame(1, 2);

        assertScore(3);
    }

    @Test
    public void rollVolledigSpel_ScoreIsSomVanDeTienFrames() {
        rollFrame(0, 9);
        rollFrame(1, 8);
        rollFrame(2, 7);
        rollFrame(3, 6);
        rollFrame(4, 5);
        rollFrame(5, 4);
        rollFrame(6, 3);
        rollFrame(7, 2);
        rollFrame(8, 1);
        rollFrame(9, 0);

        assertScore(90);
    }

    // TODO unignore
    @Ignore
    @Test
    public void alsJeEenSpareRolt_TeltDeVolgendeWorpDubbel() {
        rollFrame(5, 5);
        rollFrame(2, 6);

        assertScore(20);
    }

    private void roll(int pins) {
        bowlingGame.roll(pins);
    }

    private void rollFrame(int roll1, int roll2) {
        roll(roll1);
        roll(roll2);
    }

    private void assertScore(int score) {
        assertThat(bowlingGame.score()).isEqualTo(score);
    }

}
