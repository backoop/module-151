package ch.jringli.daojokes.model;
import java.sql.*;
import java.util.ArrayList;


public class JokeBook {
    ArrayList<Joke> jokes = new ArrayList<>();
    public JokeBook(ResultSet jokelist) throws SQLException {
        while (jokelist.next()) {
            jokes.add(new Joke(jokelist.getInt("id"), jokelist.getDate("date"), jokelist.getInt("rating"), jokelist.getString("text")));
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Joke joke : jokes) {
            sb.append(joke).append("\n\n");
        }
        return sb.toString();
    }
}
