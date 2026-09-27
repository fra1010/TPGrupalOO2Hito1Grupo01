
package negocio;

import java.time.LocalDate;
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

}
