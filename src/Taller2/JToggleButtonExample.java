
package Taller2;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;


public class JToggleButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JToggleButton Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label = new JLabel("JToggleButton");
        label.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(label);
        label.setBounds(110,50,140,40);

        JToggleButton toggleButton = new JToggleButton("Presioname");
        toggleButton.setBounds(100, 100, 140, 50);

        toggleButton.setBackground(Color.GREEN);

        toggleButton.setFont(new Font("Serif", Font.BOLD, 16));

        panel.add(toggleButton);

        toggleButton.addActionListener(e -> {
            if (toggleButton.isSelected()) {
                System.out.println(" activado");
            } else {
                System.out.println("desactivado");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
