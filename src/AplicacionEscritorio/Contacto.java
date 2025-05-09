
package AplicacionEscritorio;
public class Contacto {
    private String nombre;
    private String apellido;
    private String numero;
    private String correo;
    private String direccion;
    private String estadoCivil;

    public Contacto(String nombre, String apellido, String numero, String correo, String direccion, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.correo = correo;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumero() {
        return numero;
    }

    public String getCorreo() {
        return correo;
    }
    
    public String getDireccion(){
        return direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }  
}

