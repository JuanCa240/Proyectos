package TallerArchviosPlanos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario extends JDialog {
    TablaPrincipal tb = new TablaPrincipal();
    private TablaPrincipal tablaPrincipal;

    
    private JPanel panel;
    private JButton botonGuardar;
    private JTextField campoCodigo;
    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JTextField campoCategoria;
   
     public Formulario(JFrame padre, TablaPrincipal tablaPrincipal){
        super(padre,"Agregar Producto",JDialog.ModalityType.APPLICATION_MODAL);
         this.tablaPrincipal = tablaPrincipal;
    }
    
    public void configurarVentanaSecundaria(){
        setSize(300,250);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        
         JLabel etiquetaCodigo = new JLabel("Código:");
        etiquetaCodigo.setBounds(10, 10, 80, 25);
        panel.add(etiquetaCodigo);

        campoCodigo = new JTextField();
        campoCodigo.setBounds(100, 10, 160, 25);
        panel.add(campoCodigo);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(10, 40, 80, 25);
        panel.add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(100, 40, 160, 25);
        panel.add(campoNombre);

        JLabel etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setBounds(10, 70, 80, 25);
        panel.add(etiquetaPrecio);

        campoPrecio = new JTextField();
        campoPrecio.setBounds(100, 70, 160, 25);
        panel.add(campoPrecio);

        JLabel etiquetaCategoria = new JLabel("Categoría:");
        etiquetaCategoria.setBounds(10, 100, 80, 25);
        panel.add(etiquetaCategoria);

        campoCategoria = new JTextField();
        campoCategoria.setBounds(100, 100, 160, 25);
        panel.add(campoCategoria);

        // Botón para guardar el producto
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(100, 140, 160, 25);
        panel.add(botonGuardar);
        
        add(panel);
        
        botonGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
             guardarProductoEnArchivo();
            }
        });
        
        setVisible(true);
    }
    
        private void guardarProductoEnArchivo(){
            String codigo = campoCodigo.getText();
            String nombre = campoNombre.getText();
            String precio = campoPrecio.getText();
            String categoria = campoCategoria.getText();
            
            tablaPrincipal.getModelo().addRow(new Object[]{codigo, nombre, precio, categoria});
            
            EscrituraArchivos archivo = new EscrituraArchivos();
            archivo.guardarProductosEnEscribirArchivo(codigo, nombre, precio, categoria);
            
            dispose();
        }
           
}
