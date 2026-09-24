package test;

import java.time.LocalDate;
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
        // caso de uso 1: empleados por unidad de venta
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
                    System.out.println("\tTipo: Cajero");
                }

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("\tUnidad de Venta: " + empleado.getUnidadVenta().getNombre());
                }

                if (empleado.getUnidadVenta() != null &&
                    empleado.getUnidadVenta().getResponsable() != null &&
                    empleado.getUnidadVenta().getResponsable().getDni() == empleado.getDni())
                {
                    System.out.println("\tEs ENCARGADO / RESPONSABLE");
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

        System.out.println("\n\t-------------- TEST 2 CANTIDAD DE EMPLEADOS POR UNIDAD --------------\n");

        if (lista != null)
        {
            for (String resultado : lista)
            {
                System.out.println("\t-----------------------------------------------");
                System.out.println("\t" + resultado);
            }
        }

        // ---------------------------------------------------------------
        // caso de uso 3: empleados mas antiguos
        // ---------------------------------------------------------------

        System.out.println();
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
                    System.out.println("\tUnidad de Venta: " + empleado.getUnidadVenta().getNombre());
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
                System.out.println("\t Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
                System.out.println("\t Unidad de Venta: " + unidad);
                System.out.println("\t Sueldo Base: $" + sueldoBase);
                System.out.println("\t Adicional: $" + adicional);
                System.out.println("\t Aguinaldo: $" + aguinaldo);
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
                System.out.println("\t Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
                System.out.println("\t Unidad de Venta: " + unidad);
                System.out.println("\t Sueldo Base: $" + sueldoBase);
                System.out.println("\t Adicional: $" + adicional);
                System.out.println("\t Sueldo: $" + sueldo);
                System.out.println("\t Aporte Jubilatorio (11%): $" + jubilacion);
            }
        }

        // ---------------------------------------------------------------
        // caso de uso 6: empleados ingresados entre dos fechas
        // ---------------------------------------------------------------

        LocalDate fechaDesde = LocalDate.of(2020, 1, 1);
        LocalDate fechaHasta = LocalDate.of(2024, 12, 31);

        List<Empleado> empleadosEntreFechas = null;

        try
        {
            empleadosEntreFechas = empleadoAbm.traerEmpleadosEntreFechas(fechaDesde, fechaHasta);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\t--------------- TEST 6 EMPLEADOS ENTRE DOS FECHAS ---------------\n");
        System.out.println("\t Desde: " + fechaDesde + "\t Hasta: " + fechaHasta);

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
                    System.out.println("\tTipo: Cocinero");
                }
                else if (empleado instanceof Cajero)
                {
                    System.out.println("\t Tipo: Cajero");
                }

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("\t Unidad de Venta: " + empleado.getUnidadVenta().getNombre());
                }
            }
        }

        // ---------------------------------------------------------------
        // caso de uso 7: total de sueldo por unidad de venta
        // ---------------------------------------------------------------

        List<Object[]> totales = null;

        try
        {
            totales = empleadoAbm.traerTotalSueldoPorUnidad();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--------------- TEST 7 TOTAL DE SUELDO POR UNIDAD ---------------\n");

        if (totales != null)
        {
            for (Object[] resultado : totales)
            {
                System.out.println("--------------------------------------------");
                System.out.println("\n Unidad: " + resultado[0]);
                System.out.println("\n Total de sueldos: $" + resultado[1]);
            }
        }
    }
}
