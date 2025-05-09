package EmpresaEmpleados;

public class EmpleadoPorSueldo extends Empleado {
    protected double sueldoMensual;
    private float retencionFuente; // %
    private float fondoSolidaridad; // %
    protected float salud; // %
    protected float pension; // %

    public EmpleadoPorSueldo(String nombre, String apellido, String numeroSeguroSocial, double salarioBase,double sueldoMensual) {
        super(nombre, apellido, numeroSeguroSocial, salarioBase);
        this.sueldoMensual = sueldoMensual;
    }
    
    @Override
    public double calcularDevengado(){
        return sueldoMensual;
    }
    @Override
     public double calcularDeducciones(){
        double deduccionRetencion = sueldoMensual * (retencionFuente / 100);
        double deduccionFondo = sueldoMensual * (fondoSolidaridad / 100);
        double deduccionSalud = sueldoMensual * (salud / 100);
        double deduccionPension = sueldoMensual * (pension / 100);
        return deduccionRetencion + deduccionFondo + deduccionSalud + deduccionPension;
    }

    public void setRetencionFuente(float retencionFuente) {
        this.retencionFuente = retencionFuente;
    }

    public void setFondoSolidaridad(float fondoSolidaridad) {
        this.fondoSolidaridad = fondoSolidaridad;
    }
    
    public void setSalud(float salud) {
        this.salud = salud;
    }

    public void setPension(float pension) {
        this.pension = pension;
    }
}
