import javax.swing.*;
import java.awt.event.*;

public class EventMouse {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("EJEMPLO MOUSECLICKED");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLayout(null); // Usamos null layout para controlar las posiciones manualmente
        
        // Etiqueta y campo para el primer número
        JLabel labelNumero1 = new JLabel("Ingrese el número 1");
        JTextField campoNumero1 = new JTextField();
        labelNumero1.setBounds(100, 50, 150, 25);
        campoNumero1.setBounds(250, 50, 150, 25);
        
        // Etiqueta y campo para el segundo número
        JLabel labelNumero2 = new JLabel("Ingrese el número 2");
        JTextField campoNumero2 = new JTextField();
        labelNumero2.setBounds(500, 50, 150, 25);
        campoNumero2.setBounds(650, 50, 150, 25);
        
        // Botones para ingresar números
        JButton botonNumero1 = new JButton("1");
        botonNumero1.setBounds(150, 100, 50, 30);
        JButton botonNumero2 = new JButton("2");
        botonNumero2.setBounds(230, 100, 50, 30);
        JButton botonNumero3 = new JButton("3");
        botonNumero3.setBounds(310, 100, 50, 30);
        
        // Botón para realizar la suma
        JButton botonSumar = new JButton("SUMAR");
        botonSumar.setBounds(400, 150, 100, 30);
        
        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Resultado: ");
        labelResultado.setBounds(400, 200, 200, 30);
        
        // Añadimos los componentes a la ventana
        ventana.add(labelNumero1);
        ventana.add(campoNumero1);
        ventana.add(labelNumero2);
        ventana.add(campoNumero2);
        ventana.add(botonNumero1);
        ventana.add(botonNumero2);
        ventana.add(botonNumero3);
        ventana.add(botonSumar);
        ventana.add(labelResultado);
        
        // Funcionalidad de los botones numéricos para ingresar los números en el campo correspondiente
        botonNumero1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campoNumero1.getText().equals("")) {
                    campoNumero1.setText("1");
                } else if (campoNumero2.getText().equals("")) {
                    campoNumero2.setText("1");
                }
            }
        });

        botonNumero2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campoNumero1.getText().equals("")) {
                    campoNumero1.setText("2");
                } else if (campoNumero2.getText().equals("")) {
                    campoNumero2.setText("2");
                }
            }
        });

        botonNumero3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campoNumero1.getText().equals("")) {
                    campoNumero1.setText("3");
                } else if (campoNumero2.getText().equals("")) {
                    campoNumero2.setText("3");
                }
            }
        });
        
        // Funcionalidad del botón "SUMAR" para realizar la operación
        botonSumar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Obtenemos los valores de los campos y realizamos la suma
                    int numero1 = Integer.parseInt(campoNumero1.getText());
                    int numero2 = Integer.parseInt(campoNumero2.getText());
                    int resultado = numero1 + numero2;
                    
                    // Mostramos el resultado en la etiqueta
                    labelResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    // Si los campos no contienen números válidos, mostramos un error
                    labelResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });
        
        ventana.setVisible(true);
    }
}