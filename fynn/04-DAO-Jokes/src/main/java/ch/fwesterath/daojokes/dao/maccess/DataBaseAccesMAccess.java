package ch.fwesterath.daojokes.dao.maccess;

import ch.fwesterath.daojokes.dao.DataBaseAccess;
import ch.fwesterath.daojokes.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccesMAccess implements DataBaseAccess {

    @Override
    public ArrayList<Joke> getAllJokes() throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");// Verbindung zur Datenbank herstellen// Setzen Sie den richtigen Port, auf dem ihre Datenbank läuft// zbsp 3306
        String connectionUrl = "jdbc:ucanaccess:///home//fwesterath//Documents//School//backoop//module-151//fynn//04-DAO-Jokes//JokeDB.accdb";
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");// Sql Befehl aufbauen und ausführen
        Statement stmt = connection.createStatement();
        ResultSet entries = stmt.executeQuery("SELECT * FROM joke");// alle Datensätze aus dem ResultSet auslesen und// (Schritt 1) in einer ArrayList ablegen

        ArrayList<Joke> jokes = new ArrayList<>();

        while (entries.next()) {
            Joke joke = JokeFillerMAccess.createJokeObject(entries);
            jokes.add(joke);
        }
        return jokes;
    }
}
