package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Logger;

public class logsborrowedbooks {

    private int books_idbooks;

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_logsborrowedbooks(int idbooks, String borroweddate, Connection conn) {
          try {
               String query = "INSERT INTO logsborrowedbooks (books_idbooks, borroweddate) values (?, ?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, idbooks);
               statement.setString(2, borroweddate);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
}
