package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class subjects {

    private static Vector data;
    private String name;

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        subjects.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* constructor */
    public subjects() {
    }

    public subjects(String name) {
        this.name = name;
    }

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_subjects(subjects new_subjects, Connection conn) {
        try {
            String query = "INSERT INTO subjects (name) values (?);";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, new_subjects.getName());
            statement.execute();

            System.out.println("Successfully Inserted.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_subjects(int idsubjects, subjects new_subjects, Connection conn) {
        try {
            String query = "UPDATE subjects SET name=? WHERE idsubjects = '" + idsubjects + "'";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, new_subjects.getName());
            statement.execute();

            System.out.println("Successfully Updated.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_subjects(String name, Connection conn) {
        try {
            String query = "DELETE FROM subjects WHERE name = '" + name + "'; ";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.execute();

            System.out.println("Successfully Deleted.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_subjects(int[] idsubjects, Connection conn) {
        try {
            int i_idsubjects;
            for (int x = 0; x < idsubjects.length; x++) {
                i_idsubjects = idsubjects[x];
                boolean isHasForeignKey = function_is_idsubjects_has_foreignKey(i_idsubjects, conn);
                if (isHasForeignKey) {
                } else {
                    String queryString = "DELETE FROM subjects WHERE idsubjects = '" + i_idsubjects + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                    statement.execute();
                }
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

// ----------------------------------------------------------------------------- [DISPLAY]
    public void display() {
        try {
            for (int i = 0; i < subjects.getData().size(); i++) {
                System.out.println(subjects.getData().get(i).toString().replace("[", "").replace("]", ""));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- [RETURN VALUES]
    public boolean function_is_idsubjects_has_foreignKey(int idsubjects, Connection conn) {
        try {
            String query = "SELECT b_s.subjects_idsubjects FROM subjects AS s , bookssubjects AS b_s WHERE s.idsubjects = b_s.subjects_idsubjects AND s.idsubjects = '" + idsubjects + "';";
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

    public boolean function_is_name_exist(String name, Connection conn) {
        try {
            String query = "SELECT s.idsubjects FROM subjects AS s WHERE s.`name` = '" + name + "';";
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

    public boolean function_is_name_exist_notLike(int idsubjects, String name, Connection conn) {
        try {
            String query = "SELECT s.idsubjects FROM subjects AS s WHERE s.`name` = '" + name + "' AND s.idsubjects NOT LIKE '" + idsubjects + "';";
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

    public int function_get_idsubjects(String name, Connection conn) {
        try {
            String query = "SELECT s.idsubjects FROM subjects AS s WHERE s.`name` = '" + name + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int s_idsubjects_rs = rs.getInt("s.idsubjects");
                return s_idsubjects_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    public String function_get_name(int idsubjects, Connection conn) {
        try {
            String query = "SELECT s.`name` FROM subjects AS s WHERE s.idsubjects = '" + idsubjects + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String s_name_rs = rs.getString("s.name");
                if (s_name_rs == null) {
                    s_name_rs = "";
                }
                return s_name_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
    
    public int select_name(Connection conn) {
        subjects.setData(new Vector());
        try {
            String query = "SELECT s.`name` FROM subjects AS s ORDER BY s.`name` ASC;";
            int allCount = executeQuery_name(query, conn);
            return allCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all(int limitFrom, int limitTo, Connection conn) {
        subjects.setData(new Vector());
        try {
            String query = "SELECT s.idsubjects, s.`name` FROM subjects AS s ORDER BY s.`name` ASC LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all(Connection conn) {
        subjects.setData(new Vector());
        try {
            String query = "SELECT s.idsubjects, s.`name` FROM subjects AS s ORDER BY s.`name` ASC ;";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all_by_idbooks(int idbooks, int limitFrom, int limitTo, Connection conn) {
        subjects.setData(new Vector());
        try {
            String query = "SELECT s.idsubjects, s.`name` FROM subjects AS s , books AS b , bookssubjects AS b_s WHERE b_s.books_idbooks = b.idbooks AND b_s.subjects_idsubjects = s.idsubjects AND b.idbooks = " + idbooks + " ORDER BY s.`name` ASC LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all_by_idbooks(int idbooks, Connection conn) {
        subjects.setData(new Vector());
        try {
            String query = "SELECT s.idsubjects, s.`name` FROM subjects AS s , books AS b , bookssubjects AS b_s WHERE b_s.books_idbooks = b.idbooks AND b_s.subjects_idsubjects = s.idsubjects AND b.idbooks = " + idbooks + " ORDER BY s.`name` ASC ;";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    private int executeQuery_name(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                String s_name_rs = rs.getString("s.name");
                Vector row = new Vector();
                row.add(s_name_rs);
                subjects.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

    private int executeQuery_all(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                resultCount++;
                int s_idsubjects_rs = rs.getInt("s.idsubjects");
                String s_name_rs = rs.getString("s.name");
                Vector row = new Vector();
                row.add(s_idsubjects_rs);
                row.add(s_name_rs);
                subjects.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

    //
    
    public int count_select_search(String search, Connection conn) {
        try {
            String query = "SELECT Count(s.idsubjects) AS resultCount FROM subjects AS s WHERE s.`name` LIKE '%"+search+"%';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
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

    public int select_by_search(String search, int limitFrom, int limitTo, Connection conn) {
        subjects.setData(new Vector());
        try {
            String query = "SELECT s.idsubjects, s.`name` FROM subjects AS s WHERE s.`name` LIKE '%"+search+"%' ORDER BY s.`name` ASC LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_search(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    
    
    private int executeQuery_search(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int s_idsubjects_rs = rs.getInt("s.idsubjects");
                    String s_name_rs = rs.getString("s.name");
   

                    Vector row = new Vector();
                    row.add(s_idsubjects_rs);
                    row.add(s_name_rs);
                    subjects.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
    }
}
