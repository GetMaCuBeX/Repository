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
public class gradelevel {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private String levelName;
    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_id;

    public int[] getArray_id() {
        return array_id;
    }

    public void setArray_id(int[] array_id) {
        this.array_id = array_id;
    }

    public String getQuerySearch() {
        return querySearch;
    }

    public void setQuerySearch(String querySearch) {
        this.querySearch = querySearch;
    }

    public int getQueryLimitFrom() {
        return queryLimitFrom;
    }

    public void setQueryLimitFrom(int queryLimitFrom) {
        this.queryLimitFrom = queryLimitFrom;
    }

    public int getQueryLimitTo() {
        return queryLimitTo;
    }

    public void setQueryLimitTo(int queryLimitTo) {
        this.queryLimitTo = queryLimitTo;
    }

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        gradelevel.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public gradelevel() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_levelName_exist(gradelevel i_this, Connection conn) {
        try {
            String q1 = "SELECT gradelevel.id FROM " + className + " "
                    + "WHERE gradelevel.levelName LIKE '" + i_this.getLevelName() + "';";
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
    public void insert_gradelevel(gradelevel i_this, Connection conn) {
        try {
            String query = "INSERT INTO " + className + " (levelName) values (?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            s1.setString(1, i_this.getLevelName());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_gradelevel(gradelevel i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET levelName=? WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getLevelName());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_gradelevel(gradelevel i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_gradelevel_array(gradelevel i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_id().length; x++) {
                String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getArray_id()[x] + "; ";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

// ----------------------------------------------------------------------------- [QUERY]
    public int select_gradelevel_levelName(gradelevel i_this, Connection conn) {
        gradelevel.setData(new Vector());
        try {
            String q1 = "SELECT gl.levelName "
                    + "FROM " + className + " AS gl "
                    + "ORDER BY gl.levelName ASC;";
            int resultCount = executeQuery(q1, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_gradelevel_id(gradelevel i_this, Connection conn) {
        try {
            String q1 = "SELECT gl.id "
                    + "FROM " + className + " AS gl "
                    + "WHERE gl.levelName LIKE '" + i_this.getLevelName() + "' ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs;
            rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getInt("gl.id");
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

// ----------------------------------------------------------------------------- [EXECUTE QUERY]
    private int executeQuery(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = s1.executeQuery();
            while (rs.next()) {
                resultCount++;
                String levelName_rs = rs.getString("gl.levelName");

                Vector row = new Vector();
                row.add(levelName_rs);
                gradelevel.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }
}
