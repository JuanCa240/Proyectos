import javax.swing.*;
import java.awt.*;

public class TextAreaAndList {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TEXTAREA Y LIST");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
 
        JLabel etiqueta = new JLabel("TEXT AREA");
        etiqueta.setFont(new Font("Serif", Font.BOLD, 16));
        etiqueta.setBounds(40, 40, 100, 30);
        panel.add(etiqueta);


        JLabel etiqueta2 = new JLabel("LIST");
        etiqueta2.setFont(new Font("Serif", Font.BOLD, 16));
        etiqueta2.setBounds(300, 40, 80, 30);
        panel.add(etiqueta2);

        String[] data = {"Elemento1", "Elemento2", "Elemento3"};
        JList<String> list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(data.length);  

        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setBounds(300, 80, 120, list.getPreferredSize().height);  
        panel.add(listScrollPane);
  
        JTextArea cajaTexto = new JTextArea(5, 9);
        cajaTexto.setText("Aqui podras escribir texto");
        cajaTexto.setLineWrap(true);
        cajaTexto.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(cajaTexto);
        scrollPane.setBounds(40, 80, 200, 100);  
        panel.add(scrollPane);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println("Seleccionado: " + list.getSelectedValue());
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
