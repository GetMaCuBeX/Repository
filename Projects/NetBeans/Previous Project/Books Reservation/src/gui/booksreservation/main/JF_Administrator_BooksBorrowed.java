package gui.booksreservation.main;

import java.awt.Color;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import mcbx.jb.classes.database.booksreservation.borrow;
import mcbx.jb.classes.databaseconnection.Database;

public class JF_Administrator_BooksBorrowed extends javax.swing.JFrame {

    private borrow ref_borrow = new borrow();
    private int idbooks_borrow = 0;

    public int getIdbooks_borrow() {
        return idbooks_borrow;
    }

    public void setIdbooks_borrow(int idbooks_borrow) {
        this.idbooks_borrow = idbooks_borrow;
    }

    public JF_Administrator_BooksBorrowed() {
        initComponents();
        jTableMembers_TableModel = (DefaultTableModel) jTableBorrowed.getModel();
        jTable_setShowHorizontalLines(jTableBorrowed);
        jTable_setTableHeader(jTableBorrowed);

    }
// ------------------------------------------------------------------------ []
    private DefaultTableModel jTableMembers_TableModel;
    private int max_results_query = 1;
    private int limit_min_results = 1;
    private int click_previous = 0;
    private int click_next = 0;
    private int count_total = 0;
    public int limit_first = 0;
    public int limit_second = 1;

    private void check_setEnable() {
        getSelectedRowCount_jTableBorrowed();
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
        getSelectedRowCount_jTableBorrowed();
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
            fill_jTableMembers(this.getIdbooks_borrow(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
            if (Database._function_getConnection(Database._booksreservation) != null) {
                limit_first = limit_first += limit_second;
                limit_second = limit_min_results;
                fill_jTableMembers(this.getIdbooks_borrow(), limit_first, limit_second, conn);
                check_setEnable();
            }
        }
    }

    private void click_previous() {
        getSelectedRowCount_jTableBorrowed();
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
            fill_jTableMembers(this.getIdbooks_borrow(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    /**/
    public void initialize_results_fill_jTableBorrowed() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                int limitresults = jSpinner_limitresults.getValue().hashCode(); // get the limit display list
                limit_min_results = limitresults; // store in the limit_min_results

                max_results_query = ref_borrow.administrator_count_information_by_idbooks_borrow_history_and_status_is_borrowed(this.getIdbooks_borrow(), conn);

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
                fill_jTableMembers(this.getIdbooks_borrow(), limit_first, limit_second, conn);
                /* check the jTableBooks */
                check_setEnable();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._booksreservation.getConnection() != null) {
                    initialize_results_fill_jTableBorrowed();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }



    }

    public void fill_jTableMembers(int idbooks_borrow, int limit_first, int limit_second, Connection conn) {
        try {
            jTableMembers_TableModel.setRowCount(0);
            /**/
            int CountListResults;
            CountListResults = ref_borrow.administrator_select_information_by_idbooks_borrow_history_and_status_is_borrowed(idbooks_borrow, limit_first, limit_second, conn);
            for (int i = 0; i < borrow.getData().size(); i++) {
                jTableMembers_TableModel.addRow((Vector) borrow.getData().get(i));
                if (jTableBorrowed.getRowCount() == 1) {
                    limit_first += 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(limit_first) + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                } else {
                    int get_limit_first = limit_first--;
                    int get_rowCount = jTableBorrowed.getRowCount();
                    int records = (get_rowCount + get_limit_first) - 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(++limit_first) + " - " + records + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                }

            }

            if (CountListResults == 0) {
                jLabel_Record.setText(" Record (" + 0 + ") of " + 0 + "");
            }
        } catch (Exception e) {
            System.err.println(e);
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
    public void getSelectedRowCount_jTableBorrowed() {
        int getSelectedRowCount = jTableBorrowed.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
        } else if (getSelectedRowCount == 1) {
        } else if (getSelectedRowCount > 1) {
        } else {
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
            System.err.println(e);
        }
        return get_columnNumber;
    }

    // ------------------------------------------------------------------------ []
    protected TableCellRenderer createMembersIDNumberColumnRenderer() {
        return new MembersIDNumberRenderer(new JLabel());
    }

    protected TableCellRenderer createJCalendarColumnRenderer() {
//          return new JCalendarRenderer(new JPanel());
        return new JCalendarRenderer_Borrow(new JLabel());
//          return new JCalendarRenderer(new JTextArea());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBorrowed = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel_Record = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinner_limitresults = new javax.swing.JSpinner();
        jButton_FirstRecord = new javax.swing.JButton();
        jButton_PreviousRecord = new javax.swing.JButton();
        jButton_NextRecord = new javax.swing.JButton();
        jButton_LastRecord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableBorrowed.setAutoCreateRowSorter(true);
        jTableBorrowed.setBackground(new java.awt.Color(153, 0, 0));
        jTableBorrowed.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableBorrowed.setForeground(new java.awt.Color(255, 255, 255));
        jTableBorrowed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idborrow", "ID Number", "Student Name", "Barcode", "Title", "Borrowed Date", "Due Date", "Copies", "Fines", "Remarks", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBorrowed.setRowHeight(24);
        jTableBorrowed.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTableBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBorrowedMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableBorrowedMouseReleased(evt);
            }
        });
        jTableBorrowed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableBorrowedKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBorrowed);
        jTableBorrowed.getColumnModel().getColumn(0).setMinWidth(0);
        jTableBorrowed.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableBorrowed.getColumnModel().getColumn(1).setMinWidth(100);
        jTableBorrowed.getColumnModel().getColumn(1).setMaxWidth(100);
        jTableBorrowed.getColumnModel().getColumn(1).setCellRenderer(createMembersIDNumberColumnRenderer());
        jTableBorrowed.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTableBorrowed.getColumnModel().getColumn(2).setMaxWidth(250);
        jTableBorrowed.getColumnModel().getColumn(3).setMinWidth(0);
        jTableBorrowed.getColumnModel().getColumn(3).setMaxWidth(0);
        jTableBorrowed.getColumnModel().getColumn(4).setMinWidth(0);
        jTableBorrowed.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableBorrowed.getColumnModel().getColumn(5).setMinWidth(120);
        jTableBorrowed.getColumnModel().getColumn(5).setMaxWidth(120);
        jTableBorrowed.getColumnModel().getColumn(5).setCellRenderer(createJCalendarColumnRenderer());
        jTableBorrowed.getColumnModel().getColumn(6).setMinWidth(120);
        jTableBorrowed.getColumnModel().getColumn(6).setMaxWidth(120);
        jTableBorrowed.getColumnModel().getColumn(6).setCellRenderer(createJCalendarColumnRenderer());
        jTableBorrowed.getColumnModel().getColumn(7).setMinWidth(60);
        jTableBorrowed.getColumnModel().getColumn(7).setMaxWidth(60);
        jTableBorrowed.getColumnModel().getColumn(8).setMinWidth(80);
        jTableBorrowed.getColumnModel().getColumn(8).setMaxWidth(80);
        jTableBorrowed.getColumnModel().getColumn(9).setPreferredWidth(150);
        jTableBorrowed.getColumnModel().getColumn(10).setPreferredWidth(150);

