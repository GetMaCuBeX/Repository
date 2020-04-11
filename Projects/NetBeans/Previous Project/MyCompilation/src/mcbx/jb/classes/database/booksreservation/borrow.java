package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class borrow {

    private static Vector data;
    private int members_idmembers;
    private int books_idbooks;
    private String borroweddate;
    private String borrowedduedate;
    private int copies;
    private String notes;
    private String returneddate;
    private String remarks;
    private double finedamount;
    private String status;
    private int returnedcopies;

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        borrow.data = data;
    }

    public int getMembers_idmembers() {
        return members_idmembers;
    }

    public void setMembers_idmembers(int members_idmembers) {
        this.members_idmembers = members_idmembers;
    }

    public int getBooks_idbooks() {
        return books_idbooks;
    }

    public void setBooks_idbooks(int books_idbooks) {
        this.books_idbooks = books_idbooks;
    }

    public String getBorroweddate() {
        return borroweddate;
    }

    public void setBorroweddate(String borroweddate) {
        this.borroweddate = borroweddate;
    }

    public String getBorrowedduedate() {
        return borrowedduedate;
    }

    public void setBorrowedduedate(String borrowedduedate) {
        this.borrowedduedate = borrowedduedate;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReturneddate() {
        return returneddate;
    }

    public void setReturneddate(String returneddate) {
        this.returneddate = returneddate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getFinedamount() {
        return finedamount;
    }

    public void setFinedamount(double finedamount) {
        this.finedamount = finedamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReturnedcopies() {
        return returnedcopies;
    }

    public void setReturnedcopies(int returnedcopies) {
        this.returnedcopies = returnedcopies;
    }

    /* constructor */
    public borrow() {
    }

    public borrow(int members_idmembers, int books_idbooks, String borroweddate, String borrowedduedate, int copies, String notes, String returneddate, String remarks, double finedamount, String status, int returnedcopies) {
        this.members_idmembers = members_idmembers;
        this.books_idbooks = books_idbooks;
        this.borroweddate = borroweddate;
        this.borrowedduedate = borrowedduedate;
        this.copies = copies;
        this.notes = notes;
        this.returneddate = returneddate;
        this.remarks = remarks;
        this.finedamount = finedamount;
        this.status = status;
        this.returnedcopies = returnedcopies;
    }

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_borrow(borrow new_borrow, Connection conn) {
        try {
            String query = "INSERT INTO borrow (members_idmembers, books_idbooks, borroweddate, borrowedduedate, copies, notes, returneddate, remarks, finedamount, status, returnedcopies) values (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setInt(1, new_borrow.getMembers_idmembers());
            statement.setInt(2, new_borrow.getBooks_idbooks());
            statement.setString(3, new_borrow.getBorroweddate());
            statement.setString(4, new_borrow.getBorrowedduedate());
            statement.setInt(5, new_borrow.getCopies());
            statement.setString(6, new_borrow.getNotes());
            statement.setString(7, new_borrow.getReturneddate());
            statement.setString(8, new_borrow.getRemarks());
            statement.setDouble(9, new_borrow.getFinedamount());
            statement.setString(10, new_borrow.getStatus());
            statement.setInt(11, new_borrow.getReturnedcopies());
            statement.execute();

            System.out.println("Successfully Inserted.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void insert_borrow(int members_idmembers, int books_idbooks, String borroweddate, String borrowedduedate, int copies, String notes, String status, Connection conn) {
        try {
            String query = "INSERT INTO borrow (members_idmembers, books_idbooks, String borroweddate, String borrowedduedate, int copies, String notes, String status) values (?,?,?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setInt(1, members_idmembers);
            statement.setInt(2, books_idbooks);
            statement.setString(3, borroweddate);
            statement.setString(4, borrowedduedate);
            statement.setInt(5, copies);
            statement.setString(6, notes);
            statement.setString(7, status);
            statement.execute();

            System.out.println("Successfully Inserted.");

        } catch (Exception sqle) {
            System.err.println(sqle);
            sqle.printStackTrace();
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_borrow(int idborrow, borrow new_borrow, Connection conn) {
        try {
            String query = "UPDATE borrow SET members_idmembers=?, books_idbooks=?, borroweddate=?, borrowedduedate=?, copies=?, notes=?, returneddate=?, remarks=?, finedamount=?, status=?, returnedcopies=? WHERE idborrow = '" + idborrow + "'";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setInt(1, new_borrow.getMembers_idmembers());
            statement.setInt(2, new_borrow.getBooks_idbooks());
            statement.setString(3, new_borrow.getBorroweddate());
            statement.setString(4, new_borrow.getBorrowedduedate());
            statement.setInt(5, new_borrow.getCopies());
            statement.setString(6, new_borrow.getNotes());
            statement.setString(7, new_borrow.getReturneddate());
            statement.setString(8, new_borrow.getRemarks());
            statement.setDouble(9, new_borrow.getFinedamount());
            statement.setString(10, new_borrow.getStatus());
            statement.setInt(11, new_borrow.getReturnedcopies());
            statement.execute();

            System.out.println("Successfully Updated.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void update_borrow(int idborrow, String returneddate, String remarks, double finedamount, String status, int returnedcopies, Connection conn) {
        try {
            String query = "UPDATE borrow SET returneddate=?, remarks=?, finedamount=?, status=?, returnedcopies=? WHERE idborrow = '" + idborrow + "'";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, returneddate);
            statement.setString(2, remarks);
            statement.setDouble(3, finedamount);
            statement.setString(4, status);
            statement.setInt(5, returnedcopies);
            statement.execute();

            System.out.println("Successfully Updated.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void update_borrow(int idborrow, String borroweddate, String borrowedduedate, int copies, String notes, String returneddate, String remarks, double finedamount, String status, int returnedcopies, Connection conn) {
        try {
            String query = "UPDATE borrow SET borroweddate=?, borrowedduedate=?, copies=?, notes=?, returneddate=?, remarks=?, finedamount=?, status=?, returnedcopies=? WHERE idborrow = '" + idborrow + "'";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, borroweddate);
            statement.setString(2, borrowedduedate);
            statement.setDouble(3, copies);
            statement.setString(4, notes);
            statement.setString(5, returneddate);
            statement.setString(6, remarks);
            statement.setDouble(7, finedamount);
            statement.setString(8, status);
            statement.setInt(9, returnedcopies);
            statement.execute();

            System.out.println("Successfully Updated.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void update_borrow(int idborrow, String borroweddate, String borrowedduedate, int copies, String notes, String remarks, double finedamount, String status, int returnedcopies, Connection conn) {
        try {
            String query = "UPDATE borrow SET borroweddate=?, borrowedduedate=?, copies=?, notes=?, remarks=?, finedamount=?, status=?, returnedcopies=? WHERE idborrow = '" + idborrow + "'";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, borroweddate);
            statement.setString(2, borrowedduedate);
            statement.setDouble(3, copies);
            statement.setString(4, notes);
            statement.setString(5, remarks);
            statement.setDouble(6, finedamount);
            statement.setString(7, status);
            statement.setInt(8, returnedcopies);
            statement.execute();

            System.out.println("Successfully Updated.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_borrow(int idborrow, Connection conn) {
        try {
            String query = "DELETE FROM borrow WHERE idborrow = '" + idborrow + "'; ";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.execute();

            System.out.println("Successfully Deleted.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_borrow(int[] idborrow, Connection conn) {
        try {
            int i_idborrow;
            for (int x = 0; x < idborrow.length; x++) {
                i_idborrow = idborrow[x];
                String query = "DELETE FROM borrow WHERE idborrow = '" + i_idborrow + "'; ";
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                statement.execute();
            }
            System.out.println("Successfully Deleted.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DISPLAY]
    public void display() {
        try {
            for (int i = 0; i < borrow.getData().size(); i++) {
                System.out.println(borrow.getData().get(i).toString().replace("[", "").replace("]", ""));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- [RETURN VALUES]
    public boolean function_is_idmembers_idbooks_exist(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.members_idmembers FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }

    public java.util.Date function_get_borroweddate(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.borroweddate FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.util.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                return br_borroweddate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public int function_get_copies(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.copies FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_copies_rs = rs.getInt("br.copies");
                return br_copies_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    public int function_get_count_borrowed_member_who_borrow_this_books(int idbooks, Connection conn) {
        try {
            String query = "SELECT Count(br.idborrow) as CountBorrowedBooks FROM books AS b LEFT JOIN booksimage AS bi ON b.idbooks = bi.books_idbooks LEFT JOIN borrow AS br ON b.idbooks = br.books_idbooks LEFT JOIN members AS m ON br.members_idmembers = m.idmembers LEFT JOIN membersimage AS mi ON m.idmembers = mi.members_idmembers WHERE b.idbooks = "+idbooks+" AND br.`status` = 'Borrowed' ORDER BY br.`status` ASC, br.borroweddate ASC;";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_CountBorrowedBooks_rs = rs.getInt("CountBorrowedBooks");
                return br_CountBorrowedBooks_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    
    
    public String function_get_notes(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.notes FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String br_notes_rs = rs.getString("br.notes");
                return br_notes_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public java.util.Date function_get_returneddate(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.returneddate FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.util.Date br_returneddate_rs = rs.getDate("br.returneddate");
                return br_returneddate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_remarks(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.remarks FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String br_remarks_rs = rs.getString("br.remarks");
                return br_remarks_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public double function_get_finedamount(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.finedamount FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                double br_finedamount_rs = rs.getDouble("br.finedamount");
                return br_finedamount_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    public String function_get_status(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.status FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String br_status_rs = rs.getString("br.status");
                return br_status_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public int function_get_returnedcopies(int idmembers, int idbooks, Connection conn) {
        try {
            String query = "SELECT br.returnedcopies FROM borrow AS br WHERE br.members_idmembers = '" + idmembers + "' AND br.books_idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_returnedcopies_rs = rs.getInt("br.returnedcopies");
                return br_returnedcopies_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    /**/
    public boolean function_is_idmembers_has_an_idbooks_that_is_not_yet_return(int idmembers, Connection conn) {
        try {
            String query = "SELECT br.idborrow, br.`status` FROM borrow AS br , books AS b WHERE br.books_idbooks = b.idbooks AND br.members_idmembers = '" + idmembers + "' AND br.`status` = 'Borrowed';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }


    /**/
    public int function_get_the_remaining_copies_of_the_idbooks(int idbooks, Connection conn) {
        try {

            int sum_copies_borrowed = function_get_sum_of_total_copies_of_idbooks_by_status_is_borrowed(idbooks, conn);
            int sum_returnedcopies = function_get_sum_of_total_returned_copies_of_idbooks_by_status_is_borrowed(idbooks, conn);
            int copynumber_idbooks = function_get_the_copynumber_of_the_idbooks(idbooks, conn);
            /**/
            int remaining_copy = ((copynumber_idbooks - sum_copies_borrowed) + sum_returnedcopies);
            return remaining_copy;

        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int function_get_the_copynumber_of_the_idbooks(int idbooks, Connection conn) {
        try {
            String query = "SELECT b.copynumber FROM books AS b WHERE b.idbooks = '" + idbooks + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int b_copynumber_rs = rs.getInt("b.copynumber");
                return b_copynumber_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    private int function_get_sum_of_total_copies_of_idbooks_by_status_is_borrowed(int idbooks, Connection conn) {
        try {
            String query = "SELECT Sum(br.copies) AS br_copies FROM borrow AS br WHERE br.books_idbooks = '" + idbooks + "' AND br.`status` = 'Borrowed';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_copies_rs = rs.getInt("br_copies");
                return br_copies_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    private int function_get_sum_of_total_returned_copies_of_idbooks_by_status_is_borrowed(int idbooks, Connection conn) {
        try {
            String query = "SELECT Sum(br.returnedcopies) AS br_returnedcopies FROM borrow AS br WHERE br.books_idbooks = '" + idbooks + "' AND br.`status` = 'Borrowed';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_returnedcopies_rs = rs.getInt("br_returnedcopies");
                return br_returnedcopies_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    /**/
    public java.sql.Date function_get_borroweddate(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.borroweddate FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
//                    java.sql.Time br_borrowedateTime_rs = rs.getTime("br.borroweddate");
                return br_borroweddate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    /**/
    public java.sql.Time function_get_borroweddate_time_update(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.borroweddate FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                    java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                java.sql.Time br_borrowedateTime_rs = rs.getTime("br.borroweddate");
                return br_borrowedateTime_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    /**/
    public java.util.Date function_get_borroweddate_time(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.borroweddate FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.util.Date br_borroweddate_rs = rs.getTime("br.borroweddate");
                return br_borroweddate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public java.sql.Date function_get_borrowedduedate(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.borrowedduedate FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.sql.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                return br_borrowedduedate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public int function_get_copies(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.copies FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_copies_rs = rs.getInt("br.copies");
                return br_copies_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    public String function_get_notes(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.notes FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String br_notes_rs = rs.getString("br.notes");
                return br_notes_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";
    }

    public java.sql.Date function_get_returneddate(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.returneddate FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.sql.Date br_returneddate_rs = rs.getDate("br.returneddate");
                return br_returneddate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public java.sql.Time function_get_returneddate_time_update(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.returneddate FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.sql.Time br_returneddate_rs = rs.getTime("br.returneddate");
                if (br_returneddate_rs == null) {
                    return null;
                } else {
                    return br_returneddate_rs;
                }
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_remarks(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.remarks FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String br_remarks_rs = rs.getString("br.remarks");
                return br_remarks_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";
    }

    public double function_get_finedamount(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.finedamount FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                double br_finedamount_rs = rs.getDouble("br.finedamount");
                return br_finedamount_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    public String function_get_status(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.status FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String br_status_rs = rs.getString("br.status");
                return br_status_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";
    }

    public int function_get_returnedcopies(int idborrow, Connection conn) {
        try {
            String query = "SELECT br.returnedcopies FROM borrow AS br WHERE br.idborrow = '" + idborrow + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int br_returnedcopies_rs = rs.getInt("br.returnedcopies");
                return br_returnedcopies_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
    public int select_all(int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, br.members_idmembers, br.books_idbooks, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.returneddate, br.remarks, br.finedamount, br.`status` FROM borrow AS br LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all_by_idmembers(int members_idmembers, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, br.members_idmembers, br.books_idbooks, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.returneddate, br.remarks, br.finedamount, br.`status` FROM borrow AS br WHERE br.members_idmembers = " + members_idmembers + " LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all_by_idbooks(int books_idbooks, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, br.members_idmembers, br.books_idbooks, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.returneddate, br.remarks, br.finedamount, br.`status` FROM borrow AS br WHERE br.books_idbooks = " + books_idbooks + " LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all_by_idmembers_idbooks(int members_idmembers, int books_idbooks, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, br.members_idmembers, br.books_idbooks, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.returneddate, br.remarks, br.finedamount, br.`status` FROM borrow AS br WHERE br.books_idbooks = " + books_idbooks + " AND br.members_idmembers = " + members_idmembers + " LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int executeQuery_all(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int br_idborrow_rs = rs.getInt("br.idborrow");
                int br_members_idmembers_rs = rs.getInt("br.members_idmembers");
                int br_books_idbooks_rs = rs.getInt("br.books_idbooks");
                java.util.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                java.util.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                int br_copies_rs = rs.getInt("br.copies");
                String br_notes_rs = rs.getString("br.notes");
                java.util.Date br_returneddate_rs = rs.getDate("br.returneddate");
                String br_remarks_rs = rs.getString("br.remarks");
                double br_finedamount_rs = rs.getDouble("br.finedamount");
                String br_status_rs = rs.getString("br.status");

                Vector row = new Vector();
                row.add(br_idborrow_rs);
                row.add(br_members_idmembers_rs);
                row.add(br_books_idbooks_rs);
                row.add(br_borroweddate_rs);
                row.add(br_borrowedduedate_rs);
                row.add(br_copies_rs);
                row.add(br_notes_rs);
                row.add(br_returneddate_rs);
                row.add(br_remarks_rs);
                row.add(br_finedamount_rs);
                row.add(br_status_rs);
                borrow.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

    /**/
    public int count_information_by_idmembers(int members_idmembers, Connection conn) {
        try {
            String query = "SELECT Count(br.idborrow) as resultCount FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND m.idmembers = '" + members_idmembers + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int r_resultCount_rs = rs.getInt("resultCount");
                    return r_resultCount_rs;
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

    public int select_information_by_idmembers(int members_idmembers, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, m.idnumber, b.barcode, b.isbn, b.title, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.returneddate, br.remarks, br.finedamount, br.`status`, br.returnedcopies FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND m.idmembers = '" + members_idmembers + "' LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_table_information_idmembers(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int executeQuery_table_information_idmembers(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int br_idreserve_rs = rs.getInt("br.idborrow");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String b_barcode_rs = rs.getString("b.barcode");
                String b_isbn_rs = rs.getString("b.isbn");
                String b_title_rs = rs.getString("b.title");
                java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                java.sql.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                int br_copies_rs = rs.getInt("br.copies");
                String br_notes_rs = rs.getString("br.notes");
                java.sql.Date br_returneddate_rs = rs.getDate("br.returneddate");
                String br_remarks_rs = rs.getString("br.remarks");
                double br_finedamount_rs = rs.getInt("br.finedamount");
                String br_status_rs = rs.getString("br.status");
                int br_returnedcopies_rs = rs.getInt("br.returnedcopies");

                Vector row = new Vector();
                row.add(br_idreserve_rs);
                row.add(m_idnumber_rs);
                row.add(b_barcode_rs);
                row.add(b_isbn_rs);
                row.add(b_title_rs);
                row.add(br_borroweddate_rs);
                row.add(br_borrowedduedate_rs);
                row.add(br_copies_rs);
                row.add(br_notes_rs);
                row.add(br_returneddate_rs);
                row.add(br_remarks_rs);
                row.add(br_finedamount_rs);
                row.add(br_status_rs);
                row.add(br_returnedcopies_rs);
                borrow.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);

        }
        return resultCount;
    }

    /**/
    public int count_information_by_idbooks_borrow_history(int idbooks, Connection conn) {
        try {
            String query = "SELECT Count(br.idborrow) as resultCount FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND b.idbooks = '" + idbooks + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int r_resultCount_rs = rs.getInt("resultCount");
                    return r_resultCount_rs;
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

    public int select_information_by_idbooks_borrow_history(int idbooks, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, br.borroweddate, br.borrowedduedate, br.copies, br.finedamount, br.`status`, b.category_name FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND b.idbooks = '" + idbooks + "' LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_table_information_idbooks_borrow_history(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int executeQuery_table_information_idbooks_borrow_history(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int br_idreserve_rs = rs.getInt("br.idborrow");
                String b_barcode_rs = rs.getString("b.barcode");
                String b_isbn_rs = rs.getString("b.isbn");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String m_firstname_rs = rs.getString("m.firstname");
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                String m_lastname_rs = rs.getString("m.lastname");
                String b_title_rs = rs.getString("b.title");
                String b_description_rs = rs.getString("b.description");
                java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                java.sql.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                int br_copies_rs = rs.getInt("br.copies");
                double br_finedamount_rs = rs.getInt("br.finedamount");
                String br_status_rs = rs.getString("br.status");
                String b_category_name_rs = rs.getString("b.category_name");

                Vector row = new Vector();
                row.add(br_idreserve_rs);
                row.add(b_barcode_rs);
                row.add(b_isbn_rs);
                row.add(m_idnumber_rs);
                row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                row.add(b_title_rs);
                row.add(b_description_rs);
                row.add(br_borroweddate_rs);
                row.add(br_borrowedduedate_rs);
                row.add(br_copies_rs);
                row.add(br_finedamount_rs);
                row.add(br_status_rs);
                row.add(b_category_name_rs);
                borrow.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);

        }
        return resultCount;
    }

    /* Administrator */
    public int administrator_count_information_by_idbooks_borrow_history_and_status_is_borrowed(int idbooks, Connection conn) {
        try {
            String query = "SELECT Count(br.idborrow) as resultCount FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND br.status = 'Borrowed' AND b.idbooks = '" + idbooks + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int r_resultCount_rs = rs.getInt("resultCount");
                    return r_resultCount_rs;
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

    public int administrator_select_information_by_idbooks_borrow_history_and_status_is_borrowed(int idbooks, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.finedamount, br.`status`, br.remarks, b.category_name FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND br.status = 'Borrowed' AND b.idbooks = '" + idbooks + "' LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = administrator_executeQuery_table_information_idbooks_borrow_history_and_status_is_borrowed(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int administrator_executeQuery_table_information_idbooks_borrow_history_and_status_is_borrowed(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int br_ididborrow_rs = rs.getInt("br.idborrow");
                String b_barcode_rs = rs.getString("b.barcode");
//                    String b_isbn_rs = rs.getString("b.isbn");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String m_firstname_rs = rs.getString("m.firstname");
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                String m_lastname_rs = rs.getString("m.lastname");
                String b_title_rs = rs.getString("b.title");
//                    String b_description_rs = rs.getString("b.description");
                java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");

//                    java.sql.Time time_ = rs.getTime("br.borroweddate");
//                    int HH = Integer.parseInt(""+(new SimpleDateFormat("HH").format(time_)));
//                    int mm = Integer.parseInt((new SimpleDateFormat("mm").format(time_)));
//                    int ss = Integer.parseInt((new SimpleDateFormat("ss").format(time_)));
//                    br_borroweddate_rs.setHours(HH);
//                    br_borroweddate_rs.setMinutes(mm);
//                    br_borroweddate_rs.setSeconds(ss);


                java.sql.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                int br_copies_rs = rs.getInt("br.copies");
                double br_finedamount_rs = rs.getInt("br.finedamount");
                String br_remarks_rs = rs.getString("br.remarks");
                String br_notes_rs = rs.getString("br.notes");
//                    String br_status_rs = rs.getString("br.status");
//                    String b_category_name_rs = rs.getString("b.category_name");

                Vector row = new Vector();
                row.add(br_ididborrow_rs);
                row.add(m_idnumber_rs);
                row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                row.add(b_barcode_rs);
//                    row.add(b_isbn_rs);
                row.add(b_title_rs);
//                    row.add(b_description_rs);
                row.add(br_borroweddate_rs);
                row.add(br_borrowedduedate_rs);
                row.add(br_copies_rs);
                row.add(br_finedamount_rs);
//                    row.add(br_status_rs);
//                    row.add(b_category_name_rs);
                row.add(br_remarks_rs);
                row.add(br_notes_rs);
                borrow.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);

        }
        return resultCount;
    }

    /* Members */
    public int administrator_count_information_by_idmembers_borrow_history_and_status_is_borrowed(int idmembers, Connection conn) {
        try {
            String query = "SELECT Count(br.idborrow) as resultCount FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND br.status = 'Borrowed' AND m.idmembers = '" + idmembers + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int r_resultCount_rs = rs.getInt("resultCount");
                    return r_resultCount_rs;
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

    public int administrator_select_information_by_idmembers_borrow_history_and_status_is_borrowed(int idmembers, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, br.borroweddate, br.borrowedduedate, br.copies, br.notes, br.finedamount, br.`status`, br.remarks, b.category_name FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND br.status = 'Borrowed' AND m.idmembers = '" + idmembers + "' LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = administrator_executeQuery_table_information_idmembers_borrow_history_and_status_is_borrowed(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int administrator_executeQuery_table_information_idmembers_borrow_history_and_status_is_borrowed(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int br_ididborrow_rs = rs.getInt("br.idborrow");
                String b_barcode_rs = rs.getString("b.barcode");
//                    String b_isbn_rs = rs.getString("b.isbn");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String m_firstname_rs = rs.getString("m.firstname");
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                String m_lastname_rs = rs.getString("m.lastname");
                String b_title_rs = rs.getString("b.title");
//                    String b_description_rs = rs.getString("b.description");
                java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                java.sql.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                int br_copies_rs = rs.getInt("br.copies");
                double br_finedamount_rs = rs.getInt("br.finedamount");
                String br_remarks_rs = rs.getString("br.remarks");
                String br_notes_rs = rs.getString("br.notes");
//                    String br_status_rs = rs.getString("br.status");
//                    String b_category_name_rs = rs.getString("b.category_name");

                Vector row = new Vector();
                row.add(br_ididborrow_rs);
                row.add(m_idnumber_rs);
                row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                row.add(b_barcode_rs);
//                    row.add(b_isbn_rs);
                row.add(b_title_rs);
//                    row.add(b_description_rs);
                row.add(br_borroweddate_rs);
                row.add(br_borrowedduedate_rs);
                row.add(br_copies_rs);
                row.add(br_finedamount_rs);
//                    row.add(br_status_rs);
//                    row.add(b_category_name_rs);
                row.add(br_remarks_rs);
                row.add(br_notes_rs);
                borrow.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);

        }
        return resultCount;
    }

    /**/
    public int administrator_count_information_by_idmembers_penalties(int idmembers, Connection conn) {
        try {
            String query = "SELECT Count(br.idborrow) as resultCount FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND m.idmembers = '" + idmembers + "' AND  br.finedamount > 0 ;";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int r_resultCount_rs = rs.getInt("resultCount");
                    return r_resultCount_rs;
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

    public int administrator_select_information_by_idmembers_penalties(int idmembers, int limitFrom, int limitTo, Connection conn) {
        borrow.setData(new Vector());
        try {
            String query = "SELECT br.idborrow, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, br.borroweddate, br.borrowedduedate, br.returneddate, br.copies, br.notes, br.finedamount, br.`status`, br.remarks, b.category_name FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND m.idmembers = '" + idmembers + "' AND  br.finedamount > 0 LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = administrator_executeQuery_table_information_idmembers_borrow_penalties(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int administrator_executeQuery_table_information_idmembers_borrow_penalties(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int br_ididborrow_rs = rs.getInt("br.idborrow");
                String b_barcode_rs = rs.getString("b.barcode");
//                    String b_isbn_rs = rs.getString("b.isbn");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String m_firstname_rs = rs.getString("m.firstname");
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                String m_lastname_rs = rs.getString("m.lastname");
                String b_title_rs = rs.getString("b.title");
//                    String b_description_rs = rs.getString("b.description");
                java.sql.Date br_borroweddate_rs = rs.getDate("br.borroweddate");
                java.sql.Date br_borrowedduedate_rs = rs.getDate("br.borrowedduedate");
                java.sql.Date br_returneddate_rs = rs.getDate("br.returneddate");

                int br_copies_rs = rs.getInt("br.copies");
                double br_finedamount_rs = rs.getInt("br.finedamount");
                String br_remarks_rs = rs.getString("br.remarks");
                String br_notes_rs = rs.getString("br.notes");
//                    String br_status_rs = rs.getString("br.status");
//                    String b_category_name_rs = rs.getString("b.category_name");

                Vector row = new Vector();
                row.add(br_ididborrow_rs);
                row.add(m_idnumber_rs);
                row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                row.add(b_barcode_rs);
//                    row.add(b_isbn_rs);
                row.add(b_title_rs);
//                    row.add(b_description_rs);
                row.add(br_borroweddate_rs);
                row.add(br_borrowedduedate_rs);
                row.add(br_returneddate_rs);
                row.add(br_copies_rs);
                row.add(br_finedamount_rs);
//                    row.add(br_status_rs);
//                    row.add(b_category_name_rs);
                row.add(br_remarks_rs);
                row.add(br_notes_rs);
                borrow.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);

        }
        return resultCount;
    }
}
