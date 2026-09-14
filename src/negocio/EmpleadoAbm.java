package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.Cocinero;
import datos.Cajero;

public class EmpleadoAbm 
{
	private static EmpleadoAbm instancia = null; // Patrón Singleton

	public EmpleadoAbm() 
	{
		
	}

	public static EmpleadoAbm getInstance() 
	{
		if (instancia == null)
			instancia = new EmpleadoAbm();
		return instancia;
	}
	
	public int agregarEmpleadoCocinero(String nombre, String apellido, long dni,LocalDate fechaNacimiento, LocalDate ingreso, String especialidad,String categoria,int porcentaje)
	{
	    int id = 0;

	    if (EmpleadoDao.getInstance().traerPorDni(dni) == null)
	    {
	        id = EmpleadoDao.getInstance().agregar(new Cocinero(nombre, apellido, dni, fechaNacimiento, ingreso, especialidad,categoria,porcentaje));
	    }

	    return id;
	}
	
	public int agregarEmpleadoCajero(String nombre, String apellido, long dni,LocalDate fechaNacimiento, LocalDate ingreso, String turno,double plusAntiguedad)
	{
	    int id = 0;

	    if (EmpleadoDao.getInstance().traerPorDni(dni) == null)
	    {
	        id = EmpleadoDao.getInstance().agregar(new Cajero(nombre, apellido, dni, fechaNacimiento, ingreso, turno,plusAntiguedad));
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

	// --------------------CASO DE USO 1----------------------------
	
	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad)
	{
		return EmpleadoDao.getInstance().traerCocinerosPorEspecialidad(especialidad);
	}

	// --------------------CASO DE USO 2----------------------------
	
	public List<Cajero> traerCajerosPorTurno(String turno)
	{
		 return EmpleadoDao.getInstance().traerCajerosPorTurno(turno);
	}

	// --------------------CASO DE USO 3----------------------------
	
	public List<Empleado> traerEmpleadosPorFechaNacimiento(LocalDate fechaNacimiento)
	{
		return EmpleadoDao.getInstance().traerEmpleadosPorFechaNacimiento(fechaNacimiento);
	}
	
	// --------------------CASO DE USO 4----------------------------
	
	public List<Cocinero> traerCocineros()
	{
		return EmpleadoDao.getInstance().traerCocineros();
	}
	
	// ---------------------------- CASO DE USO 5 -----------------------------

	public Empleado traerEmpleadoConMasDeAniosDeAntiguedad(LocalDate inicio,LocalDate fin)
	{
	    return EmpleadoDao.getInstance().traerEmpleadoConMasAntiguedadEntreFechas(inicio,fin);
	}

	// ---------------------------- CASO DE USO 6 -----------------------------

	public List<Cocinero> traerCocinerosConMenosDeAniosDeAntiguedad(int anios)
	{
		
	    return EmpleadoDao.getInstance().traerCocinerosConMenosDeAniosDeAntiguedad(anios);
	}

	// ---------------------------- CASO DE USO 7 -----------------------------

	public List<Cajero> traerCajerosEntreFechasDeIngreso(LocalDate fechaDesde, LocalDate fechaHasta)
	{
	    return EmpleadoDao.getInstance().traerCajerosEntreFechasDeIngreso(fechaDesde, fechaHasta);
	}

	// ---------------------------- CASO DE USO 8 -----------------------------

	public List<Empleado> traerEmpleadosEntreFechasDeNacimiento(LocalDate fechaDesde, LocalDate fechaHasta)
	{
	    return EmpleadoDao.getInstance().traerEmpleadosEntreFechasDeNacimiento(fechaDesde, fechaHasta);
	}

}
