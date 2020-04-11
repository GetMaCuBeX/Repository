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
public class schoolyear {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private int yearFrom;
    private int yearTo;
    private String schoolId = null;
    private String region = null;
    private String district = null;
    private String schoolHead = null;
    private String division = null;
    private String schoolName = null;

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
        schoolyear.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSchoolHead() {
        return schoolHead;
    }

    public void setSchoolHead(String schoolHead) {
        this.schoolHead = schoolHead;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public schoolyear() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_yearFrom_and_yearTo_exist(schoolyear i_this, Connection conn) {
        try {
            String q1 = "SELECT " + className + ".id FROM " + className + " WHERE " + className + ".yearFrom LIKE '" + i_this.getYearFrom() + "' AND " + className + ".yearTo LIKE '" + i_this.getYearTo() + "';";
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

    public int function_get_id(schoolyear i_this, Connection conn) {
        try {
            String q1 = "SELECT " + className + ".id FROM " + className + " WHERE " + className + ".yearFrom LIKE '" + i_this.getYearFrom() + "' AND " + className + ".yearTo LIKE '" + i_this.getYearTo() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getInt("schoolyear.id");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_schoolyear(schoolyear i_this, Connection conn) {
        try {
            String query = "INSERT INTO " + className + " (yearFrom,yearTo,schoolId,region,district,schoolHead,division,schoolName) values (?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            s1.setInt(1, i_this.getYearFrom());
            s1.setInt(2, i_this.getYearTo());
            s1.setString(3, i_this.getSchoolId());
            s1.setString(4, i_this.getRegion());
            s1.setString(5, i_this.getDistrict());
            s1.setString(6, i_this.getSchoolHead());
            s1.setString(7, i_this.getDivision());
            s1.setString(8, i_this.getSchoolName());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_schoolyear(schoolyear i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET yearFrom=?, yearTo=?, schoolId=?, region=?, district=?, schoolHead=?, division=?, schoolName=? WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getYearFrom());
            s1.setInt(2, i_this.getYearTo());
            s1.setString(3, i_this.getSchoolId());
            s1.setString(4, i_this.getRegion());
            s1.setString(5, i_this.getDistrict());
            s1.setString(6, i_this.getSchoolHead());
            s1.setString(7, i_this.getDivision());
            s1.setString(8, i_this.getSchoolName());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_schoolyear(schoolyear i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_schoolyear_array(schoolyear i_this, Connection conn) {
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
    public int select_schoolyear_yearFrom_yearTo(schoolyear i_this, Connection conn) {
        schoolyear.setData(new Vector());
        try {
            String q1 = "SELECT CONCAT (sy.yearFrom,' - ' ,sy.yearTo) as yFyT FROM " + className + " AS sy ORDER BY sy.id ASC;";
            int resultCount = executeQuery(q1, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
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
                String schoolyear_rs = rs.getString("yFyT");

                Vector row = new Vector();
                row.add(schoolyear_rs);
                schoolyear.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

}
