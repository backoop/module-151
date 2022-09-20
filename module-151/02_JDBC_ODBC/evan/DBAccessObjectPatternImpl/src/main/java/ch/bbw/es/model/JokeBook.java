package ch.bbw.es.model;

import ch.bbw.es.dao.DBAccess;

import java.util.ArrayList;

public class JokeBook {
    private ArrayList<Joke> jokes;

    public JokeBook(DBAccess dao){
        jokes = dao.getAllJokes();
    }

    public void print() {
        for (Joke i: jokes){
            i.toString();
            System.out.println();
        }
    }
}
