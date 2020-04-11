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
public class studentsbooksrecords {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int students_id;
    private int books_id;
    private String acquiredDate;
    private boolean isReturned;
    private String information;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;
    private int[] array_students_id;
    private int[] array_books_id;

    public int[] getArray_schoolYear_id() {
        return array_schoolYear_id;
    }

    public void setArray_schoolYear_id(int[] array_schoolYear_id) {
        this.array_schoolYear_id = array_schoolYear_id;
    }

    public int[] getArray_gradeLevel_id() {
        return array_gradeLevel_id;
    }

    public void setArray_gradeLevel_id(int[] array_gradeLevel_id) {
        this.array_gradeLevel_id = array_gradeLevel_id;
    }

    public String[] getArray_sectionName() {
        return array_sectionName;
    }

    public void setArray_sectionName(String[] array_sectionName) {
        this.array_sectionName = array_sectionName;
    }

    public int[] getArray_students_id() {
        return array_students_id;
    }

    public void setArray_students_id(int[] array_students_id) {
        this.array_students_id = array_students_id;
    }

    public int[] getArray_books_id() {
        return array_books_id;
    }

    public void setArray_books_id(int[] array_books_id) {
        this.array_books_id = array_books_id;
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
        studentsbooksrecords.data = data;
    }

    public int getSchoolYear_id() {
        return schoolYear_id;
    }

    public void setSchoolYear_id(int schoolYear_id) {
        this.schoolYear_id = schoolYear_id;
    }

    public int getGradeLevel_id() {
        return gradeLevel_id;
    }

    public void setGradeLevel_id(int gradeLevel_id) {
        this.gradeLevel_id = gradeLevel_id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public int getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int books_id) {
        this.books_id = books_id;
    }

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(String acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public boolean isIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public studentsbooksrecords() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(studentsbooksrecords i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE " + className + ".schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND " + className + ".gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND " + className + ".sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND " + className + ".students_id = " + i_this.getStudents_id() + " "
                    + "AND " + className + ".books_id = " + i_this.getBooks_id() + ";";
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
    public void insert_studentsbooksrecords(studentsbooksrecords i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,students_id,books_id,acquiredDate,isReturned,information) values (?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getStudents_id());
            s1.setInt(5, i_this.getBooks_id());
            s1.setString(6, i_this.getAcquiredDate());
            s1.setBoolean(7, i_this.isIsReturned());
            s1.setString(8, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_studentsbooksrecords(studentsbooksrecords i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET acquiredDate=?, isReturned=?, information=? "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND students_id = " + i_this.getStudents_id() + " "
                    + "AND books_id = " + i_this.getBooks_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getAcquiredDate());
            s1.setBoolean(2, i_this.isIsReturned());
            s1.setString(3, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_studentsbooksrecords(studentsbooksrecords i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND students_id = " + i_this.getStudents_id() + " "
                    + "AND books_id = " + i_this.getBooks_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_studentsbooksrecords_array(studentsbooksrecords i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND students_id = " + i_this.getArray_students_id()[x] + " "
                        + "AND books_id = '" + i_this.getArray_books_id()[x] + "';";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
