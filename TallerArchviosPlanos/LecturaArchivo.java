package TallerArchviosPlanos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class LecturaArchivo {
   public ArrayList<String[]> leerProductosDesdeArchivo() {
        ArrayList<String[]> productos = new ArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\EscribirTablaArchivo.txt"))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datosProducto = linea.split(",");
                if (datosProducto.length == 4) { 
                    productos.add(datosProducto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return productos;
    }
    
}