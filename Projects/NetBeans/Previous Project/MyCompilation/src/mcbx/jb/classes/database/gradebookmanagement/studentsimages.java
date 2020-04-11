package mcbx.jb.classes.database.gradebookmanagement;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class studentsimages {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int students_id;
    private String fileextension;
    private String imgblob;
    private String fileName_browsed;
    private String file_browsed;
    private String file_directory_name;

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        studentsimages.data = data;
    }

    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public String getFileextension() {
        return fileextension;
    }

    public void setFileextension(String fileextension) {
        this.fileextension = fileextension;
    }

    public String getImgblob() {
        return imgblob;
    }

    public void setImgblob(String imgblob) {
        this.imgblob = imgblob;
    }

    public String getFileName_browsed() {
        return fileName_browsed;
    }

    public void setFileName_browsed(String fileName_browsed) {
        this.fileName_browsed = fileName_browsed;
    }

    public String getFile_browsed() {
        return file_browsed;
    }

    public void setFile_browsed(String file_browsed) {
        this.file_browsed = file_browsed;
    }

    public String getFile_directory_name() {
        return file_directory_name;
    }

    public void setFile_directory_name(String file_directory_name) {
        this.file_directory_name = file_directory_name;
    }

    public studentsimages() {
    }

    FileOutputStream image;
//     String filename = "c:/1.jpg";
//     File file = new File(filename);

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_studentsimages(studentsimages i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (students_id, fileextension, imgblob) values (?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setInt(1, i_this.getStudents_id());
            s1.setString(2, i_this.getFileName_browsed());
            System.out.println("FILENAME BROWSED: "+i_this.getFileName_browsed());
            System.out.println("FILE BROWSED: "+i_this.getFile_browsed());
            s1.setBinaryStream(3, new FileInputStream(i_this.getFile_browsed()), (int) new File(i_this.getFile_browsed()).length());
            s1.execute();

            System.out.println("Successfully Inserted.");
        } catch (SQLException se) {
            System.err.println("SQLException occured :" + se);
        } catch (FileNotFoundException e) {
            System.err.println("Exception occured :" + e);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_studentsimages(studentsimages i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET fileextension=?, imgblob=? WHERE students_id = " + i_this.getStudents_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getFileName_browsed());
            s1.setBinaryStream(2, new FileInputStream(i_this.getFile_browsed()), (int) new File(i_this.getFile_browsed()).length());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException se) {
            System.err.println("SQLException occured :" + se);
        } catch (FileNotFoundException e) {
            System.err.println("Exception occured :" + e);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_studentsimages(studentsimages i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE students_id = " + i_this.getStudents_id() + "; ";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();
            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [SELECT]
    public void savePicture(studentsimages i_this, Connection conn) {
        try {
            FileOutputStream fos;
            String q1 = "SELECT * FROM " + className + " WHERE students_id= '" + i_this.getStudents_id() + "'; ";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs;
            rs = s1.executeQuery();
            while (rs.next()) {
                String fileextension_rs = rs.getString(2);
                File image_rs = new File(i_this.getFile_directory_name() + fileextension_rs.substring(fileextension_rs.lastIndexOf(".")).toLowerCase() + "");
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

// ----------------------------------------------------------------------------- [RETURN VALUES]
    public boolean function_is_students_id_exist(studentsimages i_this, Connection conn) {
        try {
            String q1 = "SELECT * FROM " + className + " WHERE students_id = '" + i_this.getStudents_id() + "';";
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

    public ImageIcon function_select_Image(studentsimages i_this, Connection conn) {
        try {
            ImageIcon newImageIcon;
            String q1 = "SELECT * FROM " + className + " WHERE students_id = " + i_this.getStudents_id() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs;
            rs = s1.executeQuery();
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
}
