package ch.fwesterath.daojokes.dao;

import java.util.ArrayList;
import ch.fwesterath.daojokes.model.Joke;

public interface DataBaseAccess {
    public abstract ArrayList<Joke> getAllJokes();
}
