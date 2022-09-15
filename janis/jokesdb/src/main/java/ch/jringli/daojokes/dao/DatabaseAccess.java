package ch.jringli.daojokes.dao;

import ch.jringli.daojokes.model.Joke;

import java.util.ArrayList;

public interface DatabaseAccess {
    public ArrayList<Joke> getAllJokes();
}
