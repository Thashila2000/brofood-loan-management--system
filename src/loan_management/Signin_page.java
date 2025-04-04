/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loan_management;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Signin_page extends javax.swing.JFrame {

    /**
     * Creates new form loan2
     */
    public Signin_page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        u_name_txt = new app.bolivia.swing.JCTextField();
        clear_btn = new rojeru_san.complementos.RSButtonHover();
        login_btn1 = new rojeru_san.complementos.RSButtonHover();
        status_lbl = new javax.swing.JLabel();
        pw_txt = new javax.swing.JPasswordField();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        ancel_btn = new rojeru_san.complementos.RSButtonHover();
        reset_pw_btn = new rojeru_san.complementos.RSButtonHover();

        jLabel4.setFont(new java.awt.Font("MS PGothic", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setFont(new java.awt.Font("MS PGothic", 0, 30)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel3.setFont(new java.awt.Font("MS PGothic", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");

        jLabel5.setFont(new java.awt.Font("MS PGothic", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User name :");

        u_name_txt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        u_name_txt.setPlaceholder("Enter user name");
        u_name_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                u_name_txtKeyPressed(evt);
            }
        });

        clear_btn.setBackground(new java.awt.Color(204, 0, 51));
        clear_btn.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        clear_btn.setText("Clear");
        clear_btn.setColorHover(new java.awt.Color(255, 102, 102));
        clear_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_btnMouseClicked(evt);
            }
        });
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        login_btn1.setBackground(new java.awt.Color(51, 204, 0));
        login_btn1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        login_btn1.setText("Log in");
        login_btn1.setColorHover(new java.awt.Color(255, 102, 102));
        login_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_btn1MouseClicked(evt);
            }
        });
        login_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btn1ActionPerformed(evt);
            }
        });

        status_lbl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N

        pw_txt.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N

        rSButtonHover1.setBackground(new java.awt.Color(0, 51, 102));
        rSButtonHover1.setForeground(new java.awt.Color(0, 255, 255));
        rSButtonHover1.setText("Bro hot food and beverage loan management system");
        rSButtonHover1.setColorHover(new java.awt.Color(0, 51, 102));
        rSButtonHover1.setColorTextHover(new java.awt.Color(153, 0, 0));
        rSButtonHover1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 30)); // NOI18N
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
        ancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ancel_btnActionPerformed(evt);
            }
        });

        reset_pw_btn.setBackground(new java.awt.Color(0, 51, 102));
        reset_pw_btn.setText("Reset password");
        reset_pw_btn.setColorHover(new java.awt.Color(0, 51, 102));
        reset_pw_btn.setColorTextHover(new java.awt.Color(255, 153, 153));
        reset_pw_btn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        reset_pw_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset_pw_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(560, 560, 560)
                .addComponent(status_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(login_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(u_name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addComponent(pw_txt)))
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(reset_pw_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pw_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(status_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(reset_pw_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_btnActionPerformed

    private void login_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_btn1ActionPerformed

    private void login_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btn1MouseClicked
                                            
    String username = u_name_txt.getText();
    String password = new String(pw_txt.getPassword());

    if (username.equals("bro_food") && password.equals("1234")) {
        JOptionPane.showMessageDialog(this, "Login Successful!");
        this.dispose(); // Close the login window
        
        // Open HomePage
        Home_page home = new Home_page(); // Assuming HomePage is another JFrame
        home.setVisible(true);
    } else {
        status_lbl.setText("Invalid Username or Password!");
        status_lbl.setForeground(Color.RED);
    }
  

    }//GEN-LAST:event_login_btn1MouseClicked

    private void u_name_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u_name_txtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        pw_txt.requestFocus();
    }//GEN-LAST:event_u_name_txtKeyPressed
    }
    private void clear_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_btnMouseClicked
        u_name_txt.setText("");
        pw_txt.setText("");
    }//GEN-LAST:event_clear_btnMouseClicked

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void ancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ancel_btnMouseClicked
        this.dispose();
    }//GEN-LAST:event_ancel_btnMouseClicked

    private void ancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ancel_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ancel_btnActionPerformed

    private void reset_pw_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_pw_btnMouseClicked
        Password_reset pr = new Password_reset();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reset_pw_btnMouseClicked
    
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
            java.util.logging.Logger.getLogger(Signin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover ancel_btn;
    private java.awt.Canvas canvas1;
    private rojeru_san.complementos.RSButtonHover clear_btn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private rojeru_san.complementos.RSButtonHover login_btn1;
    private javax.swing.JPasswordField pw_txt;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover reset_pw_btn;
    private javax.swing.JLabel status_lbl;
    private app.bolivia.swing.JCTextField u_name_txt;
    // End of variables declaration//GEN-END:variables
}
