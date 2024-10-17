package EmpresaEmpleados;

public class Menu {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        // Crear empleados con un salario base válido
        EmpleadoPorHoras empleadoHoras = new EmpleadoPorHoras("Juan", "Pérez", "123456789", 1500, 40, 20);
        empleadoHoras.setRetencionFuente(10); // 10% de retención en la fuente
        empleadoHoras.setFondoSolidaridad(5); // 5% de fondo de solidaridad

        EmpleadoPorSueldo empleadoSueldo = new EmpleadoPorSueldo("Ana", "Gómez", "987654321", 2000, 3000);
        empleadoSueldo.setRetencionFuente(15); // 15% de retención en la fuente
        empleadoSueldo.setFondoSolidaridad(3); // 3% de fondo de solidaridad
        empleadoSueldo.setSalud(4); // 4% de salud
        empleadoSueldo.setPension(4); // 4% de pensión

        Gerente gerente = new Gerente("Carlos", "Martínez", "135792468", 4000, 10000, 2000, 10, 15, 6, 2);

        // Agregar empleados a la empresa
        empresa.agregar(empleadoHoras);
        empresa.agregar(empleadoSueldo);
        empresa.agregar(gerente);

        // Mostrar información de los empleados
        empresa.mostrarInformacionEmpleados();

        // Calcular y mostrar la nómina total
        empresa.mostrarNominaTotal();
    }
}
