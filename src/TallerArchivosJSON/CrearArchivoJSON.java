package TallerArchivosJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrearArchivoJSON {
    public static void main(String[] args) {
        List<Factura> listaFacturas = new ArrayList<>();
        listaFacturas.add(new Factura("P001", "Producto A", 2, 100, 19, 238));
        listaFacturas.add(new Factura("P002", "Producto B", 1, 200, 38, 238));
        listaFacturas.add(new Factura("P003", "Producto C", 5, 50, 25, 275));

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
        String json = gson.toJson(listaFacturas);

        try (FileWriter writer = new FileWriter("facturas.json")) {
            writer.write(json);
            System.out.println("Archivo JSON creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
