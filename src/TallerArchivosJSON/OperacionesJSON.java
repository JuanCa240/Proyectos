package TallerArchivosJSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class OperacionesJSON {
    private String rutaArchivo = "facturas.json";  // Ruta del archivo JSON
    private ArrayList<Factura> facturas;

    public OperacionesJSON() {
        this.facturas = new ArrayList<>();
        cargarPersonasDesdeArchivo();
    }


    public void cargarPersonasDesdeArchivo() {
        try (Reader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Factura>>() {}.getType();
            facturas = gson.fromJson(reader, listType);
            if (facturas == null) {
                facturas = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se iniciará con una lista vacía.");
            facturas = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

   
    public void guardarPersonasEnArchivo() {
        try (Writer writer = new FileWriter(rutaArchivo)) {
            Gson gson = new Gson();
            gson.toJson(facturas, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }


    public void agregarPersona(Factura factura) {
        facturas.add(factura);
        guardarPersonasEnArchivo();
    }

    public void editarPersona(int index, Factura factura) {
        facturas.set(index, factura);
        guardarPersonasEnArchivo();
    }

    public void eliminarPersona(int index) {
        facturas.remove(index);
        guardarPersonasEnArchivo();
    }

    public void cargarPersonasEnTabla(DefaultTableModel modelo) {
        modelo.setRowCount(0); 
        for (Factura factura : facturas) {
            Object[] fila = {
                factura.getCodigoProducto(),
                factura.getNombre(),
                factura.getCantidad(),
                factura.getPrecio(),
                factura.getImpuesto(),
                factura.getTotal()
            };
            modelo.addRow(fila);
        }
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
}
