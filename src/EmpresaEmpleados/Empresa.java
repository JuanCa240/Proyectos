package EmpresaEmpleados;

import java.util.ArrayList;

public class Empresa {
    ArrayList<Empleado> empleados;
    
    EmpleadoPorHoras horas;
    EmpleadoPorSueldo sueldo;
    Gerente gerente;
    
    public Empresa(){
       empleados = new ArrayList<Empleado>();
    }
    
    public void agregar(Empleado e){
        empleados.add(e);
    }
    
    public double calcularNomina(Empleado e){
        return e.calcularSalarioNeto();
    }
    
    public double calcularNominaTotal() {
        double total = 0;
        for (int j = 0; j < empleados.size(); j++) {
            total += calcularNomina(empleados.get(j));
        }
        return total; 
    }
    
    public void mostrarNominaTotal() {
        double nominaTotal = calcularNominaTotal();
        System.out.println("Nómina total: " + String.format("%.2f", nominaTotal));
    }
    
    public void mostrarInformacionEmpleados() {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            empleado.getInformacion(); 
            
            System.out.println("Salario Devengado: " + String.format("%.2f", empleado.calcularDevengado()));
            System.out.println("Deducciones: " + String.format("%.2f", empleado.calcularDeducciones()));
            System.out.println("Salario Neto: " + String.format("%.2f", empleado.calcularSalarioNeto()));
            System.out.println();
        }
    }  
}
