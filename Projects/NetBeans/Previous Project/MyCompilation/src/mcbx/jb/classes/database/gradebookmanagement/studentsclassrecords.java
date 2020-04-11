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
public class studentsclassrecords {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int classes_id;
    private int teachers_id;
    private String types;
    private String description;
    private int students_id;
    private int gradingPeriod_id;
    private double score;
    private String information;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;
    private int[] array_classes_id;
    private int[] array_teachers_id;
    private String[] array_types;
    private String[] array_description;
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

    public String[] getArray_types() {
        return array_types;
    }

    public void setArray_types(String[] array_types) {
        this.array_types = array_types;
    }

    public String[] getArray_description() {
        return array_description;
    }

    public void setArray_description(String[] array_description) {
        this.array_description = array_description;
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
        studentsclassrecords.data = data;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public int getGradingPeriod_id() {
        return gradingPeriod_id;
    }

    public void setGradingPeriod_id(int gradingPeriod_id) {
        this.gradingPeriod_id = gradingPeriod_id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public studentsclassrecords() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(studentsclassrecords i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "' "
                    + "AND description LIKE '" + i_this.getDescription() + "' "
                    + "AND students_id = " + i_this.getStudents_id() + " "
                    + "AND gradingPeriod_id = " + i_this.getGradingPeriod_id() + ";";
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
    public void insert_studentsClassRecords(studentsclassrecords i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,classes_id,teachers_id,types,description,students_id,gradingPeriod_id,score,information) values (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getClasses_id());
            s1.setInt(5, i_this.getTeachers_id());
            s1.setString(6, i_this.getTypes());
            s1.setString(7, i_this.getDescription());
            s1.setInt(8, i_this.getStudents_id());
            s1.setInt(9, i_this.getGradingPeriod_id());
            s1.setDouble(9, i_this.getScore());
            s1.setString(11, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_studentsClassRecords(studentsclassrecords i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET types=?, description=?, gradingPeriod_id=?, score=?, information=? WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND students_id = " + i_this.getStudents_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getTypes());
            s1.setString(2, i_this.getDescription());
            s1.setInt(3, i_this.getGradingPeriod_id());
            s1.setDouble(4, i_this.getScore());
            s1.setString(5, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_studentsClassRecords(studentsclassrecords i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "' "
                    + "AND description LIKE '" + i_this.getDescription() + "' "
                    + "AND students_id = " + i_this.getStudents_id() + " "
                    + "AND gradingPeriod_id = " + i_this.getGradingPeriod_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_studentsclassrecords_array(studentsclassrecords i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " WHERE "
                        + "schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND classes_id = " + i_this.getArray_classes_id()[x] + " "
                        + "AND teachers_id = " + i_this.getArray_teachers_id()[x] + " "
                        + "AND types LIKE '" + i_this.getArray_types()[x] + "' "
                        + "AND description LIKE '" + i_this.getArray_description()[x] + "' "
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
