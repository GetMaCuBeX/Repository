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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.database.booksreservation.booksimage;
import mcbx.jb.classes.database.booksreservation.borrow;
import mcbx.jb.classes.database.booksreservation.logsborrowedbooks;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.database.booksreservation.membersimage;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.MyFileChooserBrowsePicture;
import mcbx.jb.classes.mycollection.MyFileChooserSavePicture;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JD_BorrowBooks extends javax.swing.JDialog {

    /**/
    private members ref_members = new members();
    private borrow ref_borrow = new borrow();
    private books ref_books = new books();
    private reserve ref_reserve = new reserve();
    /**/
    private DefaultTableModel jTableMembers_TableModel;
    /**/
    /**/
    private membersimage ref_membersimage = new membersimage();
    private ImageIcon NoImageBackground_Books = new ImageIcon(Main.class.getResource("icons/1_256x256_NoImageBackground_Books.png"));
    /* preview picture */
    /* for browsed pictures */
    private ImageIcon icon_browsed = null;
    private ImageIcon iconThumbnail_browsed = null;
    private int icon_DimensionSize = 130;
    private int borrow_idbooks = 0;
    private int borrow_idmember = 0;
    private String searchMember_keyword = "";
    private boolean isNeedRefresh = false;

    public boolean isIsNeedRefresh() {
        return isNeedRefresh;
    }

    public void setIsNeedRefresh(boolean isNeedRefresh) {
        this.isNeedRefresh = isNeedRefresh;
    }

    public int getBorrow_idbooks() {
        return borrow_idbooks;
    }

    public void setBorrow_idbooks(int borrow_idbooks) {
        this.borrow_idbooks = borrow_idbooks;
    }

    public int getBorrow_idmember() {
        return borrow_idmember;
    }

    public void setBorrow_idmember(int borrow_idmember) {
        this.borrow_idmember = borrow_idmember;
    }

    public String getSearchMember_keyword() {
        return searchMember_keyword;
    }

    public void setSearchMember_keyword(String searchMember_keyword) {
        this.searchMember_keyword = searchMember_keyword;
    }

    /**/
    private int max_results_query = 0;
    private int limit_min_results = 1;
    private int click_previous = 0;
    private int click_next = 0;
    private int count_total = 0;
    private int limit_first = 0;
    private int limit_second = 1;

    private void check_setEnable() {
        getSelectedRowCount_jTableMembers();
        if (click_next > 1) {
            jButton_NextRecord.setEnabled(true);
            jButton_LastRecord.setEnabled(true);
        } else {
            jButton_NextRecord.setEnabled(false);
            jButton_LastRecord.setEnabled(false);
        }
        if (click_previous < count_total) {
            jButton_PreviousRecord.setEnabled(true);
            jButton_FirstRecord.setEnabled(true);
        } else {
            jButton_PreviousRecord.setEnabled(false);
            jButton_FirstRecord.setEnabled(false);
        }
    }

    private void cick_next() {
        getSelectedRowCount_jTableMembers();
        click_next--;
        click_previous--;
        if (click_next > 1) {
            jButton_NextRecord.setEnabled(true);
            jButton_LastRecord.setEnabled(true);
        } else {
            jButton_NextRecord.setEnabled(false);
            jButton_LastRecord.setEnabled(false);
        }
        if (click_previous < count_total) {
            jButton_PreviousRecord.setEnabled(true);
            jButton_FirstRecord.setEnabled(true);
        } else {
            jButton_PreviousRecord.setEnabled(false);
            jButton_FirstRecord.setEnabled(false);
        }
        last_next();
    }

    private void click_last() {
        int count = 0;
        while (click_next > 1) {
            click_next--;
            click_previous--;
            count++;
        }
        for (int x = 1; x < count; x++) {
            limit_first = limit_first += limit_second;
            limit_second = limit_min_results;
        }
        last_next();
    }

    private void last_next() {
        /**/
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            limit_first = limit_first += limit_second;
            limit_second = limit_min_results;
            fill_jTableMembers(this.getSearchMember_keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    private void click_previous() {
        getSelectedRowCount_jTableMembers();
        click_next++;
        click_previous++;
        if (click_next > 1) {
            jButton_NextRecord.setEnabled(true);
        } else {
            jButton_NextRecord.setEnabled(false);
        }
        if (click_previous < count_total) {
            jButton_PreviousRecord.setEnabled(true);
            jButton_FirstRecord.setEnabled(true);
        } else {
            jButton_PreviousRecord.setEnabled(false);
            jButton_FirstRecord.setEnabled(false);
        }
        first_previous();
    }

    private void click_first() {
        int count = 0;
        while (click_previous < count_total) {
            click_next++;
            click_previous++;
            count++;
        }
        for (int x = 1; x < count; x++) {
            limit_first = limit_first -= limit_min_results;
            limit_second = limit_min_results;
        }
        first_previous();
    }

    private void first_previous() {
        /**/
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            limit_first = limit_first -= limit_min_results;
            limit_second = limit_min_results;
            fill_jTableMembers(this.getSearchMember_keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }
    /**/

    public JD_BorrowBooks(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /**/
        jTableMembers_TableModel = (DefaultTableModel) jTableMembers.getModel();
        jTable_setShowHorizontalLines(jTableMembers);
        jTable_setTableHeader(jTableMembers);
        /**/
        initialize_results_fill_jTableMembers();

        /**/
        setDatechooserPanel_1();
        setDatechooserPanel_2();
        JDC_1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDC_2.setMinSelectableDate(JDC_1.getDate());
                JDC_2.setDate(JDC_1.getDate());
            }
        });
        /**/
        jButton2.setVisible(false);

        validate_BooksImage();

    }

// ----------------------------------------------------------------------------- [SET TABLE]
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

// ----------------------------------------------------------------------------- [RETURN COLUMN NUMBER]     
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

    protected TableCellRenderer createMembersIDNumberColumnRenderer() {
        return new MembersIDNumberRenderer(new JLabel());
    }

    protected TableCellRenderer createMiddleInitialColumnRenderer() {
        return new MiddleInitialRenderer(new JLabel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinner_limitresults = new javax.swing.JSpinner();
        jButton_FirstRecord = new javax.swing.JButton();
        jButton_PreviousRecord = new javax.swing.JButton();
        jButton_NextRecord = new javax.swing.JButton();
        jButton_LastRecord = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_Record = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMembers = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton_browsedimage = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel_1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel_2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jMenuItem1.setText("Select This Member");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Borrow");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane1.setFocusable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(156);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setMnemonic('A');
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Auto Search");
        jCheckBox1.setToolTipText("Auto Search");
        jCheckBox1.setFocusPainted(false);
        jCheckBox1.setOpaque(false);
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator1);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(0, 4, 0, 4));
        jTextField1.setPreferredSize(new java.awt.Dimension(10, 19));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel6.add(jTextField1);

        jPanel5.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("     Limit Results");
        jPanel7.add(jLabel1);

        jSpinner_limitresults.setModel(new javax.swing.SpinnerNumberModel(3, 1, 1000, 1));
        jSpinner_limitresults.setPreferredSize(new java.awt.Dimension(80, 20));
        jSpinner_limitresults.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_limitresultsStateChanged(evt);
            }
        });
        jPanel7.add(jSpinner_limitresults);

        jButton_FirstRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_First.png"))); // NOI18N
        jButton_FirstRecord.setFocusable(false);
        jButton_FirstRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_FirstRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_FirstRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FirstRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_FirstRecord);

        jButton_PreviousRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_Previous.png"))); // NOI18N
        jButton_PreviousRecord.setFocusable(false);
        jButton_PreviousRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_PreviousRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PreviousRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_PreviousRecord);

        jButton_NextRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_Next.png"))); // NOI18N
        jButton_NextRecord.setFocusable(false);
        jButton_NextRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_NextRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_NextRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NextRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_NextRecord);

        jButton_LastRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_8x8_Last.png"))); // NOI18N
        jButton_LastRecord.setFocusable(false);
        jButton_LastRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_LastRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_LastRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LastRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_LastRecord);

        jPanel5.add(jPanel7);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setLayout(new java.awt.BorderLayout());
        jPanel9.add(jSeparator3, java.awt.BorderLayout.PAGE_START);

        jLabel_Record.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Record.setText(" Record 1-2 of 2");
        jLabel_Record.setPreferredSize(new java.awt.Dimension(86, 18));
        jPanel9.add(jLabel_Record, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9);

        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableMembers.setAutoCreateRowSorter(true);
        jTableMembers.setBackground(new java.awt.Color(153, 0, 0));
        jTableMembers.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableMembers.setForeground(new java.awt.Color(255, 255, 255));
        jTableMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idmembers", "ID Number", "Firstname", "M.I.", "Lastname", "Gender", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMembers.setRowHeight(24);
        jTableMembers.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTableMembers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMembersMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMembersMouseReleased(evt);
            }
        });
        jTableMembers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableMembersKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMembers);
        jTableMembers.getColumnModel().getColumn(0).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableMembers.getColumnModel().getColumn(1).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(1).setPreferredWidth(90);
        jTableMembers.getColumnModel().getColumn(1).setMaxWidth(90);
        jTableMembers.getColumnModel().getColumn(1).setCellRenderer(createMembersIDNumberColumnRenderer());
        jTableMembers.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableMembers.getColumnModel().getColumn(3).setMinWidth(40);
        jTableMembers.getColumnModel().getColumn(3).setMaxWidth(40);
        jTableMembers.getColumnModel().getColumn(3).setCellRenderer(createMiddleInitialColumnRenderer());
        jTableMembers.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableMembers.getColumnModel().getColumn(5).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(5).setPreferredWidth(0);
        jTableMembers.getColumnModel().getColumn(5).setMaxWidth(0);
        jTableMembers.getColumnModel().getColumn(6).setMinWidth(100);
        jTableMembers.getColumnModel().getColumn(6).setMaxWidth(100);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrow Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setPreferredSize(new java.awt.Dimension(34, 20));

        jButton_browsedimage.setToolTipText("Browse Image");
        jButton_browsedimage.setFocusPainted(false);
        jButton_browsedimage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_browsedimage.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_browsedimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_browsedimageActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jPanel_1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_1.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("From:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("To:");

        jPanel_2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_2.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Notes:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Copy:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_browsedimage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton_browsedimage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel10);

        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("                             ", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
     }//GEN-LAST:event_formKeyReleased

     private void jTableMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMembersMouseClicked
         int buttonChoice = evt.getButton();
         int clickCount = evt.getClickCount();
         if (clickCount == 2) {
             check_idmembers_and_forms();
         }



         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
                     getSelectedRowCount_jTableMembers();
