package gui.booksreservation.main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;

public class REF_JF_Administrator_Members extends javax.swing.JFrame {

    /**/
    private static members ref_members = new members();
    private books ref_books = new books();
    private reserve ref_reserve = new reserve();
    /**/
    public REF_JF_MembersBooksReserved ref_MembersBooksReserved = new REF_JF_MembersBooksReserved();
    public REF_JF_MembersBooksBorrowed ref_MembersBooksBorrowed = new REF_JF_MembersBooksBorrowed();
    public REF_JF_MembersBooksPenalties ref_MembersBooksPenalties = new REF_JF_MembersBooksPenalties();

    public REF_JF_Administrator_Members() {
        initComponents();
        /**/
        jTableMembers_TableModel = (DefaultTableModel) jTableMembers.getModel();
        jTable_setShowHorizontalLines(jTableMembers);
        jTable_setTableHeader(jTableMembers);
        /**/
        initialize_results_fill_jTableMembers();
        /**/
        SearchTextField1 = jTextField1.getText().trim().toString();
        SearchTextField2 = SearchTextField1;
        jTextField1.setText(SearchTextField2);
        /**/
        jTabbedPane1.add("    Reserved Books    ", ref_MembersBooksReserved.jPanel2);
        set_ref_MembersBooksReserved_Listeners();
        jTabbedPane1.add("    Borrowed Books    ", ref_MembersBooksBorrowed.jPanel2);
        set_ref_MembersBooksBorrowed_Listeners();
        jTabbedPane1.add("    Penalties    ", ref_MembersBooksPenalties.jPanel2);
        set_ref_MembersBooksPenalties_Listeners();
        /**/
        ref_JD_UpdateBorrowedBooks.setLocationRelativeTo(null);
        ref_JD_AddNewMembers.setLocationRelativeTo(null);
        /**/
        ref_MembersBooksReserved.initialize_results_fill_jTableMembers();
        ref_MembersBooksBorrowed.initialize_results_fill_jTableMembers();
        ref_MembersBooksPenalties.initialize_results_fill_jTableMembers();

    }
    // ------------------------------------------------------------------------ []
    private String SearchTextField1;
    private String SearchTextField2;
    private DefaultTableModel jTableMembers_TableModel;
    public String SearchTextField_Keyword = "";

    public String getSearchTextField_Keyword() {
        return SearchTextField_Keyword;
    }

    public void setSearchTextField_Keyword(String SearchTextField_Keyword) {
        this.SearchTextField_Keyword = SearchTextField_Keyword;
    }
    private int max_results_query = 1;
    private int limit_min_results = 1;
    private int click_previous = 0;
    private int click_next = 0;
    private int count_total = 0;
    public int limit_first = 0;
    public int limit_second = 1;

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
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            limit_first = limit_first += limit_second;
            limit_second = limit_min_results;
            fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
            if (Database._function_getConnection(Database._booksreservation) != null) {
                limit_first = limit_first += limit_second;
                limit_second = limit_min_results;
                fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                check_setEnable();
            }
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
            fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    /**/
    private void initialize_results_fill_jTableMembers() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                int limitresults = jSpinner_limitresults.getValue().hashCode(); // get the limit display list
                limit_min_results = limitresults; // store in the limit_min_results

