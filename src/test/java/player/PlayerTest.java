package player;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player = new Player("Erlend");

    @Test
    public void name() {
        assertThat(player.getName()).isEqualTo("Erlend");
    }
}