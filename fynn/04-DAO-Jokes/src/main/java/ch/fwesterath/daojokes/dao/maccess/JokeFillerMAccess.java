package ch.fwesterath.daojokes.dao.maccess;

import ch.fwesterath.daojokes.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerMAccess {
    public static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(entry.getInt("jokeid"), entry.getString("content"), entry.getDate("date"), entry.getInt("rating"));
    }
    public static Joke createJokeObject(ResultSet entry) throws SQLException{
        Joke joke = new Joke();
        fillJoke(joke, entry);
        return joke;
    }
}
