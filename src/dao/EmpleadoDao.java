package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;

public class EmpleadoDao 
{
	private static Session session;
	private Transaction tx;
	
	private static EmpleadoDao instancia = null;

	protected EmpleadoDao() 
	{
		
	}

	public static EmpleadoDao getInstance() 
	{
		if (instancia == null)
		{	
			instancia = new EmpleadoDao();
		}	
		
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException 
	{
		tx.rollback();
		
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public void actualizar(Empleado objeto) 
	{
		try 
		{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} 
		catch (HibernateException he) 
		{
			manejaExcepcion(he);
		} finally 
		{
			session.close();
		}
	}
	
	// ------- METODOS DE CONSULTA DE BASE DE DATOS EMPLEADO -----------
	
	// ---- metodo agregar empleado a la base de datos -----
	
	public int agregar(Empleado objeto) 
	{
		int id = 0;

		try 
		{
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} 
		catch (HibernateException he) 
		{
			manejaExcepcion(he);
		} 
		finally 
		{
			session.close();
		}
		return id;
	}
	
	// ----- metodo traer empleado por su id -----
	
	public Empleado traer(int idEmpleado) 
	{
		Empleado objeto = null;
		
		try 
		{
			iniciaOperacion();

			objeto = (Empleado)session.createQuery(
					"from Empleado e where e.idEmpleado = :idEmpleado")
					.setParameter("idEmpleado", idEmpleado)
					.uniqueResult();
		} 
		finally 
		{
			session.close();
		}
		
		return objeto;
	}

	// -------- metodo traer empleado por su documento -------
	
	public Empleado traerPorDni(long dni)
	{
		Empleado objeto = null;

		try
		{
			iniciaOperacion();

			objeto = (Empleado) session.createQuery(
					"from Empleado e where e.dni = :dni")
					.setParameter("dni", dni)
					.uniqueResult();
		}
		finally
		{
			session.close();
		}

		return objeto;
	}
	
	// ------- metodo traer lista de todos los empleados -------- 
	
	public List<Empleado> traer() throws HibernateException 
	{
		List<Empleado> lista = new ArrayList<Empleado>();
		
		try 
		{
			iniciaOperacion();

			lista = session.createQuery(
					"from Empleado", Empleado.class)
					.list();
		} 
		finally 
		{
			session.close();
		}
		
		return lista;
	}

	// ------- traer una lista de empleados segun la fecha de nacimiento -------

	public List<Empleado> traerEmpleadosPorFechaNacimiento(LocalDate fechaNacimiento)
	{
		List<Empleado> lista = new ArrayList<Empleado>();

		try
		{
			iniciaOperacion();

			lista = session.createQuery(
					"from Empleado e where e.fechaNacimiento = :fechaNacimiento",
					Empleado.class)
					.setParameter("fechaNacimiento", fechaNacimiento)
					.list();
		}
		finally
		{
			session.close();
		}

		return lista;
	}
	
	// ------- traer una lista de cocineros -------

	public List<Cocinero> traerCocineros()
	{
		List<Cocinero> lista = new ArrayList<Cocinero>();

		try
		{
			iniciaOperacion();

			lista = session.createQuery(
					"from Cocinero",
					Cocinero.class)
					.list();
		}
		finally
		{
			session.close();
		}

		return lista;
	}
	
	// ----------- traer una lista de cocineros por especialidad ------------

	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad)
	{
		List<Cocinero> lista = new ArrayList<Cocinero>();

		try
		{
			iniciaOperacion();

			lista = session.createQuery(
				   "from Cocinero c where c.especialidad = :especialidad",
					Cocinero.class)
					.setParameter("especialidad", especialidad)
					.list();
		}
		finally
		{
			session.close();
		}

		return lista;
	}

	// ---------- traer una lista de cajeros segun el turno ----------

	public List<Cajero> traerCajerosPorTurno(String turno)
	{
		List<Cajero> lista = new ArrayList<Cajero>();

		try
		{
			iniciaOperacion();

			lista = session.createQuery(
					"from Cajero c where c.turno = :turno",
					Cajero.class)
					.setParameter("turno", turno)
					.list();
		}
		finally
		{
			session.close();
		}

		return lista;
	}

	// ---------- caso de uso 1: traer solo el empleado mas antiguo entre fechas -------------

	public Empleado traerEmpleadoConMasAntiguedadEntreFechas(LocalDate inicio, LocalDate fin)
	{
		Empleado empleado = null;

		try
		{
			iniciaOperacion();

			empleado = session.createQuery(
					"from Empleado e where e.ingreso between :inicio and :fin order by e.ingreso asc",
					Empleado.class)
					.setParameter("inicio", inicio)
					.setParameter("fin", fin)
					.setMaxResults(1)
					.uniqueResult();
		}
		finally
		{
			session.close();
		}

		return empleado;
	}
	
	// ------------------ caso de uso 2: traer una lista de empleados entre 2 fechas --------------------

	public List<Empleado> traerEmpleadosEntreFechasDeNacimiento(LocalDate fechaDesde, LocalDate fechaHasta)
	{
		List<Empleado> lista = new ArrayList<Empleado>();

		try
		{
			iniciaOperacion();

			lista = session.createQuery(
					"from Empleado e where e.fechaNacimiento between :fechaDesde and :fechaHasta",
					Empleado.class)
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.list();
		}
		finally
		{
			session.close();
		}

		return lista;
	}

	// -------- caso de uso 3: traer la lista de cocinero con menos anios de antiguedad --------

	public List<Cocinero> traerCocinerosConMenosDeAniosDeAntiguedad(int anios)
	{
		List<Cocinero> lista = new ArrayList<Cocinero>();

		try
		{
			iniciaOperacion();

			LocalDate fechaLimite = LocalDate.now().minusYears(anios);

			lista = session.createQuery(
					"from Cocinero c where c.ingreso > :fechaLimite",
					Cocinero.class)
					.setParameter("fechaLimite", fechaLimite)
					.list();
		}
		finally
		{
			session.close();
		}

		return lista;
	}

	// --- caso de uso 4: traer una lista de cajeros que ingresaron entre un intervalo de fechas ---

	public List<Cajero> traerCajerosEntreFechasDeIngreso(LocalDate fechaDesde, LocalDate fechaHasta) 
	{
	    List<Cajero> lista = new ArrayList<Cajero>();

	    try 
	    {
	        iniciaOperacion();

	        lista = session.createQuery(
	                "from Cajero c where c.ingreso >= :fechaDesde and c.ingreso <= :fechaHasta",
	                Cajero.class)
	        		.setParameter("fechaDesde", fechaDesde)
	        		.setParameter("fechaHasta", fechaHasta)
	        		.list();
	    } 
	    
	    finally 
	    {
	        session.close();
	    }

	    return lista;
	}
}
