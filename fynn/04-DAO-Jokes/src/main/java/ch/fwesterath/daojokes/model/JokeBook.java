package ch.fwesterath.daojokes.model;

import ch.fwesterath.daojokes.dao.DataBaseAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JokeBook {
    ArrayList<Joke> jokes = new ArrayList<Joke>();

    public JokeBook(DataBaseAccess dao) throws SQLException, ClassNotFoundException {
        this.jokes = dao.getAllJokes();
    }

    public String print() {
        String output = "";
        for (int i = 0; i < jokes.size(); i++) {
            output = output + jokes.get(i) + "\n\n";
        }
        System.out.println(output);
        return output;
    }
}
