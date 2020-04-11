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
public class teachersgradingsystem {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int classes_id;
    private int teachers_id;
    private String types;
    private int percentage;
    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;
    private int[] array_classes_id;
    private int[] array_teachers_id;
    private String[] array_types;

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

    public int[] getArray_classes_id() {
        return array_classes_id;
    }

    public void setArray_classes_id(int[] array_classes_id) {
        this.array_classes_id = array_classes_id;
    }

    public int[] getArray_teachers_id() {
        return array_teachers_id;
    }

    public void setArray_teachers_id(int[] array_teachers_id) {
        this.array_teachers_id = array_teachers_id;
    }

    public String[] getArray_types() {
        return array_types;
    }

    public void setArray_types(String[] array_types) {
        this.array_types = array_types;
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
        teachersgradingsystem.data = data;
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

    public int getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(int classes_id) {
        this.classes_id = classes_id;
    }

    public int getTeachers_id() {
        return teachers_id;
    }

    public void setTeachers_id(int teachers_id) {
        this.teachers_id = teachers_id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public teachersgradingsystem() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(teachersgradingsystem i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "';";
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

    public boolean function_is_percentageTotal_100_percent(teachersgradingsystem i_this, Connection conn) {
        try {
            String q1 = "SELECT Sum(" + className + ".percentage) FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            int rs_1 = 0;
            while (rs.next()) {
                rs_1 = rs.getInt(1);
                if (rs_1 == 100) {
                    return true;
                }
                {
                    return false;
                }
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_teachersgradingsystem(teachersgradingsystem i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,classes_id,teachers_id,types,percentage) values (?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getClasses_id());
            s1.setInt(5, i_this.getTeachers_id());
            s1.setString(6, i_this.getTypes());
            s1.setInt(7, i_this.getPercentage());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_teachersgradingsystem(teachersgradingsystem i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET types=?, percentage=? WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getTypes());
            s1.setInt(1, i_this.getPercentage());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_teachersgradingsystem(teachersgradingsystem i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_teachersgradingsystem_array(teachersgradingsystem i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND classes_id = " + i_this.getArray_classes_id()[x] + " "
                        + "AND teachers_id = " + i_this.getArray_teachers_id()[x] + " "
                        + "AND types LIKE '" + i_this.getArray_types()[x] + "';";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
