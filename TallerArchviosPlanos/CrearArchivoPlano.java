package TallerArchviosPlanos;

import java.io.File;
import java.io.IOException;

public class CrearArchivoPlano {
public static void main(String[] args) {
       
 
        File archivo = new File("EscribirTablaArchivo.txt");

      
        if (!archivo.exists()) {
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado exitosamente.");
                } else {
                    System.out.println("El archivo ya existe.");
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error al crear el archivo.");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo ya existe.");
        }
    }
    
}

