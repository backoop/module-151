package ch.jringli.daojokes.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import ch.jringli.daojokes.model.Joke;

import java.util.ArrayList;

public interface DatabaseAccess {
    public abstract ArrayList<Joke> getAllJokes() throws ClassNotFoundException, SQLException;
}
