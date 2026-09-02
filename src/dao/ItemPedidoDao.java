package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;

public class ItemPedidoDao {
	
	
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

	public int agregar(ItemPedido objeto) {
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

	public void actualizar(ItemPedido objeto) {
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

	public void eliminar(ItemPedido objeto) {
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

	public ItemPedido traer(int idItemPedido) {
		ItemPedido objeto = null;
		try {
			iniciaOperacion();
			String hql = "from ItemPedido i inner join fetch i.pedido inner join fetch i.plato where i.idItemPedido = :idItemPedido";
			objeto = (ItemPedido) session.createQuery(hql).setParameter("idItemPedido", idItemPedido).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<ItemPedido> traer() {

	    List<ItemPedido> lista = new ArrayList<ItemPedido>();

	    try {
	        iniciaOperacion();
	        String hql = "from ItemPedido i " + "inner join fetch i.pedido " + "inner join fetch i.plato " + "order by i.idItemPedido asc";
	        lista = session.createQuery(hql, ItemPedido.class).getResultList();
	        
	    } finally {
	        session.close();
	    }

	    return lista;
	}
	
	public List<ItemPedido> traer(Pedido pedido) {

	    List<ItemPedido> lista = new ArrayList<ItemPedido>();

	    try {
	        iniciaOperacion();
	        String hql = "from ItemPedido i " + "inner join fetch i.plato " + "where i.pedido.idPedido = :idPedido " + "order by i.idItemPedido asc";
	        lista = session.createQuery(hql, ItemPedido.class).setParameter("idPedido", pedido.getIdPedido()).getResultList();
	        
	    } finally {
	        session.close();
	    }

	    return lista;
	}
	
	public List<ItemPedido> traer(Plato plato) {

	    List<ItemPedido> lista = new ArrayList<ItemPedido>();

	    try {
	        iniciaOperacion();
	        String hql = "from ItemPedido i " + "inner join fetch i.pedido " + "where i.plato.idPlato = :idPlato " + "order by i.idItemPedido asc";
	        lista = session.createQuery(hql, ItemPedido.class).setParameter("idPlato", plato.getIdPlato()).getResultList();
	        
	    } finally {
	        session.close();
	    }

	    return lista;
	}
}