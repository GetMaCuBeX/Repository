package mcbx.jb.classes.mycollection;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

public class MyFileChooserBrowsePicture {

     public JFileChooser fileChooser;
     private MyFilenameFilter filter = new MyFilenameFilter();

     private static class MyFilenameFilter extends javax.swing.filechooser.FileFilter implements FilenameFilter {

          private HashSet extSet = new HashSet();
          private String extensions;

          @Override
          public boolean accept(File dir, String name) {
               return accept(new File(dir, name));
          }

          public void setExtensions(String newValue) {
               extensions = newValue;
               extSet.clear();

               StringTokenizer tt = new StringTokenizer(newValue);
               while (tt.hasMoreTokens()) {
                    extSet.add(tt.nextToken());
               }

               //extSet.addAll(Arrays.asList(newValue.toLowerCase().split(" ")));
          }

          @Override
          public boolean accept(File file) {
               if (file.isDirectory()) {
                    return true;
               }
               String name = file.getName();
               int p = name.lastIndexOf(".");
               if (p != -1) {
                    return extSet.contains(name.substring(p + 1).toLowerCase());
               }
               return false;
          }

          @Override
          public String getDescription() {
               return extensions;
          }
     }
     private String extensions = "jpeg jpg png";

     public void configureFileChooser() {
          if (fileChooser == null) {
               long start = System.currentTimeMillis();
               fileChooser = new JFileChooser() {
                    @Override
                    public void updateUI() {
                         long start = System.currentTimeMillis();
                         super.updateUI();
                         long end = System.currentTimeMillis();
                         System.out.println("FileChooserTest.updateUI e=" + (end - start));
                    }
               };
               long end = System.currentTimeMillis();
               System.out.println("FileChooserTest newFileChooser elapsed=" + (end - start));
          }

          fileChooser.setAcceptAllFileFilterUsed(false);
          fileChooser.setApproveButtonText("Select");
          filter.setExtensions(extensions);
          fileChooser.setFileFilter(filter);
          fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          fileChooser.setFileHidingEnabled(false);
          fileChooser.setMultiSelectionEnabled(false);





          fileChooser.setFileSystemView(FileSystemView.getFileSystemView());
     }
}
