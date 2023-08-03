package com.alberttlee.conversor.gui;

import com.alberttlee.conversor.Enums.EnumTemperatures;
import com.alberttlee.conversor.models.ModelTemperature;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TemperatureGui extends MainGui {


    private JPanel temperatureGui;
    private JComboBox fromJcombo;
    private JComboBox toJcombo;
    private JButton btnBack;
    private JButton btnClear;
    private JButton btnConverter;
    private JTextField degreesTxt;
    private JLabel txtOut;
    private ModelTemperature modelTemperature;



    public TemperatureGui(){
        super.buildFrame(temperatureGui);
        this.modelTemperature = new ModelTemperature();
        setTypesToConvert();
        blockTxt(degreesTxt);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGui mainGui = new MainGui();
                dispose();
            }
        });

        btnConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIsEmpty(degreesTxt, modelTemperature);
                modelTemperature.setFromTemperature(fromJcombo.getSelectedItem().toString());
                modelTemperature.setToTemperature(toJcombo.getSelectedItem().toString());
                txtOut.setText(modelTemperature.convert() + "  " + modelTemperature.getToTemperature());
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                degreesTxt.setText("");
                txtOut.setText("-");
            }
        });
    }

    //Metodo para agregar los los enum//
    public void setTypesToConvert() {
        for (EnumTemperatures temp: EnumTemperatures.values()) {
            this.fromJcombo.addItem(temp.getName());
        }
        for (EnumTemperatures temp : EnumTemperatures.values()) {
            this.toJcombo.addItem(temp.getName());
        }
    }

    public void txtIsEmpty(JTextField st, ModelTemperature mdl){
        if (st.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"The box is blank, please enter a value.");
        } else {
            mdl.setDegrees(Double.parseDouble(st.getText()));
        }
    }

//metodo para usar solo numeros en en JText//
    public void blockTxt(JTextField texto ) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char a =e.getKeyChar();
                if (!((int)a>=48 && (int)a<=57)){
                    e.consume();
                }
            }
        });
    }
}


