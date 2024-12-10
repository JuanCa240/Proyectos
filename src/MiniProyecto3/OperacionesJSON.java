package MiniProyecto3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;

public class OperacionesJSON {
    private static final String ARCHIVO_JSON = "C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\MiniProyecto\\facturas.json";

    public static void guardarFactura(Factura factura) {
        try {
            List<Factura> facturas = leerFacturas();
            facturas.add(factura);

         
            Gson gson = new Gson();
            String json = gson.toJson(facturas);
            
            FileWriter fileWriter = new FileWriter(ARCHIVO_JSON);
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("Factura guardada en archivo JSON.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Factura> leerFacturas() {
        try {
            File archivo = new File(ARCHIVO_JSON);
            if (!archivo.exists()) {
                return List.of(); 
            }

            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea);
            }

            bufferedReader.close();

            Gson gson = new Gson();
            return gson.fromJson(contenido.toString(), new TypeToken<List<Factura>>() {}.getType());

        } catch (IOException e) {
            e.getMessage();
            return List.of(); 
        }
    }
}
