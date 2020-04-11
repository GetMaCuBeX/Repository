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
public class classroomclasses {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int classes_id;
    private String information;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;
    private int[] array_classes_id;

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
        classroomclasses.data = data;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public classroomclasses() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(classroomclasses i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = '" + i_this.getClasses_id() + "';";
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
    public void insert_classroomclasses(classroomclasses i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,classes_id,information) values (?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getClasses_id());
            s1.setString(5, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_classroomclasses(classroomclasses i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET classes_id=?, information=? "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName = " + i_this.getSectionName() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getClasses_id());
            s1.setString(2, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_classroomclasses(classroomclasses i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_classroomclasses_array(classroomclasses i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND classes_id = " + i_this.getArray_classes_id()[x] + ";";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [QUERY]
    public int count_select_search(classroomclasses i_this, Connection conn) {
        try {
            String q1 = "SELECT cc.schoolYear_id, cc.gradeLevel_id, gl.levelName, cc.sectionName, cc.classes_id, classes.learningAreas, ct.teachers_id, csc.days, csc.startTime, csc.endTime, t.firstName, t.middleName, t.lastName FROM classroomclasses AS cc INNER JOIN classrooms AS c ON cc.schoolYear_id = c.schoolYear_id AND cc.gradeLevel_id = c.gradeLevel_id AND cc.sectionName = c.sectionName INNER JOIN classroomsections AS cs ON c.schoolYear_id = cs.schoolYear_id AND c.gradeLevel_id = cs.gradeLevel_id AND c.sectionName = cs.sectionName INNER JOIN gradelevel AS gl ON cs.gradeLevel_id = gl.id LEFT JOIN classroomclassteachers AS ct ON ct.schoolYear_id = cc.schoolYear_id AND ct.gradeLevel_id = cc.gradeLevel_id AND ct.sectionName = cc.sectionName AND ct.classes_id = cc.classes_id LEFT JOIN classschedule AS csc ON csc.schoolYear_id = cc.schoolYear_id AND csc.gradeLevel_id = cc.gradeLevel_id AND csc.sectionName = cc.sectionName AND csc.classes_id = cc.classes_id INNER JOIN classes ON cc.classes_id = classes.id LEFT JOIN teachers AS t ON c.teachers_id = t.id AND ct.teachers_id = t.id "
                    + "WHERE classes.learningAreas LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "HAVING "
                    + "cc.schoolYear_id = " + i_this.getSchoolYear_id() + " AND "
                    + "cc.gradeLevel_id = " + i_this.getGradeLevel_id() + " AND "
                    + "cc.sectionName LIKE '" + i_this.getSectionName() + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = statement.executeQuery();
                int count = 0;
                while (rs.next()) {
                    count++;
                }
                rs.close();
                return count;
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return 0;
    }

    public int select_classroomclasses_by_search(classroomclasses i_this, Connection conn) {
        classroomclasses.setData(new Vector());
        try {

            String q1 = "SELECT cc.schoolYear_id, cc.gradeLevel_id, gl.levelName, cc.sectionName, cc.classes_id, classes.learningAreas, ct.teachers_id, csc.days, csc.startTime, csc.endTime, t.firstName, t.middleName, t.lastName FROM classroomclasses AS cc INNER JOIN classrooms AS c ON cc.schoolYear_id = c.schoolYear_id AND cc.gradeLevel_id = c.gradeLevel_id AND cc.sectionName = c.sectionName INNER JOIN classroomsections AS cs ON c.schoolYear_id = cs.schoolYear_id AND c.gradeLevel_id = cs.gradeLevel_id AND c.sectionName = cs.sectionName INNER JOIN gradelevel AS gl ON cs.gradeLevel_id = gl.id LEFT JOIN classroomclassteachers AS ct ON ct.schoolYear_id = cc.schoolYear_id AND ct.gradeLevel_id = cc.gradeLevel_id AND ct.sectionName = cc.sectionName AND ct.classes_id = cc.classes_id LEFT JOIN classschedule AS csc ON csc.schoolYear_id = cc.schoolYear_id AND csc.gradeLevel_id = cc.gradeLevel_id AND csc.sectionName = cc.sectionName AND csc.classes_id = cc.classes_id INNER JOIN classes ON cc.classes_id = classes.id LEFT JOIN teachers AS t ON c.teachers_id = t.id AND ct.teachers_id = t.id "
                    + "WHERE classes.learningAreas LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "HAVING "
                    + "cc.schoolYear_id = " + i_this.getSchoolYear_id() + " AND "
                    + "cc.gradeLevel_id = " + i_this.getGradeLevel_id() + " AND "
                    + "cc.sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "LIMIT " + i_this.getQueryLimitFrom() + ", " + i_this.getQueryLimitTo() + ";";
            int resultCount = executeQuery(q1, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

// ----------------------------------------------------------------------------- [EXECUTE QUERY]

    private teachers ref_teachers = new teachers();
    private int executeQuery(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = s1.executeQuery();

            while (rs.next()) {
                resultCount++;
                String teachers_fullName;
                int schoolYear_id_rs = rs.getInt("cc.schoolYear_id");
                int gradeLevel_id_rs = rs.getInt("cc.gradeLevel_id");
                String levelName_rs = rs.getString("gl.levelName");
                String sectionName_rs = rs.getString("cc.sectionName");
                int classes_id_rs = rs.getInt("cc.classes_id");
                String learningAreas_rs = rs.getString("classes.learningAreas");
                int ct_teachers_id_rs = rs.getInt("ct.teachers_id");
                String csc_days_rs = rs.getString("csc.days");
                String csc_startTime_rs = rs.getString("csc.startTime");
                String csc_endTime_rs = rs.getString("csc.endTime");

                if (ct_teachers_id_rs != 0) {
                    ref_teachers.setId(ct_teachers_id_rs);
                    String firstName = new teachers().function_get_teachers_firstName(ref_teachers, conn);
                    String lastName = new teachers().function_get_teachers_lastName(ref_teachers, conn);
                    teachers_fullName = firstName+" "+lastName;
                } else {
                    teachers_fullName = "";
                }

                Vector row = new Vector();
                row.add(schoolYear_id_rs);
                row.add(gradeLevel_id_rs);
                row.add(levelName_rs);
                row.add(sectionName_rs);
                row.add(classes_id_rs);
                row.add(learningAreas_rs);
                row.add(ct_teachers_id_rs);
                row.add(teachers_fullName);
                row.add(csc_days_rs);
                row.add(csc_startTime_rs);
                row.add(csc_endTime_rs);

                classroomclasses.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);

        }
        return resultCount;
    }

}
