
package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.EmpleadoDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;

public class EmpleadoAbm
{
    private static EmpleadoAbm instancia = null;

    public EmpleadoAbm()
    {
    }

    public static EmpleadoAbm getInstance()
    {
        if (instancia == null)
        {
            instancia = new EmpleadoAbm();
        }

        return instancia;
    }

    // -------------------------------------------------------------------
    // Alta de empleados
    // -------------------------------------------------------------------

    public int agregarEmpleadoCocinero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
    		LocalDate ingreso,String especialidad,String categoria,int porcentaje) throws Exception
    {
        if (EmpleadoDao.getInstance().traerPorDni(dni) != null)
        {
            throw new Exception("ERROR: ya existe un empleado con dicho DNI");
        }

        return EmpleadoDao.getInstance().agregar(new Cocinero(nombre,apellido,dni,fechaNacimiento,
                        ingreso,especialidad,categoria,porcentaje));
    }

    public int agregarEmpleadoCajero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
            LocalDate ingreso,String turno,double plusAntiguedad) throws Exception
    {
        if (EmpleadoDao.getInstance().traerPorDni(dni) != null)
        {
            throw new Exception("ERROR: ya existe un empleado con dicho DNI");
        }

        return EmpleadoDao.getInstance().agregar(new Cajero(nombre,apellido,dni,fechaNacimiento,
                        ingreso,turno,plusAntiguedad));
    }

    // -------------------------------------------------------------------
    // Consultas basicas
    // -------------------------------------------------------------------

    public Empleado traer(int idEmpleado) throws Exception
    {
        Empleado empleado = EmpleadoDao.getInstance().traerPorId(idEmpleado);

        if (empleado == null)
        {
            throw new Exception("ERROR: no existe empleado con dicho ID");
        }

        return empleado;
    }

    public List<Empleado> traer() throws Exception
    {
        List<Empleado> empleados = EmpleadoDao.getInstance().traerTodos();

        if (empleados.isEmpty())
        {
            throw new Exception("ERROR: no hay empleados registrados");
        }

        return empleados;
    }

    public void actualizar(Empleado empleado)
    {
        EmpleadoDao.getInstance().actualizar(empleado);
    }

    // -------------------------------------------------------------------
    // Caso de uso 1: empleados por unidad
    // -------------------------------------------------------------------

    public List<Empleado> traerEmpleadosPorUnidad()
    {
        return EmpleadoDao.getInstance().traerEmpleadosPorUnidad();
    }

    // -------------------------------------------------------------------
    // Caso de uso 2: cantidad de empleados por unidad
    // -------------------------------------------------------------------

    public List<String> traerCantidadEmpleadosPorUnidad()
    {
        return EmpleadoDao.getInstance().traerCantidadEmpleadosPorUnidad();
    }

    // -------------------------------------------------------------------
    // Caso de uso 3: empleados mas antiguos
    // -------------------------------------------------------------------

    public List<Empleado> traerEmpleadosMasAntiguos(int cantidad)
    {
        return EmpleadoDao.getInstance().traerEmpleadosMasAntiguos(cantidad);
    }

    // -------------------------------------------------------------------
    // Caso de uso 4: aguinaldo por empleado
    // -------------------------------------------------------------------

    public List<Object[]> traerAguinaldoPorEmpleado()
    {
        List<Object[]> resultados = new ArrayList<Object[]>();

        List<Object[]> datos = EmpleadoDao.getInstance().traerEmpleadosConSueldo();

        int anioActual = LocalDate.now().getYear();

        for (Object[] dato : datos)
        {
            Empleado empleado = (Empleado) dato[0];
            String unidad = (String) dato[1];
            int sueldoBase = (Integer) dato[2];

            double adicional = calcularAdicional(empleado,sueldoBase,anioActual);

            double sueldo = sueldoBase + adicional;
            double aguinaldo = sueldo / 2;

            resultados.add(new Object[]{empleado,unidad,sueldoBase,adicional,aguinaldo});
        }

        return resultados;
    }

    // -------------------------------------------------------------------
    // Caso de uso 5: aporte jubilatorio por empleado
    // -------------------------------------------------------------------

    public List<Object[]> traerJubilacionPorEmpleado()
    {
        List<Object[]> resultados = new ArrayList<Object[]>();

        List<Object[]> datos = EmpleadoDao.getInstance().traerEmpleadosConSueldo();

        int anioActual = LocalDate.now().getYear();

        for (Object[] dato : datos)
        {
            Empleado empleado = (Empleado) dato[0];
            String unidad = (String) dato[1];
            int sueldoBase = (Integer) dato[2];

            double adicional = calcularAdicional(empleado,sueldoBase,anioActual);

            double sueldo = sueldoBase + adicional;

            double jubilacion = sueldo * 0.11;

            resultados.add(new Object[]{empleado,unidad,sueldoBase,adicional,sueldo,jubilacion});
        }

        return resultados;
    }

    // -------------------------------------------------------------------
    // Calculo del adicional segun el tipo de empleado
    // -------------------------------------------------------------------

    private double calcularAdicional(Empleado empleado,int sueldoBase,int anioActual)
    {
        if (empleado instanceof Cajero)
        {
            Cajero cajero = (Cajero) empleado;

            int antiguedad = anioActual - empleado.getIngreso().getYear();

            return cajero.getPlusAntiguedad() * antiguedad;
        }

        if (empleado instanceof Cocinero)
        {
            Cocinero cocinero = (Cocinero) empleado;

            return sueldoBase * cocinero.getPorcentaje() / 100.0;
        }

        return 0;
    }

    // -------------------------------------------------------------------
    // Caso de uso 6: empleados ingresados entre dos fechas
    // -------------------------------------------------------------------

    public List<Empleado> traerEmpleadosEntreFechas(LocalDate fechaDesde,LocalDate fechaHasta)
    {
        return EmpleadoDao.getInstance().traerEmpleadosEntreFechas(fechaDesde,fechaHasta);
    }

    // -------------------------------------------------------------------
    // Caso de uso 7: total de sueldo por unidad
    // -------------------------------------------------------------------

    public List<Object[]> traerTotalSueldosPorUnidad()
    {
        return EmpleadoDao.getInstance().traerTotalSueldosPorUnidad();
    }
}
