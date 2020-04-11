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

/**
 *
 * @author Administrator
 */
public class gradelevelclasses {

    final private String className = this.getClass().getSimpleName();

    private int gradeLevel_id;
    private int classes_id;

    private int[] array_gradeLevel_id;
    private int[] array_classes_id;

    public int[] getArray_gradeLevel_id() {
        return array_gradeLevel_id;
    }

    public void setArray_gradeLevel_id(int[] array_gradeLevel_id) {
        this.array_gradeLevel_id = array_gradeLevel_id;
    }

    public int[] getArray_classes_id() {
        return array_classes_id;
    }

    public void setArray_classes_id(int[] array_classes_id) {
        this.array_classes_id = array_classes_id;
    }

    public int getGradeLevel_id() {
        return gradeLevel_id;
    }

    public void setGradeLevel_id(int gradeLevel_id) {
        this.gradeLevel_id = gradeLevel_id;
    }

    public int getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(int classes_id) {
        this.classes_id = classes_id;
    }

    public gradelevelclasses() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_primaryKey_exist(gradelevelclasses i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE " + className + ".gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND " + className + ".classes_id = " + i_this.getClasses_id() + ";";
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
    public void insert_gradelevelclasses(gradelevelclasses i_this, Connection conn) {
        try {
            String query = "INSERT INTO " + className + " (gradeLevel_id,classes_id) values (?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            s1.setInt(1, i_this.getGradeLevel_id());
            s1.setInt(2, i_this.getClasses_id());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
// ----------------------------------------------------------------------------- [DELETE]
    public void delete_gradelevelclasses(gradelevelclasses i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " "
                    + "WHERE " + className + ".gradeLevel_id = " + i_this.getGradeLevel_id() + " "
                    + "AND " + className + ".classes_id = " + i_this.getClasses_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_gradelevelclasses_array(gradelevelclasses i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_classes_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE gradeLevel_id = " + i_this.getArray_gradeLevel_id()[x] + " "
                        + "AND classes_id = " + i_this.getArray_classes_id()[x] + "; ";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