                max_results_query = ref_members.count_select_search(this.getSearchTextField_Keyword(), conn);

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
                fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                /* check the jTableBooks */
                check_setEnable();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._booksreservation.getConnection() != null) {
                    initialize_results_fill_jTableMembers();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }



    }

    public void fill_jTableMembers(String search, int limit_first, int limit_second, Connection conn) {
        try {
            jTableMembers_TableModel.setRowCount(0);

            /**/
            int CountListResults = 0;
            CountListResults = ref_members.select_by_search(search, limit_first, limit_second, conn);
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

            if (CountListResults == 0) {
                jLabel_Record.setText(" Record (" + 0 + ") of " + 0 + "");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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

    /**/
    public void getSelectedRowCount_jTableMembers() {
        int getSelectedRowCount = jTableMembers.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
            jButtonViewInfo.setEnabled(false);
            empty_booksInformation();
        } else if (getSelectedRowCount == 1) {
            show_ref_MembersBooksReserved();
            show_ref_MembersBooksBorrowed();
            show_ref_MembersBooksPenalties();
            jButtonViewInfo.setEnabled(true);
        } else if (getSelectedRowCount > 1) {
            empty_booksInformation();
            jButtonViewInfo.setEnabled(false);
        } else {
            empty_booksInformation();
        }
        getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
        getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
        getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
    }

    public int function_getColumnNumber_jTable(String jTableColumn_Name, JTable jTable_Name) {
        int get_columnNumber = 0;
        try {
            /*
             int selectedColumn = function_getColumnNumber_jTable("idbooks", jTableBooks);
             int selectedRow = jTableBooks.getSelectedRow();
             int idbooks = jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();                
             */
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

    // ------------------------------------------------------------------------ []
    protected TableCellRenderer createMembersIDNumberColumnRenderer() {
        return new MembersIDNumberRenderer(new JLabel());
    }

    protected TableCellRenderer createMiddleInitialColumnRenderer() {
        return new MiddleInitialRenderer(new JLabel());
    }

    /**/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPaneMembers = new javax.swing.JScrollPane();
        jTableMembers = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel_Record = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSpinner_limitresults = new javax.swing.JSpinner();
        jButton_FirstRecord = new javax.swing.JButton();
        jButton_PreviousRecord = new javax.swing.JButton();
        jButton_NextRecord = new javax.swing.JButton();
        jButton_LastRecord = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jButtonViewInfo = new javax.swing.JButton();
        jButtonCancelReservation = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();
        jButtonUpdatePenalties = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setMinimumSize(new java.awt.Dimension(442, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPaneMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneMembersMouseClicked(evt);
            }
        });

        jTableMembers.setAutoCreateRowSorter(true);
        jTableMembers.setBackground(new java.awt.Color(153, 0, 0));
        jTableMembers.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableMembers.setForeground(new java.awt.Color(255, 255, 255));
        jTableMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idmembers", "ID Number", "Firstname", "M.I.", "Lastname", "Gender", "Member Type", "1st Contact #", "2nd Contact #", "Total Fines"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMembers.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableMembers.setRowHeight(24);
        jTableMembers.setSelectionBackground(new java.awt.Color(0, 0, 0));
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
        jScrollPaneMembers.setViewportView(jTableMembers);
        jTableMembers.getColumnModel().getColumn(0).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableMembers.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableMembers.getColumnModel().getColumn(1).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableMembers.getColumnModel().getColumn(1).setMaxWidth(100);
        jTableMembers.getColumnModel().getColumn(1).setCellRenderer(createMembersIDNumberColumnRenderer());
        jTableMembers.getColumnModel().getColumn(3).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTableMembers.getColumnModel().getColumn(3).setMaxWidth(40);
        jTableMembers.getColumnModel().getColumn(3).setCellRenderer(createMiddleInitialColumnRenderer());
        jTableMembers.getColumnModel().getColumn(4).setMinWidth(60);
        jTableMembers.getColumnModel().getColumn(5).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(5).setPreferredWidth(90);
        jTableMembers.getColumnModel().getColumn(5).setMaxWidth(90);
        jTableMembers.getColumnModel().getColumn(6).setPreferredWidth(120);
        jTableMembers.getColumnModel().getColumn(6).setMaxWidth(120);
        jTableMembers.getColumnModel().getColumn(7).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(7).setPreferredWidth(0);
        jTableMembers.getColumnModel().getColumn(7).setMaxWidth(0);
        jTableMembers.getColumnModel().getColumn(8).setMinWidth(0);
        jTableMembers.getColumnModel().getColumn(8).setPreferredWidth(0);
        jTableMembers.getColumnModel().getColumn(8).setMaxWidth(0);
        jTableMembers.getColumnModel().getColumn(9).setPreferredWidth(90);
        jTableMembers.getColumnModel().getColumn(9).setMaxWidth(90);

        jSplitPane1.setLeftComponent(jScrollPaneMembers);
        jSplitPane1.setRightComponent(jTabbedPane1);

        jPanel8.add(jSplitPane1);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

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

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setText("Search Members");
        jTextField1.setMargin(new java.awt.Insets(0, 4, 0, 4));
        jTextField1.setPreferredSize(new java.awt.Dimension(10, 19));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel6.add(jTextField1);

        jPanel9.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel_Record.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Record.setText(" Record 1-2 of 2");
        jLabel_Record.setPreferredSize(new java.awt.Dimension(150, 18));
        jPanel7.add(jLabel_Record);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Limit Results");
        jPanel7.add(jLabel1);

        jSpinner_limitresults.setModel(new javax.swing.SpinnerNumberModel(5, 1, 100, 1));
        jSpinner_limitresults.setPreferredSize(new java.awt.Dimension(60, 20));
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
        jButton_PreviousRecord.setToolTipText("");
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

        jPanel9.add(jPanel7);

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel3.setMinimumSize(new java.awt.Dimension(95, 270));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 55));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jButtonViewInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_ViewInformation.png"))); // NOI18N
        jButtonViewInfo.setText("<html> <head> </head> <body> <div align=\"center\"><strong></strong> </div> </body> </html> ");
        jButtonViewInfo.setToolTipText("View Books Information");
        jButtonViewInfo.setFocusable(false);
        jButtonViewInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonViewInfo.setIconTextGap(0);
        jButtonViewInfo.setMargin(new java.awt.Insets(3, 14, 2, 14));
        jButtonViewInfo.setMaximumSize(new java.awt.Dimension(85, 75));
        jButtonViewInfo.setMinimumSize(new java.awt.Dimension(85, 75));
        jButtonViewInfo.setPreferredSize(new java.awt.Dimension(80, 44));
        jButtonViewInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewInfoActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonViewInfo);

        jButtonCancelReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_CancelReservation.png"))); // NOI18N
        jButtonCancelReservation.setText("<html> <head> </head> <body> <div align=\"center\"><strong></strong> </div> </body> </html> ");
        jButtonCancelReservation.setToolTipText("Cancel Reservation");
        jButtonCancelReservation.setFocusable(false);
        jButtonCancelReservation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelReservation.setIconTextGap(0);
        jButtonCancelReservation.setMargin(new java.awt.Insets(3, 14, 2, 14));
        jButtonCancelReservation.setMaximumSize(new java.awt.Dimension(85, 75));
        jButtonCancelReservation.setMinimumSize(new java.awt.Dimension(85, 75));
        jButtonCancelReservation.setPreferredSize(new java.awt.Dimension(80, 44));
        jButtonCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelReservationActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCancelReservation);

        jButtonReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_ReturnBooks.png"))); // NOI18N
        jButtonReturn.setText("<html> <head> </head> <body> <div align=\"center\"><strong></strong> </div> </body> </html> ");
        jButtonReturn.setToolTipText("Renew Borrowed Books");
        jButtonReturn.setFocusable(false);
        jButtonReturn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReturn.setIconTextGap(0);
        jButtonReturn.setMargin(new java.awt.Insets(3, 14, 2, 14));
        jButtonReturn.setMaximumSize(new java.awt.Dimension(85, 75));
        jButtonReturn.setMinimumSize(new java.awt.Dimension(85, 75));
        jButtonReturn.setPreferredSize(new java.awt.Dimension(80, 44));
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonReturn);

        jButtonUpdatePenalties.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_ReturnBooks_Penalties.png"))); // NOI18N
        jButtonUpdatePenalties.setText("<html> <head> </head> <body> <div align=\"center\"><strong></strong> </div> </body> </html> ");
        jButtonUpdatePenalties.setToolTipText("Renew Borrowed Books");
        jButtonUpdatePenalties.setFocusable(false);
        jButtonUpdatePenalties.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUpdatePenalties.setIconTextGap(0);
        jButtonUpdatePenalties.setMargin(new java.awt.Insets(3, 14, 2, 14));
        jButtonUpdatePenalties.setMaximumSize(new java.awt.Dimension(85, 75));
        jButtonUpdatePenalties.setMinimumSize(new java.awt.Dimension(85, 75));
        jButtonUpdatePenalties.setPreferredSize(new java.awt.Dimension(80, 44));
        jButtonUpdatePenalties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePenaltiesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonUpdatePenalties);

        jToolBar1.add(jPanel3);

        jPanel2.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
         //           try {
         //               if (jCheckBox2.isSelected()) { // auto search
         //                    JIF_Guest.setSearchBook_keyword(jTextField1.getText().trim().toString());
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
                 if (jTextField1.getText().trim().toString().equals(SearchTextField2)) { // if empty in the textfield
                     //                         JIF_Guest.setSearchBook_Keyword("");
                     //                         initialize_results_fill_jTableBooks();
                 } else {
                     //                         JIF_Guest.setSearchBook_Keyword(jTextField1.getText().trim().toString());
                     this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                     initialize_results_fill_jTableMembers();
                 }
             } else {
             }
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jCheckBox1ActionPerformed

     private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
