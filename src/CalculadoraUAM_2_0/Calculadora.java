/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CalculadoraUAM_2_0;

import java.awt.event.KeyEvent;

public class Calculadora extends javax.swing.JFrame {
    
    public Calculadora() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        boton0 = new javax.swing.JButton();
        etiqueta1 = new javax.swing.JLabel();
        campoTexto1 = new javax.swing.JTextField();
        campoTexto2 = new javax.swing.JTextField();
        botonSumar = new javax.swing.JButton();
        botonRestar = new javax.swing.JButton();
        botonMultiplicar = new javax.swing.JButton();
        botonDividir = new javax.swing.JButton();
        campoResultado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CALCULADORA");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        boton1.setText("1");
        boton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton1MouseClicked(evt);
            }
        });
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setText("2");
        boton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton2MouseClicked(evt);
            }
        });

        boton3.setText("3");
        boton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton3MouseClicked(evt);
            }
        });

        boton4.setText("4");
        boton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton4MouseClicked(evt);
            }
        });
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        boton5.setText("5");
        boton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton5MouseClicked(evt);
            }
        });

        boton6.setText("6");
        boton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton6MouseClicked(evt);
            }
        });

        boton7.setText("7");
        boton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton7MouseClicked(evt);
            }
        });
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });

        boton8.setText("8");
        boton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton8MouseClicked(evt);
            }
        });

        boton9.setText("9");
        boton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton9MouseClicked(evt);
            }
        });

        boton0.setText("0");
        boton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton0MouseClicked(evt);
            }
        });

        etiqueta1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        etiqueta1.setText("CALCULADORA 2.0");

        campoTexto1.setEditable(false);
        campoTexto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTexto1ActionPerformed(evt);
            }
        });

        campoTexto2.setEditable(false);
        campoTexto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTexto2ActionPerformed(evt);
            }
        });

        botonSumar.setText("+");
        botonSumar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSumarMouseClicked(evt);
            }
        });
        botonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumarActionPerformed(evt);
            }
        });

        botonRestar.setText("-");
        botonRestar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRestarMouseClicked(evt);
            }
        });

        botonMultiplicar.setText("*");
        botonMultiplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMultiplicarMouseClicked(evt);
            }
        });

        botonDividir.setText("/");
        botonDividir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDividirMouseClicked(evt);
            }
        });
        botonDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDividirActionPerformed(evt);
            }
        });

        campoResultado.setEditable(false);
        campoResultado.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(campoTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(campoTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(etiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(boton1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(boton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton0, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addComponent(boton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton6, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(boton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonMultiplicar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(botonRestar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonSumar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonDividir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boton3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(boton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton0, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(campoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonSumar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonRestar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMultiplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton7ActionPerformed

    private void campoTexto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTexto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTexto1ActionPerformed

    private void botonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSumarActionPerformed

    private void botonDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDividirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonDividirActionPerformed

    private void ingresarNumero(String numero) {
        if (campoTexto1.getText().equals("")) {
            campoTexto1.setText(numero);
        } else if (campoTexto2.getText().equals("")) {
            campoTexto2.setText(numero);
    }
}
    
    private void boton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseClicked
        ingresarNumero("1");
    }//GEN-LAST:event_boton1MouseClicked

    private void boton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseClicked
        ingresarNumero("2");
    }//GEN-LAST:event_boton2MouseClicked

    private void boton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton3MouseClicked
      ingresarNumero("3");
    }//GEN-LAST:event_boton3MouseClicked

    private void boton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton4MouseClicked
      ingresarNumero("4");
    }//GEN-LAST:event_boton4MouseClicked

    private void boton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton5MouseClicked
     ingresarNumero("5");
    }//GEN-LAST:event_boton5MouseClicked

    private void boton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton6MouseClicked
      ingresarNumero("6");
    }//GEN-LAST:event_boton6MouseClicked

    private void boton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton7MouseClicked
      ingresarNumero("7");
    }//GEN-LAST:event_boton7MouseClicked

    private void boton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton8MouseClicked
     ingresarNumero("8");
    }//GEN-LAST:event_boton8MouseClicked

    private void boton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton9MouseClicked
       ingresarNumero("9");
    }//GEN-LAST:event_boton9MouseClicked

    private void boton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton0MouseClicked
     ingresarNumero("0");
    }//GEN-LAST:event_boton0MouseClicked

    private void botonSumarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSumarMouseClicked
       int numero1 = Integer.parseInt(campoTexto1.getText());
       int numero2 = Integer.parseInt(campoTexto2.getText());
       int resultado = numero1 + numero2;
       campoResultado.setText(String.valueOf(resultado)); //Pasar del entero a String
       campoTexto1.setText("");
       campoTexto2.setText("");
    }//GEN-LAST:event_botonSumarMouseClicked

    private void botonRestarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRestarMouseClicked
       int numero1 = Integer.parseInt(campoTexto1.getText());
       int numero2 = Integer.parseInt(campoTexto2.getText());
       int resultado = numero1 - numero2;
       campoResultado.setText(String.valueOf(resultado)); //Pasar del entero a String
       campoTexto1.setText("");
       campoTexto2.setText("");
    }//GEN-LAST:event_botonRestarMouseClicked

    private void botonMultiplicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMultiplicarMouseClicked
       int numero1 = Integer.parseInt(campoTexto1.getText());
       int numero2 = Integer.parseInt(campoTexto2.getText());
       int resultado = numero1 * numero2;
       campoResultado.setText(String.valueOf(resultado)); //Pasar del entero a String
       campoTexto1.setText("");
       campoTexto2.setText("");
    }//GEN-LAST:event_botonMultiplicarMouseClicked

    private void botonDividirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDividirMouseClicked
       int numero1 = Integer.parseInt(campoTexto1.getText());
       int numero2 = Integer.parseInt(campoTexto2.getText());
    
       if(numero2 != 0){
            float resultado = (float) numero1 / numero2;
       campoResultado.setText(String.valueOf(resultado)); //Pasar del entero a String
       }else{
            campoResultado.setText("Error: División por 0");
       }
       campoTexto1.setText("");
       campoTexto2.setText("");
    }//GEN-LAST:event_botonDividirMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void campoTexto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTexto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTexto2ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        String numero = String.valueOf(evt.getKeyChar());
        char keyChar = evt.getKeyChar();
        
        if(numero.equals("1")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("1");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("1"); 
        }
        
        if(numero.equals("2")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("2");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("2"); 
        }
          
        if(numero.equals("3")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("3");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("3"); 
        }
          
        if(numero.equals("4")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("4");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("4"); 
        }
        
        if(numero.equals("5")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("5");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("5"); 
        }
        
        if(numero.equals("6")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("6");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("6"); 
        }
          
        if(numero.equals("7")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("7");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("7"); 
        }
            
        if(numero.equals("8")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("8");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("8"); 
        }
              
        if(numero.equals("9")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("9");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("9"); 
        }
                
        if(numero.equals("0")){
            if(campoTexto1.getText().equals(""))
                campoTexto1.setText("0");
        
            else if(campoTexto2.getText().equals(""))
                campoTexto2.setText("0"); 
        }
      
        switch (keyChar) {
            case '+':
                realizarOperacion("+");
                break;
            case '-':
                realizarOperacion("-");
                break;
            case '*':
                realizarOperacion("*");
                break;
            case '/':
                realizarOperacion("/");
                break;
        }
    }//GEN-LAST:event_formKeyPressed
    
    private void realizarOperacion(String operacion) {
    if (!campoTexto1.getText().isEmpty() && !campoTexto2.getText().isEmpty()) {
        int numero1 = Integer.parseInt(campoTexto1.getText());
        int numero2 = Integer.parseInt(campoTexto2.getText());
        float resultado = 0;

        switch (operacion) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = (float) numero1 / numero2;
                } else {
                    campoResultado.setText("Error: División por 0");
                    return;
                }
                break;
        }
        campoResultado.setText(String.valueOf(resultado));
        campoTexto1.setText(""); 
        campoTexto2.setText("");
    } else {
        campoResultado.setText("Ingrese ambos números");
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton0;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JButton botonDividir;
    private javax.swing.JButton botonMultiplicar;
    private javax.swing.JButton botonRestar;
    private javax.swing.JButton botonSumar;
    private javax.swing.JTextField campoResultado;
    private javax.swing.JTextField campoTexto1;
    private javax.swing.JTextField campoTexto2;
    private javax.swing.JLabel etiqueta1;
    // End of variables declaration//GEN-END:variables
}
