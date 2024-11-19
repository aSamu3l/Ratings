package it.samu3l.ratings.model;

public class RatingsDTO {
    private int rating;
    private String totem;

    public RatingsDTO() {
    }

    public RatingsDTO(int umid, String room) {
        this.rating = umid;
        this.totem = room;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTotem() {
        return totem;
    }

    public void setTotem(String totem) {
        this.totem = totem;
    }
}
