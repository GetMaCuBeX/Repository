package gui.booksreservation.main;

import java.awt.Color;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mcbx.jb.classes.database.booksreservation.authors;
import mcbx.jb.classes.database.booksreservation.booksauthors;
import mcbx.jb.classes.database.booksreservation.bookssubjects;
import mcbx.jb.classes.database.booksreservation.subjects;
import mcbx.jb.classes.databaseconnection.Database;

public class JD_Subjects extends javax.swing.JDialog {

    /**/
    private subjects ref_subjects = new subjects();
    private bookssubjects ref_bookssubjects = new bookssubjects();
    /**/
    private DefaultTableModel jTableSubjects_TableModel;
    /**/
    private int edit_idsubjects = 1;
    public String searchSubject_keyword = "";

    public int getEdit_idsubjects() {
        return edit_idsubjects;
    }

    public void setEdit_idsubjects(int edit_idsubjects) {
        this.edit_idsubjects = edit_idsubjects;
    }

    public String getSearchSubject_keyword() {
        return searchSubject_keyword;
    }

    public void setSearchSubject_keyword(String searchSubject_keyword) {
        this.searchSubject_keyword = searchSubject_keyword;
    }
    private int max_results_query = 0;
    private int limit_min_results = 1;
    private int click_previous = 0;
    private int click_next = 0;
    private int count_total = 0;
    public int limit_first = 0;
    public int limit_second = 1;

    private void check_setEnable() {
        getSelectedRowCount_jTableSubjects();
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
        getSelectedRowCount_jTableSubjects();
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
            fill_jTableSubjects(this.getSearchSubject_keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    private void click_previous() {
        getSelectedRowCount_jTableSubjects();
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
            fill_jTableSubjects(this.getSearchSubject_keyword(), limit_first, limit_second, conn);
            check_setEnable();
        } else {
            Database._open_JD_MySQLConnect(Database._booksreservation);
        }
    }

    public JD_Subjects(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /**/
        jTableSubjects_TableModel = (DefaultTableModel) jTableSubjects.getModel();
        jTable_setShowHorizontalLines(jTableSubjects);
        jTable_setTableHeader(jTableSubjects);
        /**/
        initialize_results_fill_jTableSubjects();


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
    private static int function_getColumnNumber_jTable(String jTableColumn_Name, JTable jTable_Name) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem_addToBooksInformation = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jDialog1_Add = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDialog1_Update = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel_Record = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneSubjects = new javax.swing.JScrollPane();
        jTableSubjects = new javax.swing.JTable();

        jPopupMenu1.setForeground(java.awt.Color.white);

        jMenuItem_addToBooksInformation.setText("Add selected subject(s) to books information");
        jMenuItem_addToBooksInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_addToBooksInformationActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem_addToBooksInformation);
        jPopupMenu1.add(jSeparator4);

        jMenuItem2.setText("Add New Subject");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem4.setText("Update Selected Subject");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setText("Delete Selected Subject(s)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);
        jPopupMenu1.add(jSeparator2);

        jMenuItem3.setText("Refresh");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jDialog1_Add.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1_Add.setTitle("Add New Subject");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Subject Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jDialog1_Add.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("Add");
        jButton1.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jToolBar1.add(jPanel3);

        jDialog1_Add.getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jDialog1_Update.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1_Update.setTitle("Update Subjection");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Subject Name:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDialog1_Update.getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        jToolBar2.setFloatable(false);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton3.setText("Update");
        jButton3.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);

        jButton4.setText("Close");
        jButton4.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4);

        jToolBar2.add(jPanel8);

        jDialog1_Update.getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Subjects");
        setMinimumSize(new java.awt.Dimension(550, 250));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel_Record.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Record.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Record.setText(" Record 1-2 of 2");
        jLabel_Record.setPreferredSize(new java.awt.Dimension(86, 18));
        jPanel4.add(jLabel_Record, java.awt.BorderLayout.CENTER);
        jPanel4.add(jSeparator3, java.awt.BorderLayout.PAGE_START);

        jPanel10.add(jPanel4);

