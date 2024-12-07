package TallerArchviosPlanos;
import javax.swing.JFrame;

public class Menu {
    public static void main(String[] args) {
     TablaPrincipal tb = new TablaPrincipal();
       
     JFrame ventana = tb.configurarVentana();
        
     String[] columnas = {"Código ","Nombre","Precio","Categoria"};
     tb.crearTabla(new String[0][0], columnas);
      
     Formulario f = new Formulario(ventana,tb);
     ventana.setVisible(true);
       
       
    }
}
