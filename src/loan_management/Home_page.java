/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loan_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class Home_page extends javax.swing.JFrame {

    /**
     * Creates new form Home_page
     */
      DefaultTableModel model;
    
      public Home_page() {
        initComponents();
        loan_details();
    }
    
    public void loan_details(){
          try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#");
            String query = "SELECT name, amount FROM loans_check"; // Fetch only required columns
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                String name = rs.getString("name");
                double amount = rs.getDouble("amount"); 

               Object[] obj={name,amount};
                    model=(DefaultTableModel)loan_tbl.getModel();
                    model.addRow(obj);
                
            }

            // Close connections
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //method to search field
        public void search(String str){
           model=(DefaultTableModel)loan_tbl.getModel();
           TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
           loan_tbl.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
           trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
       }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loan_tbl = new rojeru_san.complementos.RSTableMetro();
        cancel_btn = new javax.swing.JLabel();
        search_txt = new app.bolivia.swing.JCTextField();
        jPanel1 = new javax.swing.JPanel();
        add_loan_btn = new rojeru_san.complementos.RSButtonHover();
        loandetails_btn = new rojeru_san.complementos.RSButtonHover();
        add_member_btn = new rojeru_san.complementos.RSButtonHover();
        payment_details_btn = new rojeru_san.complementos.RSButtonHover();
        logout_btn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        loan_tbl.setBackground(new java.awt.Color(0, 51, 51));
        loan_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Total Loan Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        loan_tbl.setColorBackgoundHead(new java.awt.Color(0, 204, 51));
        loan_tbl.setColorFilasBackgound1(new java.awt.Color(255, 153, 153));
        loan_tbl.setColorFilasBackgound2(new java.awt.Color(153, 153, 255));
        loan_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 204));
        loan_tbl.setColorFilasForeground2(new java.awt.Color(0, 51, 204));
        loan_tbl.setColorSelBackgound(new java.awt.Color(0, 0, 204));
        loan_tbl.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loan_tbl.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loan_tbl.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        loan_tbl.setGridColor(new java.awt.Color(204, 204, 255));
        loan_tbl.setRowHeight(40);
        loan_tbl.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(loan_tbl);

        cancel_btn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 50)); // NOI18N
        cancel_btn.setForeground(new java.awt.Color(153, 0, 0));
        cancel_btn.setText("X");
        cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_btnMouseClicked(evt);
            }
        });

        search_txt.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        search_txt.setPlaceholder("Enter ID or Name");
        search_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_txtActionPerformed(evt);
            }
        });
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        add_loan_btn.setBackground(new java.awt.Color(102, 0, 102));
        add_loan_btn.setText("Manage loans");
        add_loan_btn.setColorHover(new java.awt.Color(255, 153, 153));
        add_loan_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_loan_btnMouseClicked(evt);
            }
        });

        loandetails_btn.setBackground(new java.awt.Color(102, 0, 102));
        loandetails_btn.setText("Loan details");
        loandetails_btn.setColorHover(new java.awt.Color(255, 153, 153));
        loandetails_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loandetails_btnMouseClicked(evt);
            }
        });
        loandetails_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loandetails_btnActionPerformed(evt);
            }
        });

        add_member_btn.setBackground(new java.awt.Color(102, 0, 102));
        add_member_btn.setText("Add member ");
        add_member_btn.setColorHover(new java.awt.Color(255, 153, 153));
        add_member_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_member_btnMouseClicked(evt);
            }
        });

        payment_details_btn.setBackground(new java.awt.Color(102, 0, 102));
        payment_details_btn.setText("Payment details");
        payment_details_btn.setColorHover(new java.awt.Color(255, 153, 153));
        payment_details_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payment_details_btnMouseClicked(evt);
            }
        });
        payment_details_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                payment_details_btnKeyPressed(evt);
            }
        });

        logout_btn.setBackground(new java.awt.Color(102, 0, 102));
        logout_btn.setText("Log out");
        logout_btn.setColorHover(new java.awt.Color(255, 153, 153));
        logout_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_member_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loandetails_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payment_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_loan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(add_member_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(add_loan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(loandetails_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(payment_details_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297)
                        .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1550, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseClicked
         System.exit(0);
    }//GEN-LAST:event_cancel_btnMouseClicked

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void add_member_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_member_btnMouseClicked
        AddMember_page ap = new AddMember_page();
        ap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_add_member_btnMouseClicked

    private void add_loan_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_loan_btnMouseClicked
        add_loan al = new add_loan();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_add_loan_btnMouseClicked

    private void payment_details_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payment_details_btnKeyPressed
        AddMember_page ap = new AddMember_page();
        ap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_payment_details_btnKeyPressed

    private void payment_details_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_details_btnMouseClicked
        payment_details_page pd = new payment_details_page();
        pd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_payment_details_btnMouseClicked

    private void loandetails_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loandetails_btnMouseClicked
        Loan_details ld = new Loan_details();
        ld.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loandetails_btnMouseClicked

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
      String searcString=search_txt.getText();
      search(searcString);
    }//GEN-LAST:event_search_txtKeyReleased

    private void logout_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseClicked
        Signin_page si = new Signin_page();
        si.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logout_btnMouseClicked

    private void loandetails_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loandetails_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loandetails_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover add_loan_btn;
    private rojeru_san.complementos.RSButtonHover add_member_btn;
    private javax.swing.JLabel cancel_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro loan_tbl;
    private rojeru_san.complementos.RSButtonHover loandetails_btn;
    private rojeru_san.complementos.RSButtonHover logout_btn;
    private rojeru_san.complementos.RSButtonHover payment_details_btn;
    private app.bolivia.swing.JCTextField search_txt;
    // End of variables declaration//GEN-END:variables
}
