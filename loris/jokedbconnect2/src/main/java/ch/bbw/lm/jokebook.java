package ch.bbw.lm;

import java.sql.*;
import java.util.ArrayList;

public class jokebook {
    private ArrayList<Joke> jokes;

    public jokebook() {
        super();
        jokes = new ArrayList<>();

        try {// Driver class für MySql-Datenbankladen
            Class.forName("com.mysql.cj.jdbc.Driver");// Verbindung zur Datenbank herstellen// Setzen Sie den richtigen Port, auf dem ihre Datenbank läuft// zbsp 3306
            String connectionUrl = "jdbc:mysql://localhost:3306/jokedb";//beachten Sie username und passwort
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "");// Sql Befehl aufbauen und ausführen

            Statement stmt = connection.createStatement();
            ResultSet entries = stmt.executeQuery("SELECT * FROM joke");// alle Datensätze aus dem ResultSet auslesen und// (Schritt 1) in einer ArrayList ablegen

            while (entries.next()) {
                //System.out.println(entries.getString("text"));
                jokes.add(JokeFiller.createJokeObject(entries));
            }
            entries.close();
            stmt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void print() {
            for (Joke i: jokes){
                i.print();
                System.out.println();
            }
        }
}
