package ch.bbw.lm.dao;

import ch.bbw.lm.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFiller_ma {

    private static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("jokeid"),
                entry.getString("content"),
                entry.getDate("date"),
                entry.getInt("rating")
        );
    }

    public static Joke createJokeObject(ResultSet entry) throws SQLException{
        Joke joke=new Joke();
        fillJoke(joke, entry);
        return joke;
    }

}