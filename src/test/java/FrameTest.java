import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void gooi5KegelsOmMet1Worp_5KegelsZijnOmgegooid() {
        frame.gooi(5);

        assertThat(frame.getOmgegooideKegels()).isEqualTo(5);
    }

    @Test
    public void gooi7KegelsOmMet2Worpen_7KegelsZijnOmgegooid() {
        frame.gooi(3);
        frame.gooi(4);

        assertThat(frame.getOmgegooideKegels()).isEqualTo(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gooiMeerDan10KegelsOm_IsNietToegelaten() {
        frame.gooi(12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gooiMeerDan10KegelsOmInTweeWorpen_IsNietToegelaten() {
        frame.gooi(4);
        frame.gooi(8);
    }

    @Test(expected = IllegalStateException.class)
    public void gooiHoewelJeGeenKansenMeerHebt() {
        frame.gooi(1);
        frame.gooi(1);
        frame.gooi(1);
    }

    @Test
    public void getAantalNogTeGebruikenKansenZonderWorp() {
        assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(2);
    }

    @Test
    public void getAantalNogTeGebruikenKansenNa1Worp() {
        frame.gooi(3);

        assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(1);
    }

    @Test
    public void getAantalNogKansenNatweeWorpen() {
        frame.gooi(3);
        frame.gooi(4);

        assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(0);
    }

    @Test
    public void getAantalNogKansenNaStrike_0() {
        frame.gooi(10);

        assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(0);
    }

    @Test
    public void alleKegelsOmverMet1Worp_isGeenSpare() {
        frame.gooi(10);

        assertThat(frame.isSpare()).isFalse();
    }

    @Test
    public void nietAlleKegelsOmver_IsGeenSpare() {
        frame.gooi(2);
        frame.gooi(3);

        assertThat(frame.isSpare()).isFalse();
    }

    @Test
    public void alleKegelsOmverMetTweeWorpen_isSpare() {
        frame.gooi(6);
        frame.gooi(4);

        assertThat(frame.isSpare()).isTrue();
    }

    @Test
    public void testIsStrike_AlleKegelsOmverMet1Worp() {
        frame.gooi(10);

        assertThat(frame.isSpare()).isFalse();
    }

    @Test
    public void nietAlleKegelsOmver_IsGeenStrike() {
        frame.gooi(2);
        frame.gooi(3);

        assertThat(frame.isStrike()).isFalse();
    }

    @Test
    public void alleKegelsOmverMetTweeWorpen_isGeenStrike() {
        frame.gooi(6);
        frame.gooi(4);

        assertThat(frame.isStrike()).isFalse();
    }

    @Test
    public void testIsStrike_AlleKegelsOmverMet1WorpIsStrike() {
        frame.gooi(10);

        assertThat(frame.isStrike()).isTrue();
    }
}
