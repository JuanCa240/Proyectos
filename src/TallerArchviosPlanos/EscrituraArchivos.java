package TallerArchviosPlanos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class EscrituraArchivos {
    BufferedWriter bw = null;
    
    public void guardarProductosEnEscribirArchivo(String codigo,String nombre,String precio,String categoria){
        try{
            File archivoSalida = new File("C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\src\\TallerArchviosPlanos\\EscribirTablaArchivo.txt");
            bw = new BufferedWriter(new FileWriter(archivoSalida));
           
            bw.write(codigo + "," + nombre + "," + precio + "," + categoria);
            bw.newLine();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }finally{
            try{
                if(bw != null)
                    bw.close();
                
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

