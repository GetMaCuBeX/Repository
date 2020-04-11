package mcbx.jb.samples.forms;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class JIF_OpenForms2 extends javax.swing.JInternalFrame {

    BasicInternalFrameUI _BasicInternalFrameUI = (BasicInternalFrameUI) getUI();
    int count = 0;

    public JIF_OpenForms2() {
        initComponents();

// ----------------------------------------------------------------------------- JInternalFrame
//        _BasicInternalFrameUI.setNorthPane(null);
//        _BasicInternalFrameUI.setEastPane(null);
//        _BasicInternalFrameUI.setWestPane(null);
//        _BasicInternalFrameUI.setSouthPane(null);
//        this.setBackground(new Color(80, 80, 80, 80));



    }

    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();

          setClosable(true);
          setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
          setIconifiable(true);
          setResizable(true);
          setTitle("JInternalFrame 2");
          setVisible(true);

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 345, Short.MAX_VALUE)
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 289, Short.MAX_VALUE)
          );

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JPanel jPanel1;
     // End of variables declaration//GEN-END:variables
}
