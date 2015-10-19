package be.cegeka.bowlinggame;

class Frame {

    private int score = 0;

    void roll(int pins) {
        if (pins < 0) throw new IllegalStateException("error.not.enough.pins");
        if (pins > 10) throw new IllegalStateException("error.too.many.pins");
        if (pins + score > 10) throw new IllegalStateException("error.too.many.pins");

        score += pins;
    }

    int score() {
        return score;
    }
}
