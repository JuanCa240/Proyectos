package MiniProyecto3;
import java.awt.Image;

public class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private Categoria categoria;
    private Image imagen;

    public enum Categoria {
        LAPTOP,
        SMARTPHONE,
        TABLET
    }
 
    public Producto(String nombre, String codigo, double precio, Categoria categoria, Image imagen) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Image getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre= " + nombre + ", "
                           + "codigo=" + codigo + ", "
                           + "precio=" + precio + ", "
                           + "categoria=" + categoria + ", "
                           + "imagen=" + imagen + '}';
    }
}