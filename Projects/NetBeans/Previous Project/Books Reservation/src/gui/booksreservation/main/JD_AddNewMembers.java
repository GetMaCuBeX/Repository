package gui.booksreservation.main;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.booksimage;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.database.booksreservation.membersimage;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.MyFileChooserBrowsePicture;
import mcbx.jb.classes.mycollection.MyFileChooserSavePicture;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JD_AddNewMembers extends javax.swing.JDialog {

    // PICTURE IMAGE
    /* preview picture */
    private membersimage ref_membersimage = new membersimage();
    private MyFileChooserBrowsePicture ins_MyFileChooserBrowsePicture = new MyFileChooserBrowsePicture();
    /* save picture */
    private MyFileChooserSavePicture ins_MyFileChooserSavePicture = new MyFileChooserSavePicture();
    private ImageIcon NoImageBackground_Books = new ImageIcon(Main.class.getResource("icons/1_256x256_NoImageBackground_Books.png"));
    /* for browsed pictures */
    private ImageIcon icon_browsed = null;
    private ImageIcon iconThumbnail_browsed = null;
    private int icon_DimensionSize = 140;
    private String file_browsed;
    private File ins_file_browsed;
    private String fileName_Browsed;
    //
    private int idmembers = 0;
    private boolean isneedupdate = false;

    public boolean isIsneedupdate() {
        return isneedupdate;
    }

    public void setIsneedupdate(boolean isneedupdate) {
        this.isneedupdate = isneedupdate;
    }

    public int getIdmembers() {
        return idmembers;
    }

    public void setIdmembers(int idmembers) {
        this.idmembers = idmembers;
    }

    public JD_AddNewMembers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /**/
        setDatechooserPanel_1();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel_1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton_Add = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_browsedimage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton_SavePicture = new javax.swing.JButton();
        jButton_BrowsePicture = new javax.swing.JButton();
        jButton_SaveAs = new javax.swing.JButton();
        jButton_DeletePicture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("E-Address:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Phone 1:");

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField6.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Type:");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField5.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Phone 2:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Birth Date:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Lastname:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Gender:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Firstname:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Address 1:");

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Address 2:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField2.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student", "Instructor", "Administrator", "Officer" }));

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField7.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("ID Number:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jPanel_1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_1.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Username:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Password:");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField4.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("M.I");

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField8.setMargin(new java.awt.Insets(1, 4, 1, 4));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3)
                            .addComponent(jPanel_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jButton_Add.setText("Add");
        jButton_Add.setPreferredSize(new java.awt.Dimension(69, 23));
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.setPreferredSize(new java.awt.Dimension(69, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_browsedimage.setToolTipText("Browse Image");
        jButton_browsedimage.setFocusPainted(false);
        jButton_browsedimage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_browsedimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_browsedimageActionPerformed(evt);
            }
        });

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 10, 5));

        jButton_SavePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_SaveImage.png"))); // NOI18N
        jButton_SavePicture.setToolTipText("Save Image to database");
        jButton_SavePicture.setFocusable(false);
        jButton_SavePicture.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_SavePicture.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_SavePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SavePictureActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_SavePicture);

        jButton_BrowsePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_AddUpdateImage.png"))); // NOI18N
        jButton_BrowsePicture.setToolTipText("Browse Image");
        jButton_BrowsePicture.setFocusable(false);
        jButton_BrowsePicture.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_BrowsePicture.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_BrowsePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BrowsePictureActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_BrowsePicture);

        jButton_SaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_SaveAsImage.png"))); // NOI18N
        jButton_SaveAs.setToolTipText("Save As Image");
        jButton_SaveAs.setFocusPainted(false);
        jButton_SaveAs.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_SaveAs.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveAsActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_SaveAs);

        jButton_DeletePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_DeleteImage.png"))); // NOI18N
        jButton_DeletePicture.setToolTipText("Delete Image");
        jButton_DeletePicture.setFocusable(false);
        jButton_DeletePicture.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_DeletePicture.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_DeletePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletePictureActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_DeletePicture);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_browsedimage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_browsedimage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_update))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed

         boolean isPassed = checkTheFormFirst();
         if (isPassed) { // all data is valid
             addnewMember();
         }


     }//GEN-LAST:event_jButton_AddActionPerformed

     private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
