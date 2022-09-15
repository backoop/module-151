package ch.fwesterath.daojokes.dao;

import ch.fwesterath.daojokes.model.Joke;

import java.util.ArrayList;

public class DataBaseAccesSQL implements DataBaseAccess {

    @Override
    public ArrayList<Joke> getAllJokes() {
        return new ArrayList<>();
    }
}
