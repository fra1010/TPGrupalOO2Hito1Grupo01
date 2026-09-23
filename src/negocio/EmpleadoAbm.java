package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.UnidadVenta;
import datos.Cocinero;
import datos.Cajero;

public class EmpleadoAbm 
{
	private static EmpleadoAbm instancia = null;

	public EmpleadoAbm() 
	{
		
	}

	public static EmpleadoAbm getInstance() 
	{
		if (instancia == null)
			instancia = new EmpleadoAbm();

		return instancia;
	}
	
	public int agregarEmpleadoCocinero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
			LocalDate ingreso,String especialidad,String categoria,int porcentaje) throws Exception
	{
		int id = 0;

		if (EmpleadoDao.getInstance().traerPorDni(dni) != null)
		{
			throw new Exception("ERROR: ya existe un empleado con dicho DNI");
		}

		id = EmpleadoDao.getInstance().agregar(new Cocinero(nombre,apellido,dni,fechaNacimiento,
				ingreso,especialidad,categoria,porcentaje));

		return id;
	}
	
	public int agregarEmpleadoCajero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
			LocalDate ingreso,String turno,double plusAntiguedad) throws Exception
	{
		int id = 0;

		if (EmpleadoDao.getInstance().traerPorDni(dni) != null)
		{
			throw new Exception("ERROR: ya existe un empleado con dicho DNI");
		}

		id = EmpleadoDao.getInstance().agregar(new Cajero(nombre,apellido,dni,fechaNacimiento,
					ingreso,turno,plusAntiguedad));

		return id;
	}

	public Empleado traer(int idEmpleado) throws Exception
	{
		Empleado e = EmpleadoDao.getInstance().traer(idEmpleado);

		if (e == null)
		{
			throw new Exception("ERROR: no existe empleado con dicho ID");
		}

		return e;
	}

	public List<Empleado> traer() throws Exception
	{
		List<Empleado> lista = EmpleadoDao.getInstance().traer();

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no hay empleados registrados");
		}

		return lista;
	}

	public void actualizar(Empleado empleado) 
	{
		EmpleadoDao.getInstance().actualizar(empleado);
	}
	
	//-----------------------------------------------------------------------------
    // ---- caso de uso 1: traer empleados por unidad de venta --------------------
	//-----------------------------------------------------------------------------
	
	public static List<Empleado> traerEmpleadosPorUnidadVenta()
	{
	    return EmpleadoDao.getInstance().traerEmpleadosPorUnidadVenta();
	}
	
	// ---- caso de uso 2: traer cantidades de empleados por unidad de venta --------------------
	
	public static List<String> traerCantidadPorUnidadVenta()
	{
	    return EmpleadoDao.getInstance().traerCantidadPorUnidadVenta();
	}

	
}

