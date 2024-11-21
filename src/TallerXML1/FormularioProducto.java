package TallerXML1;
import javax.swing.*;
import java.awt.*;

public class FormularioProducto extends JDialog{
     private JTextField txtCodigo, txtNombre, txtPrecio, txtCategoria;
    private VentanaPrincipal ventanaPrincipal;
    private Producto producto;

    public FormularioProducto(VentanaPrincipal ventanaPrincipal, Producto producto) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.producto = producto;
        setTitle(producto == null ? "Agregar Producto" : "Editar Producto");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        // Campos
        add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        add(txtCodigo);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        JButton botonGuardar = new JButton("Guardar");
        add(botonGuardar);

        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
            txtCategoria.setText(producto.getCategoria());
        }

        botonGuardar.addActionListener(e -> guardarProducto());
    }

    public void guardarProducto() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioTexto = txtPrecio.getText().trim();
        String categoria = txtCategoria.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || precioTexto.isEmpty() || categoria.isEmpty())
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            
        
        double precio;
        try {
            precio = Double.parseDouble(precioTexto);
            if (precio < 0) {
                JOptionPane.showMessageDialog(this, "El precio no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (producto == null) {
            ventanaPrincipal.agregarProductoATabla(new Producto(codigo, nombre, precio, categoria));
        } else {
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCategoria(categoria);
            ventanaPrincipal.actualizarProductoEnTabla(producto);
            ventanaPrincipal.guardarXML();
        }
    }
}

