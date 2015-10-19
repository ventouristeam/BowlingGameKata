package score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard = new ScoreBoard();

    @Test
    public void score_NoStrikesOrSpares() {
        scoreBoard.roll(1);

        assertThat(scoreBoard.getScore()).isEqualTo(1);

        scoreBoard.roll(2);

        assertThat(scoreBoard.getScore()).isEqualTo(3);

        scoreBoard.roll(3);

        assertThat(scoreBoard.getScore()).isEqualTo(6);

        scoreBoard.roll(4);

        assertThat(scoreBoard.getScore()).isEqualTo(10);

        scoreBoard.roll(5);

        assertThat(scoreBoard.getScore()).isEqualTo(15);
    }


}