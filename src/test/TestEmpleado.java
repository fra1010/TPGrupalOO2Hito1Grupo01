package test;

import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;
import negocio.EmpleadoAbm;

public class TestEmpleado {

    public static void main(String[] args) 
    {
    	// ------- caso de uso 1: traer empleados por unidad de venta ------------

    	List<Empleado> empleados = null;

    	try 
    	{
    	    empleados = EmpleadoAbm.traerEmpleadosPorUnidadVenta();
    	} 
    	catch (Exception e) 
    	{
    	    System.out.println(e.getMessage());
    	}

    	System.out.println("------ EMPLEADOS POR UNIDAD DE VENTA ------");

    	for (Empleado empleado : empleados) 
    	{
    	    System.out.println("--------------------------------");

    	    System.out.println("Nombre: " + empleado.getNombre());
    	    System.out.println("Apellido: " + empleado.getApellido());

    	    if (empleado instanceof Cocinero) 
    	    {
    	        System.out.println("Tipo: Cocinero");
    	    } 
    	    else if (empleado instanceof Cajero) 
    	    {
    	        System.out.println("Tipo: Cajero");
    	    }

    	    // unidad de Venta
    	    if (empleado.getUnidadVenta() != null) 
    	    {
    	        System.out.println("Unidad de Venta: " + empleado.getUnidadVenta().getNombre());
    	    }

    	    // responsable
    	    if (empleado.getUnidadVenta() != null && empleado.getUnidadVenta().getResponsable() != null &&
    	        empleado.getUnidadVenta().getResponsable().getDni() == empleado.getDni()) 
    	    {
    	        System.out.println("Es ENCARGADO / RESPONSABLE");
    	    }
    	}

    	// ---- caso de uso 2: cantidad de empleados por unidad de venta -----
        
        List<String> lista = null;
		
        try 
		{
			lista = EmpleadoAbm.traerCantidadPorUnidadVenta();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

        System.out.println();
        
        System.out.println("\n----- CANTIDAD DE EMPLEADOS POR UNIDAD DE VENTA ----\n");

        for (String resultado : lista)
        {
            System.out.println(resultado);
        }
    }
}

