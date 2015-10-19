import org.junit.Before;
import org.junit.Ignore;
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

    @Test
    @Ignore
    public void derdeRollGeeftNieuweFrame() {
        speler.roll(2);
        speler.roll(2);
        speler.roll(2);

        assertThat(speler.getAantalFrames()).isEqualTo(2);
    }

    @Test
    @Ignore
    public void strikeStartNieuweFrame() {
        speler.roll(10);
        speler.roll(2);

        assertThat(speler.getAantalFrames()).isEqualTo(2);
    }



}
