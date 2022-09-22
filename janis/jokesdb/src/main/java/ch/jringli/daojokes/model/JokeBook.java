package ch.jringli.daojokes.model;
import ch.jringli.daojokes.dao.DatabaseAccess;

import java.sql.*;
import java.util.ArrayList;


public class JokeBook {
    ArrayList<Joke> jokes = new ArrayList<>();
    public JokeBook(DatabaseAccess dao) throws SQLException, ClassNotFoundException {
       this.jokes = dao.getAllJokes();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Joke joke : jokes) {
            sb.append(joke).append("\n\n");
        }
        return sb.toString();
    }
}
