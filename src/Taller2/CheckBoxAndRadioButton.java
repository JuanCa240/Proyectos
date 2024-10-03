package Taller2;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBoxAndRadioButton {
    public static void main(String[] arg){
        JFrame frame = new JFrame("CHECKBOX Y RADIOBUTTON");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,250);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel etiqueta = new JLabel("CheckBox");
        etiqueta.setFont(new Font("Serif",Font.BOLD,16));
        etiqueta.setBounds(50,48,100,20);
        panel.add(etiqueta);
        
        JLabel etiqueta2 = new JLabel("Estado: No seleccionado");
        etiqueta2.setFont(new Font("Serif",Font.BOLD,14));
        etiqueta2.setBounds(46,12,155,50);
        panel.add(etiqueta2);
        
        JLabel etiqueta3 = new JLabel("Estado: No seleccionado");
        etiqueta3.setFont(new Font("Serif",Font.BOLD,14));
        etiqueta3.setBounds(233,12,155,50);
        panel.add(etiqueta3);
        
        JLabel etiqueta4 = new JLabel("RadioButton");
        etiqueta4.setFont(new Font("Serif",Font.BOLD,16));
        etiqueta4.setBounds(250,48,100,20);
        panel.add(etiqueta4);
        
        JCheckBox op1 = new JCheckBox("Opcion 1");
        op1.setBounds(46,65,90,38);
        op1.setFont(new Font("Serif",Font.BOLD,14));
        panel.add(op1);
        
        JCheckBox op2 = new JCheckBox("Opcion 2");
        op2.setBounds(46,93,90,38);
        op2.setFont(new Font("Serif",Font.BOLD,14));
        panel.add(op2);
        
        JCheckBox op3 = new JCheckBox("Opcion 2");
        op3.setBounds(46,125,90,38);
        op3.setFont(new Font("Serif",Font.BOLD,14));
        panel.add(op3);
        
        JRadioButton botonRadio1 = new JRadioButton("Opcion 1");
        botonRadio1.setBounds(250,69,100,25);
        panel.add(botonRadio1);
        
        JRadioButton botonRadio2 = new JRadioButton("Opcion 2");
        botonRadio2.setBounds(250,94,90,25);
        panel.add(botonRadio2);
        
        JRadioButton botonRadio3 = new JRadioButton("Opcion 3");
        botonRadio3.setBounds(250,120,90,25);
        panel.add(botonRadio3);
        
        ButtonGroup botonGrupo = new ButtonGroup();
        botonGrupo.add(botonRadio1);
        botonGrupo.add(botonRadio2);
        botonGrupo.add(botonRadio3);
                
        JCheckBox[] opciones = {op1,op2,op3};
       
        for (int i = 0; i < opciones.length; i++) {
            int pos1 = i;
            opciones[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(opciones[pos1].isSelected())
                        etiqueta2.setText("Estado: Seleccionado");
                    else
                        etiqueta2.setText("Estado: No seleccionado");
                } 
            });
        }

       JRadioButton[] botones = {botonRadio1,botonRadio2,botonRadio3};
        
       for (int i = 0; i < botones.length; i++) {
            int pos2 = i;
        botones[i].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(botones[pos2].isSelected())
                   etiqueta3.setText("Estado: Seleccionado");
                else
                   etiqueta3.setText("Estado: No seleccionado");
            } 
        });
       }
        
        
       frame.add(panel);
       frame.setVisible(true);
    }
}
    

