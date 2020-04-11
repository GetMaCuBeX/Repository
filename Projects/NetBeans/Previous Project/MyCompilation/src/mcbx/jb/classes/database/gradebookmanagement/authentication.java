/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcbx.jb.classes.database.gradebookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class authentication {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int teachers_id;
    private String username;
    private String password;

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        authentication.data = data;
    }

    public int getTeachers_id() {
        return teachers_id;
    }

    public void setTeachers_id(int teachers_id) {
        this.teachers_id = teachers_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public authentication() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_username_and_password_exist(authentication i_this, Connection conn) {
        try {
            String q1 = "SELECT teachers_id FROM " + className + " "
                    + "WHERE username LIKE '" + i_this.getUsername() + "' "
                    + "AND password LIKE '" + i_this.getPassword() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                i_this.setTeachers_id(rs.getInt("teachers_id"));
                return true;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }

    public boolean function_is_teachers_id_exist(authentication i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE teachers_id = " + i_this.getTeachers_id() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_authentication(authentication i_this, Connection conn) {
        try {
            String query = "INSERT INTO " + className + " (teachers_id,username,password) values (?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            s1.setInt(1, i_this.getTeachers_id());
            s1.setString(2, i_this.getUsername());
            s1.setString(3, i_this.getPassword());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_authentication(authentication i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET username=?,password=? "
                    + "WHERE teachers_id = " + i_this.getTeachers_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getUsername());
            s1.setString(2, i_this.getPassword());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_authentication(authentication i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE teachers_id = " + i_this.getTeachers_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
