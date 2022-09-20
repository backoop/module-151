package ch.bbw.es.dao;

import ch.bbw.es.model.Joke;

import java.util.ArrayList;

public interface DBAccess {
    public abstract ArrayList<Joke> getAllJokes();
}
