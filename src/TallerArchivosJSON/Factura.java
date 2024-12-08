package TallerArchivosJSON;

public class Factura {
    private String codigoProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private float impuesto;
    private double total;

    public Factura(String codigoProducto, String nombre, int cantidad, double precio, float impuesto, double total) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.impuesto = impuesto;
        this.total = total;
    }
    
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

   
}
