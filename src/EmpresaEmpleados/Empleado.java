package EmpresaEmpleados;
public class Empleado {
    private String nombre;
    private String apellido;
    private String numeroSeguroSocial;
    private double salarioBase;
    
    public Empleado(String nombre, String apellido, String numeroSeguroSocial,double salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSeguroSocial = numeroSeguroSocial;
        setSalarioBase(salarioBase);
    }
    
    public double calcularDevengado(){
        return salarioBase;
    }
    
    public double calcularDeducciones(){
      return 0;
    }
    
    public double calcularSalarioNeto(){
        double devengado = calcularDevengado();
        double deducciones = calcularDeducciones();
        
       if (devengado - deducciones < 0) 
        return 0;
       
     else 
        return devengado - deducciones;
    
    }
    
    public void getInformacion(){
        System.out.println("Nombre: " + getNombre() +
                           "\nApellido: "+ getApellido() +
                           "\nNumero de seguro social: " + getNumeroSeguroSocial() +
                           "\nSalario Base: " + getSalarioBase());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public boolean setSalarioBase(double salarioBase) {
    if (salarioBase < 0) {
        return false;  
    }
    
    this.salarioBase = salarioBase;
    return true;  
}    
}
