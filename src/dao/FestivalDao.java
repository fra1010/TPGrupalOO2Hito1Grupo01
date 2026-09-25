package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.UnidadVenta;
import datos.Empleado;
import datos.Festival;

public class FestivalDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Festival objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return id;
	}

	public Festival traer(int idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.get(Festival.class, idFestival);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Festival traerPorNombre(String nombre) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival where nombre = :nombre";
			objeto = (Festival) session.createQuery(hql).setParameter("nombre", nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public void actualizar(Festival objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Festival objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// query
	public List<Festival> traer() {
		List<Festival> lista = new ArrayList<Festival>();

		try {
			iniciaOperacion();

			Query<Festival> query = session.createQuery("from Festival f", Festival.class);
			lista = query.getResultList();

		} finally {
			session.close();
		}
		return lista;

	}

	public Festival traerFestivalYCosto(int idFestival) throws HibernateException {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival f inner join fetch f.costo where f.idFestival = :idFestival";
			objeto = (Festival) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public Festival traerFestivalYUnidadesVenta(int idFestival) {

		Festival objeto = null;

		try {
			iniciaOperacion();

			String hql = "from Festival f " + "left join fetch f.unidadesVenta " + "where f.idFestival = :idFestival";

			objeto = (Festival) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();

		} finally {
			session.close();
		}

		return objeto;
	}

	public UnidadVenta traerUnidadPorCodigo(String codigo) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			String hql = "from UnidadVenta uv where uv.codigo = :codigo";
			objeto = (UnidadVenta) session.createQuery(hql).setParameter("codigo", codigo).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Festival> traerPorRangoDeFechas(LocalDate desde, LocalDate hasta) {
		List<Festival> lista = new ArrayList<Festival>();
		try {
			iniciaOperacion();

			String hql = "from Festival f " + "where f.fechaInicio >= :desde and f.fechaFin <= :hasta "
					+ "order by f.fechaInicio";

			Query<Festival> query = session.createQuery(hql, Festival.class);
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);

			lista = query.getResultList();

		} finally {
			session.close();
		}
		return lista;
	}

	public List<Festival> traerPorTemporada(String temporada) {
		List<Festival> lista = new ArrayList<Festival>();
		try {
			iniciaOperacion();

			String hql = "from Festival f where f.temporada = :temporada order by f.fechaInicio";

			Query<Festival> query = session.createQuery(hql, Festival.class);
			query.setParameter("temporada", temporada);

			lista = query.getResultList();

		} finally {
			session.close();
		}
		return lista;
	}

	public List<Festival> traerPorRangoDeCosto(int montoMinimo, int montoMaximo) {
		List<Festival> lista = new ArrayList<Festival>();
		try {
			iniciaOperacion();

			String hql = "select f from Festival f inner join fetch f.costo c "
					+ "where (c.costoSuperficie + c.costoMontaje + c.costoElectricidad + c.sueldoBase) "
					+ "between :min and :max "
					+ "order by (c.costoSuperficie + c.costoMontaje + c.costoElectricidad + c.sueldoBase) desc";

			Query<Festival> query = session.createQuery(hql, Festival.class);
			query.setParameter("min", montoMinimo);
			query.setParameter("max", montoMaximo);

			lista = query.getResultList();

		} finally {
			session.close();
		}
		return lista;
	}

	public List<Festival> traerPorTipoUnidad(String tipoUnidad) {
		List<Festival> lista = new ArrayList<Festival>();

		try {
			iniciaOperacion();

			String tipoClase = tipoUnidad.equalsIgnoreCase("FoodTruck") ? "FoodTruck" : "PuestoDesarmable";

			String hql = "SELECT DISTINCT f " + "FROM Festival f " + "LEFT JOIN FETCH f.unidadesVenta "
					+ "WHERE EXISTS (" + "  SELECT u2 FROM UnidadVenta u2 " + "  WHERE u2.festival = f "
					+ "  AND TYPE(u2) = " + tipoClase + ")";

			lista = session.createQuery(hql, Festival.class).getResultList();

		} finally {
			session.close();
		}

		return lista;
	}

	public double calcularGananciaPlatos(int idFestival) {
		Number resultado = null;
		try {
			iniciaOperacion();

			String hql = "SELECT SUM((i.precioUnitario - i.costoUnitario) * i.cantidad) " + "FROM ItemPedido i "
					+ "JOIN i.pedido p " + "JOIN p.unidad u " + "JOIN u.festival f "
					+ "WHERE f.idFestival = :idFestival";

			resultado = (Number) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();

		} finally {
			session.close();
		}

		if (resultado != null) {
			return resultado.doubleValue();
		} else {
			return 0;
		}
	}
	
	public List<Object[]> traerUnidadesMasRentablesPorFestival(int idFestival, int top) { // se usa lista de object porque en cada fila de la consulta hibernate empaqueta la unidad y su ganancia
	    List<Object[]> lista = new ArrayList<Object[]>();

	    try {
	        iniciaOperacion();

	        String hql = "SELECT u, SUM((i.precioUnitario - i.costoUnitario) * i.cantidad) "
	                + "FROM ItemPedido i "
	                + "JOIN i.pedido p "
	                + "JOIN p.unidad u "
	                + "JOIN u.festival f "
	                + "WHERE f.idFestival = :idFestival "
	                + "AND p.abierto = false "
	                + "GROUP BY u "
	                + "ORDER BY SUM((i.precioUnitario - i.costoUnitario) * i.cantidad) DESC";

	        lista = session.createQuery(hql, Object[].class)
	                .setParameter("idFestival", idFestival)
	                .setMaxResults(top)
	                .getResultList();

	    } finally {
	        session.close();
	    }

	    return lista;
	}
	
	public Object[] traerDiaDeMayorRecaudacion(int idFestival) {
	    Object[] resultado = null;

	    try {
	        iniciaOperacion();

	        String hql = "SELECT p.fechaTransaccion, SUM(i.precioUnitario * i.cantidad) "
	                + "FROM ItemPedido i "
	                + "JOIN i.pedido p "
	                + "JOIN p.unidad u "
	                + "JOIN u.festival f "
	                + "WHERE f.idFestival = :idFestival "
	                + "AND p.abierto = false "
	                + "GROUP BY p.fechaTransaccion " //agrupa por fecha 
	                + "ORDER BY SUM(i.precioUnitario * i.cantidad) DESC";

	        List<Object[]> lista = session.createQuery(hql, Object[].class)
	                .setParameter("idFestival", idFestival)
	                .setMaxResults(1)// deja solamente el dia de mayor recaudacion
	                .getResultList();

	        if (!lista.isEmpty()) {
	            resultado = lista.get(0);
	        }

	    } finally {
	        session.close();
	    }

	    return resultado;
	}
	
	public Object[] calcularTicketPromedio(int idFestival) {//la consulta obtiene la cantidad de pedidos cerrados y su recaudacion total
	    Object[] resultado = null;

	    try {
	        iniciaOperacion();

	        String hql = "SELECT COUNT(DISTINCT p.idPedido), SUM(i.precioUnitario * i.cantidad) "
	                + "FROM ItemPedido i "
	                + "JOIN i.pedido p "
	                + "JOIN p.unidad u "
	                + "JOIN u.festival f "
	                + "WHERE f.idFestival = :idFestival "
	                + "AND p.abierto = false";

	        resultado = (Object[]) session.createQuery(hql, Object[].class)
	                .setParameter("idFestival", idFestival)
	                .uniqueResult();

	    } finally {
	        session.close();
	    }

	    return resultado;
	}
	
	public List<Object[]> compararGananciaPorTipoUnidad(int idFestival) {
	    List<Object[]> lista = new ArrayList<Object[]>();

	    try {
	        iniciaOperacion();

	        String hql = "SELECT TYPE(u), SUM((i.precioUnitario - i.costoUnitario) * i.cantidad) "
	                + "FROM ItemPedido i "
	                + "JOIN i.pedido p "
	                + "JOIN p.unidad u "
	                + "JOIN u.festival f "
	                + "WHERE f.idFestival = :idFestival "
	                + "AND p.abierto = false "
	                + "GROUP BY TYPE(u)";

	        lista = session.createQuery(hql, Object[].class)
	                .setParameter("idFestival", idFestival)
	                .getResultList();

	    } finally {
	        session.close();
	    }

	    return lista;
	}

	public double calcularCostosFijos(int idFestival) {
		Number resultado = null;
		try {
			iniciaOperacion();

			String hql = "SELECT (f.costo.costoSuperficie + f.costo.costoMontaje + f.costo.costoElectricidad) "
					+ "FROM Festival f " + "WHERE f.idFestival = :idFestival";

			resultado = (Number) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();

		} finally {
			session.close();
		}

		if (resultado != null) {
			return resultado.doubleValue();
		} else {
			return 0;
		}
	}

	public double calcularSueldos(int idFestival) {
		Number cocineros = null;
		Number cajeros = null;

		try {
			iniciaOperacion();

			String hqlCocineros = "SELECT SUM(f.costo.sueldoBase + (f.costo.sueldoBase * co.porcentaje / 100.0)) "
					+ "FROM Cocinero co " + "JOIN co.unidadVenta u " + "JOIN u.festival f "
					+ "WHERE f.idFestival = :idFestival";

			cocineros = (Number) session.createQuery(hqlCocineros).setParameter("idFestival", idFestival)
					.uniqueResult();

		} finally {
			session.close();
		}

		try {
			iniciaOperacion();

			String hqlCajeros = "SELECT SUM(f.costo.sueldoBase + ca.plusAntiguedad) " + "FROM Cajero ca "
					+ "JOIN ca.unidadVenta u " + "JOIN u.festival f " + "WHERE f.idFestival = :idFestival";

			cajeros = (Number) session.createQuery(hqlCajeros).setParameter("idFestival", idFestival).uniqueResult();

		} finally {
			session.close();
		}

		double totalCocineros;
		if (cocineros != null) {
			totalCocineros = cocineros.doubleValue();
		} else {
			totalCocineros = 0;
		}

		double totalCajeros;
		if (cajeros != null) {
			totalCajeros = cajeros.doubleValue();
		} else {
			totalCajeros = 0;
		}

		return totalCocineros + totalCajeros;
	}

	public List<Object[]> calcularCostosFijosTodos() {
		List<Object[]> lista = new ArrayList<Object[]>();
		try {
			iniciaOperacion();

			String hql = "SELECT f, (c.costoSuperficie + c.costoMontaje + c.costoElectricidad) " + "FROM Festival f "
					+ "JOIN f.costo c";

			lista = session.createQuery(hql, Object[].class).getResultList();

		} finally {
			session.close();
		}
		return lista;
	}

	public List<Object[]> calcularSueldosCocinerosTodos() {
		List<Object[]> lista = new ArrayList<Object[]>();
		try {
			iniciaOperacion();

			String hql = "SELECT f.idFestival, SUM(c.sueldoBase + (c.sueldoBase * co.porcentaje / 100.0)) "
					+ "FROM Cocinero co " + "JOIN co.unidadVenta u " + "JOIN u.festival f " + "JOIN f.costo c "
					+ "GROUP BY f.idFestival";

			lista = session.createQuery(hql, Object[].class).getResultList();

		} finally {
			session.close();
		}
		return lista;
	}

	public List<Object[]> calcularSueldosCajerosTodos() {
		List<Object[]> lista = new ArrayList<Object[]>();
		try {
			iniciaOperacion();

			String hql = "SELECT f.idFestival, SUM(c.sueldoBase + ca.plusAntiguedad) " + "FROM Cajero ca "
					+ "JOIN ca.unidadVenta u " + "JOIN u.festival f " + "JOIN f.costo c " + "GROUP BY f.idFestival";

			lista = session.createQuery(hql, Object[].class).getResultList();

		} finally {
			session.close();
		}
		return lista;
	}
	
	// -------------------------------------------------------------------
    // Caso de uso 1: traer lista de empleados por festival IVAN TOLABA
    // -------------------------------------------------------------------

	public List<Empleado> traerEmpleadosPorFestival(Festival festival)
	{
	    List<Empleado> lista = new ArrayList<Empleado>();

	    try
	    {
	        iniciaOperacion();

	        lista = session.createQuery(
	            "SELECT e " +
	            "FROM Festival f " +
	            "JOIN f.unidadesVenta uv " +
	            "JOIN uv.empleados e " +
	            "JOIN FETCH e.unidadVenta " +
	            "WHERE f = :festival " +
	            "ORDER BY uv.nombre, e.apellido",
	            Empleado.class
	        ).setParameter("festival", festival).getResultList();

	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}

	// -------------------------------------------------------------------
	// Caso de uso 2: traer cantidad de empleados por festival IVAN TOLABA
	// -------------------------------------------------------------------
	
	public List<Object[]> traerCantidadEmpleadosPorUnidad(Festival festival)
	{
	    List<Object[]> lista = new ArrayList<Object[]>();

	    try
	    {
	        iniciaOperacion();

	        lista = session.createQuery(
	            "SELECT uv.nombre, " +
	            "SUM(CASE WHEN TYPE(e) = Cocinero THEN 1 ELSE 0 END), " +
	            "SUM(CASE WHEN TYPE(e) = Cajero THEN 1 ELSE 0 END), " +
	            "CASE WHEN uv.responsable IS NOT NULL THEN 1 ELSE 0 END " +
	            "FROM Festival f " +
	            "JOIN f.unidadesVenta uv " +
	            "LEFT JOIN uv.empleados e " +
	            "WHERE f = :festival " +
	            "GROUP BY uv.idUnidadVenta, uv.nombre, uv.responsable " +
	            "ORDER BY uv.nombre",
	            Object[].class
	        )
	        .setParameter("festival", festival)
	        .getResultList();
	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}

	
	
	// -----------------------------------------------------------------------------
    // Caso de uso 3: traer lista de empleados mas antiguos por festival IVAN TOLABA
    // ------------------------------------------------------------------------------

	public List<Empleado> traerEmpleadosMasAntiguos(Festival festival, int cantidad)
	{
	    List<Empleado> lista = new ArrayList<Empleado>();

	    try
	    {
	        iniciaOperacion();

	        lista = session.createQuery(
	            "SELECT e " +
	            "FROM Festival f " +
	            "JOIN f.unidadesVenta uv " +
	            "JOIN uv.empleados e " +
	            "JOIN FETCH e.unidadVenta " +
	            "WHERE f = :festival " +
	            "ORDER BY e.ingreso ASC",
	            Empleado.class
	        )
	        .setParameter("festival", festival)
	        .setMaxResults(cantidad)
	        .getResultList();

	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}

	// -----------------------------------------------------------------------
    // Caso de uso 4: traer empleados entre fechas por festival IVAN TOLABA
    // -----------------------------------------------------------------------
	
	public List<Empleado> traerEmpleadosEntreFechas(Festival festival,LocalDate fechaDesde,LocalDate fechaHasta)
	{
	    List<Empleado> lista = new ArrayList<Empleado>();

	    try
	    {
	        iniciaOperacion();

	        lista = session.createQuery(
	            "SELECT e " +
	            "FROM Festival f " +
	            "JOIN f.unidadesVenta uv " +
	            "JOIN uv.empleados e " +
	            "JOIN FETCH e.unidadVenta " +
	            "WHERE f = :festival " +
	            "AND e.ingreso BETWEEN :fechaDesde AND :fechaHasta " +
	            "ORDER BY uv.nombre, e.ingreso, e.apellido",
	            Empleado.class
	        )
	        .setParameter("festival", festival)
	        .setParameter("fechaDesde", fechaDesde)
	        .setParameter("fechaHasta", fechaHasta)
	        .getResultList();

	    }
	    finally
	    {
	        session.close();
	    }

	    return lista;
	}

}
