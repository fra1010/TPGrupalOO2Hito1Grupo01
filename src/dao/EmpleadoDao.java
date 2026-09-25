package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    // -------------------------------------------------------------------
    // CRUD
    // -------------------------------------------------------------------

    public void actualizar(Empleado empleado)
    {
        try
        {
            iniciaOperacion();

            session.update(empleado);

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
    }

    public int agregar(Empleado empleado)
    {
        int id = 0;

        try
        {
            iniciaOperacion();

            id = Integer.parseInt(session.save(empleado).toString());

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

    public Empleado traerPorId(int idEmpleado)
    {
        Empleado empleado = null;

        try
        {
            iniciaOperacion();

            empleado = session.createQuery(
                    "from Empleado e where e.idEmpleado = :idEmpleado",
                    Empleado.class)
                    .setParameter("idEmpleado", idEmpleado)
                    .uniqueResult();
        }
        finally
        {
            session.close();
        }

        return empleado;
    }

    public Empleado traerPorDni(long dni)
    {
        Empleado empleado = null;

        try
        {
            iniciaOperacion();

            empleado = session.createQuery(
                    "from Empleado e where e.dni = :dni",
                    Empleado.class)
                    .setParameter("dni", dni)
                    .uniqueResult();
        }
        finally
        {
            session.close();
        }

        return empleado;
    }

    public List<Empleado> traerTodos()
    {
        List<Empleado> empleados = new ArrayList<Empleado>();

        try
        {
            iniciaOperacion();

            empleados = session.createQuery(
                    "from Empleado",
                    Empleado.class)
                    .getResultList();
        }
        finally
        {
            session.close();
        }

        return empleados;
    }

}
