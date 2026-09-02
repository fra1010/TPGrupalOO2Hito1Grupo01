package dao;

import java.time.LocalDate;
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
	
	private static EmpleadoDao instancia = null; // Patrón Singleton

	protected EmpleadoDao() 
	{
		
	}

	public static EmpleadoDao getInstance() 
	{
		if (instancia == null)
			instancia = new EmpleadoDao();
		
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException 
	{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

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
	
	public Empleado traer(int idEmpleado) 
	{
		Empleado objeto = null;
		
		try 
		{
			iniciaOperacion();
			objeto = (Empleado) session.createQuery("from Empleado e where e.idEmpleado=:idEmpleado")
						.setParameter("idEmpleado", idEmpleado).uniqueResult();
		} 
		finally 
		{
			session.close();
		}
		
		return objeto;
	}

	public Empleado traerPorDni(long dni)
	{
	    Empleado objeto = null;

	    try
	    {
	        iniciaOperacion();
	        objeto = (Empleado) session.createQuery("from Empleado e where e.dni = :dni")
	                .setParameter("dni", dni).uniqueResult();
	    }
	    finally
	    {
	        session.close();
	    }

	    return objeto;
	}
	
	public List<Empleado> traer() throws HibernateException 
	{
		List<Empleado> lista = null;
		
		try 
		{
			iniciaOperacion();
			lista = session.createQuery("from Empleado",Empleado.class).list();
		} 
		finally 
		{
			session.close();
		}
		
		return lista;
	}
	

	// ------------------------- CASO DE USO 1 ---------------------------------
	
	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad)
	{
	    List<Cocinero> lista = null;

	    try
	    {
	        iniciaOperacion();
	        lista = session.createQuery("from Cocinero c where c.especialidad = :especialidad",Cocinero.class)
	                .setParameter("especialidad", especialidad).list();
	    }
	    finally
	    {
	        session.close();
	    }
	    return lista;
	}

	// ----------------------------CASO DE USO 2-----------------------------
	
	public List<Cajero> traerCajerosPorTurno(String turno)
	{
	    List<Cajero> lista = null;

	    try
	    {
	        iniciaOperacion();
	        lista = session.createQuery("from Cajero c where c.turno = :turno",
	                Cajero.class).setParameter("turno", turno).list();
	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}

	// ---------------------------CASO DE USO 3------------------------------

	public List<Empleado> traerEmpleadosPorFechaNacimiento(LocalDate fechaNacimiento)
	{
	    List<Empleado> lista = null;

	    try
	    {
	        iniciaOperacion();
	        lista = session.createQuery("from Empleado e where e.fechaNacimiento = :fechaNacimiento",
	                Empleado.class).setParameter("fechaNacimiento", fechaNacimiento).list();
	    }
	    finally
	    {
	        session.close();
	    }
	    return lista;
	}

	// ----------------------------CASO DE USO 4-----------------------------

	public List<Cocinero> traerCocineros()
	{
	    List<Cocinero> lista = null;

	    try
	    {
	        iniciaOperacion();
	        lista = session.createQuery("from Cocinero",Cocinero.class).list();
	    }
	    finally
	    {
	        session.close();
	    }
	    return lista;
	}
	
}


