package gui.booksreservation.main;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.authors;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.database.booksreservation.booksauthors;
import mcbx.jb.classes.database.booksreservation.booksimage;
import mcbx.jb.classes.database.booksreservation.bookspublishers;
import mcbx.jb.classes.database.booksreservation.bookssubjects;
import mcbx.jb.classes.database.booksreservation.category;
import mcbx.jb.classes.database.booksreservation.publishers;
import mcbx.jb.classes.database.booksreservation.subjects;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.MyFileChooserBrowsePicture;
import mcbx.jb.classes.mycollection.MyFileChooserSavePicture;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JF_BooksInformation extends javax.swing.JFrame {

    public JD_Authors ref_JD_Authors = new JD_Authors(this, false);
    public JD_Publishers ref_JD_Publishers = new JD_Publishers(this, false);
    public JD_Subjects ref_JD_Subjects = new JD_Subjects(this, false);
    //
    private authors ref_authors = new authors();
    private publishers ref_publishers = new publishers();
    private subjects ref_subjects = new subjects();
    private booksauthors ref_booksauthors = new booksauthors();
    private bookspublishers ref_bookspublishers = new bookspublishers();
    private bookssubjects ref_bookssubjects = new bookssubjects();
    private category ref_category = new category();
    private int idbooks_information = 0;

    public int getIdbooks_information() {
        return idbooks_information;
    }

    public void setIdbooks_information(int idbooks_information) {
        this.idbooks_information = idbooks_information;
    }
    //
    private books ref_books = new books();
    private booksimage ref_booksimage = new booksimage();
    private MyFunctions ref_MyFunctions = new MyFunctions();
    /**/
    /* preview picture */
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
    /**/
//     public static REF_JF_BooksInformation_Authors ref_JF_BooksInformation_Authors = new REF_JF_BooksInformation_Authors();
//     public static REF_JF_BooksInformation_Subjects ref_JF_BooksInformation_Subjects = new REF_JF_BooksInformation_Subjects();
// ----------------------------------------------------------------------------- INITIALIZE ADDITIONAL INFORMATION
    private DefaultTableModel jTableAuthors_TableModel, jTablePublishers_TableModel, jTableSubjects_TableModel, jTableCategory_TableModel;

    public JF_BooksInformation() {
        initComponents();
        jButton_Search.setVisible(false);
//        validate_BooksInformation();
//        validate_BooksImage();
// ----------------------------------------------------------------------------- [CATEGORY] 

// ----------------------------------------------------------------------------- INITIALIZE ADDITIONAL INFORMATION
        jTableAuthors_TableModel = (DefaultTableModel) jTableAuthors.getModel();
        jTable_setShowHorizontalLines(jTableAuthors);
        jTable_setTableHeader(jTableAuthors);
        jTablePublishers_TableModel = (DefaultTableModel) jTablePublishers.getModel();
        jTable_setShowHorizontalLines(jTablePublishers);
        jTable_setTableHeader(jTablePublishers);
        jTableSubjects_TableModel = (DefaultTableModel) jTableSubjects.getModel();
        jTable_setShowHorizontalLines(jTableSubjects);
        jTable_setTableHeader(jTableSubjects);

        // Category
        jTableCategory_TableModel = (DefaultTableModel) jTableCategory.getModel();
        jTable_setShowHorizontalLines(jTableCategory);
        jTable_setTableHeader(jTableCategory);

        jDialog_Category.setSize(jDialog_Category.getPreferredSize());
//        jDialog_Category.setModal(true);
        jDialog_Category.setLocationRelativeTo(this);
//        addEvents_jTable_AdditionalInformation();


        // INITIALZE jDialog Additional Information
        initiComponents_jDialog_AdditionalInformation();


        jDialog1_AddBooks.setSize(jDialog1_AddBooks.getPreferredSize());

    }

// ----------------------------------------------------------------------------- [SET TABLE]
    /**/
    private void jTable_setShowHorizontalLines(JTable jTable) {

        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(true);
    }

    private void jTable_setTableHeader(JTable jTable) {
        JTableHeader header = jTable.getTableHeader();
        header.setReorderingAllowed(false);
        header.setResizingAllowed(true);
        header.setEnabled(true);
        header.setUpdateTableInRealTime(true);
        // header.setBackground(Color.BLACK);
        header.setForeground(Color.BLACK);
        header.setFont(new java.awt.Font("Arial", 1, 11));
        header.setAlignmentX(0);
        header.setAlignmentY(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu_jTableAuthors = new javax.swing.JPopupMenu();
        jMenuItem_jTableAuthors_AddNew = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_jTableAuthors_RemoveSelected = new javax.swing.JMenuItem();
        jPopupMenu_jTablePublishers = new javax.swing.JPopupMenu();
        jMenuItem_jTablePublishers_AddNew = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_jTablePublishers_RemoveSelected = new javax.swing.JMenuItem();
        jPopupMenu_jTableSubjects = new javax.swing.JPopupMenu();
        jMenuItem_jTableSubjects_AddNew = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_jTableSubjects_RemoveSelected = new javax.swing.JMenuItem();
        jDialog_Category = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jScrollPaneCategory = new javax.swing.JScrollPane();
        jTableCategory = new javax.swing.JTable();
        jPopupMenu_jTableCategory = new javax.swing.JPopupMenu();
        jMenuItem_jTableCategory_AddNew = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_jTableCategory_RemoveSelected = new javax.swing.JMenuItem();
        jMenuItem_jTableCategory_UpdateSelected = new javax.swing.JMenuItem();
        jDialog_AddCategory = new javax.swing.JDialog();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel10 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jDialog_UpdateCategory = new javax.swing.JDialog();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel12 = new javax.swing.JPanel();
        jButton_updateCategoryName = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jDialog1_AddBooks = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jTextField2_AddBooks = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField3_AddBooks = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField4_AddBooks = new javax.swing.JTextField();
        jFormattedTextField2_AddBooks = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jFormattedTextField1_AddBooks = new javax.swing.JFormattedTextField();
        jFormattedTextField4_AddBooks = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox_CategoryName_AddBooks = new javax.swing.JComboBox();
        jComboBox_isBorrowable_AddBooks = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel_AcquiredDate_AddBooks = new javax.swing.JPanel();
        jFormattedTextField3_AddBooks = new javax.swing.JFormattedTextField();
        jTextField5_AddBooks = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2_AddBooks = new javax.swing.JScrollPane();
        jTextArea1_AddBooks = new javax.swing.JTextArea();
        jButton4_AddBooks = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jButton2_AddBooks = new javax.swing.JButton();
        jButton7_AddBooks = new javax.swing.JButton();
        jButton3_AddBooks = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_browsedimage = new javax.swing.JButton();
        jButton_BrowsePicture = new javax.swing.JButton();
        jButton_Search = new javax.swing.JButton();
        jButton_SavePicture = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_CategoryName = new javax.swing.JComboBox();
        jComboBox_isBorrowable = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel_AcquiredDate = new javax.swing.JPanel();
        jButton_updateBooksInformation = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneAuthors = new javax.swing.JScrollPane();
        jTableAuthors = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPanePublishers = new javax.swing.JScrollPane();
        jTablePublishers = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPaneSubjects = new javax.swing.JScrollPane();
        jTableSubjects = new javax.swing.JTable();
        jButton_DeletePicture = new javax.swing.JButton();
        jButton_SaveAs = new javax.swing.JButton();

        jMenuItem_jTableAuthors_AddNew.setText("Add New Author");
        jMenuItem_jTableAuthors_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableAuthors_AddNewActionPerformed(evt);
            }
        });
        jPopupMenu_jTableAuthors.add(jMenuItem_jTableAuthors_AddNew);
        jPopupMenu_jTableAuthors.add(jSeparator1);

        jMenuItem_jTableAuthors_RemoveSelected.setText("Remove Selected");
        jMenuItem_jTableAuthors_RemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableAuthors_RemoveSelectedActionPerformed(evt);
            }
        });
        jPopupMenu_jTableAuthors.add(jMenuItem_jTableAuthors_RemoveSelected);

        jMenuItem_jTablePublishers_AddNew.setText("Add New Publisher");
        jMenuItem_jTablePublishers_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTablePublishers_AddNewActionPerformed(evt);
            }
        });
        jPopupMenu_jTablePublishers.add(jMenuItem_jTablePublishers_AddNew);
        jPopupMenu_jTablePublishers.add(jSeparator2);

        jMenuItem_jTablePublishers_RemoveSelected.setText("Remove Selected");
        jMenuItem_jTablePublishers_RemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTablePublishers_RemoveSelectedActionPerformed(evt);
            }
        });
        jPopupMenu_jTablePublishers.add(jMenuItem_jTablePublishers_RemoveSelected);

        jMenuItem_jTableSubjects_AddNew.setText("Add New Subject");
        jMenuItem_jTableSubjects_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableSubjects_AddNewActionPerformed(evt);
            }
        });
        jPopupMenu_jTableSubjects.add(jMenuItem_jTableSubjects_AddNew);
        jPopupMenu_jTableSubjects.add(jSeparator3);

        jMenuItem_jTableSubjects_RemoveSelected.setText("Remove Selected");
        jMenuItem_jTableSubjects_RemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableSubjects_RemoveSelectedActionPerformed(evt);
            }
        });
        jPopupMenu_jTableSubjects.add(jMenuItem_jTableSubjects_RemoveSelected);

        jDialog_Category.setTitle("Books Category");
        jDialog_Category.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog_CategoryWindowClosed(evt);
            }
        });

        jTableCategory.setAutoCreateRowSorter(true);
        jTableCategory.setBackground(new java.awt.Color(153, 0, 0));
        jTableCategory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableCategory.setForeground(new java.awt.Color(255, 255, 255));
        jTableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCategory.setRowHeight(24);
        jTableCategory.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPaneCategory.setViewportView(jTableCategory);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        jDialog_Category.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        jMenuItem_jTableCategory_AddNew.setText("Add New Category");
        jMenuItem_jTableCategory_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableCategory_AddNewActionPerformed(evt);
            }
        });
        jPopupMenu_jTableCategory.add(jMenuItem_jTableCategory_AddNew);
        jPopupMenu_jTableCategory.add(jSeparator4);

        jMenuItem_jTableCategory_RemoveSelected.setText("Remove Selected");
        jMenuItem_jTableCategory_RemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableCategory_RemoveSelectedActionPerformed(evt);
            }
        });
        jPopupMenu_jTableCategory.add(jMenuItem_jTableCategory_RemoveSelected);

        jMenuItem_jTableCategory_UpdateSelected.setText("Update Selected");
        jMenuItem_jTableCategory_UpdateSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_jTableCategory_UpdateSelectedActionPerformed(evt);
            }
        });
        jPopupMenu_jTableCategory.add(jMenuItem_jTableCategory_UpdateSelected);

        jDialog_AddCategory.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_AddCategory.setTitle("Add New Category");
        jDialog_AddCategory.setMinimumSize(new java.awt.Dimension(300, 115));
        jDialog_AddCategory.setResizable(false);

        jToolBar1.setFloatable(false);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton5.setText("Add");
        jButton5.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton5);

        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton6);

        jToolBar1.add(jPanel10);

        jDialog_AddCategory.getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Enter Name:");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jDialog_AddCategory.getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

        jDialog_UpdateCategory.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_UpdateCategory.setTitle("Update Category");
        jDialog_UpdateCategory.setMinimumSize(new java.awt.Dimension(300, 115));
        jDialog_UpdateCategory.setResizable(false);

        jToolBar3.setFloatable(false);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton_updateCategoryName.setText("Update");
        jButton_updateCategoryName.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton_updateCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateCategoryNameActionPerformed(evt);
            }
        });
        jPanel12.add(jButton_updateCategoryName);

        jButton9.setText("Close");
        jButton9.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton9);

        jToolBar3.add(jPanel12);

        jDialog_UpdateCategory.getContentPane().add(jToolBar3, java.awt.BorderLayout.PAGE_END);

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Enter Name:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jDialog_UpdateCategory.getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

        jDialog1_AddBooks.setTitle("Add New Book(s)");
        jDialog1_AddBooks.setMinimumSize(new java.awt.Dimension(450, 400));
        jDialog1_AddBooks.setResizable(false);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jTextField2_AddBooks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("ISBN:");

        jTextField3_AddBooks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Barcode:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Title:");

        jTextField4_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));
        jTextField4_AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4_AddBooksActionPerformed(evt);
            }
        });

        jFormattedTextField2_AddBooks.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField2_AddBooks.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField2_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Cost:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Pages:");

        jFormattedTextField1_AddBooks.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormattedTextField1_AddBooks.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField1_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jFormattedTextField4_AddBooks.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormattedTextField4_AddBooks.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField4_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Copy Number:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Category:");

        jComboBox_CategoryName_AddBooks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "True", "False" }));

        jComboBox_isBorrowable_AddBooks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Borrowable:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Acquired Date:");

        jPanel_AcquiredDate_AddBooks.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_AcquiredDate_AddBooks.setLayout(new java.awt.BorderLayout());

        jFormattedTextField3_AddBooks.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField3_AddBooks.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField3_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jTextField5_AddBooks.setMargin(new java.awt.Insets(1, 4, 1, 4));
        jTextField5_AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5_AddBooksActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Purchased Cost:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Language:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Description:");

        jTextArea1_AddBooks.setColumns(20);
        jTextArea1_AddBooks.setLineWrap(true);
        jTextArea1_AddBooks.setRows(5);
        jScrollPane2_AddBooks.setViewportView(jTextArea1_AddBooks);

        jButton4_AddBooks.setText("...");
        jButton4_AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_AddBooksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2_AddBooks)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3_AddBooks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2_AddBooks))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField2_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1_AddBooks))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField4_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField3_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5_AddBooks))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4_AddBooks))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_isBorrowable_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel_AcquiredDate_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jComboBox_CategoryName_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox_CategoryName_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_isBorrowable_AddBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_AcquiredDate_AddBooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2_AddBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel14, java.awt.BorderLayout.CENTER);

        jButton2_AddBooks.setText("Add");
        jButton2_AddBooks.setToolTipText("Update Information");
        jButton2_AddBooks.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton2_AddBooks.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton2_AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_AddBooksActionPerformed(evt);
            }
        });
        jPanel15.add(jButton2_AddBooks);

        jButton7_AddBooks.setText("Clear");
        jButton7_AddBooks.setToolTipText("Reset Information");
        jButton7_AddBooks.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton7_AddBooks.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton7_AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7_AddBooksActionPerformed(evt);
            }
        });
        jPanel15.add(jButton7_AddBooks);

        jButton3_AddBooks.setText("Cancel");
        jButton3_AddBooks.setToolTipText("Reset Information");
        jButton3_AddBooks.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton3_AddBooks.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton3_AddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_AddBooksActionPerformed(evt);
            }
        });
        jPanel15.add(jButton3_AddBooks);

        jPanel8.add(jPanel15, java.awt.BorderLayout.PAGE_END);

        jDialog1_AddBooks.getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        setTitle("Books Information");

        jButton_browsedimage.setToolTipText("Browse Image");
        jButton_browsedimage.setFocusPainted(false);
        jButton_browsedimage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_browsedimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_browsedimageActionPerformed(evt);
            }
        });

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

        jButton_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_Search.png"))); // NOI18N
        jButton_Search.setFocusPainted(false);
        jButton_Search.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_Search.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ISBN:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Barcode:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Title:");

        jTextField3.setMargin(new java.awt.Insets(1, 4, 1, 4));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField2.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Cost:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Pages:");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField1.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormattedTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField4.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Copy Number:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Category:");

        jComboBox_CategoryName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "True", "False" }));

        jComboBox_isBorrowable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Borrowable:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Acquired Date:");

        jPanel_AcquiredDate.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_AcquiredDate.setLayout(new java.awt.BorderLayout());

        jButton_updateBooksInformation.setText("Update");
        jButton_updateBooksInformation.setToolTipText("Update Information");
        jButton_updateBooksInformation.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton_updateBooksInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateBooksInformationActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.setToolTipText("Reset Information");
        jButton3.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField3.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jTextField4.setMargin(new java.awt.Insets(1, 4, 1, 4));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Purchased Cost:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Language:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Description:");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 109, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_isBorrowable, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel_AcquiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jComboBox_CategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_updateBooksInformation)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox_CategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_isBorrowable, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_AcquiredDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_updateBooksInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("    Information    ", jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPaneAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneAuthorsMouseClicked(evt);
            }
        });

        jTableAuthors.setAutoCreateRowSorter(true);
        jTableAuthors.setBackground(new java.awt.Color(153, 0, 0));
        jTableAuthors.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableAuthors.setForeground(new java.awt.Color(255, 255, 255));
        jTableAuthors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idauthors", "Name", "Contact Information"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAuthors.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableAuthors.setRowHeight(24);
        jTableAuthors.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTableAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAuthorsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableAuthorsMouseReleased(evt);
            }
        });
        jTableAuthors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableAuthorsKeyReleased(evt);
            }
        });
        jScrollPaneAuthors.setViewportView(jTableAuthors);
        jTableAuthors.getColumnModel().getColumn(0).setMinWidth(0);
        jTableAuthors.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableAuthors.getColumnModel().getColumn(1).setMinWidth(0);
        jTableAuthors.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTableAuthors.getColumnModel().getColumn(1).setMaxWidth(250);
        jTableAuthors.getColumnModel().getColumn(2).setPreferredWidth(350);

        jPanel1.add(jScrollPaneAuthors, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("    Authors    ", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTablePublishers.setAutoCreateRowSorter(true);
        jTablePublishers.setBackground(new java.awt.Color(153, 0, 0));
        jTablePublishers.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTablePublishers.setForeground(new java.awt.Color(255, 255, 255));
        jTablePublishers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idpublishers", "Name", "Contact Information"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePublishers.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTablePublishers.setRowHeight(24);
        jTablePublishers.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPanePublishers.setViewportView(jTablePublishers);
        jTablePublishers.getColumnModel().getColumn(0).setMinWidth(0);
        jTablePublishers.getColumnModel().getColumn(0).setMaxWidth(0);
        jTablePublishers.getColumnModel().getColumn(1).setMinWidth(0);
        jTablePublishers.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTablePublishers.getColumnModel().getColumn(1).setMaxWidth(250);
        jTablePublishers.getColumnModel().getColumn(2).setPreferredWidth(350);

        jPanel4.add(jScrollPanePublishers, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("    Publishers    ", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTableSubjects.setAutoCreateRowSorter(true);
        jTableSubjects.setBackground(new java.awt.Color(153, 0, 0));
        jTableSubjects.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableSubjects.setForeground(new java.awt.Color(255, 255, 255));
        jTableSubjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idsubjects", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSubjects.setRowHeight(24);
        jTableSubjects.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPaneSubjects.setViewportView(jTableSubjects);
        jTableSubjects.getColumnModel().getColumn(0).setMinWidth(0);
        jTableSubjects.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableSubjects.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableSubjects.getColumnModel().getColumn(0).setHeaderValue("idsubjects");

        jPanel5.add(jScrollPaneSubjects, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("    Related Subjects    ", jPanel5);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_SavePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_BrowsePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_SaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_DeletePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_browsedimage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_browsedimage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_SavePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_BrowsePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_DeletePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_SaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_browsedimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_browsedimageActionPerformed

        if ("Administrator".equals(UserLogs.getMembertype())) {
            ins_MyFileChooserBrowsePicture.configureFileChooser();
            int option = ins_MyFileChooserBrowsePicture.fileChooser.showOpenDialog(this);
            analyzeOptionBrowse(ins_MyFileChooserBrowsePicture.fileChooser, option);
        }


    }//GEN-LAST:event_jButton_browsedimageActionPerformed

    private void jButton_BrowsePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BrowsePictureActionPerformed
        if ("Administrator".equals(UserLogs.getMembertype())) {
            ins_MyFileChooserBrowsePicture.configureFileChooser();
            int option = ins_MyFileChooserBrowsePicture.fileChooser.showOpenDialog(this);
            analyzeOptionBrowse(ins_MyFileChooserBrowsePicture.fileChooser, option);
        }
    }//GEN-LAST:event_jButton_BrowsePictureActionPerformed

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        //          if (!jDialog_SearchBooks.isVisible()) {
        //               jDialog_SearchBooks.setVisible(true);
        //          } else {
        //               jDialog_SearchBooks.setVisible(true);
        //          }
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void jButton_SavePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SavePictureActionPerformed
        Connection conn = Database._function_getConnection(Database._booksreservation);
        try {
            if (conn != null) {
                /* insert to booksimage */
                if (new File(file_browsed).length() < 1024000) {
                    boolean isExist_idbooksB = ref_booksimage.function_is_idbooks_exist(this.getIdbooks_information(), conn);
                    if (isExist_idbooksB) { // update the image
                        ref_booksimage.update_booksimage(this.getIdbooks_information(), fileName_Browsed, file_browsed, conn);
                    } else { // insert image
                        ref_booksimage.insert_booksimage(this.getIdbooks_information(), fileName_Browsed, file_browsed, conn);
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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton_updateBooksInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateBooksInformationActionPerformed
//        updateBooksInformation();
    }//GEN-LAST:event_jButton_updateBooksInformationActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /**/
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            validate_BooksImage();
            validate_BooksInformation();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        jDialog_Category.setLocationRelativeTo(this);
//        getSelectedRowCount_jTableCategory();
//        jDialog_Category.setAlwaysOnTop(true);
//        jDialog_Category.setModal(true);
//        jDialog_Category.setVisible(true);


        show_jDialog_Category();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_DeletePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletePictureActionPerformed
        /* delete image */
        int choice = JOptionPane.showConfirmDialog(this, "Delete image?", "Delete Confirmation", JOptionPane.WARNING_MESSAGE);
        System.out.println(choice);
        switch (choice) {
            case JOptionPane.OK_OPTION:
                Connection conn = Database._function_getConnection(Database._booksreservation);
                try {
                    if (conn != null) {
                        int books_idbooks = this.getIdbooks_information();
                        ref_booksimage.delete_booksimage(books_idbooks, conn);
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

    private void jTableAuthorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAuthorsMouseClicked
//        int buttonChoice = evt.getButton();
//        switch (buttonChoice) {
//            case 1: // IF MOUSE IS LEFT CLICKED
//            break;
//            case 2:
//            break;
//            case 3: // IF MOUSE IS RIGHT CLICKED
//            if (!evt.isPopupTrigger()) {
//                getSelectedRowCount_jTableBooks();
//                switch (UserLogs.getMembertype()) {
//                    case "Student":
//                    break;
//                    case "Administrator":
//                    break;
//                    default:
//                    break;
//                }
//                //                         jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
//            }
//
//            break;
//            default: // IF MOUSE IS !RIGHTCLICK
//            break;
//        }
    }//GEN-LAST:event_jTableAuthorsMouseClicked

    private void jTableAuthorsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAuthorsMouseReleased
//        int buttonChoice = evt.getButton();
//        switch (buttonChoice) {
//            case 1: // IF MOUSE IS LEFT CLICKED
//            getSelectedRowCount_jTableBooks();
//            break;
//            case 2:
//            break;
//            case 3: // IF MOUSE IS RIGHT CLICKED
//
//            break;
//            default: // IF MOUSE IS !RIGHTCLICK
//            break;
//        }
    }//GEN-LAST:event_jTableAuthorsMouseReleased

    private void jTableAuthorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAuthorsKeyReleased
//        int keyCode = evt.getKeyCode();
//        switch (keyCode) {
//            case 10: // IF HIT 'ENTER' KEY
//            getSelectedRowCount_jTableBooks();
//            break;
//            case 32: // IF HIT 'SPACE' KEY
//            break;
//            default:
//            getSelectedRowCount_jTableBooks();
//            break;
//        }
    }//GEN-LAST:event_jTableAuthorsKeyReleased

    private void jScrollPaneAuthorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneAuthorsMouseClicked
//        int buttonChoice = evt.getButton();
//        switch (buttonChoice) {
//            case 1: // IF MOUSE IS LEFT CLICKED
//            break;
//            case 2:
//            break;
//            case 3: // IF MOUSE IS RIGHT CLICKED
//            if (!evt.isPopupTrigger()) {
//                getSelectedRowCount_jTableBooks();
//                switch (UserLogs.getMembertype()) {
//                    case "Student":
//                    break;
//                    case "Administrator":
//                    break;
//                    default:
//                    break;
//                }
//                //                         jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
//            }
//            break;
//            default: // IF MOUSE IS !RIGHTCLICK
//            break;
//        }
    }//GEN-LAST:event_jScrollPaneAuthorsMouseClicked

    private void jMenuItem_jTableSubjects_RemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableSubjects_RemoveSelectedActionPerformed
        removeSelectedSubject();
    }//GEN-LAST:event_jMenuItem_jTableSubjects_RemoveSelectedActionPerformed

    private void jMenuItem_jTablePublishers_RemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTablePublishers_RemoveSelectedActionPerformed
        removeSelectedPublishers();
    }//GEN-LAST:event_jMenuItem_jTablePublishers_RemoveSelectedActionPerformed

    private void jMenuItem_jTableAuthors_RemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableAuthors_RemoveSelectedActionPerformed
        removeSelectedAuthors();
    }//GEN-LAST:event_jMenuItem_jTableAuthors_RemoveSelectedActionPerformed

    private void jButton_SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveAsActionPerformed

        if (iconThumbnail_browsed != null) {
            ins_MyFileChooserSavePicture.configureFileChooser();
            int option = ins_MyFileChooserSavePicture.fileChooser.showSaveDialog(this);
            analyzeOptionSave(ins_MyFileChooserSavePicture.fileChooser, option);

        }

    }//GEN-LAST:event_jButton_SaveAsActionPerformed

    private void jMenuItem_jTableCategory_RemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableCategory_RemoveSelectedActionPerformed
        removeSelectedCateogry();
    }//GEN-LAST:event_jMenuItem_jTableCategory_RemoveSelectedActionPerformed

    private void jMenuItem_jTableAuthors_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableAuthors_AddNewActionPerformed


        show_JD_Authors();


    }//GEN-LAST:event_jMenuItem_jTableAuthors_AddNewActionPerformed

    private void jMenuItem_jTablePublishers_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTablePublishers_AddNewActionPerformed

        show_JD_Publishers();

    }//GEN-LAST:event_jMenuItem_jTablePublishers_AddNewActionPerformed

    private void jMenuItem_jTableSubjects_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableSubjects_AddNewActionPerformed

        show_JD_Subjects();
    }//GEN-LAST:event_jMenuItem_jTableSubjects_AddNewActionPerformed

    private void jMenuItem_jTableCategory_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableCategory_AddNewActionPerformed
        jDialog_AddCategory.setSize(jDialog_AddCategory.getPreferredSize());
        jDialog_AddCategory.setLocationRelativeTo(jDialog_Category);
        jDialog_AddCategory.setAlwaysOnTop(true);
        jDialog_AddCategory.setModal(true);
        jDialog_AddCategory.setVisible(true);
    }//GEN-LAST:event_jMenuItem_jTableCategory_AddNewActionPerformed

    private void jMenuItem_jTableCategory_UpdateSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_jTableCategory_UpdateSelectedActionPerformed
        try {
            jDialog_UpdateCategory.setSize(jDialog_UpdateCategory.getPreferredSize());
            jDialog_UpdateCategory.setLocationRelativeTo(jDialog_Category);
            jDialog_UpdateCategory.setAlwaysOnTop(true);
            jDialog_UpdateCategory.setModal(true);
            /**/
            int selectedColumn = function_getColumnNumber_jTable("Name", jTableCategory);
            int selectedRow = jTableCategory.getSelectedRow();
            edit_updateCategory = jTableCategory.getValueAt(selectedRow, selectedColumn).toString();
            jTextField8.setText(edit_updateCategory + "");

            jDialog_UpdateCategory.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem_jTableCategory_UpdateSelectedActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        addNewCategory();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        jDialog_AddCategory.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        int keyCode = evt.getKeyCode();
        switch (keyCode) {
            case 10: // IF HIT 'ENTER' KEY
                addNewCategory();
                break;
            case 32: // IF HIT 'SPACE' KEY
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton_updateCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateCategoryNameActionPerformed
//        updateSelectedCategory();
    }//GEN-LAST:event_jButton_updateCategoryNameActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jDialog_UpdateCategory.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        int keyCode = evt.getKeyCode();
        switch (keyCode) {
            case 10: // IF HIT 'ENTER' KEY

                updateSelectedCategory();
                break;
            case 32: // IF HIT 'SPACE' KEY
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jDialog_CategoryWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog_CategoryWindowClosed
    }//GEN-LAST:event_jDialog_CategoryWindowClosed

    private void jTextField4_AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4_AddBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4_AddBooksActionPerformed

    private void jTextField5_AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5_AddBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5_AddBooksActionPerformed

    private void jButton4_AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_AddBooksActionPerformed
        //        try {
        //            jDialog_Category.setLocationRelativeTo(jDialog1_AddBooks);
        //            getSelectedRowCount_jTableCategory();
        //            jDialog_Category.setVisible(true);
        //        } catch (Exception e) {
        //            System.err.println(e);
        //        }

        show_jDialog_Category();

    }//GEN-LAST:event_jButton4_AddBooksActionPerformed

    private void jButton2_AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_AddBooksActionPerformed

        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            try {
                boolean isvalid = isvalid_addBooks_form_addBooks();
                if (isvalid) {
                    boolean isExist_barcode_isbn = ref_books.function_is_barcode_isbn_exist(jTextField3_AddBooks.getText().trim().toString(), jTextField2_AddBooks.getText().trim().toString(), conn);
                    if (isExist_barcode_isbn) {
                        JOptionPane.showMessageDialog(jDialog1_AddBooks, "BARCODE & ISBN is already exist\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                    } else {
                        boolean isExist_barcode = ref_books.function_is_barcode_exist(jTextField3_AddBooks.getText().trim().toString(), conn);
                        if (isExist_barcode) {
                            JOptionPane.showMessageDialog(jDialog1_AddBooks, "BARCODE is already exist\nPlease change the barcode", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                        } else {
                            java.util.Date i_acquiredDate = JDC_acquiredDate_addBooks.getDate();
                            if (i_acquiredDate == null) {
                                JOptionPane.showMessageDialog(jDialog1_AddBooks, "Invalid Acquired Date\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                            } else {
                                String str_acquiredDate = (new SimpleDateFormat("yyyy-MM-dd").format(i_acquiredDate));
                                String barcode_ = jTextField3_AddBooks.getText().trim().toString();
                                String isbn_ = jTextField2_AddBooks.getText().trim().toString();
                                String title_ = jTextField4_AddBooks.getText().trim().toString();
                                String description_ = jTextArea1_AddBooks.getText().trim().toString();
                                String language_ = jTextField5_AddBooks.getText().trim().toString();
                                double cost_ = Double.parseDouble(jFormattedTextField2_AddBooks.getValue().toString() + "");
                                double purchasedcost_ = Double.parseDouble(jFormattedTextField3_AddBooks.getValue().toString() + "");
                                int pages_ = jFormattedTextField1_AddBooks.getValue().hashCode();
                                int copynumber_ = jFormattedTextField4_AddBooks.getValue().hashCode();
                                if (jComboBox_CategoryName_AddBooks.getItemCount() == 0) {
                                    JOptionPane.showMessageDialog(jDialog1_AddBooks, "Please setup a new Books Category...", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                                } else {
                                    String categoryname_ = jComboBox_CategoryName_AddBooks.getSelectedItem().toString();
                                    int isborrowable_ = jComboBox_isBorrowable_AddBooks.getSelectedIndex();
                                    ref_books.insert_books(new books(barcode_, isbn_, title_, pages_, description_, language_, cost_, purchasedcost_, copynumber_, str_acquiredDate, isborrowable_, categoryname_), conn);
                                    //                                   JOptionPane.showMessageDialog(this, "Books Successfully Add", "Message", JOptionPane.PLAIN_MESSAGE, null);
                                    Object[] options = {"Yes", "Not now"};
                                    int choice = JOptionPane.showOptionDialog(
                                            jDialog1_AddBooks,
                                            "Books Successfully Add\n"
                                            + "Would you like to add more information to this book?",
                                            "Message",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            options,
                                            options[0]);
                                    if (choice == JOptionPane.YES_OPTION) {
                                        int get_idbooks = ref_books.function_get_idbooks(barcode_, isbn_, conn);
                                        jDialog1_AddBooks.dispose();
                                        viewBookInformation_addBooks(get_idbooks);
                                    } else if (choice == JOptionPane.NO_OPTION) {
                                    } else {
                                    }
                                }

                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.err.println(e);
                e.printStackTrace();
            }
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }//GEN-LAST:event_jButton2_AddBooksActionPerformed

    private void jButton7_AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7_AddBooksActionPerformed
//        validateAddBooksForms_addBooks();
        jTextField3_AddBooks.setText("");
        jTextField2_AddBooks.setText("");
        jTextField4_AddBooks.setText("");
        jFormattedTextField2_AddBooks.setValue(0);
        jFormattedTextField3_AddBooks.setValue(0);
        jFormattedTextField1_AddBooks.setValue(0);
        jTextField5_AddBooks.setText("");
        jFormattedTextField4_AddBooks.setValue(0);
        setCategoryName_addBooks();
        setDatechooserPanel_AcquiredDate_addBooks();
        jTextArea1_AddBooks.setText("");
    }//GEN-LAST:event_jButton7_AddBooksActionPerformed

    private void jButton3_AddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_AddBooksActionPerformed
        jDialog1_AddBooks.dispose();
    }//GEN-LAST:event_jButton3_AddBooksActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_BooksInformation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_BooksInformation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_BooksInformation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_BooksInformation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_BooksInformation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_AddBooks;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3_AddBooks;
    public javax.swing.JButton jButton4;
    private javax.swing.JButton jButton4_AddBooks;
    public javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7_AddBooks;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_BrowsePicture;
    private javax.swing.JButton jButton_DeletePicture;
    private javax.swing.JButton jButton_SaveAs;
    private javax.swing.JButton jButton_SavePicture;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_browsedimage;
    public javax.swing.JButton jButton_updateBooksInformation;
    public javax.swing.JButton jButton_updateCategoryName;
    private javax.swing.JComboBox jComboBox_CategoryName;
    private javax.swing.JComboBox jComboBox_CategoryName_AddBooks;
    private javax.swing.JComboBox jComboBox_isBorrowable;
    private javax.swing.JComboBox jComboBox_isBorrowable_AddBooks;
    public javax.swing.JDialog jDialog1_AddBooks;
    private javax.swing.JDialog jDialog_AddCategory;
    public javax.swing.JDialog jDialog_Category;
    private javax.swing.JDialog jDialog_UpdateCategory;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField1_AddBooks;
    private static javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField2_AddBooks;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField3_AddBooks;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField4_AddBooks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem_jTableAuthors_AddNew;
    private javax.swing.JMenuItem jMenuItem_jTableAuthors_RemoveSelected;
    public javax.swing.JMenuItem jMenuItem_jTableCategory_AddNew;
    public javax.swing.JMenuItem jMenuItem_jTableCategory_RemoveSelected;
    public javax.swing.JMenuItem jMenuItem_jTableCategory_UpdateSelected;
    private javax.swing.JMenuItem jMenuItem_jTablePublishers_AddNew;
    private javax.swing.JMenuItem jMenuItem_jTablePublishers_RemoveSelected;
    private javax.swing.JMenuItem jMenuItem_jTableSubjects_AddNew;
    private javax.swing.JMenuItem jMenuItem_jTableSubjects_RemoveSelected;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel_AcquiredDate;
    private javax.swing.JPanel jPanel_AcquiredDate_AddBooks;
    private javax.swing.JPopupMenu jPopupMenu_jTableAuthors;
    private javax.swing.JPopupMenu jPopupMenu_jTableCategory;
    private javax.swing.JPopupMenu jPopupMenu_jTablePublishers;
    private javax.swing.JPopupMenu jPopupMenu_jTableSubjects;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2_AddBooks;
    private javax.swing.JScrollPane jScrollPaneAuthors;
    private javax.swing.JScrollPane jScrollPaneCategory;
    private javax.swing.JScrollPane jScrollPanePublishers;
    private javax.swing.JScrollPane jScrollPaneSubjects;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAuthors;
    private javax.swing.JTable jTableCategory;
    private javax.swing.JTable jTablePublishers;
    private javax.swing.JTable jTableSubjects;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea1_AddBooks;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField2_AddBooks;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField3_AddBooks;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField4_AddBooks;
    private javax.swing.JTextField jTextField5_AddBooks;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration//GEN-END:variables

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
                int books_idbooks = this.getIdbooks_information();
                boolean isExist_idbooks = ref_booksimage.function_is_idbooks_exist(books_idbooks, conn);
                /* check if it has an image */
                if (isExist_idbooks) {
                    icon_browsed = new booksimage().function_select_Image(books_idbooks, conn);
                    /* chech if the icon is null */
                    if (icon_browsed != null) {
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

    /* validate books information */
    public void validate_BooksInformation() {
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            int get_idbooks = this.getIdbooks_information();
            if (get_idbooks != 0) {
                jTextField1.setText(ref_books.function_get_barcode(get_idbooks, conn));
                jTextField2.setText(ref_books.function_get_isbn(get_idbooks, conn));
                jTextField3.setText(ref_books.function_get_title(get_idbooks, conn));
                jFormattedTextField2.setValue(ref_books.function_get_cost(get_idbooks, conn));
                jFormattedTextField3.setValue(ref_books.function_get_purchasedcost(get_idbooks, conn));
                jFormattedTextField1.setValue(ref_books.function_get_pages(get_idbooks, conn));
                jFormattedTextField4.setValue(ref_books.function_get_copynumber(get_idbooks, conn));
                jComboBox_isBorrowable.setSelectedIndex(ref_books.function_get_isborrowable(get_idbooks, conn));
                jTextField4.setText(ref_books.function_get_language(get_idbooks, conn));
                jTextArea1.setText(ref_books.function_get_description(get_idbooks, conn));
                setDatechooserPanel_AcquiredDate(get_idbooks, conn);
                setCtegoryName(get_idbooks, conn);

                jButton_updateBooksInformation.setVisible(true);
                jButton3.setVisible(true);
            } else {
                jButton_updateBooksInformation.setVisible(false);
                jButton3.setVisible(false);
            }
            check_userlogs();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    public void validate_BooksInformation_Additional() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                fill_jTableAuthors(this.getIdbooks_information(), conn);
                fill_jTablePublishers(this.getIdbooks_information(), conn);
                fill_jTableSubjects(this.getIdbooks_information(), conn);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
            getSelectedRowCount_jTableSubjects();
        } catch (Exception e) {
            System.err.println("validate_BooksInformation_Additional");
        }
    }

    private void setCtegoryName(int _idbooks, Connection conn) {
        String categoryName = ref_books.function_get_category_name(_idbooks, conn);
        jComboBox_CategoryName.removeAllItems();
        ref_category.select_name(conn);
        if (category.getData().size() > 0) {
            for (int i = 0; i < category.getData().size(); i++) {
                jComboBox_CategoryName.addItem(category.getData().get(i).toString().replace("[", "").replace("]", ""));
            }
            jComboBox_CategoryName.setSelectedItem(categoryName);
        }
    }
// ----------------------------------------------------------------------------- [DATE CHOOSER PANEL]    
    private JDateChooser JDC_acquiredDate = new JDateChooser(null, null, null, new JSpinnerDateEditor());

    private void setDatechooserPanel_AcquiredDate(int _idbooks, Connection conn) {
        try {
            java.util.Date get_acquiredDate = ref_books.function_get_acquireddate(_idbooks, conn);
            JDC_acquiredDate.setDate(get_acquiredDate);
            setDateChooser("MMMM dd, yyyy", JDC_acquiredDate, jPanel_AcquiredDate);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDateChooser(String SDF, JDateChooser JDC_dateChooser, JPanel JP_dateChooser) {
        JDC_dateChooser.setDateFormatString(SDF);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setTodayButtonVisible(true);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setNullDateButtonVisible(false);

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

    private int function_getColumnNumber_jTable(String jTableColumn_Name, JTable jTable_Name) {
        int get_columnNumber = 0;
        try {
            // iterate and find the column "column_Name"
            for (int c = 0; c < jTable_Name.getColumnCount(); c++) {
                String columnName = jTable_Name.getColumnName(c);
                // check if it is equal to the column "column_Name"
                if (jTableColumn_Name.equals(columnName)) { // GET THE COLUMN NUMBER
                    // set and return the column number
                    get_columnNumber = c;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return get_columnNumber;
    }

    /**/
    private boolean isvalid_addBooks_form() {
        int barcode_ = jTextField1.getText().trim().toString().length();
        int isbn_ = jTextField2.getText().trim().toString().length();
        System.out.println(barcode_);
        if (barcode_ <= 0 || barcode_ > 45) {
            JOptionPane.showMessageDialog(this, "Invalid BARCODE length\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }

        if (isbn_ <= 0 || isbn_ > 45) {
            JOptionPane.showMessageDialog(this, "Invalid ISBN length\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        return true;
    }

    /**/
    public boolean updateBooksInformation() {
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            try {
                boolean isvalid = isvalid_addBooks_form();
                if (isvalid) {
                    int books_idbooks = this.getIdbooks_information();
                    /**/
                    boolean isExist_barcode_isbn_notlike_idbooks = ref_books.function_is_barcode_isbn_exist_notLike(jTextField1.getText().trim().toString(), jTextField2.getText().trim().toString(), books_idbooks, conn);
                    if (isExist_barcode_isbn_notlike_idbooks) {
                        JOptionPane.showMessageDialog(this, "BARCODE & ISBN is already exist\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                    } else {
                        int books_idbooks_ = this.getIdbooks_information();
                        boolean isExist_barcode_notlike_idbooks = ref_books.function_is_barcode_exist_notLike(jTextField1.getText().trim().toString(), "" + books_idbooks_, conn);
                        if (isExist_barcode_notlike_idbooks) {
                            JOptionPane.showMessageDialog(this, "BARCODE is already exist\nPlease change the barcode", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                        } else {
                            java.util.Date i_acquiredDate = JDC_acquiredDate.getDate();
                            if (i_acquiredDate == null) {
                                JOptionPane.showMessageDialog(this, "Invalid Acquired Date\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
                            } else {
                                String str_acquiredDate = (new SimpleDateFormat("yyyy-MM-dd").format(i_acquiredDate));
                                String barcode_ = jTextField1.getText().trim().toString();
                                String isbn_ = jTextField2.getText().trim().toString();
                                String title_ = jTextField3.getText().trim().toString();
                                String description_ = jTextArea1.getText().trim().toString();
                                String language_ = jTextField4.getText().trim().toString();
                                double cost_ = Double.parseDouble(jFormattedTextField2.getValue().toString() + "");
                                double purchasedcost_ = Double.parseDouble(jFormattedTextField3.getValue().toString() + "");
                                int pages_ = jFormattedTextField1.getValue().hashCode();
                                int copynumber_ = jFormattedTextField4.getValue().hashCode();
                                String categoryname_ = jComboBox_CategoryName.getSelectedItem().toString();
                                int isborrowable_ = jComboBox_isBorrowable.getSelectedIndex();
                                ref_books.update_books(books_idbooks, new books(barcode_, isbn_, title_, pages_, description_, language_, cost_, purchasedcost_, copynumber_, str_acquiredDate, isborrowable_, categoryname_), conn);
//                                JOptionPane.showMessageDialog(this, "Books Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE, null);
                                return true;
                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
        return false;
    }

    /**/
    public void check_userlogs() {
        switch (UserLogs.getMembertype()) {
            case "Instructor":
                jButton_updateBooksInformation.setVisible(false);
                jButton_Search.setVisible(false);
                jButton_SaveAs.setVisible(false);
                jButton_DeletePicture.setVisible(false);
                jButton_BrowsePicture.setVisible(false);
                jButton_SavePicture.setVisible(false);
                jButton4.setVisible(false);
                break;
            case "Student":
                jButton_updateBooksInformation.setVisible(false);
                jButton_Search.setVisible(false);
                jButton_SaveAs.setVisible(false);
                jButton_DeletePicture.setVisible(false);
                jButton_BrowsePicture.setVisible(false);
                jButton_SavePicture.setVisible(false);
                jButton4.setVisible(false);
                break;
            case "Administrator":
                jButton_updateBooksInformation.setVisible(true);
                jButton_Search.setVisible(false);
                jButton_SaveAs.setVisible(true);
                jButton_DeletePicture.setVisible(true);
                jButton_BrowsePicture.setVisible(true);
                jButton_SavePicture.setVisible(true);
                jButton4.setVisible(true);
                addEvents_jTable_AdditionalInformation();
                break;
            case "Officer":
                jButton_updateBooksInformation.setVisible(true);
                jButton_Search.setVisible(false);
                jButton_SaveAs.setVisible(true);
                jButton_DeletePicture.setVisible(true);
                jButton_BrowsePicture.setVisible(true);
                jButton_SavePicture.setVisible(true);
                jButton4.setVisible(true);
                addEvents_jTable_AdditionalInformation();
                break;
            default:
                jButton_updateBooksInformation.setVisible(false);
                jButton_Search.setVisible(false);
                jButton_SaveAs.setVisible(false);
                jButton_DeletePicture.setVisible(false);
                jButton_BrowsePicture.setVisible(false);
                jButton_SavePicture.setVisible(false);
                jButton4.setVisible(false);
                break;
        }
    }

// ----------------------------------------------------------------------------- ADD EVENTS ADDITIONAL INFORMATION
    private void addEvents_jTable_AdditionalInformation() {
        addEvents_jTableAuthors();
        addEvents_jTablePublishers();
        addEvents_jTableSubjects();
        addEvents_jTableCategory();
    }

    private void addEvents_jTableAuthors() {
        jTableAuthors.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableAuthorsKeyReleased(evt);
            }

            private void jTableAuthorsKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_jTableAuthors();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_jTableAuthors();
                        break;
                }
            }
        });
        jTableAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAuthorsMouseClicked(evt);
            }

            private void jTableAuthorsMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTableAuthors();
                            jPopupMenu_jTableAuthors.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableAuthorsMouseReleased(evt);
            }

            private void jTableAuthorsMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_jTableAuthors();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        jScrollPaneAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneAuthorsMouseClicked(evt);
            }

            private void jScrollPaneAuthorsMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTableAuthors();
                            jPopupMenu_jTableAuthors.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
    }

    private void addEvents_jTablePublishers() {

        jTablePublishers.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePublishersKeyReleased(evt);
            }

            private void jTablePublishersKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_jTablePublishers();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_jTablePublishers();
                        break;
                }
            }
        });
        jTablePublishers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePublishersMouseClicked(evt);
            }

            private void jTablePublishersMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTablePublishers();
                            jPopupMenu_jTablePublishers.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTablePublishersMouseReleased(evt);
            }

            private void jTablePublishersMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_jTablePublishers();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        jScrollPanePublishers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPanePublishersMouseClicked(evt);
            }

            private void jScrollPanePublishersMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTablePublishers();
                            jPopupMenu_jTablePublishers.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

    }

    private void addEvents_jTableSubjects() {


        jTableSubjects.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSubjectsKeyReleased(evt);
            }

            private void jTableSubjectsKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_jTableSubjects();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_jTableSubjects();
                        break;
                }
            }
        });
        jTableSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSubjectsMouseClicked(evt);
            }

            private void jTableSubjectsMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTableSubjects();
                            jPopupMenu_jTableSubjects.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSubjectsMouseReleased(evt);
            }

            private void jTableSubjectsMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_jTableSubjects();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        jScrollPaneSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneSubjectsMouseClicked(evt);
            }

            private void jScrollPaneSubjectsMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTableSubjects();
                            jPopupMenu_jTableSubjects.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });


    }

    private void addEvents_jTableCategory() {


        jTableCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCategoryKeyReleased(evt);
            }

            private void jTableCategoryKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_jTableCategory();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_jTableCategory();
                        break;
                }
            }
        });
        jTableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoryMouseClicked(evt);
            }

            private void jTableCategoryMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTableCategory();
                            jPopupMenu_jTableCategory.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCategoryMouseReleased(evt);
            }

            private void jTableCategoryMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_jTableCategory();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        jScrollPaneCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneCategoryMouseClicked(evt);
            }

            private void jScrollPaneCategoryMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_jTableCategory();
                            jPopupMenu_jTableCategory.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });


    }

