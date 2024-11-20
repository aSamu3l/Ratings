package it.samu3l.ratings.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "rating")
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "totem")
    private String totem;
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    public Ratings() {
    }

    public Ratings(String totem, int rating) {
        this.totem = totem;
        this.rating = rating;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Ratings(String totem, int rating, Timestamp timestamp) {
        this.totem = totem;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "id=" + id +
                ", rating=" + rating +
                ", totem='" + totem + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
