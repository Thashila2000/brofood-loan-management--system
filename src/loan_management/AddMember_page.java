/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loan_management;


import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


/**
 *
 * @author ACER
 */
public class AddMember_page extends javax.swing.JFrame {

    /**
     * Creates new form Registration_page
     */
    public AddMember_page() {
        initComponents();
        registration_details();
    }

    DefaultTableModel model;

    public void registerUser() {
        String userId = id_txt.getText().trim();
        String name = name_txt.getText().trim();

        if (userId.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#")) {
            // Check if user already exists
            String checkQuery = "SELECT COUNT(*) FROM registration WHERE cus_id = ?";
            try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                checkStmt.setString(1, userId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "User ID already exists!");
                    return;
                }
            }

            // Insert new user
            String insertQuery = "INSERT INTO registration (cus_id, name) VALUES (?, ?)";
            try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                pst.setString(1, userId);
                pst.setString(2, name);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Registered Successfully!");
            }
            
            registration_details();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        }
    }
     
    //fetching data from registration table to j table
     public void registration_details(){
          try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#");
        String query = "SELECT cus_id, name FROM registration"; // Fetch only required columns
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Get table model
        model = (DefaultTableModel) register_tbl.getModel();
        
        // **Clear existing rows to refresh the table**
        model.setRowCount(0); 

        // Fetch and add new data
        while (rs.next()) {
            String cus_id = rs.getString("cus_id");
            String name = rs.getString("name");

            Object[] obj = {cus_id, name};
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
     
     //update customer details 
    public void updateCustomerDetails() {
    String updatedId = id_txt.getText().trim(); // Get updated Customer ID
    String updatedName = name_txt.getText().trim(); // Get updated Name
    
    // Validate fields
    if (updatedId.isEmpty() || updatedName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill both fields before updating.");
        return;
    }

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#")) {
        String query = "UPDATE registration SET name = ? WHERE cus_id = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, updatedName);
            pst.setString(2, updatedId);
           

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Customer details updated successfully!");
                refreshTable(); // Refresh JTable after update
            } else {
                JOptionPane.showMessageDialog(this, "Update failed! Customer ID not found.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage());
    }
}
     
  //delete customer details 
   public void deleteCustomer() {
    int selectedRow = register_tbl.getSelectedRow(); // Get selected row index

    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        return;
    }

    String selectedId = register_tbl.getValueAt(selectedRow, 0).toString(); // Get cus_id from selected row

    int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this customer?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#")) {
            String query = "DELETE FROM registration WHERE cus_id = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, selectedId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
                    refreshTable(); // Refresh JTable after delete
                } else {
                    JOptionPane.showMessageDialog(this, "Delete failed! Customer not found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage());
        }
    }
}



     //to refresh jtable
    
    public void refreshTable() {
    DefaultTableModel model = (DefaultTableModel) register_tbl.getModel();
    model.setRowCount(0); // Clear the table
    registration_details(); // Reload data from the database
  }



    
 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        id_txt = new javax.swing.JTextField();
        register_btn = new rojeru_san.complementos.RSButtonHover();
        delete_btn = new rojeru_san.complementos.RSButtonHover();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        register_tbl = new rojeru_san.complementos.RSTableMetro();
        search_txt = new app.bolivia.swing.JCTextField();
        update_btn = new rojeru_san.complementos.RSButtonHover();
        clear_btn = new rojeru_san.complementos.RSButtonHover();
        back_btn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter user ID :");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter user name :");

        name_txt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_txtActionPerformed(evt);
            }
        });
        name_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name_txtKeyPressed(evt);
            }
        });

        id_txt.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        id_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_txtMouseClicked(evt);
            }
        });
        id_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_txtActionPerformed(evt);
            }
        });
        id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_txtKeyPressed(evt);
            }
        });

        register_btn.setBackground(new java.awt.Color(51, 204, 0));
        register_btn.setText("Register");
        register_btn.setColorHover(new java.awt.Color(255, 153, 153));
        register_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_btnMouseClicked(evt);
            }
        });
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(102, 102, 102));
        delete_btn.setText("Delete");
        delete_btn.setColorHover(new java.awt.Color(255, 153, 153));
        delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_btnMouseClicked(evt);
            }
        });
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add member page");

        register_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        register_tbl.setColorBackgoundHead(new java.awt.Color(0, 204, 0));
        register_tbl.setColorFilasBackgound1(new java.awt.Color(153, 153, 255));
        register_tbl.setColorFilasBackgound2(new java.awt.Color(255, 153, 153));
        register_tbl.setColorFilasForeground1(new java.awt.Color(0, 51, 204));
        register_tbl.setColorFilasForeground2(new java.awt.Color(0, 51, 204));
        register_tbl.setColorSelBackgound(new java.awt.Color(0, 0, 204));
        register_tbl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        register_tbl.setFuenteFilas(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        register_tbl.setFuenteFilasSelect(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        register_tbl.setFuenteHead(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        register_tbl.setRowHeight(40);
        register_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(register_tbl);

        search_txt.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        search_txt.setPlaceholder("Enter ID or name");
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

        update_btn.setBackground(new java.awt.Color(204, 0, 204));
        update_btn.setText("Update");
        update_btn.setColorHover(new java.awt.Color(255, 153, 153));
        update_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_btnMouseClicked(evt);
            }
        });
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        clear_btn.setBackground(new java.awt.Color(255, 0, 51));
        clear_btn.setText("Clear");
        clear_btn.setColorHover(new java.awt.Color(255, 153, 153));
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

        back_btn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 60)); // NOI18N
        back_btn.setForeground(new java.awt.Color(153, 0, 51));
        back_btn.setText("<");
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 590, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 1270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_txtActionPerformed

    private void id_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_txtActionPerformed

    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_btnActionPerformed

    private void register_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_btnMouseClicked
    registerUser();


    }//GEN-LAST:event_register_btnMouseClicked

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void update_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_btnMouseClicked
        updateCustomerDetails();
    }//GEN-LAST:event_update_btnMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_btnActionPerformed

    private void clear_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_btnMouseClicked
        name_txt.setText("");
        id_txt.setText("");
    }//GEN-LAST:event_clear_btnMouseClicked

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_btnActionPerformed

       //method to search field
       public void search(String str){
           model=(DefaultTableModel)register_tbl.getModel();
           TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
           register_tbl.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
       }
    
    
 
     
       
    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
   

    }//GEN-LAST:event_jPanel1KeyReleased

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
        Home_page hp = new Home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnMouseClicked

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_btnActionPerformed

    private void name_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_txtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        id_txt.requestFocus();
    }   
    }//GEN-LAST:event_name_txtKeyPressed

    private void register_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_tblMouseClicked
        // Get selected row index
    int selectedRow = register_tbl.getSelectedRow();

    if (selectedRow != -1) { // Ensure a row is selected
        // Retrieve data from the selected row (Column indexes start from 0)
        String customerId = register_tbl.getValueAt(selectedRow, 0).toString();
        String customerName = register_tbl.getValueAt(selectedRow, 1).toString();

        // Set values to text fields
        id_txt.setText(customerId);
        name_txt.setText(customerName);
    }
    }//GEN-LAST:event_register_tblMouseClicked

    private void delete_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_btnMouseClicked
        deleteCustomer() ;
    }//GEN-LAST:event_delete_btnMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
      String searcString=search_txt.getText();
      search(searcString);
    }//GEN-LAST:event_search_txtKeyReleased

    private void id_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_txtMouseClicked
        
    }//GEN-LAST:event_id_txtMouseClicked

    private void id_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_txtKeyPressed
       // Method to move cursor from cus_id_del_txt to loan_amount_txt on Enter key press
                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Check if Enter key is pressed
        name_txt.requestFocus(); // Move focus to loan_amount_txt
    }
    }//GEN-LAST:event_id_txtKeyPressed

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
            java.util.logging.Logger.getLogger(AddMember_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMember_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMember_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMember_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMember_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_btn;
    private rojeru_san.complementos.RSButtonHover clear_btn;
    private rojeru_san.complementos.RSButtonHover delete_btn;
    private javax.swing.JTextField id_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_txt;
    private rojeru_san.complementos.RSButtonHover register_btn;
    private rojeru_san.complementos.RSTableMetro register_tbl;
    private app.bolivia.swing.JCTextField search_txt;
    private rojeru_san.complementos.RSButtonHover update_btn;
    // End of variables declaration//GEN-END:variables
}
