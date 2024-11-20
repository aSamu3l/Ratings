package it.samu3l.ratings.model;

public class RatingsViewDTO {
    private int positive;
    private int negative;
    private int neutral;

    public RatingsViewDTO() {
        this.positive = 0;
        this.negative = 0;
        this.neutral = 0;
    }

    public RatingsViewDTO(int positive, int negative, int neutral) {
        this.positive = positive;
        this.negative = negative;
        this.neutral = neutral;
    }

    public int getPositive() {
        return positive;
    }

    public void addPositive() {
        this.positive++;
    }

    public void setPositive(int potive) {
        this.positive = potive;
    }

    public int getNegative() {
        return negative;
    }

    public void addNegative() {
        this.negative++;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getNeutral() {
        return neutral;
    }

    public void addNeutral() {
        this.neutral++;
    }

    public void setNeutral(int neutral) {
        this.neutral = neutral;
    }
}
