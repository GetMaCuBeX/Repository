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
public class attendance {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private String schoolDays;
    private int schoolYear_id;
    private boolean isHoliday;
    private String information;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolDays;
    private String[] array_schoolYear_id;

    public int[] getArray_schoolDays() {
        return array_schoolDays;
    }

    public void setArray_schoolDays(int[] array_schoolDays) {
        this.array_schoolDays = array_schoolDays;
    }

    public String[] getArray_schoolYear_id() {
        return array_schoolYear_id;
    }

    public void setArray_schoolYear_id(String[] array_schoolYear_id) {
        this.array_schoolYear_id = array_schoolYear_id;
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
        attendance.data = data;
    }

    public String getSchoolDays() {
        return schoolDays;
    }

    public void setSchoolDays(String schoolDays) {
        this.schoolDays = schoolDays;
    }

    public int getSchoolYear_id() {
        return schoolYear_id;
    }

    public void setSchoolYear_id(int schoolYear_id) {
        this.schoolYear_id = schoolYear_id;
    }

    public boolean isIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public attendance() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(attendance i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE schoolDays LIKE '" + i_this.getSchoolDays() + "' "
                    + "AND schoolYear_id LIKE '" + i_this.getSchoolYear_id() + "';";
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
    public void insert_attendance(attendance i_this, Connection conn) {
        try {
            String query = "INSERT INTO " + className + " (schoolDays,schoolYear_id,isHoliday,information) values (?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            s1.setString(1, i_this.getSchoolDays());
            s1.setInt(2, i_this.getSchoolYear_id());
            s1.setBoolean(3, i_this.isIsHoliday());
            s1.setString(4, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_attendance(attendance i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET isHoliday=?,information=? "
                    + "WHERE schoolDays = " + i_this.getSchoolDays() + " "
                    + "AND schoolYear_id = " + i_this.getSchoolYear_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setBoolean(1, i_this.isIsHoliday());
            s1.setString(2, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_attendance(attendance i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE schoolDays = " + i_this.getSchoolDays() + " "
                    + "AND schoolYear_id = " + i_this.getSchoolYear_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_attendance_array(attendance i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolDays = " + i_this.getArray_schoolDays()[x] + " "
                        + "AND schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + ";";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
