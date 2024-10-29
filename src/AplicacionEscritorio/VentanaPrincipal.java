package AplicacionEscritorio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal {
    private JButton agregarContacto;
    private JButton editarContacto;
    private JButton eliminarContacto;
    private JButton buscarContacto;
    private JPanel panel;
    private DefaultTableModel modelo; 
    private JTable tabla;
    
    public JFrame configurarVentana(){
        JFrame ventana = new JFrame("Gestor de Contactos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(750,450);
        
        Font fuenteTitulo = establecerFuenteTitulo();
        Font fuenteBotones = establecerFuenteBotones();
        Color colorBotones = establecerColorBotones();
        
        panel = new JPanel();
        panel.setBackground(new Color(250,249,249));
        panel.setLayout(null);
      
        JLabel titulo = new JLabel("Gestor de Contactos");
        titulo.setBounds(80, 10, 240, 50);
        titulo.setFont(fuenteTitulo);
        panel.add(titulo);
        
        agregarContacto = new JButton("Agregar contacto");
        agregarContacto.setBackground(colorBotones);
        agregarContacto.setFont(fuenteBotones);
        agregarContacto.setBounds(60,80,190,55);
        panel.add(agregarContacto);
        
        editarContacto = new JButton("Editar contacto");
        editarContacto.setBackground(colorBotones);
        editarContacto.setFont(fuenteBotones);
        editarContacto.setBounds(60,145,190,55);
        panel.add(editarContacto);
        
        eliminarContacto = new JButton("Eliminar contacto");
        eliminarContacto.setBackground(colorBotones);
        eliminarContacto.setFont(fuenteBotones);
        eliminarContacto.setBounds(60,210,190,55);
        panel.add(eliminarContacto);
        
        buscarContacto = new JButton("Buscar contacto");
        buscarContacto.setBackground(colorBotones);
        buscarContacto.setFont(fuenteBotones);
        buscarContacto.setBounds(60,275,190,59);
        panel.add(buscarContacto);
        
         panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_N: // N para nuevo contacto
                        agregarContacto.doClick();
                        break;
                    case KeyEvent.VK_E: // E para editar contacto
                        editarContacto.doClick();
                        break;
                    case KeyEvent.VK_D: // D para eliminar contacto
                        eliminarContacto.doClick();
                        break;
                    case KeyEvent.VK_ENTER: // Enter para guardar contacto
        
                        break;
                }
            }
        });
        
        panel.setFocusable(true); // Asegúrate de que el panel pueda recibir el foco
        panel.requestFocusInWindow(); 
      
        ventana.add(panel); 
        return ventana; 
    }
    
    public void crearTabla(String[][] datos, String[] columnas){
        modelo = new DefaultTableModel(columnas,0);
        tabla = new JTable(modelo);
     
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(289,80,430, 256);
        panel.add(scroll);
    }
    
    public JTable getTabla(){
        return tabla;
    }
    
     public void agregarFila(String[] datosContacto) {
        modelo.addRow(datosContacto); 
    }

    public JButton getAregarContacto(){
        return agregarContacto;
    }
    
    public JButton getEditarContacto(){
        return editarContacto;
    }
    
    public JButton getEliminarContacto(){
        return eliminarContacto;
    }
    
    public JButton getBuscarContacto(){
        return buscarContacto;
    }
    
    public Font establecerFuenteTitulo(){
      return new Font("Verdana", Font.BOLD, 25);
    }
    
    public Font establecerFuenteBotones(){
        return new Font("Verdana", Font.ITALIC,16);
    }
    
    public Color establecerColorBotones(){
        return new Color(224, 224, 224);
    } 
    
    public JPanel getPanel() {
        return panel; 
    }
}  
