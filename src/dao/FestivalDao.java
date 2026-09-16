package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Festival;
import datos.UnidadVenta;

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

            String hql = "from Festival f "
                    + "where f.fechaInicio >= :desde and f.fechaFin <= :hasta "
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
}
