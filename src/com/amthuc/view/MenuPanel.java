package com.amthuc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS_PC
 */
public class MenuPanel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel(ServerFrame serverFrame) {
        this.serverFrame = serverFrame;
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        btnCategory = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        btnCategory.setText("Category");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        btnOrder.setText("Orders");
        btnOrder.setPreferredSize(new java.awt.Dimension(55, 40));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnTable.setText("Table");

        btnUser.setText("  User        ");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TO add your handling code here:
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton btnUser;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == btnCategory) {
            this.serverFrame.getMainSplitPane().setRightComponent(categoryPanel);
        } else if (btn == btnUser) {
            this.serverFrame.getMainSplitPane().setRightComponent(userPanel);
        } else if (btn == btnTable) {

        } else if (btn == btnOrder) {
            this.serverFrame.getMainSplitPane().setRightComponent(orderPanel);
        } else if (btn == btnLogout) {
            this.serverFrame.getMainSplitPane().setRightComponent(loginPanel);
            this.serverFrame.getMainSplitPane().setLeftComponent(null);
        } else if (btn == loginPanel.getBtnLogin()) {
            this.serverFrame.getMainSplitPane().setRightComponent(userPanel);
            this.serverFrame.getMainSplitPane().setLeftComponent(this);
            this.serverFrame.getMainSplitPane().setDividerSize(1);
        }
    }

    private void init() {
        loginPanel = new LoginPanel();
        userPanel = new UserPanel();
        categoryPanel = new CategoryPanel();
        orderPanel = new OrderPanel();

        serverFrame.getMainSplitPane().setRightComponent(loginPanel);
        serverFrame.getMainSplitPane().setLeftComponent(null);
        serverFrame.getMainSplitPane().setDividerSize(0);
        this.btnCategory.addActionListener(this);
        this.btnOrder.addActionListener(this);
        this.btnTable.addActionListener(this);
        this.btnUser.addActionListener(this);
        this.btnLogout.addActionListener(this);
        this.loginPanel.addBtnLoginListener(this);
    }

    private ServerFrame serverFrame;
    private LoginPanel loginPanel;
    private UserPanel userPanel;
    private CategoryPanel categoryPanel;
    private OrderPanel orderPanel;
}
