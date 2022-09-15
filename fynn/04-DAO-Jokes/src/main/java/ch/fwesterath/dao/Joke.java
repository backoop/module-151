package ch.fwesterath.dao;

import java.util.Date;

public class Joke {
    private int id;
    private Date date;
    private int rating;
    private String text;

    public Joke(int id, Date date, int rating, String text) {
        this.id = id;
        this.date = date;
        this.rating = rating;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", date=" + date +
                ", rating=" + rating +
                ", text='" + text + '\'' +
                '}';
    }
}
