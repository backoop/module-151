package ch.bbw.lm.dao;

import ch.bbw.lm.model.Joke;
import ch.bbw.lm.model.JokeBook;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseAccess_sql implements DatabaseAccess{
    @Override
    public ArrayList<Joke> getAllJokes() {
            ArrayList<Joke> jokes = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/jokedb";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

            Statement stmt = connection.createStatement();
            ResultSet entries = stmt.executeQuery("SELECT * FROM joke");

            while (entries.next()) {
                jokes.add(JokeFiller_sql.createJokeObject(entries));
            }
            entries.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return jokes;
    }

    @Override
    public void createJoke(Joke joke) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/jokedb";
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "");
        String sql = "INSERT INTO joke (id, text, date, rating) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, joke.getId());
        statement.setString(2, joke.getText());
        statement.setDate(3, new java.sql.Date(joke.getDate().getTime()));
        statement.setInt(4, joke.getRating());*/

    }


}
