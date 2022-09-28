package ch.fwesterath.daojokes;

import ch.fwesterath.daojokes.dao.DataBaseAccess;
import ch.fwesterath.daojokes.dao.DataBaseAccessFactory;
import ch.fwesterath.daojokes.dao.maccess.DataBaseAccesMAccess;
import ch.fwesterath.daojokes.dao.sql.DataBaseAccesSQL;
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
        JokeBook jokeBook = new JokeBook(sqlDAO);
        jokeBook.print();

        System.out.println("=== MAccess ===");
        DataBaseAccess mAccessDAO = factory.getDataBaseAccess("maccess");
        JokeBook jokeBookMAccess = new JokeBook(mAccessDAO);
        jokeBookMAccess.print();

    }
}
