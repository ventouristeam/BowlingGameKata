public class Frame {

    private final static int MAXIMUM_AANTAL_KANSEN = 2;
    private final static int AANTAL_KEGELS = 10;

    private int gebruikteKansen;
    private int omgegooideKegels;

    public Frame() {
        gebruikteKansen = 0;
        omgegooideKegels = 0;
    }

    public void gooi(int kegels) {
        validateWorp(kegels);
        gebruikteKansen++;
        omgegooideKegels += kegels;
    }

    private void validateWorp(int kegels) {
        if(omgegooideKegels + kegels > 10) {
            throw new IllegalArgumentException();
        }
    }

    public int getOmgegooideKegels() {
        return omgegooideKegels;
    }

    public int getAantalNietGebruikteKansen() {
        return MAXIMUM_AANTAL_KANSEN - gebruikteKansen;
    }
}
