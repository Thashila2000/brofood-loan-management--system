/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loan_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class payment_details_page extends javax.swing.JFrame {

    /**
     * Creates new form payment_details_page
     */
    public payment_details_page() {
        initComponents();
        payment_details();
    }
    
      DefaultTableModel model;
     
    //fetching data from payment)details table to j table
     public void payment_details(){
          try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#");
        String query = "SELECT name, tot_loan_amount, paid_amount, due_amount, status, paid_date  FROM payment_details"; // Fetch only required columns
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Get table model
        model = (DefaultTableModel) payments_tbl.getModel();
        
        // **Clear existing rows to refresh the table**
        model.setRowCount(0); 

        // Fetch and add new data
        while (rs.next()) {
            String name = rs.getString("name");
            double tot_loan = rs.getDouble("tot_loan_amount");
            double paid_amount = rs.getDouble("paid_amount");
            double due_amount = rs.getDouble("due_amount");
            String status = rs.getString("status");
            String paid_date = rs.getString("paid_date");

            Object[] obj = {name, tot_loan, paid_amount, due_amount, status, paid_date};
            model.addRow(obj);
        }

        // Close connections
        rs.close();
        pst.close();
        conn.close();
        
        // **Force table update**
        model.fireTableDataChanged(); 

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
       //method to search field
         public void search(String str){
           model=(DefaultTableModel)payments_tbl.getModel();
           TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
           payments_tbl.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
           trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
       }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPopuMenu1 = new rojeru_san.complementos.RSPopuMenu();
        jPanel1 = new javax.swing.JPanel();
        search_txt = new app.bolivia.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        payments_tbl = new rojeru_san.complementos.RSTableMetro();
        ancel_btn = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        back_btn = new rojeru_san.complementos.RSButtonHover();
        cancel_btn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        search_txt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        search_txt.setPlaceholder("Enter ID or name");
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_txtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        payments_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Total loan amount", "Paid amount", "Due amount", "Status", "Paid date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        payments_tbl.setColorBackgoundHead(new java.awt.Color(0, 204, 0));
        payments_tbl.setColorFilasBackgound1(new java.awt.Color(255, 153, 153));
        payments_tbl.setColorFilasBackgound2(new java.awt.Color(153, 153, 255));
        payments_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 204));
        payments_tbl.setColorFilasForeground2(new java.awt.Color(0, 0, 204));
        payments_tbl.setColorSelBackgound(new java.awt.Color(0, 51, 204));
        payments_tbl.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        payments_tbl.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        payments_tbl.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        payments_tbl.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        payments_tbl.setRowHeight(40);
        jScrollPane1.setViewportView(payments_tbl);

        ancel_btn.setBackground(new java.awt.Color(0, 51, 102));
        ancel_btn.setText("X");
        ancel_btn.setColorHover(new java.awt.Color(0, 51, 102));
        ancel_btn.setColorTextHover(new java.awt.Color(153, 0, 0));
        ancel_btn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 50)); // NOI18N
        ancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ancel_btnActionPerformed(evt);
            }
        });

        rSButtonHover2.setBackground(new java.awt.Color(0, 51, 102));
        rSButtonHover2.setText("Payment details");
        rSButtonHover2.setColorHover(new java.awt.Color(0, 51, 102));
        rSButtonHover2.setColorTextHover(new java.awt.Color(255, 51, 51));
        rSButtonHover2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 40)); // NOI18N

        back_btn.setBackground(new java.awt.Color(0, 51, 102));
        back_btn.setText("<");
        back_btn.setColorHover(new java.awt.Color(0, 51, 102));
        back_btn.setColorTextHover(new java.awt.Color(153, 0, 0));
        back_btn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 70)); // NOI18N
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_btnMouseClicked(evt);
            }
        });
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        cancel_btn.setBackground(new java.awt.Color(0, 51, 102));
        cancel_btn.setText("X");
        cancel_btn.setColorHover(new java.awt.Color(0, 51, 102));
        cancel_btn.setColorTextHover(new java.awt.Color(153, 0, 0));
        cancel_btn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 50)); // NOI18N
        cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_btnMouseClicked(evt);
            }
        });
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(876, 876, 876)
                        .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1172, Short.MAX_VALUE)
                .addComponent(ancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(ancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2830, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtKeyPressed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
      String searcString=search_txt.getText();
      search(searcString);
    }//GEN-LAST:event_search_txtKeyReleased

    private void ancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ancel_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ancel_btnActionPerformed

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
       Home_page hp = new Home_page();
       hp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_back_btnMouseClicked

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancel_btnMouseClicked
    
   
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
            java.util.logging.Logger.getLogger(payment_details_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment_details_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment_details_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment_details_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment_details_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover ancel_btn;
    private rojeru_san.complementos.RSButtonHover back_btn;
    private rojeru_san.complementos.RSButtonHover cancel_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro payments_tbl;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSPopuMenu rSPopuMenu1;
    private app.bolivia.swing.JCTextField search_txt;
    // End of variables declaration//GEN-END:variables
}
