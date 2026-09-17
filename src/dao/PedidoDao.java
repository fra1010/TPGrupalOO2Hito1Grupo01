package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Pedido;
import datos.UnidadVenta;

public class PedidoDao {
	
	
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

	public int agregar(Pedido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Pedido objeto) {
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

	public void eliminar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Pedido traer(int idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.get(Pedido.class, idPedido);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Pedido> traer() {

	    List<Pedido> lista = new ArrayList<Pedido>();
	    try {
	        iniciaOperacion();

	        Query<Pedido> query = session.createQuery("from Pedido p order by p.idPedido asc", Pedido.class);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}

	public Pedido traerPedidoEItems(int idPedido) throws HibernateException {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Pedido p where p.idPedido=:idPedido";
			objeto=(Pedido) session.createQuery(hql).setParameter("idPedido", idPedido).uniqueResult();
			Hibernate.initialize(objeto.getItemsPedidos());
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	public Object[] traerCierreDiario(UnidadVenta unidad, LocalDate fecha) {

	    Object[] resultado = null;

	    try {
	        iniciaOperacion();

	        String hql = "SELECT COUNT(DISTINCT p.idPedido), "
	                + "SUM(i.cantidad), "
	                + "SUM(i.precioUnitario * i.cantidad), "
	                + "SUM(i.costoUnitario * i.cantidad), "
	                + "SUM((i.precioUnitario - i.costoUnitario) * i.cantidad) "
	                + "FROM Pedido p "
	                + "JOIN p.itemsPedidos i "
	                + "WHERE p.unidad = :unidad "
	                + "AND p.fechaTransaccion = :fecha "
	                + "AND p.abierto = false";

	        resultado = session.createQuery(hql, Object[].class)
	                .setParameter("unidad", unidad)
	                .setParameter("fecha", fecha)
	                .uniqueResult();

	    } finally {
	        session.close();
	    }

	    return resultado;
	}
}