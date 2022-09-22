package ch.jringli.daojokes;


import ch.jringli.daojokes.dao.DatabaseAccess;
import ch.jringli.daojokes.dao.DatabaseAccessMSA;
import ch.jringli.daojokes.dao.DatabaseAccessSQL;
import ch.jringli.daojokes.model.JokeBook;

import java.sql.*;

/**
 * @Author: Janis Ringli
 * @Date: 01.09.2022
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("----------SQL-----------");
        DatabaseAccessSQL SQLdao = new DatabaseAccessSQL();
        JokeBook SQLJokeBook = new JokeBook(SQLdao);
        System.out.println(SQLJokeBook.print());

        System.out.println("----------Access-----------");
        DatabaseAccessMSA MSAdao = new DatabaseAccessMSA();
        JokeBook MSAJokebook = new JokeBook(MSAdao);
        System.out.println(MSAJokebook.print());

    }
}