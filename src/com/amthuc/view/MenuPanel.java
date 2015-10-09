package com.amthuc.view;

import com.amthuc.dao.UserDAO;
import com.amthuc.model.Table;
import com.amthuc.model.User;
import com.amthuc.utils.GLOBAL;
import com.amthuc.utils.Helper;
import static com.amthuc.view.LoginPanel.userLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pia
 */
public class MenuPanel extends javax.swing.JPanel implements ActionListener, MouseListener {

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

        btnCategory.setText("Danh mục");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        btnOrder.setText("Đơn hàng");
        btnOrder.setPreferredSize(new java.awt.Dimension(55, 40));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnTable.setText("Bàn ăn");

        btnUser.setText("Người dùng");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnLogout.setText("Đăng xuất");
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
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor1Panel);
        } else if (btn == btnOrder) {
            this.serverFrame.getMainSplitPane().setRightComponent(orderPanel);
        } else if (btn == btnLogout) {
            LoginPanel.userLogin = null;
            this.serverFrame.getMainSplitPane().setRightComponent(loginPanel);
            this.serverFrame.getMainSplitPane().setLeftComponent(null);
        } else if (btn == loginPanel.getBtnLogin()) {
            User user = new User();
            if (loginPanel.getTxtUName().getText().trim() != null && loginPanel.getTxtPass().getText().trim() != null) {
                try {
                    user.setUsername(loginPanel.getTxtUName().getText());
                    user.setPassword(loginPanel.getTxtPass().getText());
                    
                    UserDAO uDao = new UserDAO();
                    LoginPanel.userLogin = uDao.login_admin(user);
                    if (LoginPanel.userLogin != null) {
                        showMessage("Đăng nhập thành công!");
                        loginPanel.getTxtPass().setText("");
                        userPanel.initTable();
                    } else {
                        showMessage("Đăng nhập không thành công. Vui lòng kiểm tra lại tên tài khoản/mật khẩu");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    showMessage("Có lỗi xảy ra. Vui lòng thử lại sau");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    showMessage("Có lỗi xảy ra. Vui lòng thử lại sau");
                }

            }
            if (LoginPanel.userLogin != null) {
                this.serverFrame.getMainSplitPane().setRightComponent(userPanel);
                this.serverFrame.getMainSplitPane().setLeftComponent(this);
                this.serverFrame.getMainSplitPane().setDividerSize(1);
            }

        }
    }

    private void init() {
        try {
            lstTableFloor1 = Helper.loadTables("config_table.xml", GLOBAL.AREA.FLOOR_1);
            lstTableFloor2 = Helper.loadTables("config_table.xml", GLOBAL.AREA.FLOOR_2);
            lstTableFloor3 = Helper.loadTables("config_table.xml", GLOBAL.AREA.FLOOR_3);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginPanel = new LoginPanel();
        userPanel = new UserPanel();
        categoryPanel = new CategoryPanel();
        orderPanel = new OrderPanel();
        tableFloor1Panel = new TableFloor1Panel(lstTableFloor1);
        tableFloor2Panel = new TableFloor2Panel(lstTableFloor2);
        tableFloor3Panel = new TableFloor3Panel(lstTableFloor3);

        serverFrame.getMainSplitPane().setRightComponent(loginPanel);
        serverFrame.getMainSplitPane().setLeftComponent(null);
        serverFrame.getMainSplitPane().setDividerSize(0);
        this.btnCategory.addActionListener(this);
        this.btnOrder.addActionListener(this);
        this.btnTable.addActionListener(this);
        this.btnUser.addActionListener(this);
        this.btnLogout.addActionListener(this);
        this.loginPanel.addBtnLoginListener(this);

        this.tableFloor1Panel.getLblNext().addMouseListener(this);
        this.tableFloor2Panel.getLblNext().addMouseListener(this);
        this.tableFloor3Panel.getLblNext().addMouseListener(this);
        this.tableFloor1Panel.getLblPre().addMouseListener(this);
        this.tableFloor2Panel.getLblPre().addMouseListener(this);
        this.tableFloor3Panel.getLblPre().addMouseListener(this);
    }

    private List<Table> lstTableFloor1;
    private List<Table> lstTableFloor2;
    private List<Table> lstTableFloor3;
    private ServerFrame serverFrame;
    private LoginPanel loginPanel;
    private UserPanel userPanel;
    private CategoryPanel categoryPanel;
    private OrderPanel orderPanel;
    private TableFloor2Panel tableFloor2Panel;
    private TableFloor1Panel tableFloor1Panel;
    private TableFloor3Panel tableFloor3Panel;

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lbl = (JLabel) e.getComponent();
        if (lbl == tableFloor1Panel.getLblNext()) {
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor2Panel);
        } else if (lbl == tableFloor1Panel.getLblPre()) {
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor3Panel);
        } else if (lbl == tableFloor2Panel.getLblNext()) {
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor3Panel);
        } else if (lbl == tableFloor2Panel.getLblPre()) {
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor1Panel);
        } else if (lbl == tableFloor3Panel.getLblNext()) {
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor1Panel);
        } else if (lbl == tableFloor3Panel.getLblPre()) {
            this.serverFrame.getMainSplitPane().setRightComponent(tableFloor2Panel);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
