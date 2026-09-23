package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cajero;
import datos.Cocinero;
import datos.Empleado;
import datos.UnidadVenta;


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
	
	// -------------------------------------------------------------------
	// ------- METODOS DE CONSULTA DE BASE DE DATOS EMPLEADO -------------
	// -------------------------------------------------------------------
	
	
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

	//---------------------------------------------------------------------
	// ---- caso de uso 1: traer empleados por unidad de venta ------------
	//---------------------------------------------------------------------

	public List<Empleado> traerEmpleadosPorUnidadVenta()
	{
	    List<Empleado> lista = new ArrayList<Empleado>();

	    try
	    {
	        iniciaOperacion();

	        String hql = "select e from Empleado e "
	                   + "join fetch e.unidadVenta "
	                   + "where e.unidadVenta is not null "
	                   + "order by e.unidadVenta.nombre, e.apellido";

	        Query<Empleado> query =
	                session.createQuery(hql, Empleado.class);

	        lista = query.getResultList();
	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}

	// -------------------------------------------------------------------
	// ---- caso de uso 2: cantidad de empleados por unidad de venta -----
	// -------------------------------------------------------------------

	public List<String> traerCantidadPorUnidadVenta()
	{
	    List<String> lista = new ArrayList<String>();

	    try
	    {
	        iniciaOperacion();

	        String hql =
	                "select uv.nombre, " +
	                "sum(case when type(e) = Cocinero then 1 else 0 end), " +
	                "sum(case when type(e) = Cajero then 1 else 0 end), " +
	                "case when uv.responsable is not null then 1 else 0 end " +
	                "from UnidadVenta uv " +
	                "left join uv.empleados e " +
	                "group by uv.idUnidadVenta, uv.nombre " +
	                "order by uv.nombre";

	        Query<Object[]> query =
	                session.createQuery(hql, Object[].class);

	        List<Object[]> resultados = query.getResultList();

	        for (Object[] resultado : resultados)
	        {
	            String texto =
	                    "Unidad: " + resultado[0] +
	                    " | Cocineros: " + resultado[1] +
	                    " | Cajeros: " + resultado[2] +
	                    " | Encargados: " + resultado[3];

	            lista.add(texto);
	        }
	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}
	

}	
