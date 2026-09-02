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

	protected EmpleadoAbm() 
	{
		
	}

	public static EmpleadoAbm getInstance() 
	{
		if (instancia == null)
			instancia = new EmpleadoAbm();
		return instancia;
	}
	
	public int agregarEmpleadoCocinero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,LocalDate ingreso,String especialidad) 
	{
		return EmpleadoDao.getInstance().agregar(new Cocinero(nombre,apellido,dni,fechaNacimiento,ingreso,especialidad));
	}

	public int agregarEmpleadoCajero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,LocalDate ingreso,String turno)
	{
		return EmpleadoDao.getInstance().agregar(new Cajero(nombre,apellido,dni,fechaNacimiento,ingreso,turno));
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
	
}
