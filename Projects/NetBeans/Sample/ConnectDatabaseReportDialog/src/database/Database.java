/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import javafx.stage.Window;

public class Database {

    // Create instance default databse connection 
    public static MySQL BOOKS_RESERVATION = new MySQL("localhost", "3306", "booksreservation", "root", "");

    public static Connection getConnectionMySQL(MySQL mysqlConnection, Window owner) {
        try {
            mysqlConnection.connectToServer(owner);
            Connection conn = mysqlConnection.getConnection();
            return conn;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public static Connection getConnectionMySQL(MySQL mysqlConnection) {
        try {
            mysqlConnection.connectToServer();
            Connection conn = mysqlConnection.getConnection();
            return conn;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
 
}
