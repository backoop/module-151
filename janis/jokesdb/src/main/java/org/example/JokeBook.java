package org.example;
import java.sql.*;
import java.util.ArrayList;


public class JokeBook {
    ArrayList<String> jokes = new ArrayList<>();
    public JokeBook(ResultSet jokelist) throws SQLException {
        while (jokelist.next()) {
            jokes.add(jokelist.getString("text"));
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (String joke : jokes) {
            sb.append(joke).append("\n\n");
        }
        return sb.toString();
    }
}
