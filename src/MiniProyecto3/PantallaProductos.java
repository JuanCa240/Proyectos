package MiniProyecto3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PantallaProductos {
    private JFrame ventana;
    private JPanel panel;

    public JFrame configurarPantalla() {
        ventana = new JFrame("Pantalla de Productos");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ventana.add(new JScrollPane(panel), BorderLayout.CENTER);

        cargarProductosEnPantalla();

        ventana.setVisible(true);
        return ventana;
    }

    private void cargarProductosEnPantalla() {
        List<Producto> productos = OperacionesXML.leerProductos();
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            JPanel panelProducto = crearPanelProducto(producto);
            panel.add(panelProducto);
        }
        panel.revalidate();
        panel.repaint();
    }


    private JPanel crearPanelProducto(Producto producto) {
        JPanel panelProducto = new JPanel();
        panelProducto.setLayout(new BorderLayout());
        panelProducto.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel etiquetaNombre = new JLabel("Nombre: " + producto.getNombre());
        JLabel etiquetaPrecio = new JLabel("Precio: $" + producto.getPrecio());

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(2, 1));
        panelInfo.add(etiquetaNombre);
        panelInfo.add(etiquetaPrecio);

        JButton botonComprar = new JButton("Comprar");
        
        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioFactura(producto);
            }
        });

        panelProducto.add(panelInfo, BorderLayout.CENTER);
        panelProducto.add(botonComprar, BorderLayout.EAST);

        return panelProducto;
    }

    public void mostrarFormularioFactura(Producto producto) {
        FormularioFactura formularioFactura = new FormularioFactura(ventana, producto);
        formularioFactura.setVisible(true);
    }
}
