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
        isGooiToegelaten();
        validateWorp(kegels);
        gebruikteKansen++;
        omgegooideKegels = berekenHoeveelKegelsNeerliggen(kegels);
    }

    public int getOmgegooideKegels() {
        return omgegooideKegels;
    }

    public int getAantalNietGebruikteKansen() {
        return omgegooideKegels < AANTAL_KEGELS ? MAXIMUM_AANTAL_KANSEN - gebruikteKansen : 0;
    }

    private void validateWorp(int kegels) {
        if(berekenHoeveelKegelsNeerliggen(kegels) > AANTAL_KEGELS) {
            throw new IllegalArgumentException(String.format("Je probeert %d kegels om te gooien, terwijl er maar %d kegels zijn", berekenHoeveelKegelsNeerliggen(kegels), AANTAL_KEGELS));
        }
    }

    private int berekenHoeveelKegelsNeerliggen(int kegels) {
        return omgegooideKegels + kegels;
    }

    private void isGooiToegelaten() {
       if(getAantalNietGebruikteKansen() <= 0) {
           throw new IllegalStateException("Je hebt geen kansen meer om te gooien");
       }
    }
}
