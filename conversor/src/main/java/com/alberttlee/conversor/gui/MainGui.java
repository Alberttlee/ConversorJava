package com.alberttlee.conversor.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame{

    private JPanel mainPanel;
    private JButton btnCurrency;
    private JButton btnTemperature;
    private JLabel conversorLabel;



    public MainGui(){
        this.buildFrame(mainPanel);

        btnCurrency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrencyGui currencyGui = new CurrencyGui();
                dispose();
            }
        });
        btnTemperature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TemperatureGui temperatureGui = new TemperatureGui();

            }
        });
    }


    public void buildFrame(JPanel jpanel) {
        setContentPane(jpanel);
        setResizable(false);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 500));
        setMaximumSize(new Dimension(800, Integer.MAX_VALUE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();


    }
}
