import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Stream;

public class BowlingGameBoard {
    //TODO meerdere spelers
    private Speler speler = new Speler();

    public int getScore(Speler speler) {
        return speler.getScore();
    }

}
