package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;
import negocio.EmpleadoAbm;

public class TestEmpleado
{
    public static void main(String[] args)
    {
        EmpleadoAbm empleadoAbm = new EmpleadoAbm();

        // ---------------------------------------------------------------
        // Caso de uso 1: empleados por unidad de venta
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

        System.out.println("\n\t------------- TEST 1 EMPLEADOS POR UNIDAD DE VENTA -------------\n");

        if (empleados != null)
        {
            for (Empleado empleado : empleados)
            {
                System.out.println("\t---------------------------------------------------");
                System.out.println("\tNombre: " + empleado.getNombre());
                System.out.println("\tApellido: " + empleado.getApellido());

                if (empleado instanceof Cocinero)
                {
                    System.out.println("\tTipo: Cocinero");
                }
                else if (empleado instanceof Cajero)
                {
                    System.out.println("\t Tipo: Cajero");
                }

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("\tUnidad de Venta: " + empleado.getUnidadVenta().getNombre());

                    if (empleado.getUnidadVenta().getResponsable() != null &&
                        empleado.getUnidadVenta().getResponsable().getDni()== empleado.getDni())
                    {
                        System.out.println("\t Es ENCARGADO / RESPONSABLE");
                    }
                }
            }
        }

        // ---------------------------------------------------------------
        // Caso de uso 2: cantidad de empleados por unidad
        // ---------------------------------------------------------------

        List<String> cantidades = null;

        try
        {
            cantidades = empleadoAbm.traerCantidadEmpleadosPorUnidad();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\t-------------- TEST 2 CANTIDAD DE EMPLEADOS POR UNIDAD --------------\n");

        if (cantidades != null)
        {
            for (String resultado : cantidades)
            {
                System.out.println("\t-----------------------------------------------");
                System.out.println("\t" + resultado);
            }
        }

        // ---------------------------------------------------------------
        // Caso de uso 3: empleados mas antiguos
        // ---------------------------------------------------------------

        System.out.println("\n\t--------------- TEST 3 EMPLEADOS MÁS ANTIGUOS ---------------\n");

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
                System.out.println("\t--------------------------------------------");
                System.out.println("\tNombre: " + empleado.getNombre());
                System.out.println("\tApellido: " + empleado.getApellido());
                System.out.println("\tIngreso: " + empleado.getIngreso());

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("\tUnidad de Venta: "+ empleado.getUnidadVenta().getNombre());
                }
            }
        }

        // ---------------------------------------------------------------
        // Caso de uso 4: aguinaldo por empleado
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

        System.out.println("\n\t--------------- TEST 4 AGUINALDO POR EMPLEADO ---------------\n");

        if (aguinaldos != null)
        {
            for (Object[] resultado : aguinaldos)
            {
                Empleado empleado = (Empleado) resultado[0];
                String unidad = (String) resultado[1];
                int sueldoBase = (Integer) resultado[2];
                double adicional = (Double) resultado[3];
                double aguinaldo = (Double) resultado[4];

                System.out.println("\t--------------------------------------------");
                System.out.println("\tEmpleado: "+ empleado.getNombre()+ " "+ empleado.getApellido());
                System.out.println("\tUnidad de Venta: " + unidad);
                System.out.println("\t Sueldo Base: $" + sueldoBase);
                System.out.println("\tAdicional: $" + adicional);
                System.out.println("\t Aguinaldo: $" + aguinaldo);
            }
        }

        // ---------------------------------------------------------------
        // Caso de uso 5: aporte jubilatorio por empleado
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

        System.out.println("\n\t--------------- TEST 5 APORTE JUBILATORIO POR EMPLEADO ---------------\n");

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

                System.out.println("\t--------------------------------------------");
                System.out.println("\t Empleado: "+ empleado.getNombre()+ " "+ empleado.getApellido());
                System.out.println("\tUnidad de Venta: " + unidad);
                System.out.println("\t Sueldo Base: $" + sueldoBase);
                System.out.println("\tAdicional: $" + adicional);
                System.out.println("\t Sueldo: $" + sueldo);
                System.out.println("\tAporte Jubilatorio (11%): $" + jubilacion);
            }
        }

        // ---------------------------------------------------------------
        // Caso de uso 6: empleados ingresados entre dos fechas
        // ---------------------------------------------------------------

        LocalDate fechaDesde = LocalDate.of(2020, 1, 1);
        LocalDate fechaHasta = LocalDate.of(2024, 12, 31);

        List<Empleado> empleadosEntreFechas = null;

        try
        {
            empleadosEntreFechas = empleadoAbm.traerEmpleadosEntreFechas(fechaDesde,fechaHasta);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\t--------------- TEST 6 EMPLEADOS ENTRE DOS FECHAS ---------------\n");

        System.out.println("\tDesde: " + fechaDesde +"\tHasta: " + fechaHasta);

        if (empleadosEntreFechas != null)
        {
            for (Empleado empleado : empleadosEntreFechas)
            {
                System.out.println("\t--------------------------------------------");
                System.out.println("\t Nombre: " + empleado.getNombre());
                System.out.println("\t Apellido: " + empleado.getApellido());
                System.out.println("\t Ingreso: " + empleado.getIngreso());

                if (empleado instanceof Cocinero)
                {
                    System.out.println("\t Tipo: Cocinero");
                }
                else if (empleado instanceof Cajero)
                {
                    System.out.println("\t Tipo: Cajero");
                }

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("\t Unidad de Venta: "+ empleado.getUnidadVenta().getNombre());
                }
            }
        }

        // ---------------------------------------------------------------
        // Caso de uso 7: total de sueldos por unidad
        // ---------------------------------------------------------------

        List<Object[]> totales = null;

        try
        {
            totales = empleadoAbm.traerTotalSueldosPorUnidad();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\t--------------- TEST 7 TOTAL DE SUELDOS POR UNIDAD ---------------\n");

        if (totales != null)
        {
            for (Object[] resultado : totales)
            {
                System.out.println("\t--------------------------------------------");

                System.out.println("\tUnidad: " + resultado[0]);

                System.out.println("\tTotal de sueldos: $" + resultado[1]);
            }
        }
    }
}

