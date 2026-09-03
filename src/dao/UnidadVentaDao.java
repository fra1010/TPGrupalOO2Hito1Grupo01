package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
				Hibernate.initialize(unidadVenta.getResponsable());
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
				p.setUnidadVenta(objeto);
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
}
