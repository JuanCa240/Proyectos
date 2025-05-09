package EmpresaEmpleados;

public class EmpleadoPorHoras extends Empleado{
    protected int horasTrabajadas;
    protected double tarifaPorHora;
    private float retencionFuente; // Porcentaje
    private float fondoSolidaridad; // Porcentaje


    public EmpleadoPorHoras(String nombre, String apellido, String numeroSeguroSocial, double salarioBase, int horasTrabajadas, double tarifaPorHora) {
        super(nombre, apellido, numeroSeguroSocial, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    
    @Override
    public double calcularDevengado(){
        return horasTrabajadas * tarifaPorHora;
    }
    
    @Override
    public double calcularDeducciones(){
        double devengado = calcularDevengado();
        double deduccionRetencion = devengado * (retencionFuente / 100);
        double deduccionFondo = devengado * (fondoSolidaridad / 100);
        return deduccionRetencion + deduccionFondo;
    }

    public float getRetencionFuente() {
        return retencionFuente;
    }

    public void setRetencionFuente(float retencionFuente) {
        this.retencionFuente = retencionFuente;
    }

    public float getFondoSolidaridad() {
        return fondoSolidaridad;
    }

    public void setFondoSolidaridad(float fondoSolidaridad) {
        this.fondoSolidaridad = fondoSolidaridad;
    }
}
