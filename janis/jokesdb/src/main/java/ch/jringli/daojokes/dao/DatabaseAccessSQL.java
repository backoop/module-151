package ch.jringli.daojokes.dao;

import ch.jringli.daojokes.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseAccessSQL implements DatabaseAccess {
    public ArrayList<Joke> getAllJokes() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");// Verbindung zur Datenbank herstellen// Setzen Sie den richtigen Port, auf dem ihre Datenbank läuft// zbsp 3306
        String connectionUrl = "jdbc:mysql://localhost:3306/jokes";//beachten Sie username und passwort
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");// Sql Befehl aufbauen und ausführen
        Statement stmt = connection.createStatement();
        ResultSet entries = stmt.executeQuery("SELECT * FROM joke");// alle Datensätze aus dem ResultSet auslesen und// (Schritt 1) in einer ArrayList ablegen
        ArrayList<Joke> jokes = new ArrayList<>();
        while (entries.next()) {
            Joke joke = JokeFillerSQL.createJokeObject(entries);
            jokes.add(joke);
        }
        return jokes;
    }

}
