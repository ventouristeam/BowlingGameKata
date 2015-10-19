package be.cegeka.bowlinggame;

class Frame {

    private int score = 0;
    private int rolls = 0;

    void roll(int pins) {
        if (pins < 0) throw new IllegalStateException("error.not.enough.pins");
        if (pins > 10) throw new IllegalStateException("error.too.many.pins");
        if (pins + score > 10) throw new IllegalStateException("error.too.many.pins");
        rolls++;
        if (rolls > 2) throw new IllegalStateException("error.max.2.rolls");
        score += pins;
    }

    int score() {
        return score;
    }

    public int rolls() {
        return rolls;
    }
}
