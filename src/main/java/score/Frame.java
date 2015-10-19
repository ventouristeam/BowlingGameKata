package score;

public class Frame {
    private int firstThrow = -1;
    private int secondThrow = -1;

    public Frame() {}

    public Frame(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public void roll(int pins) {
        if (firstThrow == -1) {
            firstThrow = pins;
            return;
        }

        if (secondThrow == -1) {
            secondThrow = pins;
            return;
        }

        throw new IllegalStateException("No more then 2 throws per frame");
    }

    public boolean isSpare() {
        return (firstThrow != 10) && (firstThrow + secondThrow) == 10;
    }

    public boolean isStrike() {
        return (firstThrow == 10);
    }
}
