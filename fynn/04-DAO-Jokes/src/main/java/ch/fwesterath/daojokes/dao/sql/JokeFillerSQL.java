package ch.fwesterath.daojokes.dao.sql;

import ch.fwesterath.daojokes.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerSQL {
    public static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(entry.getInt("id"), entry.getString("text"), entry.getDate("date"), entry.getInt("rating"));
    }
    public static Joke createJokeObject(ResultSet entry) throws SQLException{
        Joke joke = new Joke();
        fillJoke(joke, entry);
        return joke;
    }
}