//                    jPopupMenuCategory.show(evt.getComponent(), jTextField1.getX() - jTextField1.getX(), jTextField1.getHeight());
                 }

                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jTextField1MouseClicked

     private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained

         if (SearchTextField2.equals(jTextField1.getText())) {
             jTextField1.setText("");
         }

     }//GEN-LAST:event_jTextField1FocusGained

     private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
         if (jTextField1.getText().length() == 0) {
             jTextField1.setText(SearchTextField2);
         }
     }//GEN-LAST:event_jTextField1FocusLost

     private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
         try {
             if (jCheckBox1.isSelected()) { // auto search
                 if (evt.getKeyCode() == 27) { // EQUAL TO 'SCAPE' KEY CHARACTER
                     jTextField1.setText("");
                 }
                 //                    JIF_Guest.setSearchBook_Keyword(jTextField1.getText().trim().toString());
                 this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                 initialize_results_fill_jTableMembers();
             } else {
                 int keyCode = evt.getKeyCode();
                 switch (keyCode) {
                     case 10: // IF HIT 'ENTER' KEY
                         //                              JIF_Guest.setSearchBook_Keyword(jTextField1.getText().trim().toString());
                         this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                         initialize_results_fill_jTableMembers();
                         break;
                     case 32: // IF HIT 'SPACE' KEY
                         break;
                     case 27: // IF HIT 'SCAPE' KEY
                         jTextField1.setText("");
                         this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                         initialize_results_fill_jTableMembers();
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
             //               JIF_Guest.setSearchBook_keyword(jTextField1.getText().trim().toString());
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

     private void jTableMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMembersMouseClicked
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
                     getSelectedRowCount_jTableMembers();

                     //                         jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
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
                 break;
             case 32: // IF HIT 'SPACE' KEY
                 break;
             case 127: // IF HIT 'DELETE' KEY
                 System.out.println("Delete");
                 break;
             default:
                 getSelectedRowCount_jTableMembers();
                 break;
         }
     }//GEN-LAST:event_jTableMembersKeyReleased

     private void jScrollPaneMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneMembersMouseClicked
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
                     getSelectedRowCount_jTableMembers();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                 }
                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jScrollPaneMembersMouseClicked

     private void jButtonViewInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewInfoActionPerformed
