package MiniProyecto3;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Formulario {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField campoNombre, campoCodigo, campoPrecio;
    private JComboBox<Producto.Categoria> comboCategoria;
    private JButton botonAgregar, botonCargarImagen, botonEliminar, botonEditar, botonComprar;;
    private JLabel etiquetaImagen, imagenSeleccionadaLabel;
    private Image imagen;
    private JPanel panel;
    
    public void Formulario(){
        cargarProductosEnTabla();
        
    }

    public JFrame configurarFormulario() {
        JFrame ventana = new JFrame();
        ventana.setSize(900, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        ventana.add(panel);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(20, 20, 100, 30);
        panel.add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(120, 20, 250, 30); 
        panel.add(campoNombre);

        JLabel etiquetaCodigo = new JLabel("Código:");
        etiquetaCodigo.setBounds(20, 70, 100, 30);
        panel.add(etiquetaCodigo);

        campoCodigo = new JTextField();
        campoCodigo.setBounds(120, 70, 250, 30); 
        panel.add(campoCodigo);

        JLabel etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setBounds(20, 120, 100, 30);
        panel.add(etiquetaPrecio);

        campoPrecio = new JTextField();
        campoPrecio.setBounds(120, 120, 250, 30); 
        panel.add(campoPrecio);

        JLabel etiquetaCategoria = new JLabel("Categoría:");
        etiquetaCategoria.setBounds(20, 170, 100, 30);
        panel.add(etiquetaCategoria);

        comboCategoria = new JComboBox<>(Producto.Categoria.values());
        comboCategoria.setBounds(120, 170, 250, 30); 
        panel.add(comboCategoria);

        etiquetaImagen = new JLabel("Imagen:");
        etiquetaImagen.setBounds(20, 220, 100, 30);
        panel.add(etiquetaImagen);

        botonCargarImagen = new JButton("Cargar Imagen");
        botonCargarImagen.setBounds(120, 220, 250, 30);
        panel.add(botonCargarImagen);

        imagenSeleccionadaLabel = new JLabel();
        imagenSeleccionadaLabel.setBounds(120, 260, 250, 150); 
        panel.add(imagenSeleccionadaLabel);

        botonAgregar = new JButton("Agregar Producto");
        botonAgregar.setBounds(407, 340, 150, 50); 
        panel.add(botonAgregar);
        
        botonEliminar = new JButton("Eliminar Producto");
        botonEliminar.setBounds(565, 340, 150, 50);
        panel.add(botonEliminar);
        
        botonEditar = new JButton("Editar Producto");
        botonEditar.setBounds(720, 340, 150, 50);
        panel.add(botonEditar);
        
        botonComprar = new JButton("Comprar Producto");
        botonComprar.setBounds(565,400,150,50);
        panel.add(botonComprar);

        
        String[] ENCABEZADO = {"Nombre","Código","Precio","Categoria","Imagen"};   
        modelo = new DefaultTableModel(null,ENCABEZADO);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(425,20,430,300);
        panel.add(scrollPane);
        
       
        botonCargarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = fileChooser.getSelectedFile();
                    try {
                        imagen = Toolkit.getDefaultToolkit().getImage(archivo.getAbsolutePath());
                        ImageIcon icono = new ImageIcon(imagen);
                        imagenSeleccionadaLabel.setIcon(icono);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PantallaProductos pantallaProductos = new PantallaProductos();
                    pantallaProductos.configurarPantalla();
                } catch (Exception ex) {
                    ex.printStackTrace(); 
                }
            }
        });

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProducto();
            }
        });

        
        ventana.setVisible(true);
        return ventana;
    }
    
    public void cargarProductosEnTabla() {
        List<Producto> productos = OperacionesXML.leerProductos();
        for (Producto producto : productos) {
            Object[] fila = {
                producto.getNombre(),
                producto.getCodigo(),
                producto.getPrecio(),
                producto.getCategoria().toString(),
               
            };
            modelo.addRow(fila);
        }
    }

    private void agregarProducto() {
      
        String nombre = campoNombre.getText();
        String codigo = campoCodigo.getText();
        String precioTexto = campoPrecio.getText();

     
        if (nombre.isEmpty() || codigo.isEmpty() || precioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Por favor, complete todos los campos antes de agregar el producto.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        try {
            if (!codigo.matches("\\d+")) {
                throw new CodigoNumericoException("El código debe contener solo caracteres numéricos.");
            }
        } catch (CodigoNumericoException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error en el código", JOptionPane.ERROR_MESSAGE);
            return;
        }

 
        double precio;
        try {
            precio = Double.parseDouble(precioTexto);

            // Verificar si el precio es negativo
            if (precio < 0) {
                throw new PrecioNegativoException("El precio no puede ser negativo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "El precio debe ser un número válido.", "Error en el precio", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (PrecioNegativoException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error en el precio", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto.Categoria categoria = (Producto.Categoria) comboCategoria.getSelectedItem();

        Producto producto = new Producto(nombre, codigo, precio, categoria, imagen);
        OperacionesXML.agregarProducto(producto);

        String[] datosProducto = { nombre, codigo, String.valueOf(precio), categoria.toString(), imagen != null ? imagen.toString() : "Sin imagen" };
        modelo.addRow(datosProducto);

        System.out.println("Producto agregado correctamente.");

        campoNombre.setText("");
        campoCodigo.setText("");
        campoPrecio.setText("");
        comboCategoria.setSelectedIndex(0);
        imagenSeleccionadaLabel.setIcon(null);
    }

    
    private void eliminarProducto() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            String codigo = (String) modelo.getValueAt(filaSeleccionada, 1);
            OperacionesXML.eliminarProducto(codigo);

            modelo.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un producto para eliminar.");
        }
    }
    
    private void editarProducto() {
        int filaSeleccionada = tabla.getSelectedRow();
        String nombre = campoNombre.getText();
        String codigo = campoCodigo.getText();
        String precioTexto = campoPrecio.getText();

        if (nombre.isEmpty() || codigo.isEmpty() || precioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Por favor, complete todos los campos antes de editar el producto.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if (!codigo.matches("\\d+")) {
                throw new CodigoNumericoException("El código debe contener solo caracteres numéricos.");
            }
        } catch (CodigoNumericoException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error en el código", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        double precio;
        try {
            precio = Double.parseDouble(precioTexto);

            if (precio < 0) {
                throw new PrecioNegativoException("El precio no puede ser negativo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "El precio debe ser un número válido.", "Error en el precio", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (PrecioNegativoException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error en el precio", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto.Categoria categoria = (Producto.Categoria) comboCategoria.getSelectedItem();
        Producto productoEditado = new Producto(nombre, codigo, precio, categoria, imagen);
        OperacionesXML.editarProducto(codigo, productoEditado);

        modelo.setValueAt(nombre, filaSeleccionada, 0);
        modelo.setValueAt(codigo, filaSeleccionada, 1);
        modelo.setValueAt(precio, filaSeleccionada, 2);
        modelo.setValueAt(categoria.toString(), filaSeleccionada, 3);
        modelo.setValueAt(imagen != null ? imagen.toString() : "Sin imagen", filaSeleccionada, 4);

        JOptionPane.showMessageDialog(panel, "Producto editado correctamente.");

        campoNombre.setText("");
        campoCodigo.setText("");
        campoPrecio.setText("");
        comboCategoria.setSelectedIndex(0);
        imagenSeleccionadaLabel.setIcon(null);
    }



    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoCodigo() {
        return campoCodigo;
    }

    public JTextField getCampoPrecio() {
        return campoPrecio;
    }

    public JComboBox<Producto.Categoria> getComboCategoria() {
        return comboCategoria;
    }

    public Image getImagen() {
        return imagen;
    }
    
    public DefaultTableModel getModelo() {
        return modelo;
    }
      
    public JTable getTabla() {
        return tabla;
    }
      
}
