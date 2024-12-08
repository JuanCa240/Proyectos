package TallerArchivosJSON;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JPanel panel;
    private JButton botonAgregar;
    private JButton botonEliminar;
    private JButton botonEditar;

    public JFrame configurarVentana(){
        JFrame ventana = new JFrame();
        ventana.setSize(400,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(null);
        ventana.add(panel);
        
        botonAgregar = new JButton("Agregar Factura");
        botonAgregar.setBounds(20, 20, 150, 30); 
        panel.add(botonAgregar);


        botonEliminar = new JButton("Eliminar Factura");
        botonEliminar.setBounds(20, 60, 150, 30); 
        panel.add(botonEliminar);

        botonEditar = new JButton("Editar Factura");
        botonEditar.setBounds(20, 100, 150, 30); 
        panel.add(botonEditar);
        
        String[] Encabezado = {"Codigo","Nombre","Cantidad","Precio","Impuesto","Total"};
        
        modelo = new DefaultTableModel(null,Encabezado);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10,150,370,170);
        panel.add(scrollPane);
        
        ventana.setVisible(true);
        
        return ventana;
    }

    public JTable getTabla() {
        return tabla;
    }
    
    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public JButton getBotonEditar() {
        return botonEditar;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

}