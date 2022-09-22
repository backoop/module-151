package ch.jringli.daojokes.dao;

import ch.jringli.daojokes.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseAccessMSA implements DatabaseAccess {
    public ArrayList<Joke> getAllJokes() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");// Verbindung zur Datenbank herstellen// Setzen Sie den richtigen Port, auf dem ihre Datenbank läuft// zbsp 3306
        String databaseURL = "jdbc:ucanaccess:///Users/janisringli/Coding/backoop/module-151/janis/jokesdb/JokeDB.accdb";
        Connection connection = DriverManager.getConnection(databaseURL, "root", "1234");// Sql Befehl aufbauen und ausführen
        Statement stmt = connection.createStatement();
        ResultSet entries = stmt.executeQuery("SELECT * FROM joke");// alle Datensätze aus dem ResultSet auslesen und// (Schritt 1) in einer ArrayList ablegen
        ArrayList<Joke> jokes = new ArrayList<>();
        while (entries.next()) {
            Joke joke = JokeFillerMSA.createJokeObject(entries);
            jokes.add(joke);
        }
        return jokes;

    }
}