//                     jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                 }
                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jTableMembersMouseClicked

     private void jTableMembersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMembersMouseReleased
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 getSelectedRowCount_jTableMembers();
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED

                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jTableMembersMouseReleased

     private void jTableMembersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMembersKeyReleased
         int keyCode = evt.getKeyCode();
         switch (keyCode) {
             case 10: // IF HIT 'ENTER' KEY
                 getSelectedRowCount_jTableMembers();
//                 check_idmembers_and_forms();
                 break;
             case 32: // IF HIT 'SPACE' KEY
                 break;
             default:
                 getSelectedRowCount_jTableMembers();
                 break;
         }
     }//GEN-LAST:event_jTableMembersKeyReleased

     private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
                     getSelectedRowCount_jTableMembers();
//                     jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                 }
                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jScrollPane1MouseClicked

     private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
         //           try {
         //               if (jCheckBox2.isSelected()) { // auto search
         //                    JIF_Books.setSearchBook_keyword(jTextField1.getText().trim().toString());
         //                    initialize_results_fill_jTableBooks();
         //               } else {
         //               }
         //          } catch (Exception e) {
         //               System.err.println(e);
         //          }
     }//GEN-LAST:event_jCheckBox1StateChanged

     private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
         try {
             if (jCheckBox1.isSelected()) { // auto search
                 this.setSearchMember_keyword(jTextField1.getText().trim().toString());
                 initialize_results_fill_jTableMembers();
             } else {
             }
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jCheckBox1ActionPerformed

     private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
         try {
             if (jCheckBox1.isSelected()) { // auto search
                 this.setSearchMember_keyword(jTextField1.getText().trim().toString());
                 initialize_results_fill_jTableMembers();
             } else {
                 int keyCode = evt.getKeyCode();
                 switch (keyCode) {
                     case 10: // IF HIT 'ENTER' KEY
                         this.setSearchMember_keyword(jTextField1.getText().trim().toString());
                         initialize_results_fill_jTableMembers();
                         break;
                     case 32: // IF HIT 'SPACE' KEY
                         break;
                     default:
                         break;
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jTextField1KeyReleased

     private void jSpinner_limitresultsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_limitresultsStateChanged
         try {
             initialize_results_fill_jTableMembers();
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jSpinner_limitresultsStateChanged

     private void jButton_FirstRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FirstRecordActionPerformed
         click_first();
     }//GEN-LAST:event_jButton_FirstRecordActionPerformed

     private void jButton_PreviousRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PreviousRecordActionPerformed
         click_previous();
     }//GEN-LAST:event_jButton_PreviousRecordActionPerformed

     private void jButton_NextRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NextRecordActionPerformed
         cick_next();
     }//GEN-LAST:event_jButton_NextRecordActionPerformed

     private void jButton_LastRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LastRecordActionPerformed
         click_last();
     }//GEN-LAST:event_jButton_LastRecordActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.dispose();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         addBorrowBooks();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         check_idmembers_and_forms();

     }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton_browsedimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_browsedimageActionPerformed
        //        if ("Administrator".equals(UserLogs.getMembertype())) {
            //            ins_MyFileChooserBrowsePicture.configureFileChooser();
            //            int option = ins_MyFileChooserBrowsePicture.fileChooser.showOpenDialog(this);
            //            analyzeOptionBrowse(ins_MyFileChooserBrowsePicture.fileChooser, option);
            //        }
    }//GEN-LAST:event_jButton_browsedimageActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_BorrowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_BorrowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_BorrowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_BorrowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JD_BorrowBooks dialog = new JD_BorrowBooks(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_FirstRecord;
    private javax.swing.JButton jButton_LastRecord;
    private javax.swing.JButton jButton_NextRecord;
    private javax.swing.JButton jButton_PreviousRecord;
    private javax.swing.JButton jButton_browsedimage;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Record;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JPanel jPanel_2;
    private static javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner_limitresults;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMembers;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