        jPanel8.add(jScrollPane1);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel_Record.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Record.setText(" Record (0) of 0");
        jLabel_Record.setPreferredSize(new java.awt.Dimension(86, 18));
        jPanel11.add(jLabel_Record, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel11);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Limit Results");
        jPanel7.add(jLabel1);

        jSpinner_limitresults.setModel(new javax.swing.SpinnerNumberModel(5, 1, 1000, 1));
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

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableBorrowedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBorrowedMouseClicked
        int buttonChoice = evt.getButton();
        switch (buttonChoice) {
            case 1: // IF MOUSE IS LEFT CLICKED
                break;
            case 2:
                break;
            case 3: // IF MOUSE IS RIGHT CLICKED
                if (!evt.isPopupTrigger()) {
                    getSelectedRowCount_jTableBorrowed();

                    //                         jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                }

                break;
            default: // IF MOUSE IS !RIGHTCLICK
                break;
        }
    }//GEN-LAST:event_jTableBorrowedMouseClicked

    private void jTableBorrowedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBorrowedMouseReleased
        int buttonChoice = evt.getButton();
        switch (buttonChoice) {
            case 1: // IF MOUSE IS LEFT CLICKED
                getSelectedRowCount_jTableBorrowed();
                break;
            case 2:
                break;
            case 3: // IF MOUSE IS RIGHT CLICKED

                break;
            default: // IF MOUSE IS !RIGHTCLICK
                break;
        }
    }//GEN-LAST:event_jTableBorrowedMouseReleased

    private void jTableBorrowedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableBorrowedKeyReleased
        int keyCode = evt.getKeyCode();
        switch (keyCode) {
            case 10: // IF HIT 'ENTER' KEY
                getSelectedRowCount_jTableBorrowed();
                break;
            case 32: // IF HIT 'SPACE' KEY
                break;
            case 127: // IF HIT 'DELETE' KEY
                System.out.println("Delete");
                break;
            default:
                getSelectedRowCount_jTableBorrowed();
                break;
        }
    }//GEN-LAST:event_jTableBorrowedKeyReleased

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        int buttonChoice = evt.getButton();
        switch (buttonChoice) {
            case 1: // IF MOUSE IS LEFT CLICKED
                break;
            case 2:
                break;
            case 3: // IF MOUSE IS RIGHT CLICKED
                if (!evt.isPopupTrigger()) {
                    getSelectedRowCount_jTableBorrowed();
                    //                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                }
                break;
            default: // IF MOUSE IS !RIGHTCLICK
                break;
        }
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jSpinner_limitresultsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_limitresultsStateChanged
        try {
            //               JIF_Guest.setSearchBook_keyword(jTextField1.getText().trim().toString());
            initialize_results_fill_jTableBorrowed();
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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_BooksBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_BooksBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_BooksBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_BooksBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Administrator_BooksBorrowed().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_FirstRecord;
    public javax.swing.JButton jButton_LastRecord;
    public javax.swing.JButton jButton_NextRecord;
    public javax.swing.JButton jButton_PreviousRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Record;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSpinner jSpinner_limitresults;
    public javax.swing.JTable jTableBorrowed;
    // End of variables declaration//GEN-END:variables
}
