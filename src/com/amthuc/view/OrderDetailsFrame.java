/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.view;

import com.amthuc.dao.DishDAO;
import com.amthuc.dao.OrderDAO;
import com.amthuc.dao.OrderDetailsDAO;
import com.amthuc.model.Order;
import com.amthuc.model.OrderDetails;
import com.amthuc.utils.GLOBAL;
import com.amthuc.utils.Helper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pia
 */
public class OrderDetailsFrame extends javax.swing.JFrame {

    private int orderID;
    private ArrayList<OrderDetails> listOrder;

    /**
     * Creates new form OrderDetailsForm
     */
    public OrderDetailsFrame(int orderId) {
        try {
            initComponents();
            this.orderID = orderId;
            initData();
            initTable();
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (ParseException ex) {
            Logger.getLogger(OrderDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtWaiter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOrderTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDesc = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(880, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CHI TIẾT ĐƠN HÀNG");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Món", "Giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã đơn hàng");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày giờ đặt");

        txtWaiter.setEditable(false);
        txtWaiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaiterActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nhân viên phục vụ");

        txtOrderTime.setEditable(false);
        txtOrderTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderTimeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mô tả");

        txaDesc.setEditable(false);
        txaDesc.setColumns(20);
        txaDesc.setRows(5);
        jScrollPane2.setViewportView(txaDesc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtWaiter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtOrderTime, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtWaiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaiterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaiterActionPerformed

    private void txtOrderTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderTimeActionPerformed

    private void initTable() {
        try {

            OrderDetailsDAO dao = new OrderDetailsDAO();
            listOrder = new ArrayList<>();
            listOrder = (ArrayList<OrderDetails>) dao.getByOrder(orderID);

            DefaultTableModel model = new DefaultTableModel(new String[]{"Món", "Giá", "Số lượng"}, 0);

            for (OrderDetails lc : listOrder) {
                model.addRow(new Object[]{lc.getDish().getName(), Helper.formatNumber(lc.getDisplayPrice()) + " VNĐ", lc.getQuantity()});
            }

            tblOrder.setModel(model);
            tblOrder.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int row = tblOrder.getSelectedRow();
                    OrderDetails details = listOrder.get(row);
                    txtId.setText(tblOrder.getValueAt(row, 0).toString());
                    txtWaiter.setText(details.getOrder().getOrderTime());
                    txtOrderTime.setText(details.getOrder().getPantryCompleteTime());
                    txaDesc.setText(details.getDish().getDescription());

                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextArea txaDesc;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtOrderTime;
    private javax.swing.JTextField txtWaiter;
    // End of variables declaration//GEN-END:variables

    private void initData() throws ParseException {
        try {

            SimpleDateFormat fromDb = new SimpleDateFormat(GLOBAL.CONFIG.TIME_FORMAT);
            SimpleDateFormat myFormat = new SimpleDateFormat(GLOBAL.CONFIG.TIME_DISPLAY);

            OrderDAO oDao = new OrderDAO();
            Order order = oDao.get(orderID);
            txtId.setText(order.getId() + "");
            txtWaiter.setText(order.getWaiter().getFullName());
            txtOrderTime.setText(myFormat.format(fromDb.parse(order.getOrderTime())));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
