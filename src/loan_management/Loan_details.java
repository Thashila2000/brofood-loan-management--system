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
public class Loan_details extends javax.swing.JFrame {

    /**
     * Creates new form Loan_details
     */
    public Loan_details() {
        initComponents();
        loan_details();
    }
    
    DefaultTableModel model;
     
     //fetching data from payment)details table to j table
     public void loan_details(){
          try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#");
        String query = "SELECT name, amount, loan_date  FROM loans"; // Fetch only required columns
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Get table model
        model = (DefaultTableModel) loans_tbl.getModel();
        
        // **Clear existing rows to refresh the table**
        model.setRowCount(0); 

        // Fetch and add new data
        while (rs.next()) {
            String name = rs.getString("name");
            double amount = rs.getDouble("amount");
            String date = rs.getString("loan_date");

            Object[] obj = {name, amount, date};
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
           model=(DefaultTableModel)loans_tbl.getModel();
           TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
           loans_tbl.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
           trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
       }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        search_txt = new app.bolivia.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        loans_tbl = new rojeru_san.complementos.RSTableMetro();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        ancel_btn = new rojeru_san.complementos.RSButtonHover();
        back_btn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

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

        loans_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Loan amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        loans_tbl.setColorBackgoundHead(new java.awt.Color(0, 204, 0));
        loans_tbl.setColorFilasBackgound1(new java.awt.Color(255, 153, 153));
        loans_tbl.setColorFilasBackgound2(new java.awt.Color(153, 153, 255));
        loans_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 204));
        loans_tbl.setColorFilasForeground2(new java.awt.Color(0, 0, 204));
        loans_tbl.setColorSelBackgound(new java.awt.Color(0, 51, 204));
        loans_tbl.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loans_tbl.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loans_tbl.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loans_tbl.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loans_tbl.setRowHeight(40);
        jScrollPane1.setViewportView(loans_tbl);

        rSButtonHover1.setBackground(new java.awt.Color(0, 51, 102));
        rSButtonHover1.setText("Loan details");
        rSButtonHover1.setColorHover(new java.awt.Color(0, 51, 102));
        rSButtonHover1.setColorTextHover(new java.awt.Color(255, 51, 51));
        rSButtonHover1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 40)); // NOI18N
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        ancel_btn.setBackground(new java.awt.Color(0, 51, 102));
        ancel_btn.setText("X");
        ancel_btn.setColorHover(new java.awt.Color(0, 51, 102));
        ancel_btn.setColorTextHover(new java.awt.Color(153, 0, 0));
        ancel_btn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 50)); // NOI18N
        ancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ancel_btnMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 248, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1646, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtKeyPressed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        String searcString=search_txt.getText();
        search(searcString);
    }//GEN-LAST:event_search_txtKeyReleased

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void ancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ancel_btnMouseClicked
        this.dispose();
    }//GEN-LAST:event_ancel_btnMouseClicked

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
        Home_page hp = new Home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnMouseClicked

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
            java.util.logging.Logger.getLogger(Loan_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loan_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loan_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loan_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loan_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover ancel_btn;
    private rojeru_san.complementos.RSButtonHover back_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro loans_tbl;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private app.bolivia.swing.JCTextField search_txt;
    // End of variables declaration//GEN-END:variables
}
