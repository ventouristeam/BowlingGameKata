import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpelerTest {

    private Speler speler;

    @Before
    public void setUp() {
        speler = new Speler();
    }

    @Test
    public void rollTeltPuntenBij() {
        speler.roll(10);

        assertThat(speler.getScore()).isEqualTo(10);
    }




}