// ----------------------------------------------------------------------------- FILL jTable BOOKS ADDITIONAL INFORMATION
    private void fill_jTableAuthors(int idbooks, Connection conn) {
        try {
            jTableAuthors_TableModel.setRowCount(0);
            ref_authors.select_all_by_idbooks(idbooks, conn);
            for (int i = 0; i < authors.getData().size(); i++) {
                jTableAuthors_TableModel.addRow((Vector) authors.getData().get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void fill_jTablePublishers(int idbooks, Connection conn) {
        try {
            jTablePublishers_TableModel.setRowCount(0);
            ref_publishers.select_all_by_idbooks(idbooks, conn);
            for (int i = 0; i < publishers.getData().size(); i++) {
                jTablePublishers_TableModel.addRow((Vector) publishers.getData().get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void fill_jTableSubjects(int idbooks, Connection conn) {
        try {
            jTableSubjects_TableModel.setRowCount(0);
            ref_subjects.select_all_by_idbooks(idbooks, conn);
            for (int i = 0; i < subjects.getData().size(); i++) {
                jTableSubjects_TableModel.addRow((Vector) subjects.getData().get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fill_jTableCategory(Connection conn) {
        try {
            jTableCategory_TableModel.setRowCount(0);
            ref_category.select_name(conn);
            for (int i = 0; i < category.getData().size(); i++) {
                jTableCategory_TableModel.addRow((Vector) category.getData().get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void refresh_jTableAuthors() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                fill_jTableAuthors(idbooks_, conn);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void refresh_jTablePublishers() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                fill_jTablePublishers(idbooks_, conn);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void refresh_jTableSubjects() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                fill_jTableSubjects(idbooks_, conn);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- GET SELECTED ROWCOUNT ADDITIONAL INFORMATION 
    public void getSelectedRowCount_jTableAuthors() {
        try {
            int getSelectedRowCount = jTableAuthors.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jMenuItem_jTableAuthors_RemoveSelected.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jMenuItem_jTableAuthors_RemoveSelected.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jMenuItem_jTableAuthors_RemoveSelected.setEnabled(true);
            } else {
                jMenuItem_jTableAuthors_RemoveSelected.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void getSelectedRowCount_jTablePublishers() {
        try {
            int getSelectedRowCount = jTablePublishers.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jMenuItem_jTablePublishers_RemoveSelected.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jMenuItem_jTablePublishers_RemoveSelected.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jMenuItem_jTablePublishers_RemoveSelected.setEnabled(true);
            } else {
                jMenuItem_jTablePublishers_RemoveSelected.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void getSelectedRowCount_jTableSubjects() {
        try {
            int getSelectedRowCount = jTableSubjects.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jMenuItem_jTableSubjects_RemoveSelected.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jMenuItem_jTableSubjects_RemoveSelected.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jMenuItem_jTableSubjects_RemoveSelected.setEnabled(true);
            } else {
                jMenuItem_jTableSubjects_RemoveSelected.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void getSelectedRowCount_jTableCategory() {
        try {
            int getSelectedRowCount = jTableCategory.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jMenuItem_jTableCategory_RemoveSelected.setEnabled(false);
                jMenuItem_jTableCategory_UpdateSelected.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jMenuItem_jTableCategory_RemoveSelected.setEnabled(true);
                jMenuItem_jTableCategory_UpdateSelected.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jMenuItem_jTableCategory_RemoveSelected.setEnabled(true);
                jMenuItem_jTableCategory_UpdateSelected.setEnabled(false);
            } else {
                jMenuItem_jTableCategory_RemoveSelected.setEnabled(false);
                jMenuItem_jTableCategory_UpdateSelected.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

// ----------------------------------------------------------------------------- REMOVE ADDITIONAL INFORMATION      
    //
    private void removeSelectedAuthors() {
        JOptionPane pane = new JOptionPane(
                "<html>"
                + /*
                 "<head>"+
                 "<style type=\"text/css\">"+
                 "b { font: 13pt \"Lucida Grande\" }"+
                 "p { font: 11pt \"Lucida Grande\"; margin-top: 8px }"+
                 "</style>"+
                 "</head>"+*/ "Remove selected author(s)?",
                JOptionPane.QUESTION_MESSAGE);
        Object[] options = {"Cancel", "Remove"};
        pane.setOptions(options);
        pane.setInitialValue(null);
        JDialog dialog = pane.createDialog(this, "Warning!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        analyzeValueConfirmRemoveAuthors_Array(pane.getValue());
    }

    private void analyzeValueConfirmRemoveAuthors_Array(Object value) {
        try {
            if (value.equals("Remove")) {
                remove_Authors_Array();
            } else if (value.equals("Cancel")) {
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void remove_Authors_Array() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                int r_idauthors[];
                r_idauthors = jTableAuthors.getSelectedRows();
                for (int c = 0; c < jTableAuthors.getColumnCount(); c++) {
                    String columnName = jTableAuthors.getColumnName(c);
                    if ("idauthors".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idauthors.length; r++) {
                            r_idauthors[r] = jTableAuthors.getValueAt(r_idauthors[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idauthors.length > 0) {
                    ref_booksauthors.delete_booksauthors(r_idauthors, idbooks_, conn);
                    /**/
                    fill_jTableAuthors(idbooks_, conn);
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        getSelectedRowCount_jTableAuthors();
    }

    //
    private void removeSelectedPublishers() {
        JOptionPane pane = new JOptionPane(
                "<html>"
                + /*
                 "<head>"+
                 "<style type=\"text/css\">"+
                 "b { font: 13pt \"Lucida Grande\" }"+
                 "p { font: 11pt \"Lucida Grande\"; margin-top: 8px }"+
                 "</style>"+
                 "</head>"+*/ "Remove selected publisher(s)?",
                JOptionPane.QUESTION_MESSAGE);
        Object[] options = {"Cancel", "Remove"};
        pane.setOptions(options);
        pane.setInitialValue(null);
        JDialog dialog = pane.createDialog(this, "Warning!");
        dialog.setVisible(true);
        analyzeValueConfirmRemovePublishers_Array(pane.getValue());
    }

    private void analyzeValueConfirmRemovePublishers_Array(Object value) {
        try {
            if (value.equals("Remove")) {
                remove_Publishers_Array();
            } else if (value.equals("Cancel")) {
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void remove_Publishers_Array() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                int r_idpublishersI[];
                r_idpublishersI = jTablePublishers.getSelectedRows();
                for (int c = 0; c < jTablePublishers.getColumnCount(); c++) {
                    String columnName = jTablePublishers.getColumnName(c);
                    if ("idpublishers".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idpublishersI.length; r++) {
                            r_idpublishersI[r] = jTablePublishers.getValueAt(r_idpublishersI[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idpublishersI.length > 0) {
                    ref_bookspublishers.delete_bookspublishers(r_idpublishersI, idbooks_, conn);
                    /**/
                    fill_jTablePublishers(idbooks_, conn);
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        getSelectedRowCount_jTablePublishers();
    }

    //
    private void removeSelectedSubject() {
        JOptionPane pane = new JOptionPane(
                "<html>"
                + /*
                 "<head>"+
                 "<style type=\"text/css\">"+
                 "b { font: 13pt \"Lucida Grande\" }"+
                 "p { font: 11pt \"Lucida Grande\"; margin-top: 8px }"+
                 "</style>"+
                 "</head>"+*/ "Remove selected subject(s)?",
                JOptionPane.QUESTION_MESSAGE);
        Object[] options = {"Cancel", "Remove"};
        pane.setOptions(options);
        pane.setInitialValue(null);
        JDialog dialog = pane.createDialog(this, "Warning!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        analyzeValueConfirmRemoveSubjects_Array(pane.getValue());

    }

    private void analyzeValueConfirmRemoveSubjects_Array(Object value) {
        try {
            if (value.equals("Remove")) {
                remove_Subjects_Array();
            } else if (value.equals("Cancel")) {
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void remove_Subjects_Array() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                int r_idsubjects[];
                r_idsubjects = jTableSubjects.getSelectedRows();
                for (int c = 0; c < jTableSubjects.getColumnCount(); c++) {
                    String columnName = jTableSubjects.getColumnName(c);
                    if ("idsubjects".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idsubjects.length; r++) {
                            r_idsubjects[r] = jTableSubjects.getValueAt(r_idsubjects[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idsubjects.length > 0) {
                    ref_bookssubjects.delete_bookssubjects(r_idsubjects, idbooks_, conn);
                    /**/
                    fill_jTableSubjects(idbooks_, conn);
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        getSelectedRowCount_jTableSubjects();
    }

    //
    private void removeSelectedCateogry() {
        JOptionPane pane = new JOptionPane(
                "<html>"
                + /*
                 "<head>"+
                 "<style type=\"text/css\">"+
                 "b { font: 13pt \"Lucida Grande\" }"+
                 "p { font: 11pt \"Lucida Grande\"; margin-top: 8px }"+
                 "</style>"+
                 "</head>"+*/ "Remove selected category(s)?",
                JOptionPane.QUESTION_MESSAGE);
        Object[] options = {"Cancel", "Remove"};
        pane.setOptions(options);
        pane.setInitialValue(null);
        JDialog dialog = pane.createDialog(jDialog_Category, "Warning!");
        dialog.setVisible(true);
        analyzeValueConfirmRemoveCategory_Array(pane.getValue());
    }

    private void analyzeValueConfirmRemoveCategory_Array(Object value) {
        try {
            if (value.equals("Remove")) {
                remove_Category_Array();
            } else if (value.equals("Cancel")) {
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void remove_Category_Array() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int r_category[];
                r_category = jTableCategory.getSelectedRows();
                String[] r_category_name;
                r_category_name = new String[r_category.length];
                for (int c = 0; c < jTableCategory.getColumnCount(); c++) {
                    String columnName = jTableCategory.getColumnName(c);
                    if ("Name".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_category.length; r++) {
                            r_category_name[r] = jTableCategory.getValueAt(r_category[r], c).toString();
                        }
                        break;
                    }
                }
                if (r_category_name.length > 0) {
                    ref_category.delete_category(r_category_name, conn);
                    /**/
                    setCtegoryName(this.getIdbooks_information(), conn);
                    setCategoryName_addBooks();
                    fill_jTableCategory(conn);
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        getSelectedRowCount_jTableCategory();
    }

    /**/
    private String edit_updateCategory = "";

    public boolean addNewCategory() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String name_ = jTextField7.getText().trim().toString();
                /**/
                boolean isExist_name = ref_category.function_is_name_exist(name_, conn);
                if (isExist_name) {
                    JOptionPane.showMessageDialog(jDialog_AddCategory, "The name you entered is already exist\nTry another name", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ref_category.insert_category(new category(name_), conn);

                    setCtegoryName(this.getIdbooks_information(), conn);
                    setCategoryName_addBooks();
                    fill_jTableCategory(conn);
                    jTextField7.setText("");
                    return true;
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    /**/
    public boolean updateSelectedCategory() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String name_ = jTextField8.getText().trim().toString();
                /**/
                boolean isExist_name = ref_category.function_is_name_exist(name_, conn);
                if (isExist_name) {
                    JOptionPane.showMessageDialog(jDialog_UpdateCategory, "The name you entered is already exist\nTry another name", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ref_category.update_category(edit_updateCategory, new category(name_), conn);

                    fill_jTableCategory(conn);
                    setCtegoryName(this.getIdbooks_information(), conn);
                    setCategoryName_addBooks();
                    jDialog_UpdateCategory.dispose();
                    return true;
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
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
                                ref_booksimage.savePicture(this.getIdbooks_information(), directoryInfo, conn);
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

// ----------------------------------------------------------------------------- INITIALIZE JDIALOG ADDITIONAL INFORMATION
    private void initiComponents_jDialog_AdditionalInformation() {
        ref_JD_Authors.setSize(ref_JD_Authors.getPreferredSize());
        ref_JD_Authors.setLocationRelativeTo(this);

        ref_JD_Publishers.setSize(ref_JD_Publishers.getPreferredSize());
        ref_JD_Publishers.setLocationRelativeTo(this);

        ref_JD_Subjects.setSize(ref_JD_Subjects.getPreferredSize());
        ref_JD_Subjects.setLocationRelativeTo(this);

        addEvents_jDialog_AdditionalInformation();
    }

// ----------------------------------------------------------------------------- ADD EVENTS ADDITIONAL INFORMATION
    private void addEvents_jDialog_AdditionalInformation() {
        addEvents_JD_Authors();
        addEvents_JD_Publishers();
        addEvents_JD_Subjects();
    }

    private void addEvents_JD_Authors() {
        ref_JD_Authors.jMenuItem_addToBooksInformation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSelectedAuthorToBooksInformation();
            }
        });
        ref_JD_Authors.jButton_updateAuthor.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                updateSelected_JD_Authors();
            }
        });
    }

    private void addEvents_JD_Publishers() {
        ref_JD_Publishers.jMenuItem_addToBooksInformation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSelectedPublisherToBooksInformation();
            }
        });
        ref_JD_Publishers.jButton_updatePublisher.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                updateSelected_JD_Publishers();
            }
        });

    }

    public void addEvents_JD_Subjects() {
        ref_JD_Subjects.jMenuItem_addToBooksInformation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSelectedSubjectToBooksInformation();
            }
        });
        ref_JD_Subjects.jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        String subjectName_ = ref_JD_Subjects.jTextField4.getText().trim().toString();
                        if (subjectName_.length() == 0) {
                            JOptionPane.showMessageDialog(ref_JD_Subjects.jDialog1_Update, "The field Subjet Name must not be empty\nPlease try again", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            boolean isExist_subjectName = ref_subjects.function_is_name_exist_notLike(ref_JD_Subjects.getEdit_idsubjects(), subjectName_, conn);
                            if (isExist_subjectName) {
                                JOptionPane.showMessageDialog(ref_JD_Subjects, "The name you entered is already exist\nTry another name", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                /**/
                                ref_subjects.update_subjects(ref_JD_Subjects.getEdit_idsubjects(), new subjects(subjectName_), conn);
                                ref_JD_Subjects.fill_jTableSubjects(conn);
                                ref_JD_Authors.setIsNeedRefresh(true);
                                refresh_jTableSubjects();
                            }

                        }
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
    }

    private void addSelectedAuthorToBooksInformation() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                int r_idauthors[];
                r_idauthors = ref_JD_Authors.jTableAuthors.getSelectedRows();
                for (int c = 0; c < ref_JD_Authors.jTableAuthors.getColumnCount(); c++) {
                    String columnName = ref_JD_Authors.jTableAuthors.getColumnName(c);
                    if ("idauthors".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idauthors.length; r++) {
                            r_idauthors[r] = ref_JD_Authors.jTableAuthors.getValueAt(r_idauthors[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idauthors.length > 0) {
                    ref_booksauthors.insert_booksauthors(r_idauthors, idbooks_, conn);
                    refresh_jTableAuthors();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void addSelectedPublisherToBooksInformation() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                int r_idpublishers[];
                r_idpublishers = ref_JD_Publishers.jTablePublishers.getSelectedRows();
                for (int c = 0; c < ref_JD_Publishers.jTablePublishers.getColumnCount(); c++) {
                    String columnName = ref_JD_Publishers.jTablePublishers.getColumnName(c);
                    if ("idpublishers".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idpublishers.length; r++) {
                            r_idpublishers[r] = ref_JD_Publishers.jTablePublishers.getValueAt(r_idpublishers[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idpublishers.length > 0) {
                    ref_bookspublishers.insert_bookspublishers(r_idpublishers, idbooks_, conn);
                    /**/
                    refresh_jTablePublishers();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void addSelectedSubjectToBooksInformation() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getIdbooks_information();
                int s_idsubjects[];
                s_idsubjects = ref_JD_Subjects.jTableSubjects.getSelectedRows();
                for (int c = 0; c < ref_JD_Subjects.jTableSubjects.getColumnCount(); c++) {
                    String columnName = ref_JD_Subjects.jTableSubjects.getColumnName(c);
                    if ("idsubjects".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < s_idsubjects.length; r++) {
                            s_idsubjects[r] = ref_JD_Subjects.jTableSubjects.getValueAt(s_idsubjects[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (s_idsubjects.length > 0) {
                    ref_bookssubjects.insert_bookssubjects(s_idsubjects, idbooks_, conn);
                    refresh_jTableSubjects();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- JDIALOG CATEGORY    
    public void show_jDialog_Category() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
//                jDialog_Category.setLocationRelativeTo(this);
                fill_jTableCategory(conn);
                getSelectedRowCount_jTableCategory();
                jDialog_Category.setAlwaysOnTop(true);
                jDialog_Category.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
//            System.err.println("");
        }
    }

// ----------------------------------------------------------------------------- JDIALOG ADD NEW BOOKS
    /**/
    private boolean isvalid_addBooks_form_addBooks() {
        int barcode_ = jTextField3_AddBooks.getText().trim().toString().length();
        int isbn_ = jTextField2_AddBooks.getText().trim().toString().length();
        if (barcode_ < 1 || barcode_ > 45) {
            JOptionPane.showMessageDialog(jDialog1_AddBooks, "Invalid BARCODE length\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }

        if (isbn_ < 1 || isbn_ > 45) {
            JOptionPane.showMessageDialog(jDialog1_AddBooks, "Invalid ISBN length\nPlease check the form", "Error Message", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        return true;
    }

    private void viewBookInformation_addBooks(int _idbooks) {
        try {
            if (this == null || !this.isVisible()) {
                // ref_BooksInformation.add(image1);
                // ref_BooksInformation.setSize(image1.getWidth(),image1.getHeight());
                this.setLocationRelativeTo(this);
                this.setAlwaysOnTop(true);
                this.setVisible(true);
            }

            setIdbooks_information(_idbooks);
            validate_BooksInformation();
            validate_BooksImage();
            validate_BooksInformation_Additional();
            check_userlogs();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void validateAddBooksForms_addBooks() {
        try {
            jDialog1_AddBooks.setLocationRelativeTo(null);
            jDialog1_AddBooks.setAlwaysOnTop(true);

            jTextField3_AddBooks.setText("");
            jTextField2_AddBooks.setText("");
            jTextField4_AddBooks.setText("");
            jFormattedTextField2_AddBooks.setValue(0);
            jFormattedTextField3_AddBooks.setValue(0);
            jFormattedTextField1_AddBooks.setValue(0);
            jTextField5_AddBooks.setText("");
            jFormattedTextField4_AddBooks.setValue(0);
            setCategoryName_addBooks();
            setDatechooserPanel_AcquiredDate_addBooks();
            jTextArea1_AddBooks.setText("");

            jDialog1_AddBooks.setVisible(true);

        } catch (Exception e) {
            System.err.println();
        }
    }

    private void setCategoryName_addBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                jComboBox_CategoryName_AddBooks.removeAllItems();
                ref_category.select_name(conn);
                if (category.getData().size() > 0) {
                    for (int i = 0; i < category.getData().size(); i++) {
                        jComboBox_CategoryName_AddBooks.addItem(category.getData().get(i).toString().replace("[", "").replace("]", ""));
                    }
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
// ----------------------------------------------------------------------------- [DATE CHOOSER PANEL]    
    private JDateChooser JDC_acquiredDate_addBooks = new JDateChooser(null, null, null, new JSpinnerDateEditor());

    private void setDatechooserPanel_AcquiredDate_addBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                JDC_acquiredDate_addBooks.setDate(ref_MyFunctions.select_currentDate(conn));
                setDateChooser_addBooks("MMMM dd, yyyy", JDC_acquiredDate_addBooks, jPanel_AcquiredDate_AddBooks);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDateChooser_addBooks(String SDF, JDateChooser JDC_dateChooser, JPanel JP_dateChooser) {
        JDC_dateChooser.setDateFormatString(SDF);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setTodayButtonVisible(true);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setNullDateButtonVisible(false);

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

// ----------------------------------------------------------------------------- SHOW JDIALOG INSTANCE [ADDITIONAL INFORMATION ]
    public void show_JD_Authors() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_Authors.setAlwaysOnTop(true);
                ref_JD_Authors.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
//            System.err.println("");
        }
    }

    public void show_JD_Publishers() {

        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_Publishers.setAlwaysOnTop(true);
                ref_JD_Publishers.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
//            System.err.println("");
        }
    }

    public void show_JD_Subjects() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_Subjects.setAlwaysOnTop(true);
                ref_JD_Subjects.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
//            System.err.println("");
        }
    }

// 
    public boolean updateSelected_JD_Authors() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String firstname_ = ref_JD_Authors.jTextField4.getText().trim().toString();
                String lastname_ = ref_JD_Authors.jTextField5.getText().trim().toString();
                String contactinformation = ref_JD_Authors.jTextArea2.getText().trim().toString();
                if (firstname_.length() == 0 && lastname_.length() == 0 && contactinformation.length() == 0) {
                    JOptionPane.showMessageDialog(ref_JD_Authors.jDialog1_Update, "The form must not be empty\nPlease fillup the form", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    /**/
                    ref_authors.update_authors(ref_JD_Authors.getEdit_idauthors(), new authors(firstname_, lastname_, contactinformation), conn);
                    ref_JD_Authors.fill_jTableAuthors(ref_JD_Authors.getSearchAuthor_keyword(), ref_JD_Authors.limit_first, ref_JD_Authors.limit_second, conn);
                    ref_JD_Authors.setIsNeedRefresh(true);
                    refresh_jTableAuthors();
                    return true;
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean updateSelected_JD_Publishers() {

        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String name_ = ref_JD_Publishers.jTextField4.getText().trim().toString();
                String city_ = ref_JD_Publishers.jTextField5.getText().trim().toString();
                String contactinformation = ref_JD_Publishers.jTextArea2.getText().trim().toString();
                /**/ if (name_.length() == 0 && city_.length() == 0 && contactinformation.length() == 0) {
                    JOptionPane.showMessageDialog(ref_JD_Publishers.jDialog1_Update, "The form must not be empty\nPlease fillup the form", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ref_publishers.update_publishers(ref_JD_Publishers.getEdit_idpublisher(), new publishers(name_, city_, contactinformation), conn);
                    ref_JD_Publishers.fill_jTablePublishers(ref_JD_Publishers.getSearchPublisher_keyword(), ref_JD_Publishers.limit_first, ref_JD_Publishers.limit_second, conn);
                    refresh_jTablePublishers();
                    return true;
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
}
