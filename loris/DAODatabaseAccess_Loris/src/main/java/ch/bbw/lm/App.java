package ch.bbw.lm;

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

        //SQL Database
        DatabaseAccess_sql dao_sql = new DatabaseAccess_sql();
        JokeBook sql_book = new JokeBook(dao_sql);

        //Access Database
        DatabaseAccess_ma dao_acc = new DatabaseAccess_ma();
        JokeBook access_book = new JokeBook(dao_acc);

        //Print out
        System.out.println("SQL Database");
        System.out.println(sql_book);
        System.out.println();
        System.out.println("Microsoft-Access Database");
        System.out.println(access_book);

        Joke joke = new Joke();
        joke.setupJoke(6, "Was ist braun und schwimmt im Wasser? Ein U-Brot...", new Date(System.currentTimeMillis()), 2);
        dao_sql.createJoke(joke);
        System.out.println();
        System.out.println("SQL Database with created Joke: ");
        System.out.println(sql_book);

    }
}
