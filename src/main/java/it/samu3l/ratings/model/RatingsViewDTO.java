package it.samu3l.ratings.model;

public class RatingsViewDTO {
    private int potive;
    private int negative;
    private int neutral;

    public RatingsViewDTO() {
        this.potive = 0;
        this.negative = 0;
        this.neutral = 0;
    }

    public RatingsViewDTO(int potive, int negative, int neutral) {
        this.potive = potive;
        this.negative = negative;
        this.neutral = neutral;
    }

    public int getPotive() {
        return potive;
    }

    public void addPotive() {
        this.potive++;
    }

    public void setPotive(int potive) {
        this.potive = potive;
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