// ----------------------------------------------------------------------------- [QUERY INFORMATION]   
    public void initialize_results_fill_jTableMembers() {
        try {
            /**/
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                int limitresults = jSpinner_limitresults.getValue().hashCode(); // get the limit display list
                limit_min_results = limitresults; // store in the limit_min_results
                max_results_query = ref_members.count_select_search(this.getSearchMember_keyword(), conn);
                /* max_results_query = total count results in query */
                if (limit_min_results <= max_results_query) { // if 'limit_min_results' is less than 'max_results_query'
                    count_total = max_results_query / limit_min_results; // get the quotient
                    if (max_results_query % limit_min_results > 0) {
                        count_total++;
                    }
                    click_previous = count_total; // store in the click_previous
                    click_next = count_total; // store in the click_next
                } else { // if 'limit_min_results' is greater than 'max_results_query'
                    count_total = 0;
                    click_previous = 0;
                    click_next = 0;
                }
                limit_first = 0;
                limit_second = limit_min_results;
                /* query to database */
                fill_jTableMembers(this.getSearchMember_keyword(), limit_first, limit_second, conn);
                /* check the jTableBooks */
                check_setEnable();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void fill_jTableMembers(String search, int limit_first, int limit_second, Connection conn) {
        try {
            jTableMembers_TableModel.setRowCount(0);
            int listCount = ref_members.select_by_search(search, limit_first, limit_second, conn);
            for (int i = 0; i < members.getData().size(); i++) {
                jTableMembers_TableModel.addRow((Vector) members.getData().get(i));
                if (jTableMembers.getRowCount() == 1) {
                    limit_first += 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(limit_first) + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                } else {
                    int get_limit_first = limit_first--;
                    int get_rowCount = jTableMembers.getRowCount();
                    int records = (get_rowCount + get_limit_first) - 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(++limit_first) + " - " + records + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                }

            }
            if (listCount == 0) {
                jLabel_Record.setText(" Record " + 0 + " of " + 0 + "");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getSelectedRowCount_jTableMembers() {
        int getSelectedRowCount = jTableMembers.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
            jPopupMenu1.setEnabled(false);
            /**/
        } else if (getSelectedRowCount == 1) {
            jPopupMenu1.setEnabled(true);
        } else if (getSelectedRowCount > 1) {
            jPopupMenu1.setEnabled(false);
            /**/
        } else {
        }
    }
    // ----------------------------------------------------------------------------- [DATE CHOOSER PANEL]    
    private JDateChooser JDC_1 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private JDateChooser JDC_2 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private MyFunctions ref_MyFunctions = new MyFunctions();

    private void setDatechooserPanel_1() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                JDC_1.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_1.setDate(ref_MyFunctions.select_currentDate(conn));
                setDateChooser("MMMM dd, yyyy", JDC_1, jPanel_1);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDatechooserPanel_2() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                JDC_2.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_2.setDate(ref_MyFunctions.select_currentDate(conn));
                setDateChooser("MMMM dd, yyyy", JDC_2, jPanel_2);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
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

    /**/
    public void validate_selected_idbooks() {
    }

    private void addBorrowBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {

                String timeNow = new MyFunctions().return_DateTime("HH:mm:ss");
                String borroweddate_ = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_1.getDate()));
                String borrowedduedate = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_2.getDate()));
                int copy_ = jSpinner1.getValue().hashCode();
                String notes_ = jTextArea1.getText().trim().toString();
                int idmembers_ = this.getBorrow_idmember();
                int idbooks_ = this.getBorrow_idbooks();
                String status_ = "Borrowed";
                ref_borrow.insert_borrow(new borrow(idmembers_, idbooks_, borroweddate_ + " " + timeNow, borrowedduedate + " " + timeNow, copy_, notes_, null, "", 0, status_, 0), conn);
                /**/
                ref_reserve.remove_reservation_automatic_select_information_by_idbooks_and_idmembers_of_reserve_history_and_not_expired_and_status_is_reserved(idbooks_, idmembers_, conn);
                /**/
                this.setIsNeedRefresh(true);
                JOptionPane.showMessageDialog(this, "Item Successfully Borrowed", "Message", JOptionPane.PLAIN_MESSAGE);
//                jTextField2.setText("");
                new logsborrowedbooks().insert_logsborrowedbooks(idbooks_, borroweddate_ + " " + timeNow,conn);
                jButton2.setVisible(false);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }


    }

    public void set_form_disable() {
        jTextField2.setText("");
        jButton2.setVisible(false);
    }

    public void set_the_idnumber(int idmembers_) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                boolean ifItHas_ = ref_borrow.function_is_idmembers_has_an_idbooks_that_is_not_yet_return(idmembers_, conn);
                if (ifItHas_) {
                    int n = JOptionPane.showConfirmDialog(
                            this,
                            "Selected member has an item that is not yet return...\n"
                            + "Continue to borrow selected books?",
                            "Message",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        this.setBorrow_idmember(idmembers_);
                        jTextField2.setText(ref_members.function_get_idnumber(idmembers_, conn));
                        jButton2.setVisible(true);
//                              jToggleButton1.setSelected(true);
                    } else if (n == JOptionPane.NO_OPTION) {
                        jTextField2.setText("");
                        jButton2.setVisible(false);
//                              jToggleButton1.setSelected(false);
                    } else {
                        jTextField2.setText("");
                        jButton2.setVisible(false);
                    }
                } else {
                    this.setBorrow_idmember(idmembers_);
                    jTextField2.setText(ref_members.function_get_idnumber(idmembers_, conn));
                    jButton2.setVisible(true);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void check_idmembers_and_forms() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {

                int selectedColumn = function_getColumnNumber_jTable("idmembers", jTableMembers);
                int selectedRow = jTableMembers.getSelectedRow();
                int idmembers_ = jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();

                jButton_browsedimage.setIcon(NoImageBackground_Books);
                /**/
                boolean ifItHas_ = ref_borrow.function_is_idmembers_has_an_idbooks_that_is_not_yet_return(idmembers_, conn);
                if (ifItHas_) {
                    int n = JOptionPane.showConfirmDialog(
                            this,
                            "Selected member has an item that is not yet return...\n"
                            + "Continue to borrow selected books?",
                            "Message",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        this.setBorrow_idmember(idmembers_);
                        jTextField2.setText(ref_members.function_get_idnumber(idmembers_, conn));
                        validate_BooksImage();
                        jButton2.setVisible(true);
//                              jToggleButton1.setSelected(true);
                    } else if (n == JOptionPane.NO_OPTION) {
                        jTextField2.setText("");
                        jButton2.setVisible(false);
//                              jToggleButton1.setSelected(false);
                    } else {
                        jTextField2.setText("");
                        jButton2.setVisible(false);
                    }

                } else {
                    this.setBorrow_idmember(idmembers_);
                    validate_BooksImage();
                    jTextField2.setText(ref_members.function_get_idnumber(idmembers_, conn));
                    jButton2.setVisible(true);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- BORROWERS IMAGE
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
                int members_idmembers = this.getBorrow_idmember();
                boolean isExist_idbooks = ref_membersimage.function_is_idmembers_exist(members_idmembers, conn);
                /* check if it has an image */
                if (isExist_idbooks) {
                    icon_browsed = new membersimage().function_select_Image(members_idmembers, conn);
                    /* chech if the icon is null */
                    if (icon_browsed != null) {
                        createThumbnail_browsed(icon_browsed, icon_DimensionSize);
                        jButton_browsedimage.setIcon(iconThumbnail_browsed);
                    } else {
                        jButton_browsedimage.setIcon(NoImageBackground_Books);
                    }
                } else { // idbooks is not exist
                    jButton_browsedimage.setIcon(NoImageBackground_Books);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
            jButton_browsedimage.setIcon(NoImageBackground_Books);
        }
    }
}
