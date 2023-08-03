package com.alberttlee.conversor.gui;

import com.alberttlee.conversor.Enums.EnumCurrency;
import com.alberttlee.conversor.models.ModelCurrency;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CurrencyGui extends MainGui{

    private JPanel currencyPanel;
    private JComboBox fromJcombo;
    private JComboBox toJcombo;
    private JTextField amountTxt;
    private JButton btnBack;
    private JButton btnClear;
    private JButton btnConverter;
    private JLabel txtOut;
    private ModelCurrency modelCurrency;


    public CurrencyGui(){
        super.buildFrame(currencyPanel);
        this.modelCurrency = new ModelCurrency();
        setTypesToConvert();
        blockTxt(amountTxt);

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
                txtIsEmpty(amountTxt,modelCurrency);
                modelCurrency.setFromCurrency(fromJcombo.getSelectedItem().toString());
                modelCurrency.setToCurrency(toJcombo.getSelectedItem().toString());
                txtOut.setText(modelCurrency.convert() + "  " + modelCurrency.getToCurrency());
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountTxt.setText("");
                txtOut.setText("-");
            }
        });
    }

//Metodo para agregar los los enum//
    public void setTypesToConvert() {
        for (EnumCurrency curr : EnumCurrency.values()) {
            fromJcombo.addItem(curr.getName());
        }
        for (EnumCurrency curr : EnumCurrency.values()) {
            toJcombo.addItem(curr.getName());
        }
    }

    public void txtIsEmpty(JTextField st, ModelCurrency mdlc){
        if (st.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "The box is blank, please enter a value.");
        } else {
           mdlc.setAmount(Double.valueOf(st.getText()));
        }
    }

    //metodo para usar solo numeros en en Jtext//
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