        jPanel12.add(jPanel10, java.awt.BorderLayout.PAGE_END);

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

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(0, 4, 0, 4));
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 19));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel6.add(jTextField1);

        jPanel9.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("     Limit Results");
        jPanel7.add(jLabel1);

        jSpinner_limitresults.setModel(new javax.swing.SpinnerNumberModel(10, 1, 1000, 1));
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

        jPanel9.add(jPanel7);

        jPanel12.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPaneSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneSubjectsMouseClicked(evt);
            }
        });

        jTableSubjects.setBackground(new java.awt.Color(153, 0, 0));
        jTableSubjects.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableSubjects.setForeground(new java.awt.Color(255, 255, 255));
        jTableSubjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
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
        jTableSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSubjectsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSubjectsMouseReleased(evt);
            }
        });
        jTableSubjects.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSubjectsKeyReleased(evt);
            }
        });
        jScrollPaneSubjects.setViewportView(jTableSubjects);
        jTableSubjects.getColumnModel().getColumn(0).setMinWidth(0);
        jTableSubjects.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableSubjects.getColumnModel().getColumn(1).setMinWidth(0);
        jTableSubjects.getColumnModel().getColumn(1).setPreferredWidth(80);

        jPanel2.add(jScrollPaneSubjects, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
     }//GEN-LAST:event_formKeyReleased

     private void jTableSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSubjectsMouseClicked
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
                     getSelectedRowCount_jTableSubjects();
                     jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                 }
                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jTableSubjectsMouseClicked

     private void jTableSubjectsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSubjectsMouseReleased
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
     }//GEN-LAST:event_jTableSubjectsMouseReleased

     private void jTableSubjectsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSubjectsKeyReleased
         int keyCode = evt.getKeyCode();
         switch (keyCode) {
             case 10: // IF HIT 'ENTER' KEY
                 getSelectedRowCount_jTableSubjects();
                 break;
             case 32: // IF HIT 'SPACE' KEY
                 break;
             default:
                 getSelectedRowCount_jTableSubjects();
                 break;
         }
     }//GEN-LAST:event_jTableSubjectsKeyReleased

     private void jScrollPaneSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneSubjectsMouseClicked
         int buttonChoice = evt.getButton();
         switch (buttonChoice) {
             case 1: // IF MOUSE IS LEFT CLICKED
                 break;
             case 2:
                 break;
             case 3: // IF MOUSE IS RIGHT CLICKED
                 if (!evt.isPopupTrigger()) {
                     getSelectedRowCount_jTableSubjects();
                     jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                 }
                 break;
             default: // IF MOUSE IS !RIGHTCLICK
                 break;
         }
     }//GEN-LAST:event_jScrollPaneSubjectsMouseClicked

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
                 this.setSearchSubject_keyword(jTextField1.getText().trim().toString());
                 initialize_results_fill_jTableSubjects();
             } else {
             }
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jCheckBox1ActionPerformed

     private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
         try {
             int keyCode = evt.getKeyCode();
             if (jCheckBox1.isSelected()) { // auto search
                 switch (keyCode) {
                     case 27: // IF HIT 'SCAPE' KEY
                         jTextField1.setText("");
                         break;
                     default:
                         break;
                 }
                 this.setSearchSubject_keyword(jTextField1.getText().trim().toString());
                 initialize_results_fill_jTableSubjects();
             } else {
                 switch (keyCode) {
                     case 10: // IF HIT 'ENTER' KEY
                         this.setSearchSubject_keyword(jTextField1.getText().trim().toString());
                         initialize_results_fill_jTableSubjects();
                         break;
                     case 32: // IF HIT 'SPACE' KEY
                         break;
                     case 27: // IF HIT 'SCAPE' KEY
                         jTextField1.setText("");
                         initialize_results_fill_jTableSubjects();
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
             initialize_results_fill_jTableSubjects();
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

     private void jMenuItem_addToBooksInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addToBooksInformationActionPerformed
//          addSelectedAuthorsToBooksInformation_Array();
     }//GEN-LAST:event_jMenuItem_addToBooksInformationActionPerformed

     private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

         addSubject();

     }//GEN-LAST:event_jMenuItem2ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
                 String subjectName_ = jTextField2.getText().trim().toString();
                 /**/
                 if (subjectName_.length() == 0) {
                     JOptionPane.showMessageDialog(jDialog1_Add, "The field Subjet Name must not be empty\nPlease try again", "Error", JOptionPane.ERROR_MESSAGE);
                 } else {
                     boolean isExist_subjectName = ref_subjects.function_is_name_exist(subjectName_, conn);
                     if (isExist_subjectName) {
                         JOptionPane.showMessageDialog(this, "The name you entered is already exist\nTry another name", "Error", JOptionPane.ERROR_MESSAGE);
                     } else {
                         ref_subjects.insert_subjects(new subjects(subjectName_), conn);
                         fill_jTableSubjects(conn);

                     }

                 }
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
             }
         } catch (Exception e) {
             System.err.println(e);
         }

     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         jDialog1_Add.dispose();

     }//GEN-LAST:event_jButton2ActionPerformed

     private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         updateSelectedSubject();
     }//GEN-LAST:event_jMenuItem4ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//          try {
