package mcbx.jb.samples.forms;

public class JIF_OpenForms3 extends javax.swing.JInternalFrame {

    int count = 0;

    public JIF_OpenForms3() {
        initComponents();


//        this.getRootPane().setBackground(new Color(80, 80, 80, 80));

    }

    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();

          setClosable(true);
          setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
          setIconifiable(true);
          setResizable(true);
          setTitle("JInternalFrame 3");

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 277, Short.MAX_VALUE)
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 280, Short.MAX_VALUE)
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
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
