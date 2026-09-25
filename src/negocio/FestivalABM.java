package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.FestivalDao;
import dao.UnidadVentaDao;
import datos.Costo;
import datos.Empleado;
import datos.Festival;
import datos.UnidadVenta;

public class FestivalABM {

	FestivalDao dao = new FestivalDao();
	UnidadVentaDao unidadDao = new UnidadVentaDao();
	CostoABM abmCosto = new CostoABM();

	public int agregar(Festival f) throws Exception {

		if (dao.traerPorNombre(f.getNombre()) != null) {
			throw new Exception("ERROR: ya existe un festival con el mismo nombre " + f.getNombre());
		}

		return dao.agregar(f);
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo)
			throws Exception {

		Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, costo);

		return agregar(f);
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

		Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin);

		return agregar(f);
	}

	public int agregarConCosto(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			int costoSuperficie, int costoMontaje, int costoElectricidad, int sueldoBase) throws Exception {

		int idFestival = agregar(nombre, temporada, fechaInicio, fechaFin);
		Festival f = dao.traer(idFestival);

		abmCosto.agregar(costoSuperficie, costoMontaje, costoElectricidad, sueldoBase, f);

		return idFestival;
	}

	public void modificar(Festival f) throws Exception {

		Festival existe = dao.traer(f.getIdFestival());

		if (existe == null) {
			throw new Exception("ERROR: no existe Festival con ese ID " + f.getIdFestival());
		}

		dao.actualizar(f);
	}

	public void eliminar(int id) throws Exception {

		Festival f = dao.traer(id);

		if (f == null) {
			throw new Exception("ERROR: no existe Festival con dicho ID");
		}

		dao.eliminar(f);
	}

	public Festival traer(int idFestival) {
		return dao.traer(idFestival);
	}

	public List<Festival> traer() {
		return dao.traer();
	}

	public Festival traerFestivalyCosto(int idFestival) {
		return dao.traerFestivalYCosto(idFestival);
	}

	public Festival traerFestivalYUnidadesVenta(int idFestival) {
		return dao.traerFestivalYUnidadesVenta(idFestival);
	}

	public void asociarUnidadVenta(int idFestival, String codigoUnidad) throws Exception {
		Festival f = dao.traerFestivalYUnidadesVenta(idFestival);
		if (f == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		UnidadVenta uv = dao.traerUnidadPorCodigo(codigoUnidad);
		if (uv == null) {
			throw new Exception("No existe unidad de venta con codigo " + codigoUnidad);
		}

		f.getUnidadesVenta().add(uv);
		dao.actualizar(f);
	}

	public void desasociarUnidadVenta(int idFestival, String codigoUnidad) throws Exception {
		Festival f = dao.traerFestivalYUnidadesVenta(idFestival);
		if (f == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		UnidadVenta uv = dao.traerUnidadPorCodigo(codigoUnidad);
		if (uv == null) {
			throw new Exception("No existe unidad de venta con codigo " + codigoUnidad);
		}

		if (!f.getUnidadesVenta().contains(uv)) {
			throw new Exception("La unidad de venta " + codigoUnidad + " no pertenece al festival " + f.getNombre());
		}

		f.getUnidadesVenta().remove(uv);
		dao.actualizar(f);
	}

	public void eliminarUnidadVentaDeFestival(int idFestival, String codigoUnidad) throws Exception {
		Festival f = dao.traerFestivalYUnidadesVenta(idFestival);
		if (f == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		UnidadVenta uv = unidadDao.traer(codigoUnidad);
		if (uv == null) {
			throw new Exception("No existe unidad de venta con codigo " + codigoUnidad);
		}

		if (!f.getUnidadesVenta().contains(uv)) {
			throw new Exception("La unidad de venta " + codigoUnidad + " no pertenece al festival " + f.getNombre());
		}

		f.getUnidadesVenta().remove(uv);
		dao.actualizar(f);
		unidadDao.eliminar(uv);
	}

	public List<Festival> traerPorRangoDeFechas(LocalDate desde, LocalDate hasta) throws Exception {

		if (desde == null || hasta == null) {
			throw new Exception("ERROR: las fechas 'desde' y 'hasta' no pueden ser nulas");
		}

		if (hasta.isBefore(desde)) {
			throw new Exception(
					"ERROR: la fecha 'hasta' (" + hasta + ") no puede ser anterior a 'desde' (" + desde + ")");
		}

		List<Festival> lista = dao.traerPorRangoDeFechas(desde, hasta);

		if (lista.isEmpty()) {
			throw new Exception("No hay festivales en el rango de fechas " + desde + " - " + hasta);
		}

		return lista;
	}

	public List<Festival> traerPorTemporada(String temporada) throws Exception {

		if (temporada == null || temporada.trim().isEmpty()) {
			throw new Exception("ERROR: la temporada no puede ser nula ni vacia");
		}

		List<Festival> lista = dao.traerPorTemporada(temporada);

		if (lista.isEmpty()) {
			throw new Exception("No hay festivales cargados para la temporada " + temporada);
		}

		return lista;
	}

	public List<Festival> traerPorRangoDeCosto(int montoMinimo, int montoMaximo) throws Exception {

		if (montoMinimo < 0 || montoMaximo < 0) {
			throw new Exception("ERROR: los montos no pueden ser negativos");
		}

		if (montoMaximo < montoMinimo) {
			throw new Exception(
					"ERROR: el monto maximo (" + montoMaximo + ") no puede ser menor al minimo (" + montoMinimo + ")");
		}

		List<Festival> lista = dao.traerPorRangoDeCosto(montoMinimo, montoMaximo);

		if (lista.isEmpty()) {
			throw new Exception("No hay festivales con costo entre " + montoMinimo + " y " + montoMaximo);
		}

		return lista;
	}

	public double calcularCostoReal(int idFestival) throws Exception {

		Festival festival = dao.traer(idFestival);

		if (festival == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		if (festival.getCosto() == null) {
			throw new Exception("El festival no tiene un costo asociado");
		}

		double costosFijos = dao.calcularCostosFijos(idFestival);
		double sueldos = dao.calcularSueldos(idFestival);

		return costosFijos + sueldos;
	}

	public double calcularGananciaEstimada(int idFestival) throws Exception {

		Festival festival = dao.traer(idFestival);

		if (festival == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		double gananciaPlatos = dao.calcularGananciaPlatos(idFestival);
		double costoReal = calcularCostoReal(idFestival);

		return gananciaPlatos - costoReal;
	}

	public List<Object[]> traerUnidadesMasRentablesPorFestival(int idFestival, int top) throws Exception {

		Festival festival = dao.traer(idFestival);

		if (festival == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		if (top <= 0) {
			throw new Exception("El top debe ser mayor a cero");
		}

		List<Object[]> lista = dao.traerUnidadesMasRentablesPorFestival(idFestival, top);

		if (lista.isEmpty()) {
			throw new Exception("No hay unidades de venta con ganancias registradas para este festival");
		}

		return lista;
	}

	public List<Festival> traerPorRangoDeCostoReal(int minimo, int maximo) throws Exception {

		List<Object[]> costosFijos = dao.calcularCostosFijosTodos();
		List<Object[]> sueldosCocineros = dao.calcularSueldosCocinerosTodos();
		List<Object[]> sueldosCajeros = dao.calcularSueldosCajerosTodos();

		List<Festival> resultado = new ArrayList<Festival>();

		for (Object[] filaCosto : costosFijos) {
			Festival festival = (Festival) filaCosto[0];
			double costosFijosValor = ((Number) filaCosto[1]).doubleValue();

			double sueldosCocinerosValor = buscarSueldo(sueldosCocineros, festival.getIdFestival());
			double sueldosCajerosValor = buscarSueldo(sueldosCajeros, festival.getIdFestival());

			double costoReal = costosFijosValor + sueldosCocinerosValor + sueldosCajerosValor;

			if (costoReal >= minimo && costoReal <= maximo) {
				resultado.add(festival);
			}
		}

		if (resultado.isEmpty()) {
			throw new Exception("No hay festivales con costo real entre " + minimo + " y " + maximo);
		}

		return resultado;
	}

	private double buscarSueldo(List<Object[]> filas, int idFestival) {
		for (Object[] fila : filas) {
			int id = ((Number) fila[0]).intValue();

			if (id == idFestival) {
				if (fila[1] != null) {
					return ((Number) fila[1]).doubleValue();
				} else {
					return 0;
				}
			}
		}

		return 0;
	}

	public List<Festival> traerPorTipoUnidad(String tipoUnidad) throws Exception {
		if (tipoUnidad == null || tipoUnidad.trim().isEmpty()) {
			throw new Exception("El tipo de unidad no puede ser nulo ni vacio");
		}

		if (!tipoUnidad.equalsIgnoreCase("FoodTruck") && !tipoUnidad.equalsIgnoreCase("PuestoDesarmable")) {
			throw new Exception("Tipo de unidad no valido: " + tipoUnidad);
		}

		List<Festival> lista = dao.traerPorTipoUnidad(tipoUnidad);

		if (lista.isEmpty()) {
			throw new Exception("No hay festivales con unidades del tipo " + tipoUnidad);
		}

		return lista;
	}

	public Object[] traerDiaDeMayorRecaudacion(int idFestival) throws Exception {

		Festival festival = dao.traer(idFestival);

		if (festival == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		Object[] resultado = dao.traerDiaDeMayorRecaudacion(idFestival);

		if (resultado == null) {
			throw new Exception("No hay pedidos cerrados registrados para este festival");
		}

		return resultado;
	}

	public double calcularTicketPromedio(int idFestival) throws Exception {

		Festival festival = dao.traer(idFestival);

		if (festival == null) {
			throw new Exception("No existe festival con id " + idFestival);
		}

		Object[] datos = dao.calcularTicketPromedio(idFestival);

		if (datos == null || datos[0] == null) {
			throw new Exception("No hay pedidos cerrados registrados para este festival");
		}

		long cantidadPedidos = ((Number) datos[0]).longValue();

		if (cantidadPedidos == 0) {
			throw new Exception("No hay pedidos cerrados registrados para este festival");
		}

		double recaudacionTotal;
		if (datos[1] != null) {
			recaudacionTotal = ((Number) datos[1]).doubleValue();
		} else {
			recaudacionTotal = 0;
		}

		return recaudacionTotal / cantidadPedidos;
	}
	
	public List<Object[]> compararGananciaPorTipoUnidad(int idFestival) throws Exception {

	    Festival festival = dao.traer(idFestival);

	    if (festival == null) {
	        throw new Exception("No existe festival con id " + idFestival);
	    }

	    List<Object[]> lista = dao.compararGananciaPorTipoUnidad(idFestival);

	    if (lista.isEmpty()) {
	        throw new Exception("No hay ventas registradas para este festival");
	    }

	    return lista;
	}

	// -------------------------------------------------------------------
	// Caso de uso 1: traer empleados por festival IVAN TOLABA
	// -------------------------------------------------------------------

	public List<Empleado> traerEmpleadosPorFestival(Festival festival) throws Exception
	{
	    if (festival == null)
	    {
	        throw new Exception("ERROR: el festival no puede ser null");
	    }

	    List<Empleado> empleados = dao.traerEmpleadosPorFestival(festival);

	    if (empleados.isEmpty())
	    {
	        throw new Exception("ERROR: no hay empleados asociados al festival");
	    }

	    return empleados;
	}

	// -------------------------------------------------------------------
	// Caso de uso 2: traer cantidad de empleados por festival IVAN TOLABA
	// -------------------------------------------------------------------

	public List<Object[]> traerCantidadEmpleadosPorUnidad(Festival festival) throws Exception
	{
	    if (festival == null)
	    {
	        throw new Exception("ERROR: el festival no puede ser null");
	    }

	    List<Object[]> resultados = dao.traerCantidadEmpleadosPorUnidad(festival);

	    if (resultados.isEmpty())
	    {
	        throw new Exception("ERROR: no hay unidades de venta asociadas al festival");
	    }

	    return resultados;
	}

	// -------------------------------------------------------------------
	// Caso de uso 3: traer empleados mas antiguos por festival IVAN TOLABA
	// -------------------------------------------------------------------

	public List<Empleado> traerEmpleadosMasAntiguos(Festival festival, int cantidad) throws Exception
	{
	    if (festival == null)
	    {
	        throw new Exception("ERROR: el festival no puede ser null");
	    }

	    if (cantidad <= 0)
	    {
	        throw new Exception("ERROR: la cantidad debe ser mayor a cero");
	    }

	    List<Empleado> empleados = dao.traerEmpleadosMasAntiguos(festival, cantidad);

	    if (empleados.isEmpty())
	    {
	        throw new Exception("ERROR: no hay empleados asociados al festival");
	    }

	    return empleados;
	}
	
	// -----------------------------------------------------------------------
    // Caso de uso 4: traer empleados entre fechas por festival IVAN TOLABA
    // -----------------------------------------------------------------------

	public List<Empleado> traerEmpleadosEntreFechas(Festival festival, LocalDate fechaDesde, LocalDate fechaHasta) throws Exception
	{
	    if (festival == null)
	    {
	        throw new Exception("ERROR: el festival no puede ser null");
	    }

	    if (fechaDesde == null || fechaHasta == null)
	    {
	        throw new Exception("ERROR: las fechas no pueden ser null");
	    }

	    if (fechaDesde.isAfter(fechaHasta))
	    {
	        throw new Exception("ERROR: la fecha desde no puede ser posterior a la fecha hasta");
	    }

	    List<Empleado> empleados = dao.traerEmpleadosEntreFechas(festival, fechaDesde, fechaHasta);

	    if (empleados.isEmpty())
	    {
	        throw new Exception("ERROR: no hay empleados ingresados en ese rango de fechas para el festival");
	    }

	    return empleados;
	}

}