package ch.bbw.lm;

import ch.bbw.lm.dao.DatabaseAccess;
import ch.bbw.lm.dao.DatabaseAccessFactory;
import ch.bbw.lm.dao.DatabaseAccess_ma;
import ch.bbw.lm.dao.DatabaseAccess_sql;
import ch.bbw.lm.model.Joke;
import ch.bbw.lm.model.JokeBook;

import java.sql.SQLException;
import java.util.Date;

/**
 * Loris Müller
 * Modul 151
 */

public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        System.out.println("DAO Database Access from Loris Müller: ");
        System.out.println();

        DatabaseAccess dao_sql = DatabaseAccessFactory.createDataBaseAccess("sql");
        DatabaseAccess dao_ma = DatabaseAccessFactory.createDataBaseAccess("ma");
        //SQL Database
        JokeBook sql_book = new JokeBook(dao_sql);

        //Access Database
        JokeBook access_book = new JokeBook(dao_ma);

        //Print out
        System.out.println("SQL Database: ");
        System.out.println();
        System.out.println(sql_book);
        System.out.println();
        System.out.println("####################################");
        System.out.println("Microsoft-Access Database: ");
        System.out.println();
        System.out.println(access_book);

        Joke joke = new Joke();
        joke.setupJoke(7, "Wer wohnt im Dschungel und schummelt immer?  'Mogli' ", new Date(System.currentTimeMillis()), 5);

        JokeBook.addJoketoBook(joke);
        System.out.println();
        System.out.println("####################################");
        System.out.println("SQL Database with created Joke: ");
        JokeBook updated_book = new JokeBook(dao_sql);
        System.out.println();
        System.out.println(updated_book);

        JokeBook access_book2 = new JokeBook(dao_ma);
        System.out.println();
        System.out.println("####################################");
        System.out.println("New Access-Database with created Joke: ");
        System.out.println();
        System.out.println(access_book2);

    }
}
