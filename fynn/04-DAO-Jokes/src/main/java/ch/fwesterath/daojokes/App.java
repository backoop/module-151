package ch.fwesterath.daojokes;

import ch.fwesterath.daojokes.dao.DataBaseAccess;
import ch.fwesterath.daojokes.dao.DataBaseAccessFactory;
import ch.fwesterath.daojokes.dao.maccess.DataBaseAccesMAccess;
import ch.fwesterath.daojokes.dao.sql.DataBaseAccesSQL;
import ch.fwesterath.daojokes.model.Joke;
import ch.fwesterath.daojokes.model.JokeBook;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        DataBaseAccessFactory factory = new DataBaseAccessFactory();

        System.out.println("=== SQL ===");
        DataBaseAccess sqlDAO = factory.getDataBaseAccess("sql");
        System.out.println("---" +
                " Setting up Joke ---");
        Joke joke = new Joke();
        joke.setupJoke(6, "SQL is a joke", new Date(2022, 12, 5), 0);

        System.out.println("--- Adding Joke ---");
        sqlDAO.addJoke(joke);

        System.out.println("--- Getting all Jokes ---");
        JokeBook jokeBook = new JokeBook(sqlDAO);
        jokeBook.print();

        System.out.println("=== MAccess ===");
        DataBaseAccess mAccessDAO = factory.getDataBaseAccess("maccess");

        System.out.println("--- Setting up Joke ---");
        Joke jokemaccess = new Joke();

        System.out.println("--- Adding Joke ---");
        mAccessDAO.addJoke(jokemaccess);

        JokeBook jokeBookMAccess = new JokeBook(mAccessDAO);
        jokeBookMAccess.print();

    }
}
