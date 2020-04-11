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
public class classroomstudents {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int students_id;
    private boolean isRegular;
    private String enroledDate;
    private String information;
    private boolean isDrop;
    private String dropDate;
    private String reason;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;
    private int[] array_students_id;

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
        classroomstudents.data = data;
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

    public boolean isIsRegular() {
        return isRegular;
    }

    public void setIsRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }

    public String getEnroledDate() {
        return enroledDate;
    }

    public void setEnroledDate(String enroledDate) {
        this.enroledDate = enroledDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public classroomstudents() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND students_id = " + i_this.getStudents_id() + ";";
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
    public void insert_classroomstudents_isDrop_false(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,students_id,isRegular,enroledDate,information,isDrop) values (?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getStudents_id());
            s1.setBoolean(5, i_this.isIsRegular());
            s1.setString(6, i_this.getEnroledDate());
            s1.setString(7, i_this.getInformation());
            s1.setBoolean(8, i_this.isIsDrop());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void insert_classroomstudents_isDrop_true(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,students_id,isRegular,enroledDate,information,isDrop,dropDate,reason) values (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getStudents_id());
            s1.setBoolean(5, i_this.isIsRegular());
            s1.setString(6, i_this.getEnroledDate());
            s1.setString(7, i_this.getInformation());
            s1.setBoolean(8, i_this.isIsDrop());
            s1.setString(9, i_this.getDropDate());
            s1.setString(10, i_this.getReason());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_classroomstudents_isDrop_false(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET isRegular=? enroledDate=?, information=? "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName = " + i_this.getSectionName() + " "
                    + "AND students_id = " + i_this.getStudents_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setBoolean(1, i_this.isIsRegular());
            s1.setString(2, i_this.getEnroledDate());
            s1.setString(3, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void update_classroomstudents_isDrop_true(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET isRegular=? enroledDate=?, information=?, isDrop=?, dropDate=?,reason=? "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName = " + i_this.getSectionName() + " "
                    + "AND students_id = " + i_this.getStudents_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setBoolean(1, i_this.isIsRegular());
            s1.setString(2, i_this.getEnroledDate());
            s1.setString(3, i_this.getInformation());
            s1.setBoolean(4, i_this.isIsDrop());
            s1.setString(5, i_this.getDropDate());
            s1.setString(6, i_this.getReason());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_classroomstudents(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND students_id = " + i_this.getStudents_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_classroomstudents_array(classroomstudents i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND students_id = " + i_this.getArray_students_id()[x] + ";";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [QUERY]
    public int count_select_search(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "SELECT cs.schoolYear_id,cs.gradeLevel_id,cs.sectionName "
                    + "FROM students AS s LEFT JOIN classroomstudents AS cs ON s.id = cs.students_id "
                    + "WHERE "
                    + "s.firstName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.middleName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.lastName LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "HAVING cs.schoolYear_id = " + i_this.getSchoolYear_id() + " AND "
                    + "cs.gradeLevel_id = " + i_this.getGradeLevel_id() + " AND "
                    + "cs.sectionName LIKE '" + i_this.getSectionName() + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = statement.executeQuery();
                int count = 0;
                while (rs.next()) {
                    int b_resultCount_rs = rs.getInt(1);
//                    return b_resultCount_rs;
                    count++;
                }
                rs.close();
                return count;
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return 0;
    }

    public int count_select(classroomstudents i_this, Connection conn) {
        try {
            String q1 = "SELECT cs.schoolYear_id,cs.gradeLevel_id,cs.sectionName "
                    + "FROM students AS s LEFT JOIN classroomstudents AS cs ON s.id = cs.students_id "
                    + "HAVING cs.schoolYear_id = " + i_this.getSchoolYear_id() + " AND "
                    + "cs.gradeLevel_id = " + i_this.getGradeLevel_id() + " AND "
                    + "cs.sectionName LIKE '" + i_this.getSectionName() + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = statement.executeQuery();
                int count = 0;
                while (rs.next()) {
//                    int b_resultCount_rs = rs.getInt(1);
//                    return b_resultCount_rs;
                    count++;
                }
                rs.close();
                return count;
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

        return 0;
    }

    public int select_classroomstudents_by_search(classroomstudents i_this, Connection conn) {
        classroomstudents.setData(new Vector());
        try {
            String q1 = "SELECT "
                    + "cs.schoolYear_id, "
                    + "cs.gradeLevel_id, "
                    + "cs.sectionName, "
                    + "s.id, s.firstName, "
                    + "s.middleName, "
                    + "s.lastName, "
                    + "s.sex, "
                    + "cs.isRegular, "
                    + "cs.enroledDate, "
                    + "cs.isDrop "
                    + "FROM "
                    + "students AS s LEFT JOIN classroomstudents AS cs ON s.id = cs.students_id "
                    + "WHERE "
                    + "s.firstName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.middleName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.lastName LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "HAVING cs.schoolYear_id = " + i_this.getSchoolYear_id() + " AND "
                    + "cs.gradeLevel_id = " + i_this.getGradeLevel_id() + " AND "
                    + "cs.sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "LIMIT " + i_this.getQueryLimitFrom() + ", " + i_this.getQueryLimitTo() + ";";
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
                int schoolYear_id_rs = rs.getInt("cs.schoolYear_id");
                int gradeLevel_id_rs = rs.getInt("cs.gradeLevel_id");
                String sectionName_rs = rs.getString("cs.sectionName");

                int students_id_rs = rs.getInt("s.id");
                String students_firstName_rs = rs.getString("s.firstName");
                String students_middleName_rs = rs.getString("s.middleName");
                String students_lastName_rs = rs.getString("s.lastName");
                String students_gender_rs = rs.getString("s.sex");
                boolean isRegular_rs = rs.getBoolean("cs.isRegular");
                java.sql.Date enroledDate_rs = rs.getDate("cs.enroledDate");
                boolean isDrop_rs = rs.getBoolean("cs.isDrop");

                Vector row = new Vector();
                row.add(schoolYear_id_rs);
                row.add(gradeLevel_id_rs);
                row.add(sectionName_rs);
                row.add(students_id_rs);
                row.add(students_firstName_rs);
                row.add(students_middleName_rs);
                row.add(students_lastName_rs);
                row.add(students_gender_rs);
                row.add(isRegular_rs);
                row.add(enroledDate_rs);
                row.add(isDrop_rs);

                classroomstudents.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

}
