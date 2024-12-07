package TallerArchviosPlanos;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class TablaPrincipal {
    private JButton agregarProducto;
    private JPanel panel;
    private DefaultTableModel modelo; 
    private JTable tabla;
    
    public JFrame configurarVentana(){
        JFrame ventana = new JFrame("TABLA");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(450, 350);
     
        panel = new JPanel();
        panel.setBackground(new Color(250,249,249));
        panel.setLayout(null);
      
        agregarProducto = new JButton("Agregar producto");
        agregarProducto.setBounds(125, 250, 200, 40);
        agregarProducto.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(agregarProducto);
     
         agregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Formulario formulario = new Formulario(ventana, TablaPrincipal.this);
                formulario.configurarVentanaSecundaria();
            }
        });
        
        ventana.add(panel); 
        return ventana; 
    }
    
    public void crearTabla(String[][] datos, String[] columnas){
        modelo = new DefaultTableModel(columnas,0);
        tabla = new JTable(modelo);
     
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 30, 340, 150); 
        panel.add(scroll);
        
        cargarDatosDesdeArchivo();
    }
    
    public JTable getTabla(){
        return tabla;
    }
    
    
    public DefaultTableModel getModelo(){
        return modelo;
    }
    
     private void cargarDatosDesdeArchivo() {
        LecturaArchivo lecturaArchivo = new LecturaArchivo();
        ArrayList<String[]> productos = lecturaArchivo.leerProductosDesdeArchivo();
        
        for (int i = 0; i < productos.size(); i++) {
            String[] producto = productos.get(i);
            modelo.addRow(producto);
        }
    }
}