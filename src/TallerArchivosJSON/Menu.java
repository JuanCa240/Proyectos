package TallerArchivosJSON;

import javax.swing.JFrame;


public class Menu {
    public static void main(String[] args) {
          VentanaPrincipal vp = new VentanaPrincipal();
          JFrame ventana = vp.configurarVentana();
          
          Formulario f = new Formulario(ventana);
          
          EventoBotones ev = new EventoBotones(vp,f);
    }
}
