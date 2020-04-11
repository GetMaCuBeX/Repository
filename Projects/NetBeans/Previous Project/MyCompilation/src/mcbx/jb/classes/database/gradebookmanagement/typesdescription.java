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
public class typesdescription {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int schoolYear_id;
    private int gradeLevel_id;
    private String sectionName;
    private int classes_id;
    private int teachers_id;
    private String types;
    private String description;
    private String activityDate;
    private double totalItems;
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
        typesdescription.data = data;
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

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(double totalItems) {
        this.totalItems = totalItems;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public typesdescription() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(typesdescription i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "' "
                    + "AND description LIKE '" + i_this.getDescription() + "';";
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
    public void insert_typesdescription(typesdescription i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (schoolYear_id,gradeLevel_id,sectionName,classes_id,teachers_id,types,description,activityDate,totalItems,information) values (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getSchoolYear_id());
            s1.setInt(2, i_this.getGradeLevel_id());
            s1.setString(3, i_this.getSectionName());
            s1.setInt(4, i_this.getClasses_id());
            s1.setInt(5, i_this.getTeachers_id());
            s1.setString(6, i_this.getTypes());
            s1.setString(7, i_this.getDescription());
            s1.setString(8, i_this.getActivityDate());
            s1.setDouble(9, i_this.getTotalItems());
            s1.setString(10, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_typesdescription(typesdescription i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET description=?, activityDate=?, totalItems=?, information=? WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE = '" + i_this.getTypes() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getTypes());
            s1.setString(2, i_this.getTypes());
            s1.setDouble(3, i_this.getTotalItems());
            s1.setString(4, i_this.getInformation());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_typesdescription(typesdescription i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "' "
                    + "AND description LIKE '" + i_this.getDescription() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_typesdescription_array(typesdescription i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_schoolYear_id().length; x++) {
                String q1 = "DELETE FROM " + className + " WHERE "
                        + "schoolYear_id = " + i_this.getArray_schoolYear_id()[x] + " "
                        + "AND gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND sectionName LIKE '" + i_this.getArray_sectionName()[x] + "' "
                        + "AND classes_id = " + i_this.getArray_classes_id()[x] + " "
                        + "AND teachers_id = " + i_this.getArray_teachers_id()[x] + " "
                        + "AND types LIKE '" + i_this.getArray_types()[x] + "' "
                        + "AND description LIKE '" + i_this.getArray_description()[x] + "';";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

// ----------------------------------------------------------------------------- [QUERY]
    public int count_select_search(typesdescription i_this, Connection conn) {
        try {
            String q1 = "SELECT Count(td.schoolYear_id) as resultCount "
                    + "FROM " + className + " AS td "
                    + "WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "' "
                    + "AND description LIKE '" + i_this.getDescription() + "';";
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

    public int select_typesdescription(typesdescription i_this, Connection conn) {
        typesdescription.setData(new Vector());
        try {
            String q1 = "SELECT td.schoolYear_id, td.gradeLevel_id, td.sectionName, td.classes_id, td.teachers_id, td.types, td.description, td.activityDate, td.totalItems, td.information FROM " + className + " AS td "
                    + "WHERE "
                    + "schoolYear_id = " + i_this.getSchoolYear_id() + " "
                    + "AND gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND sectionName LIKE '" + i_this.getSectionName() + "' "
                    + "AND classes_id = " + i_this.getClasses_id() + " "
                    + "AND teachers_id = " + i_this.getTeachers_id() + " "
                    + "AND types LIKE '" + i_this.getTypes() + "' "
                    + "AND description LIKE '" + i_this.getDescription() + "';";
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
                int schoolYear_id_rs = rs.getInt("td.schoolYear_id");
                int gradeLevel_id_rs = rs.getInt("td.gradeLevel_id");
                String sectionName_rs = rs.getString("td.sectionName");
                int classes_id_rs = rs.getInt("td.classes_id");
                int teachers_id_rs = rs.getInt("td.teachers_id");
                String types_rs = rs.getString("td.types");
                String description_rs = rs.getString("td.description");
                java.util.Date activityDate_rs = rs.getDate("td.activityDate");
                double totalItems_rs = rs.getDouble("td.totalItems");
                String information_rs = rs.getString("td.information");

                Vector row = new Vector();
                row.add(schoolYear_id_rs);
                row.add(gradeLevel_id_rs);
                row.add(sectionName_rs);
                row.add(classes_id_rs);
                row.add(teachers_id_rs);
                row.add(types_rs);
                row.add(description_rs);
                row.add(activityDate_rs);
                row.add(totalItems_rs);
                row.add(information_rs);
                typesdescription.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }
}
