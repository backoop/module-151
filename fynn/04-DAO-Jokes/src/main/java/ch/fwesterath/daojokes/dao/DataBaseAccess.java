package ch.fwesterath.daojokes.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import ch.fwesterath.daojokes.model.Joke;

public interface DataBaseAccess {
    public abstract ArrayList<Joke> getAllJokes() throws ClassNotFoundException, SQLException;
}
