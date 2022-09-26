package ch.bbw.lm.dao;

import ch.bbw.lm.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseAccess_ma implements DatabaseAccess{
    ArrayList<Joke> jokes = new ArrayList<>();
    @Override
    public ArrayList<Joke> getAllJokes() {
        try{
            Connection conn=DriverManager.getConnection(
                    "jdbc:ucanaccess://C:/Users/Schulkonto/Projects_School/module-151/loris/DAODatabaseAccess_Loris/JokeDB.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM joke");
            while (rs.next()) {
                jokes.add(JokeFiller_ma.createJokeObject(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jokes;
    }

    @Override
    public void createJoke(Joke joke) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Schulkonto/Projects_School/module-151/loris/DAODatabaseAccess_Loris/JokeDB.accdb");
        String sql = "INSERT INTO joke (jokeid, content, date, rating) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, joke.getId());
        statement.setString(2, joke.getText());
        statement.setDate(3, new java.sql.Date(joke.getDate().getTime()));
        statement.setInt(4, joke.getRating());
    }
}
