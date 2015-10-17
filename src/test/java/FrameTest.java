import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void gooi5KegelsOmMet1Worp_5KegelsZijnOmgegooid() {
        frame.gooi(5);

        Assertions.assertThat(frame.getOmgegooideKegels()).isEqualTo(5);
    }

    @Test
    public void gooi7KegelsOmMet2Worpen_7KegelsZijnOmgegooid() {
        frame.gooi(3);
        frame.gooi(4);

        Assertions.assertThat(frame.getOmgegooideKegels()).isEqualTo(7);
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
        Assertions.assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(2);
    }

    @Test
    public void getAantalNogTeGebruikenKansenNa1Worp() {
        frame.gooi(3);

        Assertions.assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(1);
    }

    @Test
    public void getAantalNogKansenNatweeWorpen() {
        frame.gooi(3);
        frame.gooi(4);

        Assertions.assertThat(frame.getAantalNietGebruikteKansen()).isEqualTo(0);
    }
}
