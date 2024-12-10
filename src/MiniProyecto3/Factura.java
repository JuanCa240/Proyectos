package MiniProyecto3;

public class Factura {
    private String nombre;
    private String id;
    private String direccion;
    private String nombreProducto;
    private double precio;
    private double impuesto;
    private double total;

    public Factura(String nombre, String id, String direccion, String nombreProducto, double impuesto, double total) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.nombreProducto = nombreProducto;
        this.impuesto = impuesto;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }
    
    
}