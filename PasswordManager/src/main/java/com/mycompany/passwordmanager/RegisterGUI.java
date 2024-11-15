/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.passwordmanager;

import javax.swing.JOptionPane;

/**
 *https://github.com/poliposs/SFD-GROUP-O
 * @author paulp
 */
public class RegisterGUI extends javax.swing.JFrame {
    // HashMaps for Register/Log In - Paul
    private RLUserService userService;
    
    /**
     * Creates new form RegisterGUI
     */
    public RegisterGUI() {
        initComponents();
        userService = new RLUserService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        rDirectBtn = new javax.swing.JButton();
        lDirectBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        parent = new javax.swing.JPanel();
        registerPanel = new javax.swing.JPanel();
        eLbl = new javax.swing.JLabel();
        pLbl = new javax.swing.JLabel();
        eRegTf = new javax.swing.JTextField();
        pRegTf = new javax.swing.JTextField();
        signBtn = new javax.swing.JButton();
        generateBTN = new javax.swing.JButton();
        RPG_LengthSpinner = new javax.swing.JSpinner();
        logInPanel = new javax.swing.JPanel();
        eLbl1 = new javax.swing.JLabel();
        pLbl1 = new javax.swing.JLabel();
        eLogTf = new javax.swing.JTextField();
        pLogTf = new javax.swing.JTextField();
        logBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Password Manager");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnPanel.setBackground(new java.awt.Color(153, 153, 255));

        rDirectBtn.setText("REGISTER");
        rDirectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rDirectBtnActionPerformed(evt);
            }
        });

        lDirectBtn.setText("LOG IN");
        lDirectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lDirectBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("EXIT");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rDirectBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lDirectBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn)
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rDirectBtn)
                    .addComponent(lDirectBtn)
                    .addComponent(exitBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.setLayout(new java.awt.CardLayout());

        registerPanel.setBackground(new java.awt.Color(204, 204, 255));

        eLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eLbl.setText("Email:");

        pLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pLbl.setText("Password:");

        signBtn.setText("SIGN UP");
        signBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signBtnActionPerformed(evt);
            }
        });

        generateBTN.setText("Generate");
        generateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBTNActionPerformed(evt);
            }
        });

        RPG_LengthSpinner.setModel(new javax.swing.SpinnerNumberModel(12, 12, 32, 1));

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signBtn)
                    .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(registerPanelLayout.createSequentialGroup()
                            .addComponent(pLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pRegTf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(registerPanelLayout.createSequentialGroup()
                            .addComponent(eLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eRegTf, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generateBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RPG_LengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eLbl)
                    .addComponent(eRegTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pLbl)
                    .addComponent(pRegTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(generateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RPG_LengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(signBtn)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        parent.add(registerPanel, "card2");

        logInPanel.setBackground(new java.awt.Color(204, 204, 255));

        eLbl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eLbl1.setText("Email:");

        pLbl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pLbl1.setText("Password:");

        logBtn.setText("LOG IN");
        logBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logInPanelLayout = new javax.swing.GroupLayout(logInPanel);
        logInPanel.setLayout(logInPanelLayout);
        logInPanelLayout.setHorizontalGroup(
            logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logBtn)
                    .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(logInPanelLayout.createSequentialGroup()
                            .addComponent(pLbl1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pLogTf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(logInPanelLayout.createSequentialGroup()
                            .addComponent(eLbl1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eLogTf, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        logInPanelLayout.setVerticalGroup(
            logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eLbl1)
                    .addComponent(eLogTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pLbl1)
                    .addComponent(pLogTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(logBtn)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        parent.add(logInPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rDirectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rDirectBtnActionPerformed
        // TODO add your handling code here:
        logInPanel.setVisible(false);
        registerPanel.setVisible(true);

    }//GEN-LAST:event_rDirectBtnActionPerformed

    private void signBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signBtnActionPerformed
        // TODO add your handling code here:
        String email = eRegTf.getText();
        String password = pRegTf.getText();

        // Validate input
        if (isInputValid(email, password)) {
            // Attempt to register
            registerUser(email, password);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both email and password.");
        }
    }//GEN-LAST:event_signBtnActionPerformed

    private void logBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBtnActionPerformed
        // TODO add your handling code here:
        String email = eLogTf.getText();
        String password = pLogTf.getText();

        // Validate input
        if (isInputValid(email, password)) {
            // Attempt to login
            loginUser(email, password);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both email and password.");
        }
    }//GEN-LAST:event_logBtnActionPerformed

    private void lDirectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lDirectBtnActionPerformed
        // TODO add your handling code here:
        logInPanel.setVisible(true);
        registerPanel.setVisible(false);
    }//GEN-LAST:event_lDirectBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void generateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBTNActionPerformed
        // Retrieve the length from the JSpinner
        int length = (int) RPG_LengthSpinner.getValue();
        // Generate the password using the specified length
        String generatedPassword = PasswordService.generatePassword(length);
        // Display the password in the text feild
        pRegTf.setText(generatedPassword);
    }//GEN-LAST:event_generateBTNActionPerformed
    
    // Checks input whether correct or filled
    private boolean isInputValid(String email, String password) {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }
    
    // Calling register method from RLUserService
    private void registerUser(String email, String password) {
        if (userService.register(email, password)) {
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists.");
        }
    }
    
    // Calling log in method from RLUserService
    private void loginUser(String email, String password) {
        if (userService.login(email, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            openPasswordGUI();
            // Proceed to Password Manager GUI
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.");
        }
    }
    
    private void openPasswordGUI() {
        // Create a new instance of PasswordGUI and set it visible
        PasswordGUI passwordManager = new PasswordGUI();
        passwordManager.setVisible(true);  // Open the new GUI window

        // Optionally close the current RegisterGUI window
        this.dispose();
    }
    
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
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner RPG_LengthSpinner;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JLabel eLbl;
    private javax.swing.JLabel eLbl1;
    private javax.swing.JTextField eLogTf;
    private javax.swing.JTextField eRegTf;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton generateBTN;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lDirectBtn;
    private javax.swing.JButton logBtn;
    private javax.swing.JPanel logInPanel;
    private javax.swing.JLabel pLbl;
    private javax.swing.JLabel pLbl1;
    private javax.swing.JTextField pLogTf;
    private javax.swing.JTextField pRegTf;
    private javax.swing.JPanel parent;
    private javax.swing.JButton rDirectBtn;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton signBtn;
    // End of variables declaration//GEN-END:variables
}
