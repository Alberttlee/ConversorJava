package com.alberttlee.conversor.gui;

import javax.swing.*;

public class MainGui extends JFrame{

    private JPanel mainPanel;
    private JButton currencyButton;
    private JButton temperatureButton;



    public MainGui(){
        createJframe(mainPanel);
    }

    protected void createJframe(JPanel jPanel){
        setContentPane(jPanel);
        setVisible(true);
        setTitle("Conversor");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
