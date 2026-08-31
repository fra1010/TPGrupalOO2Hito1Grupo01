package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
	public int agregarCliente(UnidadVenta objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
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
					.setParameter("codigo", codigo)
					.uniqueResult();
			Hibernate.initialize(unidadVenta.getResponsable());
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
					.setParameter("codigo", codigo)
					.uniqueResult();
			Hibernate.initialize(unidadVenta.getResponsable());
			Hibernate.initialize(unidadVenta.getEmpleados());
		} finally {
			session.close();
		}

		return unidadVenta;
	}
}