//         boolean isPassed = checkTheFormFirst();
//         if (isPassed) { // all data is valid
//             updatemember();
//         }
     }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_DeletePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletePictureActionPerformed
        /* delete image */
        int choice = JOptionPane.showConfirmDialog(this, "Delete image?", "Delete Confirmation", JOptionPane.WARNING_MESSAGE);
        System.out.println(choice);
        switch (choice) {
            case JOptionPane.OK_OPTION:
                Connection conn = Database._function_getConnection(Database._booksreservation);
                try {
                    if (conn != null) {
                        int members_idmembers = this.getIdmembers();
                        ref_membersimage.delete_membersimage(members_idmembers, conn);
                        validate_BooksImage();
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;

        }
    }//GEN-LAST:event_jButton_DeletePictureActionPerformed

    private void jButton_browsedimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_browsedimageActionPerformed

        if ("Administrator".equals(UserLogs.getMembertype())) {
            ins_MyFileChooserBrowsePicture.configureFileChooser();
            int option = ins_MyFileChooserBrowsePicture.fileChooser.showOpenDialog(this);
            analyzeOptionBrowse(ins_MyFileChooserBrowsePicture.fileChooser, option);
        }

    }//GEN-LAST:event_jButton_browsedimageActionPerformed

    private void jButton_SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveAsActionPerformed

        if (iconThumbnail_browsed != null) {
            ins_MyFileChooserSavePicture.configureFileChooser();
            int option = ins_MyFileChooserSavePicture.fileChooser.showSaveDialog(this);
            analyzeOptionSave(ins_MyFileChooserSavePicture.fileChooser, option);

        }
    }//GEN-LAST:event_jButton_SaveAsActionPerformed

    private void jButton_BrowsePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BrowsePictureActionPerformed
        if ("Administrator".equals(UserLogs.getMembertype())) {
            ins_MyFileChooserBrowsePicture.configureFileChooser();
            int option = ins_MyFileChooserBrowsePicture.fileChooser.showOpenDialog(this);
            analyzeOptionBrowse(ins_MyFileChooserBrowsePicture.fileChooser, option);
        }
    }//GEN-LAST:event_jButton_BrowsePictureActionPerformed

    private void jButton_SavePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SavePictureActionPerformed
        Connection conn = Database._function_getConnection(Database._booksreservation);
        try {
            if (conn != null) {
                /* insert to booksimage */
                if (new File(file_browsed).length() < 1024000) {
                    boolean isExist_idmembers = ref_membersimage.function_is_idmembers_exist(this.getIdmembers(), conn);
                    if (isExist_idmembers) { // update the image
                        ref_membersimage.update_membersimage(this.getIdmembers(), fileName_Browsed, file_browsed, conn);
                    } else { // insert image
                        ref_membersimage.insert_membersimage(this.getIdmembers(), fileName_Browsed, file_browsed, conn);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error to save the image...\nIvalid image size...", "Error", JOptionPane.ERROR_MESSAGE);
                }
                validate_BooksImage();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton_SavePictureActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_AddNewMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_AddNewMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_AddNewMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_AddNewMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JD_AddNewMembers dialog = new JD_AddNewMembers(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_BrowsePicture;
    private javax.swing.JButton jButton_DeletePicture;
    private javax.swing.JButton jButton_SaveAs;
    private javax.swing.JButton jButton_SavePicture;
    private javax.swing.JButton jButton_browsedimage;
    public javax.swing.JButton jButton_update;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
    private JDateChooser JDC_1 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private MyFunctions ref_MyFunctions = new MyFunctions();

    private void setDatechooserPanel_1() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                setDateChooser("MMMM dd, yyyy", JDC_1, jPanel_1, false);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDateChooser(String SDF, JDateChooser JDC_dateChooser, JPanel JP_dateChooser, boolean isNullButtonVisible) {
        JDC_dateChooser.setDateFormatString(SDF);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setTodayButtonVisible(true);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setNullDateButtonVisible(isNullButtonVisible);

        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBordersVisible(false);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBackgroundColor(Color.black);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setWeekdayForeground(Color.white);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setSundayForeground(Color.red);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBackgroundVisible(true);

        ((JDateChooser) JDC_dateChooser).getJCalendar().setWeekOfYearVisible(false);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setMaxDayCharacters(1);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setBackground(Color.black);
        JP_dateChooser.add(JDC_dateChooser);
    }

    /**/
    private members ref_members = new members();

    public boolean checkTheFormFirst() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String idnumber_ = jTextField1.getText().trim().toString().toUpperCase();
                if (idnumber_.length() > 20 || idnumber_.length() == 0) {
                    JOptionPane.showMessageDialog(this, "Ivalid ID number...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    String firstname_ = jTextField2.getText().trim().toString().toUpperCase();
                    if (firstname_.length() > 45 || firstname_.length() == 0) {
                        JOptionPane.showMessageDialog(this, "Ivalid Firstname...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        String middleinitial_ = jComboBox1.getSelectedItem().toString();
                        String lastname_ = jTextField3.getText().trim().toString().toUpperCase();
                        if (lastname_.length() > 45 || lastname_.length() == 0) {
                            JOptionPane.showMessageDialog(this, "Ivalid Lastname...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        } else {
                            if (JDC_1.getDate() == null) {
                                JOptionPane.showMessageDialog(this, "Ivalid Date of birth...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            } else {
                                String dateofbirth_ = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(JDC_1.getDate()));
                                String gender_ = jComboBox2.getSelectedItem().toString();
                                String address1_ = jTextArea1.getText().trim().toString();
                                if (address1_.length() > 100) {
                                    JOptionPane.showMessageDialog(this, "Ivalid Address 1, the length must not be greater than 100...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                } else {
                                    String address2_ = jTextArea2.getText().trim().toString();
                                    if (address2_.length() > 100) {
                                        JOptionPane.showMessageDialog(this, "Ivalid Address 2, the length must not be greater than 100...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                        return false;
                                    } else {
                                        String phonenumber1_ = jTextField4.getText().trim().toString();
                                        if (phonenumber1_.length() > 45) {
                                            JOptionPane.showMessageDialog(this, "Ivalid Phonenumber 1, the length must not be greater than 45...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                            return false;
                                        } else {

                                            String phonenumber2_ = jTextField5.getText().trim().toString();
                                            if (phonenumber2_.length() > 45) {
                                                JOptionPane.showMessageDialog(this, "Ivalid Phonenumber 2, the length must not be greater than 45...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                                return false;
                                            } else {
                                                String emailaddress_ = jTextField6.getText().trim().toString();
                                                if (emailaddress_.length() > 45) {
                                                    JOptionPane.showMessageDialog(this, "Ivalid Email Address, the length must not be greater than 45...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return false;
                                                } else {
                                                    java.sql.Date get_registereddate_ = ref_MyFunctions.select_currentDate(conn);
                                                    String registereddate_ = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(get_registereddate_));
                                                    String membertype_ = jComboBox3.getSelectedItem().toString();
                                                    String username_ = jTextField7.getText().trim().toString();
                                                    if (username_.length() > 45 || username_.length() == 0) {
                                                        JOptionPane.showMessageDialog(this, "Ivalid input username...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                                        return false;
                                                    } else {
                                                        String password_ = jTextField8.getText().trim().toString();
                                                        if (password_.length() > 45 || password_.length() == 0) {
                                                            JOptionPane.showMessageDialog(this, "Ivalid input password...\nPlease check the form...", "Error", JOptionPane.ERROR_MESSAGE);
                                                            return false;

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return true;
    }

    private void addnewMember() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String timeNow = new MyFunctions().return_DateTime("HH:mm:ss");
                
                String idnumber_ = jTextField1.getText().trim().toString().toUpperCase();
                String firstname_ = jTextField2.getText().trim().toString().toUpperCase();
                String middleinitial_ = jComboBox1.getSelectedItem().toString();
                String lastname_ = jTextField3.getText().trim().toString().toUpperCase();
                
                String dateofbirth_ = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_1.getDate()));
                String gender_ = jComboBox2.getSelectedItem().toString();
                String address1_ = jTextArea1.getText().trim().toString();
                String address2_ = jTextArea2.getText().trim().toString();
                String phonenumber1_ = jTextField4.getText().trim().toString();
                String phonenumber2_ = jTextField5.getText().trim().toString();
                String emailaddress_ = jTextField6.getText().trim().toString();
                java.sql.Date get_registereddate_ = ref_MyFunctions.select_currentDate(conn);
                String registereddate_ = (new SimpleDateFormat("yyyy-MM-dd").format(get_registereddate_));
                String membertype_ = jComboBox3.getSelectedItem().toString();
                String username_ = jTextField7.getText().trim().toString();
                String password_ = jTextField8.getText().trim().toString();
                int isblock_ = 0;

                boolean isExist_username = ref_members.function_is_username_exist(username_, conn);
                if (isExist_username) {
                    JOptionPane.showMessageDialog(this, "Input Username is already exist...\nPlease type another name...", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean isExist_password = ref_members.function_is_password_exist(password_, conn);
                    if (isExist_password) {
                        JOptionPane.showMessageDialog(this, "Input Password is already exist...\nPlease type another password...", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        ref_members.insert_members(new members(idnumber_, firstname_, middleinitial_, lastname_, dateofbirth_, gender_, address1_, address2_, phonenumber1_, phonenumber2_, emailaddress_, registereddate_+" "+timeNow, membertype_, isblock_, username_, password_), conn);
                        JOptionPane.showMessageDialog(this, "New Member Successfully Add", "Message", JOptionPane.PLAIN_MESSAGE);
                        this.setIdmembers(ref_members.function_get_idmembers(username_, password_, conn));
                        this.setTitle(ref_members.function_get_firstname_lastname(this.getIdmembers(), conn));
                        jButton_Add.setVisible(false);
                        jButton_update.setVisible(true);
                        this.setIsneedupdate(true);

                        // enable members image
                        setEnabled_viewInformation(idmembers);
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public boolean updatemember() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idmembers_ = this.getIdmembers();
                String username_ = jTextField7.getText().trim().toString();
                String password_ = jTextField8.getText().trim().toString();
                String idnumber_ = jTextField1.getText().trim().toString().toUpperCase();
                String firstname_ = jTextField2.getText().trim().toString().toUpperCase();
                String middleinitial_ = jComboBox1.getSelectedItem().toString();
                String lastname_ = jTextField3.getText().trim().toString().toUpperCase();
                String dateofbirth_ = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(JDC_1.getDate()));
                String gender_ = jComboBox2.getSelectedItem().toString();
                String address1_ = jTextArea1.getText().trim().toString();
                String address2_ = jTextArea2.getText().trim().toString();
                String phonenumber1_ = jTextField4.getText().trim().toString();
                String phonenumber2_ = jTextField5.getText().trim().toString();
                String emailaddress_ = jTextField6.getText().trim().toString();
                java.sql.Date get_registereddate_ = ref_MyFunctions.select_currentDate(conn);
                String registereddate_ = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(get_registereddate_));
                String membertype_ = jComboBox3.getSelectedItem().toString();
                int isblock_ = 0;
                /**/


                if (ref_members.function_is_idnumber_exist_notLike_idmembers(idnumber_, idmembers_, conn)) {
                    String ownerIDNumber_firstname = ref_members.function_get_firstname(idnumber_, conn);
                    String ownerIDNumber_lastname = ref_members.function_get_lastname(idnumber_, conn);
                    JOptionPane.showMessageDialog(this, "Input ID Number is already exist...\nPlease type another ID Number....\nIt was Owned by:\n" + ownerIDNumber_firstname + " " + ownerIDNumber_lastname + "", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    boolean isExist_username = ref_members.function_is_username_exist_notLike_idmembers(idmembers_, username_, conn);
                    if (isExist_username) {
                        JOptionPane.showMessageDialog(this, "Input Username is already exist...\nPlease type another name...", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        boolean isExist_password = ref_members.function_is_password_exist_notLike_idmembers(idmembers_, password_, conn);
                        if (isExist_password) {
                            JOptionPane.showMessageDialog(this, "Input Password is already exist...\nPlease type another password...", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            ref_members.update_members(idmembers_, new members(idnumber_, firstname_, middleinitial_, lastname_, dateofbirth_, gender_, address1_, address2_, phonenumber1_, phonenumber2_, emailaddress_, registereddate_, membertype_, isblock_, username_, password_), conn);
                            JOptionPane.showMessageDialog(this, "Member Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE);
                            this.setIsneedupdate(true);
                            this.setTitle(ref_members.function_get_firstname_lastname(this.getIdmembers(), conn));
                            return true;
                        }
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public void clearTheForm() {
        try {
            jTextField1.setText("");
            jTextField2.setText("");
            jComboBox1.setSelectedIndex(0);
            jTextField3.setText("");
            JDC_1.setDate(null);
            jComboBox2.setSelectedIndex(0);
            jTextArea1.setText("");
            jTextArea2.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jComboBox3.setSelectedIndex(0);
            jTextField7.setText("");
            jTextField8.setText("");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void refreshForm() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idmembers_ = this.getIdmembers();
                jTextField1.setText(ref_members.function_get_idnumber(idmembers_, conn));
                jTextField2.setText(ref_members.function_get_firstname(idmembers_, conn));
                jComboBox1.setSelectedItem(ref_members.function_get_middleinitial(idmembers_, conn));
                jTextField3.setText(ref_members.function_get_lastname(idmembers_, conn));
                JDC_1.setDate(ref_members.function_get_dateofbirth(idmembers_, conn));
                jComboBox2.setSelectedItem(ref_members.function_get_gender(idmembers_, conn));
                jTextArea1.setText(ref_members.function_get_address1(idmembers_, conn));
                jTextArea2.setText(ref_members.function_get_address2(idmembers_, conn));
                jTextField4.setText(ref_members.function_get_phonenumber1(idmembers_, conn));
                jTextField5.setText(ref_members.function_get_phonenumber2(idmembers_, conn));
                jTextField6.setText(ref_members.function_get_emailaddress(idmembers_, conn));
                jComboBox3.setSelectedItem(ref_members.function_get_membertype(idmembers_, conn));
                jTextField7.setText(ref_members.function_get_username(idmembers_, conn));
                jTextField8.setText(ref_members.function_get_password(idmembers_, conn));
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void student_view_form(boolean b) {
        try {

            jTextField1.setEnabled(b);
            jTextField2.setEnabled(b);
            jComboBox1.setEnabled(b);
            jTextField3.setEnabled(b);
            JDC_1.setEnabled(b);
            jComboBox2.setEnabled(b);
            jComboBox3.setEnabled(b);
            jTextField1.setEnabled(b);
            jTextField1.setEnabled(b);
            jTextField1.setEnabled(b);
            jTextField1.setEnabled(b);
            jTextField1.setEnabled(b);
            jTextField1.setEnabled(b);


        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    public void check_userlogs() {
        switch (UserLogs.getMembertype()) {
            case "Instructor":
                jButton_SaveAs.setVisible((jButton_SaveAs.isEnabled()) ? true : false);
                jButton_DeletePicture.setVisible(false);
                jButton_BrowsePicture.setVisible(false);
                jButton_SavePicture.setVisible(false);
                break;
            case "Student":
                jButton_SaveAs.setVisible((jButton_SaveAs.isEnabled()) ? true : false);
                jButton_DeletePicture.setVisible(false);
                jButton_BrowsePicture.setVisible(false);
                jButton_SavePicture.setVisible(false);
                break;
            case "Administrator":
                jButton_SaveAs.setVisible(true);
                jButton_DeletePicture.setVisible(true);
                jButton_BrowsePicture.setVisible(true);
                jButton_SavePicture.setVisible(true);
                break;
            case "Officer":
                jButton_SaveAs.setVisible((jButton_SaveAs.isEnabled()) ? true : false);
                jButton_DeletePicture.setVisible(true);
                jButton_BrowsePicture.setVisible(true);
                jButton_SavePicture.setVisible(true);
                break;
            default:
                jButton_SaveAs.setVisible(false);
                jButton_DeletePicture.setVisible(false);
                jButton_BrowsePicture.setVisible(false);
                jButton_SavePicture.setVisible(false);
                break;
        }
    }

// ----------------------------------------------------------------------------- PICTURE IMAGE
    private void analyzeOptionBrowse(JFileChooser fc, int option) {
        try {
//          StringBuilder buf = new StringBuilder();
            switch (option) {
                case JFileChooser.CANCEL_OPTION:
//                    buf.append("canceled");
                    break;
                case JFileChooser.APPROVE_OPTION:
//                    buf.append("approved\n");
                         /* display file */
                    file_browsed = Arrays.asList(fc.getSelectedFile().toString().replace("\\", "/")).toString().replace("[", "").replace("]", "");
                    ins_file_browsed = new File(file_browsed);
                    //System.out.println("Size: " + (int) ins_file_browsed.length());
                         /* create ImageIcon */
                    icon_browsed = new ImageIcon(file_browsed);
                    /* display ImageIcon*/
                    createThumbnail_browsed(icon_browsed, 140);
                    jButton_browsedimage.setIcon(iconThumbnail_browsed);
                    jButton_browsedimage.setToolTipText(file_browsed);
                    /* get filename */
                    fileName_Browsed = fc.getSelectedFile().getName();
//                    buf.append("file:").append(fc.getSelectedFile().toString().replace("\\", "/")).append("\n");
                    if (fc.getSelectedFile() != null) {
//                         System.out.println(fc.getSelectedFile().toString());
                    }
//                    buf.append("files:").append(Arrays.asList(fc.getSelectedFiles())).append("\n");
//                    buf.append("directory:").append(fc.getCurrentDirectory()).append("\n");

                    /**/
                    jButton_SavePicture.setEnabled(true);

                    jButton_SaveAs.setEnabled(false);
                    jButton_DeletePicture.setEnabled(false);
                    break;
                case JFileChooser.ERROR_OPTION:
//                    buf.append("error");
                    break;

            }
//          System.out.append("" + buf.toString());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* modified */
    private void createThumbnail_browsed(ImageIcon icon_browsed, int maxDim) {
        try {
            Image inImage = icon_browsed.getImage();

            double scale = (double) maxDim / (double) inImage.getHeight(null);
            if (inImage.getWidth(null) > inImage.getHeight(null)) {
                scale = (double) maxDim / (double) inImage.getWidth(null);
            }

            int scaledW = (int) (scale * inImage.getWidth(null));
            int scaledH = (int) (scale * inImage.getHeight(null));

            BufferedImage outImage = new BufferedImage(scaledW, scaledH,
                    BufferedImage.TYPE_INT_ARGB);

            AffineTransform tx = new AffineTransform();

            if (scale < 1.0d) {
                tx.scale(scale, scale);
            }

            Graphics2D g2d = outImage.createGraphics();
            g2d.drawImage(inImage, tx, null);
            g2d.dispose();

            iconThumbnail_browsed = new ImageIcon(outImage);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* validate books image */
    public void validate_BooksImage() {
        Connection conn = Database._function_getConnection(Database._booksreservation);
        try {
            if (conn != null) {
                /* create iconThumbnail */
                iconThumbnail_browsed = null;
                int members_idmembers = this.getIdmembers();
                boolean isExist_idmembers = ref_membersimage.function_is_idmembers_exist(members_idmembers, conn);
                /* check if it has an image */
                if (isExist_idmembers) {
                    icon_browsed = new membersimage().function_select_Image(members_idmembers, conn);
                    /* chech if the icon is null */
                    if (icon_browsed != null) {

                        System.out.println("!= null");
                        createThumbnail_browsed(icon_browsed, icon_DimensionSize);
                        jButton_browsedimage.setIcon(iconThumbnail_browsed);
                        jButton_SavePicture.setEnabled(false);
                        jButton_SaveAs.setEnabled(true);
                        jButton_DeletePicture.setEnabled(true);
                    } else {
                        jButton_browsedimage.setIcon(NoImageBackground_Books);
                        jButton_SavePicture.setEnabled(false);
                    }
                } else { // idbooks is not exist
                    jButton_browsedimage.setIcon(NoImageBackground_Books);
                    jButton_SavePicture.setEnabled(false);
                    jButton_SaveAs.setEnabled(false);
                    jButton_DeletePicture.setEnabled(false);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
            jButton_browsedimage.setIcon(NoImageBackground_Books);
            jButton_SavePicture.setEnabled(false);
        }
    }
    /* save booksimaage */

    private void analyzeOptionSave(JFileChooser fc, int option) {
        try {
            switch (option) {
                case JFileChooser.CANCEL_OPTION:
                    break;
                case JFileChooser.APPROVE_OPTION:
                    if (fc.getSelectedFile() != null) {
                        /* save picture */
                        String directoryInfo = fc.getSelectedFile().toString();
                        Connection conn = Database._function_getConnection(Database._booksreservation);
                        try {
                            if (conn != null) {
                                /* get the idbooks */
                                ref_membersimage.savePicture(this.getIdmembers(), directoryInfo, conn);
                            } else {
                                Database._open_JD_MySQLConnect(Database._booksreservation);
                            }
                        } catch (Exception e) {
                            System.err.println(e);
                        } // end save picture
                    }
                    break;
                case JFileChooser.ERROR_OPTION:
                    break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setEnabled_viewInformation(int idmembers) {

        jButton_browsedimage.setEnabled(true);
        jButton_SavePicture.setEnabled(true);
        jButton_BrowsePicture.setEnabled(true);
        jButton_SaveAs.setEnabled(true);
        jButton_DeletePicture.setEnabled(true);
        
        this.setIdmembers(idmembers);
        validate_BooksImage();
        check_userlogs();

    }

    public void setEnabled_addMembers() {
        jButton_browsedimage.setIcon(NoImageBackground_Books);
        
        jButton_browsedimage.setEnabled(false);
        jButton_SavePicture.setEnabled(false);
        jButton_BrowsePicture.setEnabled(false);
        jButton_SaveAs.setEnabled(false);
        jButton_DeletePicture.setEnabled(false);
    }
}
