package mcbx.jb.classes.database.booksreservation;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class blobimage {

     private static Vector data;
     private int idblobimage;
     private String name;
     private String imgblob;
     FileOutputStream image;
//     String filename = "c:/1.jpg";
//     File file = new File(filename);

     public blobimage() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_blob(String fileName_browsed, String file_browsed, Connection conn) {
          try {
               String query = "INSERT INTO blobimage (name, imgblob) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, fileName_browsed);
               statement.setBinaryStream(2, new FileInputStream(file_browsed), (int) new File(file_browsed).length());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException se) {
               System.err.println("SQLException occured :" + se);
          } catch (Exception e) {
               System.err.println("Exception occured :" + e);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_blob(int idblobimage, String fileName_browsed, String file_browsed, Connection conn) {
          try {
               String query = "UPDATE blobimage SET name=?, imgblob=? WHERE idblobimage = '" + idblobimage + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, fileName_browsed);
               statement.setBinaryStream(2, new FileInputStream(file_browsed), (int) new File(file_browsed).length());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException se) {
               System.err.println("SQLException occured :" + se);
          } catch (Exception e) {

               System.err.println("Exception occured :" + e);
          }
     }

// ----------------------------------------------------------------------------- [SELECT]
     public void savePicture(int idblobimage, String file_directory_name, Connection conn) {
          try {
               FileOutputStream fos;
               String query = "SELECT * FROM blobimage WHERE idblobimage= '" + idblobimage + "' ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    String name_rs = rs.getString(2);
                    File image_rs = new File(file_directory_name + name_rs.substring(name_rs.lastIndexOf(".")).toLowerCase() + "");
                    image_rs.setReadOnly();
                    fos = new FileOutputStream(image_rs);
                    byte[] buffer = new byte[1];
                    InputStream is = rs.getBinaryStream(3);
                    while (is.read(buffer) > 0) {
                         fos.write(buffer);
                    }
                    fos.close();
               }

          } catch (SQLException | IOException e) {
               JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
          }
     }


     public ImageIcon function_select_Image(int idblobimage, Connection conn) {
          try {
               ImageIcon newImageIcon;
               String query = "SELECT * FROM blobimage WHERE idblobimage = " + idblobimage + ";";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    InputStream stream = rs.getBinaryStream(1);
                    try {

                         ByteArrayOutputStream output = new ByteArrayOutputStream();
                         int a1 = stream.read();
                         while (a1 >= 0) {
                              output.write((char) a1);
                              a1 = stream.read();
                         }

                         /* get image in the database */
                         Blob blob = rs.getBlob(3);
                         /* chech if it has an imageBlob */
                         if ((int) blob.length() > 0) {
                              newImageIcon = new ImageIcon(blob.getBytes(1L, (int) blob.length()));
                              output.close();
                              return newImageIcon;
                         }

                    } catch (IOException e) {
                         System.err.println("Exception: " + e.getMessage());
                    }
               }
          } catch (SQLException e) {
               System.err.println("SQLException: " + e.getMessage());
               System.err.println("SQLState: " + e.getSQLState());
               System.err.println("VendorError: " + e.getErrorCode());
          }
          return null;
     }

// ----------------------------------------------------------------------------- [DISPLAY]
     public void display() {
//          try {
//               for (int i = 0; i < blob.getData().size(); i++) {
//                    System.out.println(blob.getData().get(i).toString().replace("[", "").replace("]", ""));
//               }
//          } catch (Exception e) {
//               System.err.println(e);
//          }
     }
}
