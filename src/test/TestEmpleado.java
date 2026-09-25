package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;
import datos.Festival;
import negocio.FestivalABM;

public class TestEmpleado
{
    public static void main(String[] args)
    {
        FestivalABM festivalABM = new FestivalABM();

        // -------------------------------------------------------------------
        // Caso de uso 1: traer empleados por festival - IVAN TOLABA
        // -------------------------------------------------------------------

        try
        {
            Festival festival = festivalABM.traer(1);
            List<Empleado> empleados = festivalABM.traerEmpleadosPorFestival(festival);

            System.out.println("\n------------- EMPLEADOS DEL FESTIVAL -------------\n");
            System.out.println("Festival: " + festival.getNombre());

            for (Empleado empleado : empleados)
            {
                System.out.println("---------------------------------------------");
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

                    if (empleado.getUnidadVenta().getResponsable() != null &&
                        empleado.getUnidadVenta().getResponsable().getDni() == empleado.getDni())
                    {
                        System.out.println("Es ENCARGADO / RESPONSABLE");
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // -------------------------------------------------------------------
        // Caso de uso 2: cantidad de empleados por unidad - IVAN TOLABA
        // -------------------------------------------------------------------

        try
        {
            Festival festival = festivalABM.traer(2);
            List<Object[]> resultados = festivalABM.traerCantidadEmpleadosPorUnidad(festival);

            System.out.println("\n------------- CANTIDAD DE EMPLEADOS POR UNIDAD -------------\n");
            System.out.println("Festival: " + festival.getNombre());

            for (Object[] resultado : resultados)
            {
                System.out.println("---------------------------------------------");
                System.out.println("Unidad: " + resultado[0]);
                System.out.println("Cocineros: " + resultado[1]);
                System.out.println("Cajeros: " + resultado[2]);
                System.out.println("Encargados: " + resultado[3]);
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // -------------------------------------------------------------------
        // Caso de uso 3: empleados más antiguos por festival - IVAN TOLABA
        // -------------------------------------------------------------------

        try
        {
            Festival festival = festivalABM.traer(3);
            List<Empleado> empleados = festivalABM.traerEmpleadosMasAntiguos(festival, 3);

            System.out.println("\n------------- EMPLEADOS MAS ANTIGUOS DEL FESTIVAL -------------\n");
            System.out.println("Festival: " + festival.getNombre());

            for (Empleado empleado : empleados)
            {
                System.out.println("---------------------------------------------");
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("Fecha de ingreso: " + empleado.getIngreso());

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("Unidad de Venta: " + empleado.getUnidadVenta().getNombre());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // -------------------------------------------------------------------
        // Caso de uso 4: empleados entre fechas por festival - IVAN TOLABA
        // -------------------------------------------------------------------

        try
        {
            Festival festival = festivalABM.traer(1);

            List<Empleado> empleados = festivalABM.traerEmpleadosEntreFechas(festival,LocalDate.of(2010, 1, 1),LocalDate.of(2025, 12, 31));

            System.out.println("\n------------- EMPLEADOS INGRESADOS ENTRE FECHAS -------------\n");
            System.out.println("Festival: " + festival.getNombre());
            System.out.println("Desde: 01/01/2010");
            System.out.println("Hasta: 31/12/2025");

            for (Empleado empleado : empleados)
            {
                System.out.println("---------------------------------------------");
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("DNI: " + empleado.getDni());
                System.out.println("Fecha de ingreso: " + empleado.getIngreso());

                if (empleado.getUnidadVenta() != null)
                {
                    System.out.println("Unidad de Venta: " + empleado.getUnidadVenta().getNombre());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}


