package MiniProyecto3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioFactura extends JDialog {
    private JTextField campoNombre, campoID, campoDireccion, campoNombreProducto, campoPrecio, campoImpuesto, campoTotal;
    private JButton botonGuardarFactura;
    private Producto producto;

    public FormularioFactura(JFrame padre, Producto producto) {
        super(padre, "Formulario Factura", true);
        this.producto = producto; 
        setSize(300, 450);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        configurarFormulario();
        llenarCamposFormulario();
    }

    public void configurarFormulario() {
        setLayout(null);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(20, 20, 100, 30);
        add(etiquetaNombre);
        
        campoNombre = new JTextField();
        campoNombre.setBounds(120, 20, 150, 30);
        add(campoNombre);

        JLabel etiquetaID = new JLabel("Identificación:");
        etiquetaID.setBounds(20, 70, 100, 30);
        add(etiquetaID);
        campoID = new JTextField();
        campoID.setBounds(120, 70, 150, 30);
        add(campoID);

        JLabel etiquetaDireccion = new JLabel("Dirección:");
        etiquetaDireccion.setBounds(20, 120, 100, 30);
        add(etiquetaDireccion);
        campoDireccion = new JTextField();
        campoDireccion.setBounds(120, 120, 150, 30);
        add(campoDireccion);

        JLabel etiquetaProducto = new JLabel("Producto:");
        etiquetaProducto.setBounds(20, 170, 100, 30);
        add(etiquetaProducto);
        
        campoNombreProducto = new JTextField();
        campoNombreProducto.setBounds(120, 170, 150, 30);
        campoNombreProducto.setEditable(false);
        add(campoNombreProducto);

        JLabel etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setBounds(20, 220, 100, 30);
        add(etiquetaPrecio);
        
        campoPrecio = new JTextField();
        campoPrecio.setBounds(120, 220, 150, 30);
        campoPrecio.setEditable(false);
        add(campoPrecio);

        JLabel etiquetaImpuesto = new JLabel("Impuesto:");
        etiquetaImpuesto.setBounds(20, 270, 100, 30);
        add(etiquetaImpuesto);
        campoImpuesto = new JTextField();
        campoImpuesto.setBounds(120, 270, 150, 30);
        add(campoImpuesto);

        JLabel etiquetaTotal = new JLabel("Total:");
        etiquetaTotal.setBounds(20, 320, 100, 30);
        add(etiquetaTotal);
        
        campoTotal = new JTextField();
        campoTotal.setBounds(120, 320, 150, 30);
        campoTotal.setEditable(false);
        add(campoTotal);

        botonGuardarFactura = new JButton("Guardar Factura");
        botonGuardarFactura.setBounds(100, 350, 150, 30);
        add(botonGuardarFactura);

        botonGuardarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCliente = campoNombre.getText();
                    String idCliente = campoID.getText();
                    String direccionCliente = campoDireccion.getText();
                    String nombreProducto = campoNombreProducto.getText();
                    double precioProducto = producto.getPrecio();
                    
                    if (!idCliente.matches("\\d+")) {
                        throw new IdentificacionNumericaException("La identificación debe contener únicamente caracteres numéricos.");
                    }
 
                    double impuesto = precioProducto * 0.12;
                    double total = precioProducto + impuesto;

                    campoImpuesto.setText(String.format("%.2f", impuesto));
                    campoTotal.setText(String.format("%.2f", total));

                    Factura factura = new Factura(
                            nombreCliente,
                            idCliente,
                            direccionCliente,
                            nombreProducto,
                            impuesto,
                            total
                    );

                    OperacionesJSON.guardarFactura(factura);

                 
                    JOptionPane.showMessageDialog(null,
                            "Factura registrada correctamente. Total: $" + total,
                            "Factura Guardada",
                            JOptionPane.INFORMATION_MESSAGE);

                    dispose(); 
                } catch (Exception ex) {
                    ex.getMessage(); 
                    JOptionPane.showMessageDialog(null,
                            "Error al guardar la factura. Verifique los datos.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                PantallaFacturas pantallaFacturas = new PantallaFacturas();
                pantallaFacturas.configurarPantalla();
            }
        });
    }

    public void llenarCamposFormulario() {
        campoNombreProducto.setText(producto.getNombre());
        campoPrecio.setText(String.valueOf(producto.getPrecio()));
    }

    public JButton getBotonGuardarFactura() {
        return botonGuardarFactura;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoID() {
        return campoID;
    }

    public JTextField getCampoDireccion() {
        return campoDireccion;
    }

    public JTextField getCampoNombreProducto() {
        return campoNombreProducto;
    }

    public JTextField getCampoPrecio() {
        return campoPrecio;
    }

    public JTextField getCampoImpuesto() {
        return campoImpuesto;
    }

    public JTextField getCampoTotal() {
        return campoTotal;
    }
}
