package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
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

	// ----------- traer una lista de empleados por fecha de nacimiento -------------

	public List<Empleado> traerEmpleadosPorFechaNacimiento(LocalDate fechaNacimiento) throws Exception
	{
		List<Empleado> lista = EmpleadoDao.getInstance().traerEmpleadosPorFechaNacimiento(fechaNacimiento);

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no se encontraron empleados con esa fecha de nacimiento");
		}

		return lista;
	}

	// -------- traer una lista de cocineros por especialidad ---------

	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad) throws Exception
	{
		List<Cocinero> lista = EmpleadoDao.getInstance().traerCocinerosPorEspecialidad(especialidad);

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no se encontraron cocineros con esa especialidad");
		}

		return lista;
	}

	// --------- traer una lista de cajeros por turno ------------

	public List<Cajero> traerCajerosPorTurno(String turno) throws Exception
	{
		List<Cajero> lista = EmpleadoDao.getInstance().traerCajerosPorTurno(turno);

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no se encontraron cajeros con ese turno");
		}

		return lista;
	}

	// ------------- traer una lista de cocineros ------------------

	public List<Cocinero> traerCocineros() throws Exception
	{
		List<Cocinero> lista = EmpleadoDao.getInstance().traerCocineros();

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no hay cocineros registrados");
		}

		return lista;
	}

	// ------------- traer al empleado con mas antiguedad entre 2 fechas ---------------

	public Empleado traerEmpleadoConMasDeAniosDeAntiguedad(LocalDate inicio, LocalDate fin) throws Exception
	{
		Empleado e = EmpleadoDao.getInstance().traerEmpleadoConMasAntiguedadEntreFechas(inicio, fin);

		if (e == null)
		{
			throw new Exception("ERROR: no se encontro ningun empleado");
		}

		return e;
	}

	// ------------------------- traer empleados que nacieron entre 2 fechas -------------------------

	public List<Empleado> traerEmpleadosEntreFechasDeNacimiento(LocalDate fechaDesde, LocalDate fechaHasta) throws Exception
	{
		List<Empleado> lista = EmpleadoDao.getInstance().traerEmpleadosEntreFechasDeNacimiento(fechaDesde, fechaHasta);

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no se encontraron empleados entre esas fechas");
		}

		return lista;
	}

	// ------------ traer una lista de cocineros con menos anios de antiguedad -------------

	public List<Cocinero> traerCocinerosConMenosDeAniosDeAntiguedad(int anios) throws Exception
	{
		List<Cocinero> lista = EmpleadoDao.getInstance().traerCocinerosConMenosDeAniosDeAntiguedad(anios);

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no se encontraron cocineros con menos de " + anios + " anios de antiguedad");
		}

		return lista;
	}

	// ------------------------- traer cajeros con fecha de ingreso entre 2 fechas -------------------------

	public List<Cajero> traerCajerosEntreFechasDeIngreso(LocalDate fechaDesde, LocalDate fechaHasta) throws Exception
	{
		List<Cajero> lista = EmpleadoDao.getInstance().traerCajerosEntreFechasDeIngreso(fechaDesde, fechaHasta);

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no se encontraron cajeros entre esas fechas de ingreso");
		}

		return lista;
	}
}

