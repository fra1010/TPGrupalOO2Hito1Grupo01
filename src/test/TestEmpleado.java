
package test;

import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;
import negocio.EmpleadoAbm;

public class TestEmpleado {

    public static void main(String[] args) 
    {
        EmpleadoAbm empleadoAbm = new EmpleadoAbm();

        // ---------------------------------------------------------------
        // caso de uso 1: traer empleados por unidad de venta
        // ---------------------------------------------------------------

        List<Empleado> empleados = null;

        try 
        {
            empleados = empleadoAbm.traerEmpleadosPorUnidad();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-------------TEST 1 EMPLEADOS POR UNIDAD DE VENTA -------------\n");

        if (empleados != null)
        {
            for (Empleado empleado : empleados) 
            {
            	System.out.println("---------------------------------------------------");
            	
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

                if (empleado.getUnidadVenta() != null) 
                {
                    System.out.println("Unidad de Venta: " + empleado.getUnidadVenta().getNombre());
                }

                if (empleado.getUnidadVenta() != null &&
                    empleado.getUnidadVenta().getResponsable() != null &&
                    empleado.getUnidadVenta().getResponsable().getDni() == empleado.getDni()) 
                {
                    System.out.println("Es ENCARGADO / RESPONSABLE");
                }
            }
        }

        // ---------------------------------------------------------------
        // caso de uso 2: cantidad de empleados por unidad de venta
        // ---------------------------------------------------------------

        List<String> lista = null;

        try 
        {
            lista = empleadoAbm.traerCantidadEmpleados();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("\n--------------TEST 2 CANTIDAD DE EMPLEADOS POR UNIDAD DE VENTA ----------\n");

        if (lista != null)
        {
            for (String resultado : lista)
            {
            	System.out.println("-----------------------------------------------");
            	System.out.println(resultado);
            }
        }

        // ---------------------------------------------------------------
        // caso de uso 3: empleados más antiguos
        // ---------------------------------------------------------------

        System.out.println();
        System.out.println("\n---------------TEST 3 EMPLEADOS MÁS ANTIGUOS ------------\n");

        List<Empleado> empleadosAntiguos = null;

        try
        {
            empleadosAntiguos = empleadoAbm.traerEmpleadosMasAntiguos(5);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        if (empleadosAntiguos != null)
        {
            for (Empleado empleado : empleadosAntiguos)
            {
                System.out.println("--------------------------------------------");
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("Ingreso: " + empleado.getIngreso());

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("Unidad de Venta: " + empleado.getUnidadVenta().getNombre());
                }
            }
        }
        
        // ---------------------------------------------------------------
        // caso de uso 4: aguinaldo por empleado y unidad de venta
        // ---------------------------------------------------------------

        List<Object[]> aguinaldos = null;

        try
        {
        	aguinaldos = empleadoAbm.traerAguinaldoPorEmpleado();
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("\n---------------TEST 4 AGUINALDO POR EMPLEADO ------------\n");
     
        if (aguinaldos != null)
        {
        	for (Object[] resultado : aguinaldos)
        	{
        		Empleado empleado = (Empleado) resultado[0];
        		String unidad = (String) resultado[1];
        		int sueldoBase = (Integer) resultado[2];
        		double adicional = (Double) resultado[3];
        		double aguinaldo = (Double) resultado[4];

        		System.out.println("--------------------------------------------");
        		System.out.println("Empleado: "+ empleado.getNombre() + " "+ empleado.getApellido());

        		System.out.println("Unidad de Venta: " + unidad);
        		System.out.println("Sueldo Base: $" + sueldoBase);
        		System.out.println("Adicional: $" + adicional);
        		System.out.println("Aguinaldo: $" + aguinaldo);
        	}
        }

        // ---------------------------------------------------------------
        // caso de uso 5: jubilación por empleado y unidad de venta
        // ---------------------------------------------------------------

        List<Object[]> jubilaciones = null;

        try
        {
        	jubilaciones = empleadoAbm.traerJubilacionPorEmpleado();
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("\n---------------TEST 5 APORTE JUBILATORIO POR EMPLEADO ------------\n");
     
        if (jubilaciones != null)
        {
        	for (Object[] resultado : jubilaciones)
        	{
        		Empleado empleado = (Empleado) resultado[0];
        		String unidad = (String) resultado[1];
        		int sueldoBase = (Integer) resultado[2];
        		double adicional = (Double) resultado[3];
        		double sueldo = (Double) resultado[4];
        		double jubilacion = (Double) resultado[5];

        		System.out.println("--------------------------------------------");

        		System.out.println("Empleado: "+ empleado.getNombre() + " "+ empleado.getApellido());

        		System.out.println("Unidad de Venta: " + unidad);
        		System.out.println("Sueldo Base: $" + sueldoBase);
        		System.out.println("Adicional: $" + adicional);
        		System.out.println("Sueldo: $" + sueldo);
        		System.out.println("Aporte Jubilatorio (11%): $" + jubilacion);
        	}
        }
    }
}
