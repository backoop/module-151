package ch.fwesterath.daojokes.dao.csv;

import ch.fwesterath.daojokes.dao.DataBaseAccess;
import ch.fwesterath.daojokes.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessCSV implements DataBaseAccess {

    @Override
    public ArrayList<Joke> getAllJokes() throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection connection = DriverManager.getConnection("jdbc:odbc:google");
        Statement statement = connection.createStatement();
        ResultSet entries = statement.executeQuery("select * from JokeDB.csv where id=1");

        ArrayList<Joke> jokes = new ArrayList<>();

        while (entries.next()) {
            Joke joke = JokeFillerCSV.createJokeObject(entries);
            jokes.add(joke);
        }
        return jokes;
    }
}
