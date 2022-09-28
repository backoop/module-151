package ch.bbw.lm.model;

import ch.bbw.lm.dao.DatabaseAccess;
import ch.bbw.lm.dao.DatabaseAccessFactory;
import ch.bbw.lm.dao.DatabaseAccess_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class JokeBook {

    private static ArrayList<Joke> jokeList;

    public JokeBook(DatabaseAccess dao){
        super();
        jokeList = dao.getAllJokes();
    }

    public static void addJoketoBook(Joke joke) throws SQLException, ClassNotFoundException {
        DatabaseAccess dao = DatabaseAccessFactory.createDataBaseAccess("sql");
        DatabaseAccess dao_ma = DatabaseAccessFactory.createDataBaseAccess("ma");

        jokeList = dao.getAllJokes();
        jokeList.add(joke);
        syncBookWithDB(jokeList);

        ArrayList<Joke> jokeList2 = dao_ma.getAllJokes();
        jokeList2.add(joke);
        syncBookWithMA(jokeList2);
    }

    public static void syncBookWithDB(ArrayList<Joke> jokes) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/jokedb";
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

        String delete = "DELETE FROM joke";
        PreparedStatement Deletestatement = connection.prepareStatement(delete);
        Deletestatement.executeUpdate();

        String sql = "INSERT INTO joke (id, text, date, rating) VALUES (?, ?, ?, ?)";

        for(int i = 0; i < jokes.size(); i++){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, jokes.get(i).getId());
            statement.setString(2, jokes.get(i).getText());
            statement.setDate(3, new java.sql.Date(jokes.get(i).getDate().getTime()));
            statement.setInt(4, jokes.get(i).getRating());
            statement.executeUpdate();
        }

    }

    public static void syncBookWithMA(ArrayList<Joke> jokes) throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Schulkonto/Projects_School/module-151/loris/DAODatabaseAccess_Loris/JokeDB.accdb");
        String sql = "INSERT INTO joke (jokeid, content, date, rating) VALUES (?, ?, ?, ?)";

        String delete = "DELETE FROM joke";
        PreparedStatement Deletestatement = connection.prepareStatement(delete);
        Deletestatement.executeUpdate();

        for (int i = 0; i < jokes.size(); i++){
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, jokes.get(i).getId());
        statement.setString(2, jokes.get(i).getText());
        statement.setDate(3, new java.sql.Date(jokes.get(i).getDate().getTime()));
        statement.setInt(4, jokes.get(i).getRating());
        statement.executeUpdate();
        }

    }

    @Override
    public String toString() {
        return "JokeBook{" +
                "jokeList=" + jokeList +
                '}';
    }
}
