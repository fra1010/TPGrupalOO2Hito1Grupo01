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
			LocalDate ingreso,String especialidad,String categoria,int porcentaje)
	{
		int id = 0;

		if (EmpleadoDao.getInstance().traerPorDni(dni) == null)
		{
			id = EmpleadoDao.getInstance().agregar(new Cocinero(nombre,apellido,dni,fechaNacimiento,
					ingreso,especialidad,categoria,porcentaje));
		}

		return id;
	}
	
	public int agregarEmpleadoCajero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
			LocalDate ingreso,String turno,double plusAntiguedad)
	{
		int id = 0;

		if (EmpleadoDao.getInstance().traerPorDni(dni) == null)
		{
			id = EmpleadoDao.getInstance().agregar(new Cajero(nombre,apellido,dni,fechaNacimiento,
							ingreso,turno,plusAntiguedad));
		}

		return id;
	}

	public Empleado traer(int idEmpleado) 
	{
		return EmpleadoDao.getInstance().traer(idEmpleado);
	}

	public List<Empleado> traer() 
	{
		return EmpleadoDao.getInstance().traer();
	}

	// ----------- traer una lista de empleados por fecha de nacimiento -------------

	public List<Empleado> traerEmpleadosPorFechaNacimiento(LocalDate fechaNacimiento)
	{
		return EmpleadoDao.getInstance().traerEmpleadosPorFechaNacimiento(fechaNacimiento);
	}
	
	// -------- traer una lista de cocineros por especialidad ---------

	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad)
	{
		return EmpleadoDao.getInstance().traerCocinerosPorEspecialidad(especialidad);
	}

	// --------- traer una lista de cajeros por turno ------------

	public List<Cajero> traerCajerosPorTurno(String turno)
	{
		return EmpleadoDao.getInstance().traerCajerosPorTurno(turno);
	}

	// ------------- traer una lista de cocineros ------------------

	public List<Cocinero> traerCocineros()
	{
		return EmpleadoDao.getInstance().traerCocineros();
	}
	
	// ------------- traer al empleado con mas antiguedad entre 2 fechas ---------------

	public Empleado traerEmpleadoConMasDeAniosDeAntiguedad(LocalDate inicio, LocalDate fin)
	{
		return EmpleadoDao.getInstance().traerEmpleadoConMasAntiguedadEntreFechas(inicio, fin);
	}
	
	// ------------------------- traer empleados que nacieron entre 2 fechas -------------------------

	public List<Empleado> traerEmpleadosEntreFechasDeNacimiento(LocalDate fechaDesde, LocalDate fechaHasta)
	{
			return EmpleadoDao.getInstance().traerEmpleadosEntreFechasDeNacimiento(fechaDesde, fechaHasta);
	}

	// ------------ traer una lista de cocineros con menos anios de antiguedad -------------

	public List<Cocinero> traerCocinerosConMenosDeAniosDeAntiguedad(int anios)
	{
		return EmpleadoDao.getInstance().traerCocinerosConMenosDeAniosDeAntiguedad(anios);
	}

	// ------------------------- traer cajeros con fecha de ingreso entre 2 fechas -------------------------

	public List<Cajero> traerCajerosEntreFechasDeIngreso(LocalDate fechaDesde, LocalDate fechaHasta)
	{
		return EmpleadoDao.getInstance().traerCajerosEntreFechasDeIngreso(fechaDesde, fechaHasta);
	}

}


