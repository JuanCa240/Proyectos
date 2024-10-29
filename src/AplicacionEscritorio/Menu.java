
package AplicacionEscritorio;
import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        VentanaPrincipal vp = new VentanaPrincipal();
        JFrame ventana = vp.configurarVentana();
       
        
        String[] columnas = { "Nombre", "Apellido", "Número", "Correo", "Dirección", "Estado Civil" };
        vp.crearTabla(new String[0][0], columnas);
        
          
        EventoBotones eventos = new EventoBotones(vp);
        eventos.gestionarEventos();
        
        ventana.setVisible(true);          
    }
}
