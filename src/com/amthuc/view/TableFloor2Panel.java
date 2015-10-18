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
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pia
 */
public class TableFloor2Panel extends JPanel{

    private List<TableLabel> lstTable;    
    private JLabel lblNext;
    private JLabel lblPre;
    private JLabel lblFloor;
    private JPanel content;
    

    public TableFloor2Panel(List<TableLabel> lstTable) {
        this.lstTable = lstTable;
        this.setPreferredSize(new Dimension(799, 600));
        this.setLayout(null);
        initComponents();
    }

    private void initComponents() {
        lblNext = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_nextfloor1.png")));
        lblPre = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_prefloor1.png")));
        lblFloor = new JLabel("Tầng 2");
        lblFloor.setFont(new Font("Tahoma", Font.BOLD ,28));
        lblNext.setBounds(550, 50, 54, 24);
        lblPre.setBounds(280, 50, 54, 24);
        lblFloor.setBounds(390, 40, 120, 35);
        this.add(lblNext);
        this.add(lblPre);
        this.add(lblFloor);

        content = new JPanel(new GridLayout(2, 4, 0, 0));
        content.setBounds(80, 100, 750, 500);        
        content.setOpaque(false);
        
        int count = 0;
        for (TableLabel t : lstTable) {
            if (count < 8) {
                count++;      
                JPanel pnTable = new JPanel(null);                
                t.setIcon(new ImageIcon(getClass().getResource("/image/rsz_4-0.png")));                
                t.setText(t.getName());
                t.setVerticalTextPosition(JLabel.BOTTOM);
                t.setHorizontalTextPosition(JLabel.CENTER);
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
}
