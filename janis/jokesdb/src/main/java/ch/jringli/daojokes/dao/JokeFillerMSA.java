package ch.jringli.daojokes.dao;

import ch.jringli.daojokes.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerMSA {
    public static Joke createJokeObject(ResultSet entry) throws SQLException {
        return new Joke(entry.getInt("id"), entry.getDate("date"), entry.getInt("rating"), entry.getString("text"));

    }
}
