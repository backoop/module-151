package ch.bbw.lm.dao;

import ch.bbw.lm.model.Joke;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DatabaseAccess {
    public abstract ArrayList<Joke> getAllJokes();
    public abstract void createJoke(Joke joke) throws SQLException, ClassNotFoundException;
}
