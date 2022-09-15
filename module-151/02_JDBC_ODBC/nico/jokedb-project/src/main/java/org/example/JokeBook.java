package org.example;
import java.sql.*;
import java.util.ArrayList;

public class JokeBook {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");



            String connectionUrl = "jdbc:mysql://localhost:3306/jokedb";

            Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");

            Statement stmt = connection.createStatement();
            ResultSet entries = stmt.executeQuery("SELECT * FROM joke");

            ArrayList array = new ArrayList<String>();
            while (entries.next()) {
                array.add(entries.getString("text"));
            }
            while (entries.next()) {
                System.out.println( entries.getString("text"));
            }
            System.out.println(array);


            entries.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
