
package mcbx.jb.classes.database.gradebookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class classes {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private String learningAreas = null;
    private String description = null;

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
        classes.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLearningAreas() {
        return learningAreas;
    }

    public void setLearningAreas(String learningAreas) {
        this.learningAreas = learningAreas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public classes() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_learningAreas_exist(classes i_this, Connection conn) {
        try {
            String q1 = "SELECT " + className + ".id FROM " + className + " WHERE " + className + ".learningAreas LIKE '" + i_this.getLearningAreas() + "';";
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

    public boolean function_is_learningAreas_and_description_exist(classes i_this, Connection conn) {
        try {
            String q1 = "SELECT " + className + ".id FROM " + className + " "
                    + "WHERE " + className + ".learningAreas LIKE '" + i_this.getLearningAreas() + "' "
                    + "AND " + className + ".description LIKE '" + i_this.getDescription() + "';";
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

    public String function_get_classes_learningAreas(classes i_this, Connection conn) {
        try {
            String q1 = "SELECT learningAreas FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getString("learningAreas");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";

    }

    public String function_get_classes_description(classes i_this, Connection conn) {
        try {
            String q1 = "SELECT description FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getString("description");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";

    }

// ----------------------------------------------------------------------------- [INSERT]
    public String insert_classes(classes i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (learningAreas) values (?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getLearningAreas());
            s1.execute();

            return (globalmessages.crude_info_insert);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_insert + "\n" + sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public String update_classes(classes i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET learningAreas=?, description=? WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getLearningAreas());
            s1.setString(2, i_this.getDescription());
            s1.execute();

            return (globalmessages.crude_info_update);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_update + "\n" + sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_classes(classes i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_classes_array(classes i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_id().length; x++) {

                String q1 = "DELETE FROM " + className + " WHERE id = '" + i_this.getArray_id()[x] + "'; ";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();

            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
