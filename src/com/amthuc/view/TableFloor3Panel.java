/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.view;

import com.amthuc.model.TableLabel;
import com.amthuc.utils.GLOBAL;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pia
 */
public class TableFloor3Panel extends JPanel implements MouseListener {
    private List<TableLabel> lstTable;    
    private JLabel lblNext;
    private JLabel lblPre;
    private JLabel lblFloor;
    private JPanel content;
    

    public TableFloor3Panel(List<TableLabel> lstTable) {
        this.lstTable = lstTable;
        this.setPreferredSize(new Dimension(799, 600));
        this.setLayout(null);
        initComponents();
    }

    private void initComponents() {
        lblNext = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_nextfloor1.png")));
        lblPre = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_prefloor1.png")));
        lblFloor = new JLabel("Tầng 3");
        lblFloor.setFont(new Font("Tahoma", Font.BOLD ,28));
        lblNext.setBounds(550, 50, 54, 24);
        lblPre.setBounds(280, 50, 54, 24);
        lblFloor.setBounds(390, 40, 120, 35);
        this.add(lblNext);
        this.add(lblPre);
        this.add(lblFloor);

        content = new JPanel(new GridLayout(1, 3, 0, 0));
        content.setBounds(80, 100, 750, 500);        
        content.setOpaque(false);
        
        int count = 0;
        for (TableLabel t : lstTable) {
            if (count < 8) {
                count++;      
                JPanel pnTable = new JPanel(null);                
                switch (t.getStatus()) {
                    case GLOBAL.ORDER_AND_TABLE_STATUS.TABLE_FREE:
                        t.setIcon(new ImageIcon(getClass().getResource("/image/rsz_8-0.png")));
                        break;

                    case GLOBAL.ORDER_AND_TABLE_STATUS.NOT_YET_ORDER:
                        t.setIcon(new ImageIcon(getClass().getResource("/image/rsz_8-1.png")));
                        break;

                    case GLOBAL.ORDER_AND_TABLE_STATUS.ORDERED:
                        t.setIcon(new ImageIcon(getClass().getResource("/image/rsz_8-2.png")));
                        break;

                    default:
                        t.setIcon(new ImageIcon(getClass().getResource("/image/rsz_8-0.png")));
                        break;
                }
                t.setText(t.getName());
                t.setVerticalTextPosition(JLabel.BOTTOM);
                t.setHorizontalTextPosition(JLabel.CENTER);
                
                t.addMouseListener(this);
                content.add(t);
            } else {
                break;
            }
        }
        this.add(content);
    }

    public JLabel getLblNext() {
        return lblNext;
    }
    
    public JLabel getLblPre() {
        return lblPre;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
    
    
}