//updateSelectedMember();
     }//GEN-LAST:event_jButtonViewInfoActionPerformed

     private void jButtonCancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelReservationActionPerformed
//         cancel_books_reservation();

     }//GEN-LAST:event_jButtonCancelReservationActionPerformed

     private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
//          return_books_borrow();
     }//GEN-LAST:event_jButtonReturnActionPerformed

     private void jButtonUpdatePenaltiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePenaltiesActionPerformed
//         update_books_penalties();
     }//GEN-LAST:event_jButtonUpdatePenaltiesActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REF_JF_Administrator_Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                    new REF_JF_Guest().setVisible(true);
                REF_JF_Administrator_Members ref_JF_Guest = new REF_JF_Administrator_Members();
                ref_JF_Guest.setSize(950, 600);
                ref_JF_Guest.setLocationRelativeTo(null);
                ref_JF_Guest.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonCancelReservation;
    public javax.swing.JButton jButtonReturn;
    public javax.swing.JButton jButtonUpdatePenalties;
    public javax.swing.JButton jButtonViewInfo;
    private javax.swing.JButton jButton_FirstRecord;
    private javax.swing.JButton jButton_LastRecord;
    private javax.swing.JButton jButton_NextRecord;
    private javax.swing.JButton jButton_PreviousRecord;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Record;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPaneMembers;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner_limitresults;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableMembers;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    /**/
    private void getSelectedRowCount_jTableMembers_ref_MembersBooksReserved() {
        try {
            int getSelectedRowCount = ref_MembersBooksReserved.jTableMembersBooksReserved.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jButtonCancelReservation.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jButtonCancelReservation.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jButtonCancelReservation.setEnabled(true);
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void set_ref_MembersBooksReserved_Listeners() {
        try {
            ref_MembersBooksReserved.jTableMembersBooksReserved.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTableDepartmentKeyReleased(evt);
                }

                private void jTableDepartmentKeyReleased(KeyEvent evt) {
                    int keyCode = evt.getKeyCode();
                    switch (keyCode) {
                        case 10: // IF HIT 'ENTER' KEY
                            getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
                            break;
                        case 32: // IF HIT 'SPACE' KEY
                            break;
                        case 127: // IF HIT 'DELETE' KEY
                            System.out.println("Delete");
                            break;
                        default:
                            getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
                            break;
                    }
                }
            });
            ref_MembersBooksReserved.jTableMembersBooksReserved.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jTableDepartmentMouseReleased(evt);
                }

                private void jTableDepartmentMouseReleased(MouseEvent evt) {

                    int buttonChoice = evt.getButton();
                    //int countClick = evt.getClickCount();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                //jPopupMenuDepartment.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableDepartmentMouseClicked(evt);
                }

                private void jTableDepartmentMouseClicked(MouseEvent evt) {

                    int buttonChoice = evt.getButton();
                    //int countClick = evt.getClickCount();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
                                //jPopupMenuDepartment.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }
            });
            ref_MembersBooksReserved.jScrollPaneMembersBooksReserved.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPaneDepartmentMouseClicked(evt);
                }

                private void jScrollPaneDepartmentMouseClicked(MouseEvent evt) {
                    int buttonChoice = evt.getButton();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    private void getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed() {
        try {
            int getSelectedRowCount = ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jButtonReturn.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jButtonReturn.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jButtonReturn.setEnabled(false);
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void set_ref_MembersBooksBorrowed_Listeners() {
        try {
            ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTableDepartmentKeyReleased(evt);
                }

                private void jTableDepartmentKeyReleased(KeyEvent evt) {
                    int keyCode = evt.getKeyCode();
                    switch (keyCode) {
                        case 10: // IF HIT 'ENTER' KEY
                            getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
                            break;
                        case 32: // IF HIT 'SPACE' KEY
                            break;
                        case 127: // IF HIT 'DELETE' KEY
                            System.out.println("Delete");
                            break;
                        default:
                            getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
                            break;
                    }
                }
            });
            ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jTableDepartmentMouseReleased(evt);
                }

                private void jTableDepartmentMouseReleased(MouseEvent evt) {

                    int buttonChoice = evt.getButton();
                    //int countClick = evt.getClickCount();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                //jPopupMenuDepartment.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableDepartmentMouseClicked(evt);
                }

                private void jTableDepartmentMouseClicked(MouseEvent evt) {

                    int buttonChoice = evt.getButton();
                    //int countClick = evt.getClickCount();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
                                //jPopupMenuDepartment.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }
            });
            ref_MembersBooksBorrowed.jScrollPaneMembersBooksBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPaneDepartmentMouseClicked(evt);
                }

                private void jScrollPaneDepartmentMouseClicked(MouseEvent evt) {
                    int buttonChoice = evt.getButton();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }
            });

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    public void getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties() {
        try {
            int getSelectedRowCount = ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jButtonUpdatePenalties.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jButtonUpdatePenalties.setEnabled(true);
            } else if (getSelectedRowCount > 1) {
                jButtonUpdatePenalties.setEnabled(false);
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void set_ref_MembersBooksPenalties_Listeners() {
        try {
            ref_MembersBooksPenalties.jTableMembersBooksPenalties.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTableDepartmentKeyReleased(evt);
                }

                private void jTableDepartmentKeyReleased(KeyEvent evt) {
                    int keyCode = evt.getKeyCode();
                    switch (keyCode) {
                        case 10: // IF HIT 'ENTER' KEY
                            getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
                            break;
                        case 32: // IF HIT 'SPACE' KEY
                            break;
                        case 127: // IF HIT 'DELETE' KEY
                            System.out.println("Delete");
                            break;
                        default:
                            getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
                            break;
                    }
                }
            });
            ref_MembersBooksPenalties.jTableMembersBooksPenalties.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jTableDepartmentMouseReleased(evt);
                }

                private void jTableDepartmentMouseReleased(MouseEvent evt) {

                    int buttonChoice = evt.getButton();
                    //int countClick = evt.getClickCount();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                //jPopupMenuDepartment.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableDepartmentMouseClicked(evt);
                }

                private void jTableDepartmentMouseClicked(MouseEvent evt) {

                    int buttonChoice = evt.getButton();
                    //int countClick = evt.getClickCount();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
                                //jPopupMenuDepartment.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }
            });
            ref_MembersBooksPenalties.jScrollPaneMembersBooksPenalties.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPaneDepartmentMouseClicked(evt);
                }

                private void jScrollPaneDepartmentMouseClicked(MouseEvent evt) {
                    int buttonChoice = evt.getButton();
                    switch (buttonChoice) {
                        case 1: // IF MOUSE IS LEFT CLICKED
                            break;
                        case 2:
                            break;
                        case 3: // IF MOUSE IS RIGHT CLICKED
                            if (!evt.isPopupTrigger()) {
                                getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                            }
                            break;
                        default: // IF MOUSE IS !RIGHTCLICK
                            break;
                    }
                }
            });

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    private void show_ref_MembersBooksReserved() {
        try {

            int selectedColumn = function_getColumnNumber_jTable("idmembers", jTableMembers);
            int selectedRow = jTableMembers.getSelectedRow();
            int idmembers_ = jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();

            ref_MembersBooksReserved.setIdmembers(idmembers_);
            ref_MembersBooksReserved.initialize_results_fill_jTableMembers();



        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void show_ref_MembersBooksBorrowed() {
        try {
            int selectedColumn = function_getColumnNumber_jTable("idmembers", jTableMembers);
            int selectedRow = jTableMembers.getSelectedRow();
            int idmembers_ = jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();

            ref_MembersBooksBorrowed.setIdmembers(idmembers_);
            ref_MembersBooksBorrowed.initialize_results_fill_jTableMembers();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void show_ref_MembersBooksPenalties() {
        try {
            int selectedColumn = function_getColumnNumber_jTable("idmembers", jTableMembers);
            int selectedRow = jTableMembers.getSelectedRow();
            int idmembers_ = jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();

            ref_MembersBooksPenalties.setIdmembers(idmembers_);
            ref_MembersBooksPenalties.initialize_results_fill_jTableMembers();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    public void view_members_information() {
        try {
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void delete_selected_member() {
        try {
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void cancel_books_reservation() {
        try {
            /**/
            Object[] options = {"  Yes  ", "  No  "};
            int n3 = JOptionPane.showOptionDialog(
                    this,
                    "Cancel selected reservation?",
                    "Cancel Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (n3 == JOptionPane.YES_OPTION) {
                cancel_reservation_yes();
            } else if (n3 == JOptionPane.NO_OPTION) {
            } else {
            }
            /**/
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void cancel_reservation_yes() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int r_idreserve[];
                r_idreserve = ref_MembersBooksReserved.jTableMembersBooksReserved.getSelectedRows();
                for (int c = 0; c < ref_MembersBooksReserved.jTableMembersBooksReserved.getColumnCount(); c++) {
                    String columnName = ref_MembersBooksReserved.jTableMembersBooksReserved.getColumnName(c);
                    if ("idreserve".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idreserve.length; r++) {
                            r_idreserve[r] = ref_MembersBooksReserved.jTableMembersBooksReserved.getValueAt(r_idreserve[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idreserve.length > 0) {
                    ref_reserve.update_reserve_status_to_canceled(r_idreserve, conn);
                    /**/
                    ref_MembersBooksReserved.fill_jTableMembers(ref_MembersBooksReserved.getIdmembers(), ref_MembersBooksReserved.limit_first, ref_MembersBooksReserved.limit_second, conn);
                    getSelectedRowCount_jTableMembers_ref_MembersBooksReserved();
                    /**/
                    fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                    getSelectedRowCount_jTableMembers();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**/
    /**/
    private JD_UpdateBorrowedBooks ref_JD_UpdateBorrowedBooks = new JD_UpdateBorrowedBooks(this, true);

    public void return_books_borrow() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int getSelectedRowCount = ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRowCount();
                if (getSelectedRowCount == 1) {
                    int selectedColumn = function_getColumnNumber_jTable("idborrow", ref_MembersBooksBorrowed.jTableMembersBooksBorrowed);
                    int selectedRow = ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRow();
                    int idborrow_ = ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getValueAt(selectedRow, selectedColumn).hashCode();

                    ref_JD_UpdateBorrowedBooks.setIdborrow(idborrow_);
                    ref_JD_UpdateBorrowedBooks.refreshForm();
                    ref_JD_UpdateBorrowedBooks.setVisible(true);
                    /**/
                    if (ref_JD_UpdateBorrowedBooks.isUpdated == true) {
                        ref_MembersBooksBorrowed.fill_jTableMembers(ref_MembersBooksBorrowed.getIdmembers(), ref_MembersBooksBorrowed.limit_first, ref_MembersBooksBorrowed.limit_second, conn);
                        getSelectedRowCount_jTableMembers_ref_MembersBooksBorrowed();
                        ref_MembersBooksPenalties.fill_jTableMembers(ref_MembersBooksPenalties.getIdmembers(), ref_MembersBooksPenalties.limit_first, ref_MembersBooksPenalties.limit_second, conn);
                        /**/
                        fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                        getSelectedRowCount_jTableMembers();
                        ref_JD_UpdateBorrowedBooks.setIsUpdated(false);
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update_books_penalties() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int getSelectedRowCount = ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRowCount();
                if (getSelectedRowCount == 1) {
                    int selectedColumn = function_getColumnNumber_jTable("idborrow", ref_MembersBooksBorrowed.jTableMembersBooksBorrowed);
                    int selectedRow = ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRow();
                    int idborrow_ = ref_MembersBooksPenalties.jTableMembersBooksPenalties.getValueAt(selectedRow, selectedColumn).hashCode();

                    ref_JD_UpdateBorrowedBooks.setIdborrow(idborrow_);
                    ref_JD_UpdateBorrowedBooks.refreshForm();
                    ref_JD_UpdateBorrowedBooks.setVisible(true);
                    /**/
                    if (ref_JD_UpdateBorrowedBooks.isUpdated == true) {
                        ref_MembersBooksPenalties.fill_jTableMembers(ref_MembersBooksPenalties.getIdmembers(), ref_MembersBooksPenalties.limit_first, ref_MembersBooksPenalties.limit_second, conn);
                        getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();

                        /**/
                        fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                        getSelectedRowCount_jTableMembers();
                        ref_JD_UpdateBorrowedBooks.setIsUpdated(false);
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**/
    private JD_AddNewMembers ref_JD_AddNewMembers = new JD_AddNewMembers(this, true);

    public void add_new_members() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_AddNewMembers.setIsneedupdate(false);
                ref_JD_AddNewMembers.setTitle("Add New User");
                ref_JD_AddNewMembers.clearTheForm();
                ref_JD_AddNewMembers.jButton_Add.setVisible(true);
                ref_JD_AddNewMembers.jButton_update.setVisible(false);
                ref_JD_AddNewMembers.student_view_form(true);
                ref_JD_AddNewMembers.setVisible(true);
                if (ref_JD_AddNewMembers.isIsneedupdate()) {
                    fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                    getSelectedRowCount_jTableMembers();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void updateSelectedMember() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int getSelectedRowCount = jTableMembers.getSelectedRowCount();
                if (getSelectedRowCount == 1) {
                    int selectedColumn = function_getColumnNumber_jTable("idmembers", jTableMembers);
                    int selectedRow = jTableMembers.getSelectedRow();
                    int idmember_ = jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();
                    ref_JD_AddNewMembers.setIsneedupdate(false);

                    ref_JD_AddNewMembers.setIdmembers(idmember_);
                    ref_JD_AddNewMembers.setTitle("Update Member");
                    ref_JD_AddNewMembers.refreshForm();
                    ref_JD_AddNewMembers.jButton_Add.setVisible(false);
                    ref_JD_AddNewMembers.jButton_update.setVisible(true);
                    ref_JD_AddNewMembers.student_view_form(true);
                    ref_JD_AddNewMembers.setVisible(true);

                    if (ref_JD_AddNewMembers.isIsneedupdate()) {
                        fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                        getSelectedRowCount_jTableMembers();
                    }

                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
        }
    }

    private void empty_booksInformation() {
        try {
                ref_MembersBooksReserved.setIdmembers(0);
                ref_MembersBooksReserved.initialize_results_fill_jTableMembers();
                
                ref_MembersBooksBorrowed.setIdmembers(0);
                ref_MembersBooksBorrowed.initialize_results_fill_jTableMembers();
                                
                ref_MembersBooksPenalties.setIdmembers(0);
                ref_MembersBooksPenalties.initialize_results_fill_jTableMembers();
                
                
           
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
