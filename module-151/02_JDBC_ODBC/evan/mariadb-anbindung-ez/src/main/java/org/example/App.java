package org.example;

import java.sql.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {// Driver class für MySql-Datenbankladen
            Class.forName("com.mysql.cj.jdbc.Driver");// Verbindung zur Datenbank herstellen// Setzen Sie den richtigen Port, auf dem ihre Datenbank läuft// zbsp 3306
            String connectionUrl = "jdbc:mysql://localhost:3306/jokedb";//beachten Sie username und passwort
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");// Sql Befehl aufbauen und ausführen
            Statement stmt = connection.createStatement();
            ResultSet entries = stmt.executeQuery("SELECT * FROM joke");// alle Datensätze aus dem ResultSet auslesen und// (Schritt 1) in einer ArrayList ablegen
            while (entries.next()) {
                System.out.println(entries.getString("text"));
            }// alle verwendeten Objekte schliessen
            entries.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
