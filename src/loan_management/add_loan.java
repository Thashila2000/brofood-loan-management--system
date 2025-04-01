/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loan_management;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
public class add_loan extends javax.swing.JFrame {

    /**
     * Creates new form add_loan
     */
    
    
    
    public add_loan() {
        initComponents();
    }

  

    @SuppressWarnings("unchecked")
    
  //insert data in to loans table
    public void add_loans_table(){
    String name = name_txt.getText();
    String loan_amount = loan_txt.getText();
    LocalDate currentDate = LocalDate.now();
   

    if (name.isEmpty() || loan_amount.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields");
        return;
    }

    try  {
        // Insert into loans table with the current date
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#");
        try (PreparedStatement pst = con.prepareStatement(
                "INSERT INTO loans (name, amount, loan_date) VALUES (?, ?, ?)")) {
            pst.setString(1, name);
            pst.setDouble(2, Double.parseDouble(loan_amount));
            pst.setDate(3, java.sql.Date.valueOf(currentDate));
            pst.executeUpdate();
        }
      
     JOptionPane.showMessageDialog(this, "Loan Added successfully");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage());
    }

    }
    
   
    //insert data into loan_check table
    public void updateLoansCheck() {
    String customerName = name_txt.getText();
    String loanAmountStr = loan_txt.getText();

    if (customerName.isEmpty() || loanAmountStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter Name, and Loan Amount");
        return;
    }

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#")) {
        
        double loanAmount = Double.parseDouble(loanAmountStr);

        // Check if the customer already exists in loans_check
        String checkQuery = "SELECT amount FROM loans_check WHERE name = ?";
        double existingAmount = 0;
        boolean customerExists = false;

        try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
            checkStmt.setString(1, customerName);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                existingAmount = rs.getDouble("amount");
                customerExists = true;
            }
        }

        if (customerExists) {
            // If the customer exists, update the amount by adding the new loan
            String updateQuery = "UPDATE loans_check SET amount = amount + ? WHERE name = ?";
            try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
                updateStmt.setDouble(1, loanAmount);
                updateStmt.setString(2, customerName);
                updateStmt.executeUpdate();
            }
        } else {
            // If the customer does not exist, insert a new record
            String insertQuery = "INSERT INTO loans_check (name, amount) VALUES (?, ?)";
            try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
                insertStmt.setString(1, customerName);
                insertStmt.setDouble(2, loanAmount);
                insertStmt.executeUpdate();
            }
        }

        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loan_txt = new app.bolivia.swing.JCTextField();
        name_del_txt = new app.bolivia.swing.JCTextField();
        pay_amount_txt = new app.bolivia.swing.JCTextField();
        tot_loan_amount_txt = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        add_loan_txt = new rojeru_san.complementos.RSButtonHover();
        pay_loan_btn = new rojeru_san.complementos.RSButtonHover();
        clear_pay_btn = new rojeru_san.complementos.RSButtonHover();
        cal_loan_btn = new rojeru_san.complementos.RSButtonHover();
        jPanel3 = new javax.swing.JPanel();
        name_checktxt = new app.bolivia.swing.JCTextField();
        jPanel4 = new javax.swing.JPanel();
        clear_add_btn1 = new rojeru_san.complementos.RSButtonHover();
        clear_cal_btn = new rojeru_san.complementos.RSButtonHover();
        name_txt = new app.bolivia.swing.JCTextField();
        loan_txt1 = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ancel_btn = new rojeru_san.complementos.RSButtonHover();
        back_btn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 210, 50));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(">>>>");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 70, 50));

        loan_txt.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        loan_txt.setPlaceholder("Loan amount");
        jPanel1.add(loan_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 370, 50));

        name_del_txt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        name_del_txt.setPlaceholder("Name");
        name_del_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_del_txtActionPerformed(evt);
            }
        });
        name_del_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name_del_txtKeyPressed(evt);
            }
        });
        jPanel1.add(name_del_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 420, 50));

        pay_amount_txt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        pay_amount_txt.setPlaceholder("Pay amount");
        pay_amount_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_amount_txtActionPerformed(evt);
            }
        });
        jPanel1.add(pay_amount_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 420, 50));

        tot_loan_amount_txt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tot_loan_amount_txt.setPlaceholder("Total loan amount ");
        tot_loan_amount_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tot_loan_amount_txtActionPerformed(evt);
            }
        });
        jPanel1.add(tot_loan_amount_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 410, 320, 60));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter pay amount :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 200, 50));

        add_loan_txt.setBackground(new java.awt.Color(102, 0, 51));
        add_loan_txt.setText("ADD LOAN");
        add_loan_txt.setColorHover(new java.awt.Color(255, 51, 0));
        add_loan_txt.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        add_loan_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_loan_txtMouseClicked(evt);
            }
        });
        add_loan_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_loan_txtActionPerformed(evt);
            }
        });
        jPanel1.add(add_loan_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 160, -1));

        pay_loan_btn.setBackground(new java.awt.Color(51, 204, 0));
        pay_loan_btn.setText("PAY");
        pay_loan_btn.setColorHover(new java.awt.Color(255, 51, 0));
        pay_loan_btn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        pay_loan_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pay_loan_btnMouseClicked(evt);
            }
        });
        pay_loan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_loan_btnActionPerformed(evt);
            }
        });
        jPanel1.add(pay_loan_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 730, 160, -1));

        clear_pay_btn.setBackground(new java.awt.Color(102, 102, 255));
        clear_pay_btn.setText("Clear");
        clear_pay_btn.setColorHover(new java.awt.Color(255, 51, 0));
        clear_pay_btn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        clear_pay_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_pay_btnMouseClicked(evt);
            }
        });
        clear_pay_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_pay_btnActionPerformed(evt);
            }
        });
        jPanel1.add(clear_pay_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 730, 170, -1));

        cal_loan_btn.setBackground(new java.awt.Color(0, 204, 204));
        cal_loan_btn.setText("CALCULATE TOTAL LOAN AMOUNT");
        cal_loan_btn.setColorHover(new java.awt.Color(255, 102, 102));
        cal_loan_btn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        cal_loan_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cal_loan_btnMouseClicked(evt);
            }
        });
        cal_loan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal_loan_btnActionPerformed(evt);
            }
        });
        jPanel1.add(cal_loan_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 420, -1));

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1550, 10));

        name_checktxt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        name_checktxt.setPlaceholder("Enter customer name to see total loan amount");
        name_checktxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_checktxtActionPerformed(evt);
            }
        });
        jPanel1.add(name_checktxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 450, 60));

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1550, 10));

        clear_add_btn1.setBackground(new java.awt.Color(102, 102, 255));
        clear_add_btn1.setText("Clear");
        clear_add_btn1.setColorHover(new java.awt.Color(255, 51, 0));
        clear_add_btn1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        clear_add_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_add_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear_add_btn1MouseEntered(evt);
            }
        });
        clear_add_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_add_btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(clear_add_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 170, -1));

        clear_cal_btn.setBackground(new java.awt.Color(102, 102, 255));
        clear_cal_btn.setText("Clear");
        clear_cal_btn.setColorHover(new java.awt.Color(255, 51, 0));
        clear_cal_btn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        clear_cal_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_cal_btnMouseClicked(evt);
            }
        });
        clear_cal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_cal_btnActionPerformed(evt);
            }
        });
        jPanel1.add(clear_cal_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 170, -1));

        name_txt.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        name_txt.setPlaceholder("Name");
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
        jPanel1.add(name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 370, 50));

        loan_txt1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        loan_txt1.setPlaceholder("Loan amount");
        jPanel1.add(loan_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 370, 50));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Loan amount :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 180, 50));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter customer name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 230, 50));

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
        jPanel1.add(ancel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 20, 80, -1));

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
        jPanel1.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_del_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_del_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_del_txtActionPerformed
    
    //to check amount in loan_check table
    public void getLoanCheckAmount() {
      String customerName = name_checktxt.getText().trim(); // Get and trim the input

    if (customerName.isEmpty()) { 
        JOptionPane.showMessageDialog(null, "Please enter Customer name"); 
        return;
    }

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#")) {
        String query = "SELECT amount FROM loans_check WHERE name = ?";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, customerName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double amount = rs.getDouble("amount");
                tot_loan_amount_txt.setText(String.valueOf(amount)); // Set the value in the text box
            } else {
                tot_loan_amount_txt.setText(""); // Clear text box if no record found
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    
  

    
    private void pay_amount_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_amount_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_amount_txtActionPerformed

    private void name_checktxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_checktxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_checktxtActionPerformed

    private void tot_loan_amount_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tot_loan_amount_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tot_loan_amount_txtActionPerformed
    
    public void clear_add_loans_fields(){
       name_txt.setText("");
       loan_txt.setText("");  
    }
    private void add_loan_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_loan_txtMouseClicked
         updateLoansCheck();
         add_loans_table();
         clear_add_loans_fields();
         
    }//GEN-LAST:event_add_loan_txtMouseClicked

    private void cal_loan_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cal_loan_btnMouseClicked
        getLoanCheckAmount();
    }//GEN-LAST:event_cal_loan_btnMouseClicked

    private void pay_loan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_loan_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_loan_btnActionPerformed

    private void pay_loan_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pay_loan_btnMouseClicked
     //pay loan
    
    String customerName = name_del_txt.getText();
    String paidAmountStr = pay_amount_txt.getText();

    if (customerName.isEmpty() || paidAmountStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Customer Name and Paid Amount");
        return;
    }

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoanDB", "root", "thashila2000#");) {
        double totalLoanAmount = 0;
        
        
        // Retrieve total loan amount from total_loan table
        try (PreparedStatement pst = con.prepareStatement("SELECT amount FROM loans_check WHERE name = ?")) {
            pst.setString(1,customerName);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                totalLoanAmount = rs.getDouble("amount");
            } else {
                //JOptionPane.showMessageDialog(this, "Customer not found.");
                return;
            }
        }

        double paidAmount = Double.parseDouble(paidAmountStr);
        double dueAmount = totalLoanAmount - paidAmount;
        String status = (dueAmount == 0) ? "Paid" : "Must Pay";
        LocalDate paid_date=LocalDate.now();
        // Insert payment status into loan_pay table
        try (PreparedStatement pst = con.prepareStatement(
                "INSERT INTO payment_details (name, tot_loan_amount, paid_amount, due_amount, status, paid_date) VALUES (?, ?, ?, ?, ?,?)")) {
            pst.setString(1, customerName);
            pst.setDouble(2, totalLoanAmount);
            pst.setDouble(3, paidAmount);
            pst.setDouble(4, dueAmount);
            pst.setString(5, status);
            pst.setDate(6, java.sql.Date.valueOf(paid_date));

            pst.executeUpdate();
        }

        // Update loans_check table with new total loan amount
        try (PreparedStatement pst = con.prepareStatement(
                "UPDATE loans_check SET amount = ? WHERE name = ?")) {
            pst.setDouble(1, dueAmount);
            pst.setString(2, customerName);
            pst.executeUpdate();
        }
        
       // Update or delete records in the loans_check table
        if (dueAmount == 0) {
            // If due amount is 0, delete all loan records for this customer
            try (PreparedStatement pst = con.prepareStatement(
                    "DELETE FROM loans_check WHERE name = ?")) {
                pst.setString(1, customerName);
                pst.executeUpdate();
            }
        } else {
            // If there is a remaining balance, update the loan table accordingly
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE loans_check SET amount = ? WHERE name = ?")) {
                pst.setDouble(1, dueAmount);
                pst.setString(2, customerName);
                pst.executeUpdate();
            }
        }
        JOptionPane.showMessageDialog(this, "Paid Amount: " + paidAmount + "\nDue Amount: " + dueAmount);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
      clear_payment_fields();
    }//GEN-LAST:event_pay_loan_btnMouseClicked
    
    public void clear_payment_fields(){
       name_del_txt.setText("");
       pay_amount_txt.setText(""); 
    }
    
    private void clear_pay_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_pay_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_pay_btnActionPerformed

    private void add_loan_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_loan_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_loan_txtActionPerformed

    private void clear_pay_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_pay_btnMouseClicked
        
       name_del_txt.setText("");
       pay_amount_txt.setText("");
      
    }//GEN-LAST:event_clear_pay_btnMouseClicked

    private void clear_add_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_add_btn1MouseClicked
        
        name_txt.setText("");
        loan_txt.setText("");
       
    }//GEN-LAST:event_clear_add_btn1MouseClicked

    private void clear_add_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_add_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_add_btn1ActionPerformed

    private void clear_cal_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_cal_btnMouseClicked
        name_checktxt.setText("");
        tot_loan_amount_txt.setText("");
    }//GEN-LAST:event_clear_cal_btnMouseClicked

    private void clear_cal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_cal_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_cal_btnActionPerformed

    private void clear_add_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_add_btn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_add_btn1MouseEntered

    private void cal_loan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal_loan_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cal_loan_btnActionPerformed

    private void name_del_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_del_txtKeyPressed
      // Method to move cursor from cus_id_del_txt to loan_amount_txt on Enter key press
                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Check if Enter key is pressed
        pay_amount_txt.requestFocus(); // Move focus to loan_amount_txt
    }

    }//GEN-LAST:event_name_del_txtKeyPressed

    private void name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_txtActionPerformed

    private void name_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_txtKeyPressed
        // Method to move cursor from cus_id_del_txt to loan_amount_txt on Enter key press
                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Check if Enter key is pressed
      loan_txt.requestFocus(); // Move focus to loan_amount_txt
    }
    }//GEN-LAST:event_name_txtKeyPressed

    private void ancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ancel_btnMouseClicked
        this.dispose();
    }//GEN-LAST:event_ancel_btnMouseClicked

    private void ancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ancel_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ancel_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
        Home_page hp =new Home_page();
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
            java.util.logging.Logger.getLogger(add_loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_loan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover add_loan_txt;
    private rojeru_san.complementos.RSButtonHover ancel_btn;
    private rojeru_san.complementos.RSButtonHover back_btn;
    private rojeru_san.complementos.RSButtonHover cal_loan_btn;
    private rojeru_san.complementos.RSButtonHover clear_add_btn1;
    private rojeru_san.complementos.RSButtonHover clear_cal_btn;
    private rojeru_san.complementos.RSButtonHover clear_pay_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private app.bolivia.swing.JCTextField loan_txt;
    private app.bolivia.swing.JCTextField loan_txt1;
    private app.bolivia.swing.JCTextField name_checktxt;
    private app.bolivia.swing.JCTextField name_del_txt;
    private app.bolivia.swing.JCTextField name_txt;
    private app.bolivia.swing.JCTextField pay_amount_txt;
    private rojeru_san.complementos.RSButtonHover pay_loan_btn;
    private app.bolivia.swing.JCTextField tot_loan_amount_txt;
    // End of variables declaration//GEN-END:variables
}
