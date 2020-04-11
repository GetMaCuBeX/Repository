package gui.booksreservation.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;

public class JF_Administrator_Books extends javax.swing.JFrame {

    /**/
    private books ref_books = new books();
    private reserve ref_reserve = new reserve();
    /**/

    public JF_Administrator_Books() {
        initComponents();

        /**/
        jTableBooks_TableModel = (DefaultTableModel) jTableBooks.getModel();
        jTable_setShowHorizontalLines(jTableBooks);
        jTable_setTableHeader(jTableBooks);
        /**/
        // initialize_results_fill_jTableBooks();
        /**/
        SearchTextField1 = jTextField1.getText().trim().toString();
        SearchTextField2 = SearchTextField1 + " in " + jComboBox1.getSelectedItem().toString();
        jTextField1.setText(SearchTextField2);
        /**/

    }
    // ------------------------------------------------------------------------ []
    private String SearchTextField1;
    private String SearchTextField2;
    private DefaultTableModel jTableBooks_TableModel;
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
        getSelectedRowCount_jTableBooks();
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
        getSelectedRowCount_jTableBooks();
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
            fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
            if (Database._function_getConnection(Database._booksreservation) != null) {
                limit_first = limit_first += limit_second;
                limit_second = limit_min_results;
                fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                check_setEnable();
            }
        }
    }

    private void click_previous() {
        getSelectedRowCount_jTableBooks();
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
            fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    /**/
    public void initialize_results_fill_jTableBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                int limitresults = jSpinner_limitresults.getValue().hashCode(); // get the limit display list
                limit_min_results = limitresults; // store in the limit_min_results




                String search_in = jComboBox1.getSelectedItem().toString();
                switch (search_in) {
                    case "Books":
                        max_results_query = ref_books.guest_count_select_by_search_in_books(this.getSearchTextField_Keyword(), conn);
                        break;
                    case "Category":
                        max_results_query = ref_books.guest_count_select_by_search_in_category(this.getSearchTextField_Keyword(), conn);
                        break;
                    case "Author":
                        max_results_query = ref_books.guest_count_select_by_search_int_authors(this.getSearchTextField_Keyword(), conn);
                        break;
                    case "Publisher":
                        max_results_query = ref_books.guest_count_select_by_search_int_publishers(this.getSearchTextField_Keyword(), conn);
                        break;
                    default:
                        break;
                }


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
                fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
                /* check the jTableBooks */
                check_setEnable();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._booksreservation.getConnection() != null) {
                    initialize_results_fill_jTableBooks();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void fill_jTableBooks(String search, int limit_first, int limit_second, Connection conn) {
        try {
            jTableBooks_TableModel.setRowCount(0);
            /**/
            String search_in = jComboBox1.getSelectedItem().toString();
            int CountListResults = 0;
            switch (search_in) {
                case "Books":
                    CountListResults = ref_books.guest_select_books_information_by_search_in_books(search, limit_first, limit_second, conn);
                    break;
                case "Category":
                    CountListResults = ref_books.guest_select_books_information_by_search_in_category(search, limit_first, limit_second, conn);
                    break;
                case "Author":
                    CountListResults = ref_books.guest_select_books_information_by_search_in_authors(search, limit_first, limit_second, conn);
                    break;
                case "Publisher":
                    CountListResults = ref_books.guest_select_books_information_by_search_in_publishers(search, limit_first, limit_second, conn);
                    break;
                default:
                    break;
            }

//               int listCount = ref_books.select_all_by_search(search, limit_first, limit_second, conn);
            for (int i = 0; i < books.getData().size(); i++) {
                jTableBooks_TableModel.addRow((Vector) books.getData().get(i));
                if (jTableBooks.getRowCount() == 1) {
                    limit_first += 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(limit_first) + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                } else {
                    int get_limit_first = limit_first--;
                    int get_rowCount = jTableBooks.getRowCount();
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
    public void getSelectedRowCount_jTableBooks() {
        try {
            int getSelectedRowCount = jTableBooks.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jButtonReturn.setEnabled(false);
                jButtonBorrow.setEnabled(false);
                jButtonViewInfo.setEnabled(false);
            } else if (getSelectedRowCount == 1) {
                jButtonReturn.setEnabled(false);
                jButtonBorrow.setEnabled(true);
                jButtonViewInfo.setEnabled(true);
                /**/
                // show_reservedMembers();
                // show_borrowedMembers();
                /* check if the total reservation of the selecte books is greater than the reaming copy of it */
                int selectedColumn = function_getColumnNumber_jTable("idbooks", jTableBooks);
                int selectedRow = jTableBooks.getSelectedRow();
                int idbooks = jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();
                Connection conn = Database._function_getConnection(Database._booksreservation);
                if (conn != null) {
                    boolean isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy = ref_books.function_is_total_reserved_greater_than_or_equal_to_the_remaining_copy_of_the_books(idbooks, conn);
                    if (isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy) {
                        jButtonBorrow.setEnabled(false);
                    } else {
                        jButtonBorrow.setEnabled(true);
                    }
                } else {
                    Database._open_JD_MySQLConnect(Database._booksreservation);
                    if (Database._booksreservation.getConnection() != conn) {
                    }
                }

            } else if (getSelectedRowCount > 1) {
                jButtonReturn.setEnabled(false);
                jButtonBorrow.setEnabled(false);
                jButtonViewInfo.setEnabled(false);
            } else {
            }


        } catch (Exception e) {
            System.err.println(e);
        }

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
    protected TableCellRenderer createAuthorPublisherColumnRenderer() {
        return new AuthorPublisherColumnRenderer(new JLabel());
    }
    /**/
    private static final ImageIcon IconTrue_isborrowable = new ImageIcon(Main.class.getResource("icons/1_16x16_isborrowable_true.png"));
    private static final ImageIcon IconFalse_isborrowable = new ImageIcon(Main.class.getResource("icons/1_16x16_isborrowable_false.png"));

    protected TableCellRenderer createIsBorrowableColumnRenderer() {
        return new IsBorrowableColumnRenderer();
    }

    protected class IsBorrowableColumnRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setText("");
            setHorizontalAlignment(SwingConstants.CENTER);
            /* set the icon based on the passed status */
            boolean status = (Boolean) value;
            setIcon(status ? IconTrue_isborrowable : IconFalse_isborrowable);
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBooks = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
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
        jPanel4 = new javax.swing.JPanel();
        jButtonViewInfo = new javax.swing.JButton();
        jButtonCancelReservation = new javax.swing.JButton();
        jButtonBorrow = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(538, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(553, 450));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jTableBooks.setAutoCreateRowSorter(true);
        jTableBooks.setBackground(new java.awt.Color(153, 0, 0));
        jTableBooks.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableBooks.setForeground(new java.awt.Color(255, 255, 255));
        jTableBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idbooks", "Publisher", "Author", "Title", "Pages", "Description", "Language", "Copies", "Out", "In", "Reserved", "Loanable", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBooks.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableBooks.setRowHeight(24);
        jTableBooks.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTableBooks);
        jTableBooks.getColumnModel().getColumn(0).setMinWidth(0);
        jTableBooks.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableBooks.getColumnModel().getColumn(1).setMinWidth(0);
        jTableBooks.getColumnModel().getColumn(1).setPreferredWidth(0);
        jTableBooks.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableBooks.getColumnModel().getColumn(1).setCellRenderer(createAuthorPublisherColumnRenderer());
        jTableBooks.getColumnModel().getColumn(2).setMinWidth(0);
        jTableBooks.getColumnModel().getColumn(2).setPreferredWidth(0);
        jTableBooks.getColumnModel().getColumn(2).setMaxWidth(0);
        jTableBooks.getColumnModel().getColumn(2).setCellRenderer(createAuthorPublisherColumnRenderer());
        jTableBooks.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTableBooks.getColumnModel().getColumn(4).setMinWidth(60);
        jTableBooks.getColumnModel().getColumn(4).setMaxWidth(60);
        jTableBooks.getColumnModel().getColumn(5).setPreferredWidth(300);
        jTableBooks.getColumnModel().getColumn(6).setMinWidth(0);
        jTableBooks.getColumnModel().getColumn(6).setMaxWidth(0);
        jTableBooks.getColumnModel().getColumn(7).setMinWidth(70);
        jTableBooks.getColumnModel().getColumn(7).setMaxWidth(70);
        jTableBooks.getColumnModel().getColumn(8).setMinWidth(50);
        jTableBooks.getColumnModel().getColumn(8).setMaxWidth(50);
        jTableBooks.getColumnModel().getColumn(9).setMinWidth(50);
        jTableBooks.getColumnModel().getColumn(9).setMaxWidth(50);
        jTableBooks.getColumnModel().getColumn(10).setMinWidth(70);
        jTableBooks.getColumnModel().getColumn(10).setMaxWidth(70);
        jTableBooks.getColumnModel().getColumn(11).setMinWidth(80);
        jTableBooks.getColumnModel().getColumn(11).setMaxWidth(80);
        jTableBooks.getColumnModel().getColumn(11).setCellRenderer(createIsBorrowableColumnRenderer());
        jTableBooks.getColumnModel().getColumn(12).setPreferredWidth(150);

        jSplitPane1.setLeftComponent(jScrollPane1);
        jSplitPane1.setRightComponent(jTabbedPane1);

        jPanel8.add(jSplitPane1);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Books", "Category", "Author", "Publisher" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(96, 22));
        jComboBox1.setPreferredSize(new java.awt.Dimension(98, 22));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel6.add(jComboBox1);

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
        jTextField1.setText("Search");
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
        jLabel_Record.setText("     Record 1-2 of 2");
        jLabel_Record.setPreferredSize(new java.awt.Dimension(200, 18));
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

        jPanel3.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setFloatable(false);

        jPanel4.setMinimumSize(new java.awt.Dimension(95, 270));
        jPanel4.setPreferredSize(new java.awt.Dimension(10, 55));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jButtonViewInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_ViewInformation.png"))); // NOI18N
        jButtonViewInfo.setText("<html>\n<head>\n</head>\n<body>\n<div align=\"center\"><strong></strong>\n</div>\n</body>\n</html>\n");
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
        jPanel4.add(jButtonViewInfo);

        jButtonCancelReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_CancelReservation.png"))); // NOI18N
        jButtonCancelReservation.setToolTipText("Cancel Reservation");
        jButtonCancelReservation.setFocusable(false);
        jButtonCancelReservation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelReservation.setIconTextGap(0);
        jButtonCancelReservation.setMargin(new java.awt.Insets(3, 14, 2, 14));
        jButtonCancelReservation.setMaximumSize(new java.awt.Dimension(85, 75));
        jButtonCancelReservation.setMinimumSize(new java.awt.Dimension(85, 75));
        jButtonCancelReservation.setPreferredSize(new java.awt.Dimension(80, 44));
        jPanel4.add(jButtonCancelReservation);

        jButtonBorrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_BorrowBooks.png"))); // NOI18N
        jButtonBorrow.setToolTipText("Borrow Books");
        jButtonBorrow.setFocusable(false);
        jButtonBorrow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBorrow.setIconTextGap(0);
        jButtonBorrow.setMargin(new java.awt.Insets(3, 14, 2, 14));
        jButtonBorrow.setMaximumSize(new java.awt.Dimension(85, 75));
        jButtonBorrow.setMinimumSize(new java.awt.Dimension(85, 75));
        jButtonBorrow.setPreferredSize(new java.awt.Dimension(80, 44));
        jPanel4.add(jButtonBorrow);

        jButtonReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_36x36_ReturnBooks.png"))); // NOI18N
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
        jPanel4.add(jButtonReturn);

        jToolBar1.add(jPanel4);

        jPanel3.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        if (jCheckBox1.isSelected()) { // auto search
            if (jTextField1.getText().trim().toString().equals(SearchTextField2)) { // if empty in the textfield
                SearchTextField2 = SearchTextField1 + " in " + jComboBox1.getSelectedItem().toString();
                jTextField1.setText(SearchTextField2);
                /**/
                this.setSearchTextField_Keyword("".toString());
                initialize_results_fill_jTableBooks();
            } else {
                this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                initialize_results_fill_jTableBooks();
            }
        } else { // not auto search
            if (jTextField1.getText().trim().toString().equals(SearchTextField2)) { // if empty in the textfield
                SearchTextField2 = SearchTextField1 + " in " + jComboBox1.getSelectedItem().toString();
                jTextField1.setText(SearchTextField2);
                /**/
                this.setSearchTextField_Keyword("".toString());
                initialize_results_fill_jTableBooks();
            } else {
                this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                initialize_results_fill_jTableBooks();
            }
        }

        /**/
        int author_ColumnNumber = function_getColumnNumber_jTable("Author", jTableBooks);
        int publisher_ColumnNumber = function_getColumnNumber_jTable("Publisher", jTableBooks);
        String search_in = jComboBox1.getSelectedItem().toString();
        switch (search_in) {
            case "Author":
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setPreferredWidth(200);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMinWidth(15);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMaxWidth(800);

                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMaxWidth(0);
                break;
            case "Publisher":
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMaxWidth(0);

                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setPreferredWidth(200);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMinWidth(15);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMaxWidth(800);

                break;
            default:
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMaxWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMaxWidth(0);
                break;
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
                    initialize_results_fill_jTableBooks();
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
                initialize_results_fill_jTableBooks();
            } else {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        //                              JIF_Guest.setSearchBook_Keyword(jTextField1.getText().trim().toString());
                        this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                        initialize_results_fill_jTableBooks();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 27: // IF HIT 'SCAPE' KEY
                        jTextField1.setText("");
                        this.setSearchTextField_Keyword(jTextField1.getText().trim().toString());
                        initialize_results_fill_jTableBooks();
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
            initialize_results_fill_jTableBooks();
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

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReturnActionPerformed

    private void jButtonViewInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewInfoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Administrator_Books().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonBorrow;
    public javax.swing.JButton jButtonCancelReservation;
    public javax.swing.JButton jButtonReturn;
    public javax.swing.JButton jButtonViewInfo;
    public javax.swing.JButton jButton_FirstRecord;
    public javax.swing.JButton jButton_LastRecord;
    public javax.swing.JButton jButton_NextRecord;
    public javax.swing.JButton jButton_PreviousRecord;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Record;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JSpinner jSpinner_limitresults;
    private javax.swing.JSplitPane jSplitPane1;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableBooks;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
