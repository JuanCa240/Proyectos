package AplicacionEscritorio;
import javax.swing.*;

public class VentanaSecundaria extends JDialog {
    private JPanel panel;
    private JButton botonGuardarContacto;
    
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoNumero;
    private JTextField campoCorreo;
    private JTextField campoDireccion;
    JRadioButton botonSoltero;
    JRadioButton botonCasado;
    JRadioButton botonUnionLibre;
    JRadioButton botonDivorciado;
    
    public VentanaSecundaria(JFrame padre){
        super(padre,"Agregar Contacto",JDialog.ModalityType.APPLICATION_MODAL);
    }
    
    public void configurarVentanaBotonAgregarContacto(){
        setSize(300, 410);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel etiquetaNombre = new JLabel("Nombre: ");
        etiquetaNombre.setBounds(35, 20, 100, 30);
        panel.add(etiquetaNombre);

        campoNombre = new JTextField(30);
        campoNombre.setBounds(100, 20, 150, 30);
        panel.add(campoNombre);

        JLabel etiquetaApellido = new JLabel("Apellido: ");
        etiquetaApellido.setBounds(35, 60, 100, 30);
        panel.add(etiquetaApellido);

        campoApellido = new JTextField(30);
        campoApellido.setBounds(100, 60, 150, 30);
        panel.add(campoApellido);

        JLabel etiquetaNumero = new JLabel("Número: ");
        etiquetaNumero.setBounds(35, 100, 100, 30);
        panel.add(etiquetaNumero);

        campoNumero = new JTextField(30);
        campoNumero.setBounds(100, 100, 150, 30);
        panel.add(campoNumero);

        JLabel etiquetaCorreo = new JLabel("Correo: ");
        etiquetaCorreo.setBounds(35, 140, 100, 30);
        panel.add(etiquetaCorreo);

        campoCorreo = new JTextField(30);
        campoCorreo.setBounds(100, 140, 150, 30);
        panel.add(campoCorreo);

        JLabel etiquetaDireccion = new JLabel("Dirección: ");
        etiquetaDireccion.setBounds(35, 180, 100, 30);
        panel.add(etiquetaDireccion);

        campoDireccion = new JTextField(30);
        campoDireccion.setBounds(100, 180, 150, 30);
        panel.add(campoDireccion);

        JLabel etiquetaCivil = new JLabel("Estado Civil: ");
        etiquetaCivil.setBounds(35, 220, 100, 30);
        panel.add(etiquetaCivil);
       
        botonGuardarContacto = new JButton("Guardar Contacto");
        botonGuardarContacto.setBounds(38, 305, 200, 40);
        panel.add(botonGuardarContacto);

        agregarRadioBotones();
        add(panel);
    }
    
    public void agregarRadioBotones(){
        botonSoltero = new JRadioButton("Soltero");
        botonSoltero.setBounds(35, 250, 100, 20);
        panel.add(botonSoltero);
        
        botonCasado = new JRadioButton("Casado");
        botonCasado.setBounds(135, 250, 100, 20);
        panel.add(botonCasado);
        
        botonUnionLibre = new JRadioButton("Union Libre");
        botonUnionLibre.setBounds(35, 270, 100, 20);
        panel.add(botonUnionLibre);
        
        botonDivorciado = new JRadioButton("Divorciado");
        botonDivorciado.setBounds(135, 270, 100, 20);
        panel.add(botonDivorciado);
        
        ButtonGroup g = new ButtonGroup();
        g.add(botonSoltero);
        g.add(botonCasado);
        g.add(botonUnionLibre);
        g.add(botonDivorciado);
    }
    
    public JButton getGuardarContacto(){
        return botonGuardarContacto;
    }
    
    public Contacto obtenerDatosContacto() {
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();
        String numero = campoNumero.getText();
        String correo = campoCorreo.getText();
        String direccion = campoDireccion.getText();
        String estadoCivil = "";
        
        if (botonSoltero.isSelected()) 
            estadoCivil = "Soltero";
        
        else if (botonCasado.isSelected())
            estadoCivil = "Casado";
        
        else if (botonUnionLibre.isSelected())
            estadoCivil = "Union Libre";
        
        else if (botonDivorciado.isSelected())
            estadoCivil = "Divorciado";
        
        return new Contacto(nombre, apellido, numero, correo, direccion, estadoCivil);
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoApellido() {
        return campoApellido;
    }

    public JTextField getCampoNumero() {
        return campoNumero;
    }

    public JTextField getCampoCorreo() {
        return campoCorreo;
    }

    public JTextField getCampoDireccion() {
        return campoDireccion;
    }
}

