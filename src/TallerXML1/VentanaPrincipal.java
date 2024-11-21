package TallerXML1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private JTable tablaProductos;
    private DefaultTableModel modelo;
    private ArrayList<Producto> listaProductos;

    public VentanaPrincipal() {
        listaProductos = new ArrayList<>();
        setTitle("Gestión de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

      
        modelo = new DefaultTableModel(new String[]{"Código", "Nombre", "Precio", "Categoría"}, 0);
        tablaProductos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        add(scrollPane, BorderLayout.CENTER);

    
        JPanel panelBotones = new JPanel();
        JButton botonAgregar = new JButton("Agregar");
        JButton botonModificar = new JButton("Modificar");
        JButton botonEliminar = new JButton("Eliminar");
        panelBotones.add(botonAgregar);
        panelBotones.add(botonModificar);
        panelBotones.add(botonEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        cargarProductosDesdeXML("C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\producto.xml");

         botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarProducto();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }
    
    
    private void cargarProductosDesdeXML(String archivoXML) {
        LeerXML leerXML = new LeerXML();
        listaProductos = leerXML.leerProductosDesdeXML(archivoXML);
       
        modelo.setRowCount(0);

       for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            modelo.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCategoria()});
        }
    }

    private void agregarProducto() {
        FormularioProducto formulario = new FormularioProducto(this, null);
        formulario.setVisible(true);
    }

    private void modificarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            Producto productoSeleccionado = listaProductos.get(filaSeleccionada);
            FormularioProducto formulario = new FormularioProducto(this, productoSeleccionado);
            formulario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para modificar.");
        }
    }

    private void eliminarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            listaProductos.remove(filaSeleccionada);
            modelo.removeRow(filaSeleccionada);
            guardarXML();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
        }
    }

    public void agregarProductoATabla(Producto producto) {
        listaProductos.add(producto);
        modelo.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCategoria()});
        guardarXML();
    }

    public void guardarXML() {
        EscribirXML escribirXML = new EscribirXML();
        escribirXML.guardarProductosEnXML("C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\producto.xml", listaProductos);
    }
    
    public void actualizarProductoEnTabla(Producto productoModificado) {
    for (int i = 0; i < listaProductos.size(); i++) {
        if (listaProductos.get(i).getCodigo().equals(productoModificado.getCodigo())) {
            listaProductos.set(i, productoModificado);
            break;
        }
    }

    modelo.setRowCount(0); 
   for (int i = 0; i < listaProductos.size(); i++) {
        Producto producto = listaProductos.get(i);
        modelo.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCategoria()});
    }
    guardarXML(); 
}
    
   public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
   }
}
