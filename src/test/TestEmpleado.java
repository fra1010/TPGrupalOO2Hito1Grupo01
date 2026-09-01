package test;

import java.time.LocalDate;

import datos.Empleado;
import negocio.EmpleadoAbm;

public class TestEmpleado 
{
	 public static void main(String[] args) 
	 { 
		 EmpleadoAbm.getInstance().agregarEmpleadoCocinero("Ramon","Perez", 11111111,LocalDate.of(2000,10,6),LocalDate.of(2025,10,6),"fritos");
		 
		 EmpleadoAbm.getInstance().agregarEmpleadoCajero("Martin","Gomez",22222222,LocalDate.of(1999,11,23),LocalDate.of(2023,2,5),"tarde");
		 
		 int idEmpleado=1;
		 
		 System.out.printf("+ traer(%d)\n", idEmpleado);
		 
		 System.out.println(EmpleadoAbm.getInstance().traer(idEmpleado));

		 idEmpleado=2;
		 
		 System.out.printf("\n+ traer(%d)\n", idEmpleado);			
		 System.out.println(EmpleadoAbm.getInstance().traer(idEmpleado));
		 
		 System.out.println("\n+ traer()");
		 for (Empleado e: EmpleadoAbm.getInstance().traer()) 
		 {
			 System.out.println(e);
		 }	
	 }
}
