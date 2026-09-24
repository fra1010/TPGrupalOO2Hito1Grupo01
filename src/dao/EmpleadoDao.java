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

    // -------------------------------------------------------------------
    // Caso de uso 1: empleados por unidad de venta
    // -------------------------------------------------------------------

    public List<Empleado> traerEmpleadosPorUnidad()
    {
        List<Empleado> empleados = new ArrayList<Empleado>();

        try
        {
            iniciaOperacion();

            String hql =
                    "select e " +
                    "from Empleado e " +
                    "join fetch e.unidadVenta " +
                    "where e.unidadVenta is not null " +
                    "order by e.unidadVenta.nombre, e.apellido";

            Query<Empleado> query = session.createQuery(hql, Empleado.class);

            empleados = query.getResultList();
        }
        finally
        {
            session.close();
        }

        return empleados;
    }

    // -------------------------------------------------------------------
    // Caso de uso 2: cantidad de empleados por unidad de venta
    // -------------------------------------------------------------------

    public List<String> traerCantidadEmpleadosPorUnidad()
    {
        List<String> resultados = new ArrayList<String>();

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

            Query<Object[]> query = session.createQuery(hql, Object[].class);

            List<Object[]> datos = query.getResultList();

            for (Object[] dato : datos)
            {
                String resultado =
                        "Unidad: " + dato[0] +
                        " | Cocineros: " + dato[1] +
                        " | Cajeros: " + dato[2] +
                        " | Encargados: " + dato[3];

                resultados.add(resultado);
            }
        }
        finally
        {
            session.close();
        }

        return resultados;
    }

    // -------------------------------------------------------------------
    // Caso de uso 3: empleados más antiguos
    // -------------------------------------------------------------------

    public List<Empleado> traerEmpleadosMasAntiguos(int cantidad)
    {
        List<Empleado> empleados = new ArrayList<Empleado>();

        try
        {
            iniciaOperacion();

            String hql =
                    "select e " +
                    "from Empleado e " +
                    "join fetch e.unidadVenta uv " +
                    "order by e.ingreso asc";

            empleados = session.createQuery(hql, Empleado.class)
                    .setMaxResults(cantidad)
                    .getResultList();
        }
        finally
        {
            session.close();
        }

        return empleados;
    }

    // -------------------------------------------------------------------
    // Casos de uso 4 y 5: datos de sueldo
    // -------------------------------------------------------------------

    public List<Object[]> traerEmpleadosConSueldo()
    {
        List<Object[]> datos = new ArrayList<Object[]>();

        try
        {
            iniciaOperacion();

            String hql =
                    "select e, uv.nombre, c.sueldoBase " +
                    "from Empleado e " +
                    "join e.unidadVenta uv " +
                    "join uv.festival f " +
                    "join Costo c on c.festival = f " +
                    "order by uv.nombre, e.apellido";

            datos = session.createQuery(hql, Object[].class).getResultList();
        }
        finally
        {
            session.close();
        }

        return datos;
    }

    // -------------------------------------------------------------------
    // Caso de uso 6: empleados ingresados entre dos fechas
    // -------------------------------------------------------------------

    public List<Empleado> traerEmpleadosEntreFechas(LocalDate fechaDesde,LocalDate fechaHasta)
    {
        List<Empleado> empleados = new ArrayList<Empleado>();

        try
        {
            iniciaOperacion();

            String hql =
                    "select e " +
                    "from Empleado e " +
                    "join fetch e.unidadVenta uv " +
                    "where e.ingreso between :fechaDesde and :fechaHasta " +
                    "order by uv.nombre, e.ingreso, e.apellido";

            Query<Empleado> query = session.createQuery(hql, Empleado.class);

            query.setParameter("fechaDesde", fechaDesde);
            query.setParameter("fechaHasta", fechaHasta);

            empleados = query.getResultList();
        }
        finally
        {
            session.close();
        }

        return empleados;
    }

    // -------------------------------------------------------------------
    // Caso de uso 7: total de sueldo por unidad de venta
    // -------------------------------------------------------------------

    public List<Object[]> traerTotalSueldosPorUnidad()
    {
        List<Object[]> resultados = new ArrayList<Object[]>();

        try
        {
            iniciaOperacion();

            String hql =
                    "select uv.nombre, sum(c.sueldoBase) " +
                    "from UnidadVenta uv " +
                    "join uv.empleados e " +
                    "join uv.festival f " +
                    "join Costo c on c.festival = f " +
                    "group by uv.idUnidadVenta, uv.nombre " +
                    "order by uv.nombre";

            resultados = session.createQuery(hql, Object[].class).getResultList();
        }
        finally
        {
            session.close();
        }

        return resultados;
    }
}
