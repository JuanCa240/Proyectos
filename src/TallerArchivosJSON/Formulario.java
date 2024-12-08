package TallerArchivosJSON;

import javax.swing.*;

public class Formulario extends JDialog {
    private JTextField campoCodigo, campoNombre, campoCantidad, campoPrecio, campoImpuesto, campoTotal;
    private JButton botonGuardar;

    public Formulario(JFrame padre) {
        super(padre, "Formulario de Factura", true);
        setSize(300, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(padre); 
        configurarFormulario();
    }

    private void configurarFormulario() {
       
        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(20, 20, 100, 30);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(120, 20, 150, 30);
        add(campoNombre);

      
        JLabel etiquetaCodigo = new JLabel("Código:");
        etiquetaCodigo.setBounds(20, 70, 100, 30);
        add(etiquetaCodigo);

        campoCodigo = new JTextField();
        campoCodigo.setBounds(120, 70, 150, 30);
        add(campoCodigo);

     
        JLabel etiquetaCantidad = new JLabel("Cantidad:");
        etiquetaCantidad.setBounds(20, 120, 100, 30);
        add(etiquetaCantidad);

        campoCantidad = new JTextField();
        campoCantidad.setBounds(120, 120, 150, 30);
        add(campoCantidad);

    
        JLabel etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setBounds(20, 170, 100, 30);
        add(etiquetaPrecio);

        campoPrecio = new JTextField();
        campoPrecio.setBounds(120, 170, 150, 30);
        add(campoPrecio);

        JLabel etiquetaImpuesto = new JLabel("Impuesto:");
        etiquetaImpuesto.setBounds(20, 220, 100, 30);
        add(etiquetaImpuesto);

        campoImpuesto = new JTextField();
        campoImpuesto.setBounds(120, 220, 150, 30);
        add(campoImpuesto);

        JLabel etiquetaTotal = new JLabel("Total:");
        etiquetaTotal.setBounds(20, 270, 100, 30);
        add(etiquetaTotal);

        campoTotal = new JTextField();
        campoTotal.setBounds(120, 270, 150, 30);
        campoTotal.setEditable(false); 
        add(campoTotal);

        
        botonGuardar = new JButton("Guardar Factura");
        botonGuardar.setBounds(75, 320, 150, 40);
        add(botonGuardar);
    }

 
    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoCodigo() {
        return campoCodigo;
    }

    public JTextField getCampoCantidad() {
        return campoCantidad;
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

    public JButton getBotonGuardar() {
        return botonGuardar;
    }
}
