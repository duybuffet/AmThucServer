/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.view;

import com.amthuc.dao.OrderDAO;
import com.amthuc.dao.UserDAO;
import com.amthuc.model.Order;
import com.amthuc.model.User;
import com.amthuc.utils.GLOBAL;
import com.amthuc.utils.Helper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pia
 */
public class OrderPanel extends javax.swing.JPanel {

    private int orderID = -1;

    /**
     * Creates new form OrderPanel
     */
    public OrderPanel() {
        try {
            initComponents();
            initTable();
        } catch (ParseException ex) {
            Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnOrderDetails = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH ĐƠN HÀNG");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Ngày giờ đặt", "Bàn", "Tổng hóa đơn", "Chiết khấu", "Trạng thái", "Nhân viên phục vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        btnOrderDetails.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnOrderDetails.setText("Xem chi tiết đơn hàng");
        btnOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 313, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(342, 342, 342))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDetailsActionPerformed
        if (orderID != -1) {
            new OrderDetailsFrame(orderID).setVisible(true);
        }
    }//GEN-LAST:event_btnOrderDetailsActionPerformed

    private void initTable() throws ParseException {
        try {
            OrderDAO dao = new OrderDAO();
            ArrayList<Order> listOrder = new ArrayList<>();
            listOrder = (ArrayList<Order>) dao.getAll();
            Vector tblRecords = new Vector();
            Vector tblTitle = new Vector();
            tblTitle.add("Mã");
            tblTitle.add("Ngày giờ đặt");
            tblTitle.add("Bàn");
            tblTitle.add("Tổng hóa đơn");
            tblTitle.add("Trạng thái");
            for (Order lc : listOrder) {
                SimpleDateFormat fromDb = new SimpleDateFormat(GLOBAL.CONFIG.TIME_FORMAT);
                SimpleDateFormat myFormat = new SimpleDateFormat(GLOBAL.CONFIG.TIME_DISPLAY);
                String reformattedStr = "";
                reformattedStr = myFormat.format(fromDb.parse(lc.getOrderTime()));

                Vector record = new Vector();
                record.add(lc.getId());
                record.add(reformattedStr);
                record.add(lc.getOrderTable().getName());
                record.add(Helper.formatNumber(lc.getTotalCost()) + " VNĐ");
                record.add(GLOBAL.ORDER_AND_TABLE_STATUS.ORDER_DISPLAY[lc.getStatus()]);
                tblRecords.add(record);
            }

            tblOrder.setModel(new DefaultTableModel(tblRecords, tblTitle));
            tblOrder.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int row = tblOrder.getSelectedRow();
                    orderID = Integer.parseInt(tblOrder.getValueAt(row, 0).toString());
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrderDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
