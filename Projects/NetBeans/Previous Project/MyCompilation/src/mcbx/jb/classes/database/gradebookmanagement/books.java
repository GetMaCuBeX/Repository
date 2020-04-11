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

public class books {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private String title;
    private String description;
    private String isbn;
    private String barcode;

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
        books.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public books() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_title_and_description_exist(books i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " "
                    + "WHERE " + className + ".title = " + i_this.getTitle() + " "
                    + "AND " + className + ".description = " + i_this.getDescription() + ";";
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
    public String insert_books(books i_this, Connection conn) {
        try {
            String query = "INSERT INTO " + className + " (title,description,isbn,barcode) values (?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            s1.setString(1, i_this.getTitle());
            s1.setString(2, i_this.getDescription());
            s1.setString(3, i_this.getIsbn());
            s1.setString(4, i_this.getBarcode());
            s1.execute();

            return (globalmessages.crude_info_insert);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_insert+"\n"+sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public String update_books(books i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET title=?,description=?,isbn=?,barcode=? "
                    + "WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getTitle());
            s1.setString(2, i_this.getDescription());
            s1.setString(3, i_this.getIsbn());
            s1.setString(4, i_this.getBarcode());
            s1.execute();

             return (globalmessages.crude_info_update);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_update+"\n"+sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_books(books i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_books_array(books i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_id().length; x++) {
                String q1 = "DELETE FROM " + className + " "
                        + "WHERE id = " + i_this.getArray_id()[x] + " ;";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
}
