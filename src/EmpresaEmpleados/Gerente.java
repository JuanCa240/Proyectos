
package EmpresaEmpleados;

public class Gerente extends Empleado {
    private double sueldoMensual;
    private double bonoMensual;
    private float retencionFuente;
    private float salud;
    private float pension;
    private float impuestoRiqueza;

    public Gerente(String nombre, String apellido, String numeroSeguroSocial, double salarioBase,double sueldoMensual, double bonoMensual, float retencionFuente, float salud, float pension, float impuestoRiqueza) {
        super(nombre, apellido, numeroSeguroSocial, salarioBase);
        this.sueldoMensual = sueldoMensual;
        this.bonoMensual = bonoMensual;
        this.retencionFuente = retencionFuente;
        this.salud = salud;
        this.pension = pension;
        this.impuestoRiqueza = impuestoRiqueza;
    }
    
    @Override
    public double calcularDevengado(){
        return sueldoMensual + bonoMensual;
    }

    @Override
    public double calcularDeducciones(){
        double deduccionRetencion = calcularDevengado() * (retencionFuente / 100);
        double deduccionSalud = calcularDevengado() * (salud / 100);
        double deduccionPension = calcularDevengado() * (pension / 100);
        double deduccionImpuestoRiqueza = calcularDevengado() * (impuestoRiqueza / 100);
        
        return deduccionRetencion + deduccionSalud + deduccionPension + deduccionImpuestoRiqueza;
    }
}
