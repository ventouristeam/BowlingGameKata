package score;

public class Turn {
    private int firstThrow;
    private int secondThrow;

    public Turn(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public boolean isSpare() {
        return (firstThrow != 10) && (firstThrow + secondThrow) == 10;
    }

    public boolean isStrike() {
        return (firstThrow == 10);
    }
}
