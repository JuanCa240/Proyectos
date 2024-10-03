package Taller2;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderAndProgressBar {
    public static void main(String[] args){
        JFrame frame = new JFrame("SLIDER Y PROGRESSBAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel etiqueta1 = new JLabel("SLIDER");
        etiqueta1.setFont(new Font("Serif",Font.BOLD,17));
        etiqueta1.setBounds(156,35,100,20);
        panel.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel("PROGRESS BAR");
        etiqueta2.setFont(new Font("Serif",Font.BOLD,17));
        etiqueta2.setBounds(119,150,200,20);
        panel.add(etiqueta2);
        
        JSlider slider = new JSlider(0,100);
        
        slider.setBounds(50,53,275,70);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);
        
        JProgressBar progressBar = new JProgressBar(0,100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(86,180,200,45);
        panel.add(progressBar);
        
        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                System.out.println("Valor: " + slider.getValue());
            }
        });
        
        progressBar.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                int valor = progressBar.getValue();
            }
        });
        
        Timer timer = new Timer(100, e ->{
            int valor = progressBar.getValue()+1;
            if(valor <= progressBar.getMaximum()){
                progressBar.setValue(valor);
       
            } else {
                ((Timer)e.getSource()).stop(); // Detener el temporizador cuando se llega al máximo
            }
        });
         
        timer.start();
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
