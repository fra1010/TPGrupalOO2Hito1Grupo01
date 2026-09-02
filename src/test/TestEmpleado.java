
package test;

import datos.Cocinero;
import datos.Empleado;

import java.time.LocalDate;

import datos.Cajero;
import negocio.EmpleadoAbm;

public class TestEmpleado 
{
    public static void main(String[] args) 
    {
        System.out.println("\n---------------- CASO DE USO 1 ----------------\n");

        for (Cocinero cocinero : EmpleadoAbm.getInstance().traerCocinerosPorEspecialidad("fritos")) 
        {
            System.out.println(cocinero);
        }
        
        System.out.println("\n---------------- CASO DE USO 2 ----------------\n");

        for (Cajero cajero : EmpleadoAbm.getInstance().traerCajerosPorTurno("tarde")) 
        {
            System.out.println(cajero);
        }
        
        System.out.println("\n---------------- CASO DE USO 3 ----------------\n");

        for (Empleado empleado : EmpleadoAbm.getInstance().traerEmpleadosPorFechaNacimiento(LocalDate.of(2000, 10, 6))) 
        {
            System.out.println(empleado);
        }
        
        System.out.println("\n---------------- CASO DE USO 4 ----------------\n");

        for (Cocinero cocinero : EmpleadoAbm.getInstance().traerCocineros()) 
        {
            System.out.println(cocinero);
        }
    }
}
