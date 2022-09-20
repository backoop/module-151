package ch.bbw.es.model;

import java.sql.Date;

public class Joke {
    private int id;
    private String text;
    private Date date;
    private int rating;

    public void setupJoke(int id, String text, Date date,int rating){
        this.id = id;
        this.date = date;
        this.text = text;
        this.rating = rating;
    }

    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                '}';
    }
}
