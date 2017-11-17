package com.sample;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
         
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            /*String sql = "CREATE TABLE COMPANY " +
                            "(ID INT PRIMARY KEY     NOT NULL," +
                            " NAME           TEXT    NOT NULL, " + 
                            " AGE            INT     NOT NULL, " + 
                            " ADDRESS        CHAR(50), " + 
                            " SALARY         REAL)"; 
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
            stmt.executeUpdate(sql);*/

            

            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }


    }
}
