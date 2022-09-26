package ch.bbw.lm.model;

import ch.bbw.lm.dao.DatabaseAccess;

import java.util.ArrayList;

public class JokeBook {

    private ArrayList<Joke> jokeList;

    public JokeBook(DatabaseAccess dao){
        super();
        jokeList = dao.getAllJokes();
    }

    @Override
    public String toString() {
        return "JokeBook{" +
                "jokeList=" + jokeList +
                '}';
    }
}
