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
public class studentsclassroomclasses {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int classes_id;
    private int teachers_id;
    private int students_id;
    private boolean isDrop;
    private String dropDate;
    private String information;
    private int gradingPeriod_id;
    private int gradingPeriodFinalGrade;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;
    private int[] array_classes_id;
    private int[] array_teachers_id;
    private int[] array_students_id;
    private int[] array_gradingPeriod_id;

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

    public int[] getArray_students_id() {
        return array_students_id;
    }

    public void setArray_students_id(int[] array_students_id) {
        this.array_students_id = array_students_id;
    }

    public int[] getArray_gradingPeriod_id() {
        return array_gradingPeriod_id;
    }

    public void setArray_gradingPeriod_id(int[] array_gradingPeriod_id) {
        this.array_gradingPeriod_id = array_gradingPeriod_id;
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
        studentsclassroomclasses.data = data;
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

    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public boolean isIsDrop() {
        return isDrop;
    }

    public void setIsDrop(boolean isDrop) {
        this.isDrop = isDrop;
    }

    public String getDropDate() {
        return dropDate;
    }

    public void setDropDate(String dropDate) {
        this.dropDate = dropDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getGradingPeriod_id() {
        return gradingPeriod_id;
    }

    public void setGradingPeriod_id(int gradingPeriod_id) {
        this.gradingPeriod_id = gradingPeriod_id;
    }

    public int getGradingPeriodFinalGrade() {
        return gradingPeriodFinalGrade;
    }

    public void setGradingPeriodFinalGrade(int gradingPeriodFinalGrade) {
        this.gradingPeriodFinalGrade = gradingPeriodFinalGrade;
    }

    public studentsclassroomclasses() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(studentsclassroomclasses i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND students_id = " + i_this.getStudents_id() + " AND"
                    + "AND gradingPeriod_id = " + i_this.getGradeLevel_id() + ";";
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
    public void insert_studentsclassroomclasses(studentsclassroomclasses i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,classes_id,teachers_id,students_id,isDrop,dropDate,information,gradingPeriod_id,gradingPeriodFinalGrade) values (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getClasses_id());
            s1.setInt(5, i_this.getTeachers_id());
            s1.setInt(6, i_this.getStudents_id());
            s1.setBoolean(7, i_this.isIsDrop());
            s1.setString(8, i_this.getDropDate());
            s1.setString(9, i_this.getInformation());
            s1.setInt(10, i_this.getClasses_id());
            s1.setInt(11, i_this.getTeachers_id());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_studentsclassroomclasses(studentsclassroomclasses i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET isDrop=?, dropDate=?, information=?, gradingPeriodFinalGrade=? WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND students_id = " + i_this.getStudents_id() + " "
                    + "AND gradingPeriod_id = " + i_this.getGradingPeriod_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setBoolean(1, i_this.isIsDrop());
            s1.setString(2, i_this.getDropDate());
            s1.setString(3, i_this.getInformation());
            s1.setInt(4, i_this.getGradingPeriodFinalGrade());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_studentsclassroomclasses(studentsclassroomclasses i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND students_id = " + i_this.getStudents_id() + " "
                    + "AND gradingPeriod_id = " + i_this.getGradingPeriod_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_studentsclassroomclasses_array(studentsclassroomclasses i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND teachers_id = " + i_this.getArray_teachers_id()[x] + " "
                        + "AND students_id = " + i_this.getArray_students_id()[x] + " "
                        + "AND gradingPeriod_id = " + i_this.getArray_gradingPeriod_id()[x] + ";";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
