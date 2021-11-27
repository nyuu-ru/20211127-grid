/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.nyuu.grideditor.ui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author unyuu
 */
public class MainFrame extends JFrame {

    private GridPanel gridPanel;
    
    public MainFrame() throws HeadlessException {
        setTitle("Клеточки");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gridPanel = new GridPanel();
        add(gridPanel, BorderLayout.CENTER);
        
        JButton btn = new JButton("Переключить");
        btn.addActionListener(e -> {
            gridPanel.setFilled(! gridPanel.isFilled());
            gridPanel.repaint();
        });
        add(btn, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }   
    
}