//               Connection conn = Database._function_getConnection(Database._booksreservation);
//               if (conn != null) {
//                    String firstname_ = jTextField4.getText().trim().toString();
//                    /**/
//                    ref_authors.update_authors(edit_idauthors, new authors(firstname_, lastname_, contactinformation), conn);
//                    fill_jTableAuthors(this.getSearchAuthor_keyword(), limit_first, limit_second, conn);
//                    this.setIsNeedRefresh(true);
//               } else {
//                    Database._open_JD_MySQLConnect(Database._booksreservation);
//               }
//          } catch (Exception e) {
//               System.err.println(e);
//          }
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         jDialog1_Update.dispose();
     }//GEN-LAST:event_jButton4ActionPerformed

     private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         deleteSelectedSubjects();
     }//GEN-LAST:event_jMenuItem5ActionPerformed

     private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

         refreshSubjectsInformation();
     }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(JD_Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Subjects dialog = new JD_Subjects(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_FirstRecord;
    private javax.swing.JButton jButton_LastRecord;
    private javax.swing.JButton jButton_NextRecord;
    private javax.swing.JButton jButton_PreviousRecord;
    private javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JDialog jDialog1_Add;
    public javax.swing.JDialog jDialog1_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Record;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JMenuItem jMenuItem_addToBooksInformation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JScrollPane jScrollPaneSubjects;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSpinner jSpinner_limitresults;
    public javax.swing.JTable jTableSubjects;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

// ----------------------------------------------------------------------------- [QUERY INFORMATION]   
    private void initialize_results_fill_jTableSubjects() {
        try {
            /**/
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                /**/
                int limitresults = jSpinner_limitresults.getValue().hashCode(); // get the limit display list
                limit_min_results = limitresults; // store in the limit_min_results
                max_results_query = ref_subjects.count_select_search(this.getSearchSubject_keyword(), conn);
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
                fill_jTableSubjects(this.getSearchSubject_keyword(), limit_first, limit_second, conn);
                /* check the jTableBooks */
                check_setEnable();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void fill_jTableSubjects(Connection conn) {
        try {
            initialize_results_fill_jTableSubjects();
//            fill_jTableSubjects(this.getSearchSubject_keyword(), limit_first, limit_second, conn);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void fill_jTableSubjects(String search, int limit_first, int limit_second, Connection conn) {
        try {
            jTableSubjects_TableModel.setRowCount(0);
            int listCount = ref_subjects.select_by_search(search, limit_first, limit_second, conn);
            for (int i = 0; i < subjects.getData().size(); i++) {
                jTableSubjects_TableModel.addRow((Vector) subjects.getData().get(i));
                if (jTableSubjects.getRowCount() == 1) {
                    limit_first += 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(limit_first) + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                } else {
                    int get_limit_first = limit_first--;
                    int get_rowCount = jTableSubjects.getRowCount();
                    int records = (get_rowCount + get_limit_first) - 1;
                    jLabel_Record.setText(" Record (" + NumberFormat.getIntegerInstance().format(++limit_first) + " - " + records + ") of " + NumberFormat.getIntegerInstance().format(max_results_query) + "");
                }

            }
            if (listCount == 0) {
                jLabel_Record.setText(" Record " + 0 + " of " + 0 + "");
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    public void getSelectedRowCount_jTableSubjects() {
//        int getSelectedRowCount = jTableSubjects.getSelectedRowCount();
//        if (getSelectedRowCount == 0) {
//            jMenuItem_addToBooksInformation.setEnabled(false);
//            jMenuItem4.setEnabled(false);
//            jMenuItem5.setEnabled(false);
//            /**/
//        } else if (getSelectedRowCount == 1) {
//            /**/
//            jMenuItem_addToBooksInformation.setEnabled(true);
//            jMenuItem4.setEnabled(true);
//            jMenuItem5.setEnabled(true);
//        } else if (getSelectedRowCount > 1) {
//            /**/
//            jMenuItem_addToBooksInformation.setEnabled(true);
//            jMenuItem4.setEnabled(false);
//            jMenuItem5.setEnabled(true);
//        } else {
//        }
        
    }

    /**/
    private void addSelectedAuthorsToBooksInformation_Array() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idbooks_ = this.getEdit_idsubjects();
                int s_idsubjects[];
                s_idsubjects = jTableSubjects.getSelectedRows();
                for (int c = 0; c < jTableSubjects.getColumnCount(); c++) {
                    String columnName = jTableSubjects.getColumnName(c);
                    if ("idsubjects".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < s_idsubjects.length; r++) {
                            s_idsubjects[r] = jTableSubjects.getValueAt(s_idsubjects[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (s_idsubjects.length > 0) {
                    ref_bookssubjects.insert_bookssubjects(s_idsubjects, idbooks_, conn);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    private void addSubject() {
        jDialog1_Add.setSize(jDialog1_Add.getPreferredSize());
        jDialog1_Add.setLocationRelativeTo(this);
        jDialog1_Add.setAlwaysOnTop(true);
        jDialog1_Add.setModal(true);
        jDialog1_Add.setVisible(true);
    }

    /**/
    private void updateSelectedSubject() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int selectedColumn = function_getColumnNumber_jTable("idsubjects", jTableSubjects);
                int selectedRow = jTableSubjects.getSelectedRow();
                /**/
                jDialog1_Update.setSize(jDialog1_Update.getPreferredSize());
                jDialog1_Update.setLocationRelativeTo(this);
                jDialog1_Update.setAlwaysOnTop(true);
                jDialog1_Update.setModal(true);
                /**/
                edit_idsubjects = jTableSubjects.getValueAt(selectedRow, selectedColumn).hashCode();
                jTextField4.setText(ref_subjects.function_get_name(edit_idsubjects, conn));

                jDialog1_Update.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    private void deleteSelectedSubjects() {
        JOptionPane pane = new JOptionPane(
                "<html>"
                + /*
                 "<head>"+
                 "<style type=\"text/css\">"+
                 "b { font: 13pt \"Lucida Grande\" }"+
                 "p { font: 11pt \"Lucida Grande\"; margin-top: 8px }"+
                 "</style>"+
                 "</head>"+*/ "Delete selected Subject(s)?",
                JOptionPane.QUESTION_MESSAGE);
        Object[] options = {"Cancel", "Delete"};
        pane.setOptions(options);
        pane.setInitialValue(null);
        JDialog dialog = pane.createDialog(this, "Warning!");
        dialog.setVisible(true);
        analyzeValueConfirmDeleteSubjects_Array(pane.getValue());
    }

    private void analyzeValueConfirmDeleteSubjects_Array(Object value) {
        try {
            if (value.equals("Delete")) {
                delete_Subjects_Array();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void delete_Subjects_Array() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int s_idsubjects[];
                s_idsubjects = jTableSubjects.getSelectedRows();
                for (int c = 0; c < jTableSubjects.getColumnCount(); c++) {
                    String columnName = jTableSubjects.getColumnName(c);
                    if ("idsubjects".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < s_idsubjects.length; r++) {
                            s_idsubjects[r] = jTableSubjects.getValueAt(s_idsubjects[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (s_idsubjects.length > 0) {
                    ref_subjects.delete_subjects(s_idsubjects, conn);
                    fill_jTableSubjects(conn);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        getSelectedRowCount_jTableSubjects();
    }

    private void refreshSubjectsInformation() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                fill_jTableSubjects(conn);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
