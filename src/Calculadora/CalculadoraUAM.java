package Calculadora;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class CalculadoraUAM {
    public static void main(String[] arg){
     Font fontEtiqueta = new Font("Serif",Font.BOLD,15);  
     Font fontBoton = new Font("Serif",Font.BOLD,20);
        
     JFrame ventana = new JFrame("Mi ventana");
     ventana.setSize(800,600);
     
     JPanel panel = new JPanel();
     panel.setLayout(null);
     
     JTextField campo1 = new JTextField("");
     campo1.setBounds(240, 150, 150, 30);
     campo1.setFont(fontEtiqueta);
     
     JTextField campo2 = new JTextField("");
     campo2.setBounds(395, 150, 150, 30);
     campo2.setFont(fontEtiqueta);
     
     JLabel label = new JLabel("CALCULADORA UAM");
     label.setBounds(280,80,250,30);
     label.setFont(fontBoton);
     
      String[] opciones = {"SUMAR","RESTAR","MULTIPLICAR","DIVIDIR"};
       
       JComboBox combo1 = new JComboBox(opciones);
       combo1.setBounds(310, 200, 150, 30);
       combo1.setSelectedIndex(0);
       ventana.add(combo1);
       
    JButton boton1 = new JButton("1");
    boton1.setBounds(250, 250, 70, 30);
    boton1.setFont(fontBoton);
    boton1.setBackground(new Color(238,233,232));
    
    JButton boton2 = new JButton("2");
    boton2.setBounds(350, 250, 70, 30);
    boton2.setFont(fontBoton);
    boton2.setBackground(new Color(238,233,232));
     
    JButton boton3 = new JButton("3");
    boton3.setBounds(450, 250, 70, 30);
    boton3.setFont(fontBoton);
    boton3.setBackground(new Color(238,233,232));
     
    JButton boton4 = new JButton("4");
    boton4.setBounds(250, 300, 70, 30);
    boton4.setFont(fontBoton);
    boton4.setBackground(new Color(238,233,232));
     
    JButton boton5 = new JButton("5");
    boton5.setBounds(350, 300, 70, 30);
    boton5.setFont(fontBoton);
    boton5.setBackground(new Color(238,233,232));
     
    JButton boton6 = new JButton("6");
    boton6.setBounds(450, 300, 70, 30);
    boton6.setFont(fontBoton);
    boton6.setBackground(new Color(238,233,232));
    
    JButton boton7 = new JButton("7");
    boton7.setBounds(250, 350, 70, 30);
    boton7.setFont(fontBoton);
    boton7.setBackground(new Color(238,233,232));
     
     JButton boton8 = new JButton("8");
     boton8.setBounds(350, 350, 70, 30);
     boton8.setFont(fontBoton);
     boton8.setBackground(new Color(238,233,232));
     
     JButton boton9 = new JButton("9");
     boton9.setBounds(450, 350, 70, 30);
     boton9.setFont(fontBoton);
     boton9.setBackground(new Color(238,233,232));
     
     JButton boton0 = new JButton("0");
     boton0.setBounds(350, 400, 70, 30);
     boton0.setFont(fontBoton);
     boton0.setBackground(new Color(238,233,232));
     
     JButton botonCalcular = new JButton("CALCULAR");
     botonCalcular.setBounds(310, 450, 150, 50);
     panel.add(botonCalcular);
     botonCalcular.setFont(fontEtiqueta);
     botonCalcular.setBackground(new Color(200, 200, 200));
     
     panel.add(boton1);
     panel.add(boton2);
     panel.add(boton3);
     panel.add(boton4);
     panel.add(boton5);
     panel.add(boton6);
     panel.add(boton7);
     panel.add(boton8);
     panel.add(boton9);
     panel.add(boton0);
     
     panel.add(label);
   
     panel.add(campo1);
     panel.add(campo2);
     ventana.add(label);
     
     ventana.add(panel);
  
     ventana.setVisible(true);
     
    
    JButton[] botonesNumeros = {boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0};
        for(int i = 0; i < botonesNumeros.length; i++) {
            JButton boton = botonesNumeros[i];
            
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String numero = boton.getText();
                    if (campo1.getText().equals("")) {
                        campo1.setText(numero);
                    } else if (campo2.getText().equals("")) {
                        campo2.setText(numero);
                    }
                }
            });
        }

        // Action for the calculate button
        botonCalcular.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                float numero1 = 0;
                float numero2 = 0;
                boolean esValido = true;

                // Validate input
                if (!campo1.getText().isEmpty()) {
                    numero1 = Integer.parseInt(campo1.getText());
                } else {
                    esValido = false;
                }

                if (!campo2.getText().isEmpty()) {
                    numero2 = Integer.parseInt(campo2.getText());
                } else {
                    esValido = false;
                }

                if (esValido) {
                    float resultado = 0;
                    String operacion = (String) combo1.getSelectedItem();
                    switch (operacion) {
                        case "SUMAR":
                            resultado = numero1 + numero2;
                            break;
                        case "RESTAR":
                            resultado = numero1 - numero2;
                            break;
                        case "MULTIPLICAR":
                            resultado = numero1 * numero2;
                            break;
                        case "DIVIDIR":
                            if (numero2 != 0) {
                                resultado = numero1 / numero2;
                            } else {
                                JOptionPane.showMessageDialog(null, "No se puede dividir por 0", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                    }
                    JOptionPane.showMessageDialog(null, "EL RESULTADO ES: " + resultado, "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese ambos números", "Error", JOptionPane.ERROR_MESSAGE);
                }

           
                campo1.setText("");
                campo2.setText("");
            }
        });
    }
}
    

