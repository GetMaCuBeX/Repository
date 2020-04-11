package gui.booksreservation.main;

import java.awt.Color;
import java.awt.Component;
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
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.databaseconnection.Database;

public class JF_Guest extends javax.swing.JFrame {


    /**/
    private static books ref_books = new books();

    public JF_Guest() {
        initComponents();
        /**/
        jTableBooks_TableModel = (DefaultTableModel) jTableBooks.getModel();
        jTable_setShowHorizontalLines(jTableBooks);
        jTable_setTableHeader(jTableBooks);
        /**/
        initialize_results_fill_jTableBooks();
//          getSelectedRowCount_jTableBooks();
          /**/

        SearchTextField1 = jTextField1.getText().trim().toString();
        SearchTextField2 = SearchTextField1 + " in " + jComboBox1.getSelectedItem().toString();
        jTextField1.setText(SearchTextField2);
        /**/

    }
    // ------------------------------------------------------------------------ []
//     private static DefaultTableModel jTableBooks_TableModel;
//     public static String SearchTextField_Keyword = "";
    private String SearchTextField1;
    private String SearchTextField2;
//     public static String getSearchBook_keyword() {
//          return SearchTextField_Keyword;
//     }
//
//     public static void setSearchBook_Keyword(String SearchTextField_Keyword) {
//          JIF_Guest.SearchTextField_Keyword = SearchTextField_Keyword;
//     }
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
    private int limit_first = 0;
    private int limit_second = 1;

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
//               fill_jTableBooks(JIF_Guest.getSearchBook_keyword(), limit_first, limit_second, conn);
            fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
            if (Database._function_getConnection(Database._booksreservation) != null) {
                limit_first = limit_first += limit_second;
                limit_second = limit_min_results;
//                    fill_jTableBooks(JIF_Guest.getSearchBook_keyword(), limit_first, limit_second, conn);
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
//               fill_jTableBooks(JIF_Guest.getSearchBook_keyword(), limit_first, limit_second, conn);
            fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    /**/
    private void initialize_results_fill_jTableBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                int limitresults = jSpinner_limitresults.getValue().hashCode(); // get the limit display list
                limit_min_results = limitresults; // store in the limit_min_results
//                    max_results_query = ref_books.count_select_search(JIF_Guest.getSearchBook_keyword(), conn);

                /**/
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


//                    max_results_query = ref_books.count_select_search(this.getSearchTextField_Keyword(), conn);
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
//                    fill_jTableBooks(JIF_Guest.getSearchBook_keyword(), limit_first, limit_second, conn);
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

    private void fill_jTableBooks(String search, int limit_first, int limit_second, Connection conn) {
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
        int getSelectedRowCount = jTableBooks.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
        } else if (getSelectedRowCount == 1) {
        } else if (getSelectedRowCount > 1) {
        } else {
        }
    }

