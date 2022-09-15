package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JokeBook {
    ArrayList<Joke> jokes = new ArrayList<Joke>();

    public JokeBook(ResultSet jokelist) throws SQLException {

        while (jokelist.next()) {
            jokes.add(new Joke(jokelist.getInt("id"), jokelist.getDate("date"), jokelist.getInt("rating"), jokelist.getString("text")));
        }
    }

    public String print() {
        String output = "";
        for (int i = 0; i < jokes.size(); i++) {
            output = output + jokes.get(i) + "\n\n";
        }
        System.out.println(output);
        return output;
    }
}
