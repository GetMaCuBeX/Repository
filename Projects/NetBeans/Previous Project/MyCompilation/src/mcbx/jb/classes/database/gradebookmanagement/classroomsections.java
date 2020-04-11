package mcbx.jb.classes.database.gradebookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import mcbx.jb.classes.database.gradebookmanagement.globalmessages;

public class classroomsections {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private String information;
    private String status;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_schoolYear_id;
    private int[] array_gradeLevel_id;
    private String[] array_sectionName;

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
        classroomsections.data = data;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public classroomsections() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(classroomsections i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE " + className + ".schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND " + className + ".gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND " + className + ".sectionName LIKE '" + i_this.getSectionName() + "';";
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
    public String insert_classroomsections(classroomsections i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,information,status) values (?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setString(4, i_this.getInformation());
            s1.setString(5, i_this.getStatus());
            s1.execute();

            return (globalmessages.crude_info_insert);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_insert + "\n" + sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_classroomsections(classroomsections i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET sectionName=?, information=?, status=? "
                    + "WHERE " + className + ".schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND " + className + ".gradeLevel_id = " + i_this.getGradeLevel_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getSectionName());
            s1.setString(2, i_this.getInformation());
            s1.setString(3, i_this.getStatus());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void update_classroomsections_information(classroomsections i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET information=? "
                    + "WHERE " + className + ".schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND " + className + ".gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND " + className + ".sectionName LIKE '" + i_this.getSectionName() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getInformation());
            s1.execute();
//            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
//            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_classroomsections(classroomsections i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_classroomsections_array(classroomsections i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "';";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [QUERY]
    public int count_select_search(classroomsections i_this, Connection conn) {
        try {

            String q1 = "SELECT Count(cs.sectionName) as resultCount "
                    + "FROM " + className + " AS cs "
                    + "WHERE "
                    + "cs.schoolYear_id = "+UserLogs.getSchoolyear_id()+" AND "
                    + "cs.sectionName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "cs.information LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "cs.status LIKE '%" + i_this.getQuerySearch() + "%';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int b_resultCount_rs = rs.getInt(1);
                    return b_resultCount_rs;
                }
                rs.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return 0;
    }

    public int select_classroomsections_by_search(classroomsections i_this, Connection conn) {
        classroomsections.setData(new Vector());
        try {
            String q1 = "SELECT cs.schoolYear_id, cs.gradeLevel_id, gl.levelName, cs.sectionName, cs.information, 'cs.status', c.teachers_id, t.firstName, t.middleName, t.lastName FROM " + className + " AS cs INNER JOIN gradelevel AS gl ON cs.gradeLevel_id = gl.id LEFT JOIN classrooms AS c ON c.schoolYear_id = cs.schoolYear_id AND c.gradeLevel_id = cs.gradeLevel_id AND c.sectionName = cs.sectionName LEFT JOIN teachers AS t ON c.teachers_id = t.id "
                    + "WHERE "
                    + "cs.schoolYear_id = "+UserLogs.getSchoolyear_id()+" AND "
                    + "cs.sectionName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "cs.information LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "ORDER BY cs.gradeLevel_id ASC, cs.sectionName ASC "
                    + "LIMIT " + i_this.getQueryLimitFrom() + ", " + i_this.getQueryLimitTo() + ";";
            int resultCount = executeQuery(q1, conn);

            return resultCount;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

// ----------------------------------------------------------------------------- [EXECUTE QUERY]
    private int executeQuery(String query, Connection conn) {
        int resultCount = 0;
        try {
            classroomstudents ref_classroomstudents = new classroomstudents();
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = s1.executeQuery();

            while (rs.next()) {
                resultCount++;
                int schoolYear_id_rs = rs.getInt("cs.schoolYear_id");
                int gradeLevel_id_rs = rs.getInt("cs.gradeLevel_id");
                String levelName_rs = rs.getString("gl.levelName");
                String sectionName_rs = rs.getString("cs.sectionName");


                ref_classroomstudents.setSchoolYear_id(schoolYear_id_rs);
                ref_classroomstudents.setGradeLevel_id(gradeLevel_id_rs);
                ref_classroomstudents.setSectionName(sectionName_rs);
                int studentsCount = ref_classroomstudents.count_select(ref_classroomstudents, conn);

                String information_rs = rs.getString("cs.information");
                String status_rs = rs.getString("cs.status");

                int teachers_id_rs = rs.getInt("c.teachers_id");
                String teachers_firstName_rs = rs.getString("t.firstName");
                String teachers_lastName_rs = rs.getString("t.lastName");

                if(teachers_firstName_rs==null){
                    teachers_firstName_rs="";
                }

                if(teachers_lastName_rs==null){
                    teachers_lastName_rs="";
                }

                Vector row = new Vector();
                row.add(schoolYear_id_rs);
                row.add(gradeLevel_id_rs);
                row.add(levelName_rs);
                row.add(sectionName_rs);
                row.add(information_rs);
                row.add(status_rs);
                row.add(teachers_id_rs);
                row.add(teachers_firstName_rs + " " + teachers_lastName_rs);
                row.add(studentsCount);




                classroomsections.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {

            System.err.println(sqle);
        }
        return resultCount;
    }

}