    private int function_getColumnNumber_jTable(String jTableColumn_Name, JTable jTable_Name) {
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
    private static final ImageIcon IconTrue_isborrowable = new ImageIcon(JF_Guest.class.getResource("icons/1_16x16_isborrowable_true.png"));
    private static final ImageIcon IconFalse_isborrowable = new ImageIcon(JF_Guest.class.getResource("icons/1_16x16_isborrowable_false.png"));

    protected TableCellRenderer createIsBorrowableColumnRenderer() {
        return new IsBorrowableColumnRenderer();
    }

    protected static class IsBorrowableColumnRenderer extends DefaultTableCellRenderer {

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

        jPopupMenuCategory = new javax.swing.JPopupMenu();
        jCheckBoxMenuItemBooks = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemAuthors = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemPulishers = new javax.swing.JCheckBoxMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
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
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBooks = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel_Record = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        jCheckBoxMenuItemBooks.setSelected(true);
        jCheckBoxMenuItemBooks.setText("jCheckBoxMenuItem1");
        jPopupMenuCategory.add(jCheckBoxMenuItemBooks);

        jCheckBoxMenuItemAuthors.setSelected(true);
        jCheckBoxMenuItemAuthors.setText("jCheckBoxMenuItem1");
        jPopupMenuCategory.add(jCheckBoxMenuItemAuthors);

        jCheckBoxMenuItemPulishers.setSelected(true);
        jCheckBoxMenuItemPulishers.setText("jCheckBoxMenuItem1");
        jPopupMenuCategory.add(jCheckBoxMenuItemPulishers);

        jButton1.setText("jButton1");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jFrame1.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUEST");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0));

        buttonGroup1.add(jToggleButton1);
        jToggleButton1.setSelected(true);
        jToggleButton1.setText("Books");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setPreferredSize(new java.awt.Dimension(105, 50));
        jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton1ItemStateChanged(evt);
            }
        });
        jPanel4.add(jToggleButton1);

        buttonGroup1.add(jToggleButton2);
        jToggleButton2.setText("Category");
        jToggleButton2.setFocusable(false);
        jToggleButton2.setPreferredSize(new java.awt.Dimension(105, 50));
        jToggleButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton2ItemStateChanged(evt);
            }
        });
        jPanel4.add(jToggleButton2);

        buttonGroup1.add(jToggleButton3);
        jToggleButton3.setText("Author");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setPreferredSize(new java.awt.Dimension(105, 50));
        jToggleButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton3ItemStateChanged(evt);
            }
        });
        jPanel4.add(jToggleButton3);

        buttonGroup1.add(jToggleButton4);
        jToggleButton4.setText("Publisher");
        jToggleButton4.setFocusable(false);
        jToggleButton4.setPreferredSize(new java.awt.Dimension(105, 50));
        jToggleButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton4ItemStateChanged(evt);
            }
        });
        jPanel4.add(jToggleButton4);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Books", "Category", "Author", "Publisher" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(90, 22));
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Limit Results");
        jPanel7.add(jLabel1);

        jSpinner_limitresults.setModel(new javax.swing.SpinnerNumberModel(10, 1, 1000, 1));
        jSpinner_limitresults.setPreferredSize(new java.awt.Dimension(60, 20));
        jSpinner_limitresults.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_limitresultsStateChanged(evt);
            }
        });
        jPanel7.add(jSpinner_limitresults);

        jButton_FirstRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcbx/jb/icons/booksreservation/1_8x8_First.png"))); // NOI18N
        jButton_FirstRecord.setFocusable(false);
        jButton_FirstRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_FirstRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_FirstRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FirstRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_FirstRecord);

        jButton_PreviousRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcbx/jb/icons/booksreservation/1_8x8_Previous.png"))); // NOI18N
        jButton_PreviousRecord.setFocusable(false);
        jButton_PreviousRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_PreviousRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PreviousRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_PreviousRecord);

        jButton_NextRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcbx/jb/icons/booksreservation/1_8x8_Next.png"))); // NOI18N
        jButton_NextRecord.setFocusable(false);
        jButton_NextRecord.setMargin(new java.awt.Insets(3, 2, 2, 2));
        jButton_NextRecord.setPreferredSize(new java.awt.Dimension(21, 20));
        jButton_NextRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NextRecordActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_NextRecord);

        jButton_LastRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcbx/jb/icons/booksreservation/1_8x8_Last.png"))); // NOI18N
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
        jPanel9.add(jSeparator2);

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableBooks.setAutoCreateRowSorter(true);
        jTableBooks.setBackground(new java.awt.Color(153, 0, 0));
        jTableBooks.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableBooks.setForeground(new java.awt.Color(255, 255, 255));
        jTableBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
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
        jTableBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBooksMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableBooksMouseReleased(evt);
            }
        });
        jTableBooks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableBooksKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBooks);
        jTableBooks.getColumnModel().getColumn(0).setMinWidth(0);
        jTableBooks.getColumnModel().getColumn(0).setPreferredWidth(0);
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
        jTableBooks.getColumnModel().getColumn(6).setPreferredWidth(0);
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

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel_Record.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Record.setText(" Record 1-2 of 2");
        jLabel_Record.setPreferredSize(new java.awt.Dimension(86, 18));
        jPanel11.add(jLabel_Record, java.awt.BorderLayout.CENTER);
        jPanel11.add(jSeparator3, java.awt.BorderLayout.PAGE_START);

        jPanel10.add(jPanel11);

        jPanel2.add(jPanel10, java.awt.BorderLayout.PAGE_END);

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

                // Author
                jToggleButton3.setSelected(true);
                break;
            case "Publisher":
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMaxWidth(0);

                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setPreferredWidth(200);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMinWidth(15);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMaxWidth(800);

                // Publisher
                jToggleButton4.setSelected(true);
                break;

            default:
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(author_ColumnNumber).setMaxWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setPreferredWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMinWidth(0);
                jTableBooks.getColumnModel().getColumn(publisher_ColumnNumber).setMaxWidth(0);
                
                // Books or Category
                if("Books".equals(search_in)){
                    jToggleButton1.setSelected(true);
                } else{
                    jToggleButton2.setSelected(true);
                }
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
                    jPopupMenuCategory.show(evt.getComponent(), jTextField1.getX() - jTextField1.getX(), jTextField1.getHeight());
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

    private void jTableBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBooksMouseClicked
        int buttonChoice = evt.getButton();
        switch (buttonChoice) {
            case 1: // IF MOUSE IS LEFT CLICKED
                break;
            case 2:
                break;
            case 3: // IF MOUSE IS RIGHT CLICKED
                if (!evt.isPopupTrigger()) {
                    getSelectedRowCount_jTableBooks();
                    switch (UserLogs.getMembertype()) {
                        case "Student":
                            break;
                        case "Administrator":
                            break;
                        default:
                            break;
                    }
                    //                         jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                }

                break;
            default: // IF MOUSE IS !RIGHTCLICK
                break;
        }
    }//GEN-LAST:event_jTableBooksMouseClicked

    private void jTableBooksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBooksMouseReleased
        int buttonChoice = evt.getButton();
        switch (buttonChoice) {
            case 1: // IF MOUSE IS LEFT CLICKED
                getSelectedRowCount_jTableBooks();
                break;
            case 2:
                break;
            case 3: // IF MOUSE IS RIGHT CLICKED

                break;
            default: // IF MOUSE IS !RIGHTCLICK
                break;
        }
    }//GEN-LAST:event_jTableBooksMouseReleased

    private void jTableBooksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableBooksKeyReleased
        int keyCode = evt.getKeyCode();
        switch (keyCode) {
            case 10: // IF HIT 'ENTER' KEY
                getSelectedRowCount_jTableBooks();
                break;
            case 32: // IF HIT 'SPACE' KEY
                break;
            default:
                getSelectedRowCount_jTableBooks();
                break;
        }
    }//GEN-LAST:event_jTableBooksKeyReleased

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        int buttonChoice = evt.getButton();
        switch (buttonChoice) {
            case 1: // IF MOUSE IS LEFT CLICKED
                break;
            case 2:
                break;
            case 3: // IF MOUSE IS RIGHT CLICKED
                if (!evt.isPopupTrigger()) {
                    getSelectedRowCount_jTableBooks();
                    switch (UserLogs.getMembertype()) {
                        case "Student":
                            break;
                        case "Administrator":
                            break;
                        default:
                            break;
                    }
                    //                         jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                }
                break;
            default: // IF MOUSE IS !RIGHTCLICK
                break;
        }
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton1ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton1ItemStateChanged

    private void jToggleButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton2ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton2ItemStateChanged

    private void jToggleButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton3ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton3ItemStateChanged

    private void jToggleButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton4ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton4ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Guest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_FirstRecord;
    private javax.swing.JButton jButton_LastRecord;
    private javax.swing.JButton jButton_NextRecord;
    private javax.swing.JButton jButton_PreviousRecord;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemAuthors;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemBooks;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemPulishers;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Record;
    private javax.swing.JList jList1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenuCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner_limitresults;
    private javax.swing.JTable jTableBooks;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables

    private void itemStateChange() {

        /* Books */
        if (jToggleButton1.isSelected()) {
            jComboBox1.setSelectedIndex(0);
        } else {
        }
        /* Students */
        if (jToggleButton2.isSelected()) {
            jComboBox1.setSelectedIndex(1);
        } else {
        }
        /* Records */
        if (jToggleButton3.isSelected()) {
            jComboBox1.setSelectedIndex(2);
        } else {
        }
        /* Reports */
        if (jToggleButton4.isSelected()) {
            jComboBox1.setSelectedIndex(3);
        } else {
        }
    }
}
