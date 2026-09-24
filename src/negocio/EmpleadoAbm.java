
package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.UnidadVenta;
import datos.Cocinero;
import datos.Cajero;

public class EmpleadoAbm 
{
	private static EmpleadoAbm instancia = null;

	public EmpleadoAbm() 
	{
		
	}

	public static EmpleadoAbm getInstance() 
	{
		if (instancia == null)
			instancia = new EmpleadoAbm();

		return instancia;
	}
	
	public int agregarEmpleadoCocinero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
			LocalDate ingreso,String especialidad,String categoria,int porcentaje) throws Exception
	{
		int id = 0;

		if (EmpleadoDao.getInstance().traerPorDni(dni) != null)
		{
			throw new Exception("ERROR: ya existe un empleado con dicho DNI");
		}

		id = EmpleadoDao.getInstance().agregar(new Cocinero(nombre,apellido,dni,fechaNacimiento,
				ingreso,especialidad,categoria,porcentaje));

		return id;
	}
	
	public int agregarEmpleadoCajero(String nombre,String apellido,long dni,LocalDate fechaNacimiento,
			LocalDate ingreso,String turno,double plusAntiguedad) throws Exception
	{
		int id = 0;

		if (EmpleadoDao.getInstance().traerPorDni(dni) != null)
		{
			throw new Exception("ERROR: ya existe un empleado con dicho DNI");
		}

		id = EmpleadoDao.getInstance().agregar(new Cajero(nombre,apellido,dni,fechaNacimiento,
					ingreso,turno,plusAntiguedad));

		return id;
	}

	public Empleado traer(int idEmpleado) throws Exception
	{
		Empleado e = EmpleadoDao.getInstance().traer(idEmpleado);

		if (e == null)
		{
			throw new Exception("ERROR: no existe empleado con dicho ID");
		}

		return e;
	}

	public List<Empleado> traer() throws Exception
	{
		List<Empleado> lista = EmpleadoDao.getInstance().traer();

		if (lista.isEmpty())
		{
			throw new Exception("ERROR: no hay empleados registrados");
		}

		return lista;
	}

	public void actualizar(Empleado empleado) 
	{
		EmpleadoDao.getInstance().actualizar(empleado);
	}
	

    // ---- caso de uso 1: traer empleados por unidad de venta --------------------
	
	public List<Empleado> traerEmpleadosPorUnidad()
	{
	    return EmpleadoDao.getInstance().traerEmpleadosPorUnidadVenta();
	}
	
	// ---- caso de uso 2: traer cantidades de empleados por unidad de venta -----------
	
	public List<String> traerCantidadEmpleados()
	{
	    return EmpleadoDao.getInstance().traerNumeroEmpleadosPorUnidadVenta();
	}

	// ---- caso de uso 3: traer empleados más antiguos --------------------

	public List<Empleado> traerEmpleadosMasAntiguos(int top)
	{
	    return EmpleadoDao.getInstance().traerEmpleadosMasAntiguos(top);
	}

	// ---- caso de uso 4: traer aguinaldos --------------------
	
	public List<Object[]> traerAguinaldoPorEmpleado()
	{
	    List<Object[]> resultados = new ArrayList<Object[]>();

	    List<Object[]> datos = EmpleadoDao.getInstance().traerDatosAguinaldo();

	    int anioActual = LocalDate.now().getYear();

	    for (Object[] dato : datos)
	    {
	        Empleado empleado = (Empleado) dato[0];
	        String unidad = (String) dato[1];
	        int sueldoBase = (Integer) dato[2];

	        double adicional = 0;

	        if (empleado instanceof Cajero)
	        {
	            Cajero cajero = (Cajero) empleado;

	            int antiguedad = anioActual - empleado.getIngreso().getYear();

	            adicional = cajero.getPlusAntiguedad() * antiguedad;
	        }
	        else if (empleado instanceof Cocinero)
	        {
	            Cocinero cocinero = (Cocinero) empleado;

	            adicional = sueldoBase * cocinero.getPorcentaje() / 100.0;
	        }

	        double sueldo = sueldoBase + adicional;

	        double aguinaldo = sueldo / 2;

	        resultados.add(new Object[] {empleado,unidad,sueldoBase,adicional,aguinaldo});
	    }

	    return resultados;
	}

	// ---- caso de uso 5: traer jubilaciones --------------------
	
	public List<Object[]> traerJubilacionPorEmpleado()
	{
	    List<Object[]> resultados = new ArrayList<Object[]>();

	    List<Object[]> datos = EmpleadoDao.getInstance().traerDatosAguinaldo();

	    int anioActual = LocalDate.now().getYear();

	    for (Object[] dato : datos)
	    {
	        Empleado empleado = (Empleado) dato[0];
	        String unidad = (String) dato[1];
	        int sueldoBase = (Integer) dato[2];

	        double adicional = 0;

	        // Cajero: plus fijo por cada año de antigüedad
	        if (empleado instanceof Cajero)
	        {
	            Cajero cajero = (Cajero) empleado;

	            int antiguedad = anioActual - empleado.getIngreso().getYear();

	            adicional = cajero.getPlusAntiguedad() * antiguedad;
	        }

	        // Cocinero: porcentaje sobre el sueldo base
	        else if (empleado instanceof Cocinero)
	        {
	            Cocinero cocinero = (Cocinero) empleado;

	            adicional = sueldoBase * cocinero.getPorcentaje() / 100.0;
	        }

	        double sueldo = sueldoBase + adicional;

	        // Aporte jubilatorio: 11%
	        double jubilacion = sueldo * 0.11;

	        resultados.add(new Object[] {empleado,unidad,sueldoBase,adicional,sueldo,jubilacion});
	    }

	    return resultados;
	}

}
