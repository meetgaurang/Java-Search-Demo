package com.sample.common;

import java.sql.*;
import com.sample.dao.DBInit;

/**
 * App Entry Point Class
 */
public class AppEntryPoint
{
    public static void main( String[] args )
    {
        //Connection c = DBInit.getConnection();
        Statement stmt = DBInit.getStatement();
        try {
            //stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                            "(ID INT PRIMARY KEY     NOT NULL," +
                            " NAME           TEXT    NOT NULL, " + 
                            " AGE            INT     NOT NULL, " + 
                            " ADDRESS        CHAR(50), " + 
                            " SALARY         REAL)"; 
            stmt.executeUpdate(sql);
            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}