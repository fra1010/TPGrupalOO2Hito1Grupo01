package test;

import datos.Cocinero;
import datos.Empleado;

import java.time.LocalDate;
import java.util.List;

import datos.Cajero;
import negocio.EmpleadoAbm;

public class TestEmpleado 
{
    public static void main(String[] args) 
    {
    	EmpleadoAbm empleado1 = new EmpleadoAbm();
    	
    	// ---------------------------- CARGAR DATOS ----------------------------
    	
    	empleado1.agregarEmpleadoCocinero("pepe", "Armando", 2551546, LocalDate.of(2000, 10, 6), LocalDate.of(2015, 3, 20), "fritos", "chef", 16);
    	empleado1.agregarEmpleadoCocinero("Juan", "Perez", 2551547, LocalDate.of(1995, 8, 15), LocalDate.of(2024, 2, 10), "pastas", "ayudante", 10);
    	empleado1.agregarEmpleadoCocinero("Pedro", "Gomez", 2551548, LocalDate.of(1990, 12, 1), LocalDate.of(2021, 7, 5), "carnes", "chef", 20);
    	empleado1.agregarEmpleadoCajero("Jose", "Fernandez", 3333546, LocalDate.of(2000, 10, 6), LocalDate.of(2018, 6, 15), "tarde", 15.5);
    	empleado1.agregarEmpleadoCajero("Maria", "Lopez", 3333547, LocalDate.of(1998, 4, 20), LocalDate.of(2023, 1, 10), "manana", 10);
    	empleado1.agregarEmpleadoCajero("Ana", "Rodriguez", 3333548, LocalDate.of(1987, 11, 30), LocalDate.of(2012, 9, 1), "noche", 25);
    	empleado1.agregarEmpleadoCajero("Jose", "Fernandez", 3333546, LocalDate.of(2000, 10, 6), LocalDate.of(2018, 6, 15), "tarde", 15.5);
    	empleado1.agregarEmpleadoCajero("Maria", "Lopez", 3333547, LocalDate.of(1998, 4, 20), LocalDate.of(2023, 1, 10), "manana", 10);
    	empleado1.agregarEmpleadoCajero("Ana", "Rodriguez", 3333548, LocalDate.of(1987, 11, 30), LocalDate.of(2012, 9, 1), "noche", 25);
    	empleado1.agregarEmpleadoCajero("Lucas", "Ramirez", 3333549, LocalDate.of(1992, 7, 14), LocalDate.of(2010, 2, 15), "tarde", 30);
    	empleado1.agregarEmpleadoCajero("Carla", "Moreno", 3333550, LocalDate.of(2001, 5, 22), LocalDate.of(2025, 3, 10), "manana", 5);
    	empleado1.agregarEmpleadoCajero("Diego", "Castro", 3333551, LocalDate.of(1994, 11, 8), LocalDate.of(2019, 8, 5), "noche", 20);
    	empleado1.agregarEmpleadoCajero("Valentina", "Rojas", 3333552, LocalDate.of(1985, 2, 28), LocalDate.of(2014, 10, 18), "manana", 28);

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

        for (Empleado empleado : EmpleadoAbm.getInstance().traerEmpleadosPorFechaNacimiento(
        		LocalDate.of(2000, 10, 6))) 
        {
            System.out.println(empleado);
        }
        
        System.out.println("\n---------------- CASO DE USO 4 ----------------\n");

        for (Cocinero cocinero : EmpleadoAbm.getInstance().traerCocineros()) 
        {
            System.out.println(cocinero);
        }
        
        System.out.println("\n---------------- CASO DE USO 5 ----------------\n");
        System.out.println("Empleados con mas de 5 anios de antiguedad:");

        
        // AGREGAR EXCEPCION
        
        System.out.println(EmpleadoAbm.getInstance().traerEmpleadoConMasDeAniosDeAntiguedad(LocalDate.of(1999, 2, 3), LocalDate.of(2020, 2, 3)));

        
        System.out.println("\n---------------- CASO DE USO 6 ----------------\n");
        System.out.println("Cocineros con menos de 3 años de antiguedad:");

        for (Cocinero cocinero : EmpleadoAbm.getInstance().traerCocinerosConMenosDeAniosDeAntiguedad(3))
        {
            System.out.println(cocinero);
        }
        
        System.out.println("\n---------------- CASO DE USO 7 ----------------\n");
        System.out.println("Cajeros ingresados entre 2020 y 2025:");

        for (Cajero cajero : EmpleadoAbm.getInstance().traerCajerosEntreFechasDeIngreso(
        				LocalDate.of(2020, 1, 1),LocalDate.of(2025, 12, 31)))
        {
            System.out.println(cajero);
        }
        
        System.out.println("\n---------------- CASO DE USO 8 ----------------\n");
        System.out.println("Empleados nacidos entre 1990 y 2005:");

        for (Empleado empleado : EmpleadoAbm.getInstance().traerEmpleadosEntreFechasDeNacimiento(
        				LocalDate.of(1990, 1, 1),LocalDate.of(2005, 12, 31)))
        {
            System.out.println(empleado);
        }
      
    }
}

