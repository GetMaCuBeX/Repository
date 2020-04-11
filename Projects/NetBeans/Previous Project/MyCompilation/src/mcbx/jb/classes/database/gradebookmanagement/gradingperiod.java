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
public class gradingperiod {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private int gradePeriod;
    private String description = null;

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
        gradingperiod.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGradePeriod() {
        return gradePeriod;
    }

    public void setGradePeriod(int gradePeriod) {
        this.gradePeriod = gradePeriod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public gradingperiod() {
    }

// ----------------------------------------------------------------------------- [RETURN]
// ----------------------------------------------------------------------------- [INSERT]
// ----------------------------------------------------------------------------- [UPDATE]
// ----------------------------------------------------------------------------- [DELETE]
    public void delete_gradingperiod(gradingperiod i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_gradingperiod_array(gradingperiod i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE id = " + i_this.getArray_id()[x] + " ;";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }



// ----------------------------------------------------------------------------- [DISPLAY]
}
