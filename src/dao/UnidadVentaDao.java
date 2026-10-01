package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Festival;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;

public class UnidadVentaDao {
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

	public int agregarUnidadVenta(UnidadVenta objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException e) {

			manejaExcepcion(e);
		} finally {
			session.close();
		}

		return id;
	}

	public UnidadVenta traer(String codigo) {
		UnidadVenta unidadVenta = null;
		try {
			iniciaOperacion();
			unidadVenta = (UnidadVenta) session.createQuery(" from UnidadVenta u where u.codigo = :codigo")
					.setParameter("codigo", codigo).uniqueResult();
			if (unidadVenta != null) {
				Hibernate.initialize(unidadVenta.getResponsable());
				Hibernate.initialize(unidadVenta.getFestival());

			}

		} finally {
			session.close();
		}

		return unidadVenta;
	}

	public UnidadVenta traerUnidadYEmpleados(String codigo) {
		UnidadVenta unidadVenta = null;
		try {
			iniciaOperacion();
			unidadVenta = (UnidadVenta) session.createQuery(" from UnidadVenta u where u.codigo = :codigo")
					.setParameter("codigo", codigo).uniqueResult();
			if (unidadVenta != null) {
				Hibernate.initialize(unidadVenta.getEmpleados());
			}
		} finally {
			session.close();
		}

		return unidadVenta;
	}

	public void actualizar(UnidadVenta objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public List<UnidadVenta> traer() {
		List<UnidadVenta> lista = new ArrayList<UnidadVenta>();
		try {
			iniciaOperacion();
			Query<UnidadVenta> query = session.createQuery("from UnidadVenta u order by u.nombre asc",
					UnidadVenta.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public void eliminar(UnidadVenta objeto) {
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

	public int agregarUnidadVentaYPlatos(UnidadVenta objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());

			for (Plato p : objeto.getPlatos()) {
				p.setUnidad(objeto);
				session.save(p);
			}
			tx.commit();
		} catch (HibernateException e) {

			manejaExcepcion(e);
		} finally {
			session.close();
		}

		return id;
	}

	public UnidadVenta traerUnidadVentaYPedidosEitem(String codigo) {

		UnidadVenta unidadVenta = null;
		try {
			iniciaOperacion();
			unidadVenta = (UnidadVenta) session.createQuery(" from UnidadVenta u where u.codigo = :codigo")
					.setParameter("codigo", codigo).uniqueResult();
			if (unidadVenta != null) {
				Hibernate.initialize(unidadVenta.getPedidos());

				for (Pedido p : unidadVenta.getPedidos()) {
					Hibernate.initialize(p.getItemsPedidos());
					for (ItemPedido i : p.getItemsPedidos()) {
						Hibernate.initialize(i.getPlato());
					}
				}

			}
		} finally {
			session.close();
		}

		return unidadVenta;
	}

	public List<Plato> traerPlatosPorUnidadYRangoPrecio(String codigoUnidad, double precioDesde, double precioHasta) {
		List<Plato> lista = null;
		try {
			iniciaOperacion();
			String hQL = "select p from UnidadVenta u " + "inner join u.platos p " + "where u.codigo = :codigoUnidad "
					+ "and p.precioDeVenta between :precioDesde and :precioHasta " + "order by p.precioDeVenta asc";

			lista = session.createQuery(hQL, Plato.class).setParameter("codigoUnidad", codigoUnidad)
					.setParameter("precioDesde", precioDesde).setParameter("precioHasta", precioHasta).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public UnidadVenta traerUnidadYPlatos(String codigo) {
		UnidadVenta unidadVenta = null;
		try {
			iniciaOperacion();
			unidadVenta = (UnidadVenta) session.createQuery("from UnidadVenta u where u.codigo = :codigo")
					.setParameter("codigo", codigo).uniqueResult();
			if (unidadVenta != null) {
				Hibernate.initialize(unidadVenta.getPlatos());
			}
		} finally {
			session.close();
		}

		return unidadVenta;
	}

	public UnidadVenta traerUnidadVentaYEmpleadosYFestival(String codigo) {
		UnidadVenta unidadVenta = null;
		try {
			iniciaOperacion();
			unidadVenta = (UnidadVenta) session.createQuery(" from UnidadVenta u where u.codigo = :codigo")
					.setParameter("codigo", codigo).uniqueResult();
			if (unidadVenta != null) {
				Hibernate.initialize(unidadVenta.getEmpleados());
				Hibernate.initialize(unidadVenta.getFestival());
			}
		} finally {
			session.close();
		}

		return unidadVenta;
	}

	public UnidadVenta traerUnidadVentaEstrellaConEmpleados(Festival festival) {
		UnidadVenta unidadMayorRecaudacion = null;
		try {

			iniciaOperacion();

			// Paso 1: Obtener la UnidadVenta con mayor recaudación

			String hql =" select u FROM UnidadVenta u " 
			           +" JOIN u.pedidos p "
					   +" JOIN p.itemsPedidos ip "
					   +" WHERE u.festival = :festival " + "GROUP BY u "
					   +" ORDER BY SUM(ip.precioUnitario * ip.cantidad) DESC";
			unidadMayorRecaudacion = session.createQuery(hql, UnidadVenta.class).setParameter("festival", festival)
					.setMaxResults(1).uniqueResult();

			// Paso 2: inicializo los empleados de la unidad
			if (unidadMayorRecaudacion != null) {
				Hibernate.initialize(unidadMayorRecaudacion.getEmpleados());

			}
		} finally {
			session.close();
		}

		return unidadMayorRecaudacion;
	}

	public double unidadVentaTotalVentaMenosCostoPlato(String codigoUnidad, Festival festival) {
		double totalGanancia = 0;
		try {

			iniciaOperacion();

			String hql = "SELECT SUM((ip.precioUnitario - ip.costoUnitario) * ip.cantidad)" + " FROM UnidadVenta uv"
					+ " JOIN uv.pedidos p" + " JOIN p.itemsPedidos ip" + " WHERE uv.codigo = :codigoUnidad "
					+ " AND uv.festival = :festival";

			totalGanancia = session.createQuery(hql, Double.class).setParameter("codigoUnidad", codigoUnidad)
					.setParameter("festival", festival).uniqueResult();

		} finally {
			session.close();
		}

		return totalGanancia;
	}

	public double calcularCanonUnidadVenta(String codigoUnidad, Festival festival) {

		double totalCanon = 0;
		try {

			iniciaOperacion();

			String hql = "SELECT CASE " + "    WHEN TYPE(u) = FoodTruck THEN "
					+ "        ((u.superficie * u.festival.costo.costoSuperficie) + "
					+ "         (CASE WHEN u.conexion = true THEN u.festival.costo.costoElectricidad ELSE 0 END)) "
					+ "    WHEN TYPE(u) = PuestoDesarmable THEN "
					+ "        ((u.superficie * u.festival.costo.costoSuperficie) + "
					+ "         (u.cantidadCarpas * u.festival.costo.costoMontaje)) " + "    ELSE 0 " + "END "
					+ "FROM UnidadVenta u " + "WHERE u.festival= :festival " + "AND u.codigo = :codigoUnidad";

			totalCanon = session.createQuery(hql, Double.class).setParameter("codigoUnidad", codigoUnidad)
					.setParameter("festival", festival).uniqueResult();

		} finally {
			session.close();
		}

		return totalCanon;

	}

	public double calcularSueldoEmpleadosDeUnidadVenta(String codigoUnidad, Festival festival) {
		double totalSueldoUnidad = 0;
		try {

			iniciaOperacion();
			String hqlE = "SELECT COALESCE(SUM( " + "  CASE " + "    WHEN TYPE(e) = Cocinero THEN "
					+ "        (c.sueldoBase * (1 + COALESCE(e.porcentaje, 0) / 100.0)) "
					+ "    WHEN TYPE(e) = Cajero THEN " + "        (c.sueldoBase + COALESCE(e.plusAntiguedad, 0)) "
					+ "    ELSE 0 " + "  END " + "), 0.0) " + "FROM UnidadVenta uv " + "JOIN uv.empleados e "
					+ "JOIN uv.festival f " + "JOIN f.costo c " + "WHERE uv.festival = :festival "
					+ "AND uv.codigo = :codigoUnidad";
			totalSueldoUnidad = session.createQuery(hqlE, Double.class).setParameter("festival", festival)
					.setParameter("codigoUnidad", codigoUnidad).uniqueResult();

		} finally {
			session.close();
		}

		return totalSueldoUnidad;
	}
}
