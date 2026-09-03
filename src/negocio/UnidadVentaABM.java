package negocio;

import java.util.List;
import java.util.Set;

import dao.UnidadVentaDao;
import datos.Empleado;
import datos.FoodTruck;
import datos.Pedido;
import datos.Plato;
import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class UnidadVentaABM {

	UnidadVentaDao dao = new UnidadVentaDao();

	public int agregarUnidadVenta(String nombre, Empleado responsable, double superficie, String codigo, String patente,
			boolean conexion) throws Exception {
		if (dao.traer(codigo) != null) {
			throw new Exception("Ya existe una unidad de venta con ese codigo : " + codigo);
		}
		UnidadVenta foodTruck = new FoodTruck(nombre, responsable, superficie, codigo, patente, conexion);

		return dao.agregarUnidadVenta(foodTruck);
	}

	public int agregarUnidadVenta(String nombre, Empleado responsable, double superficie, String codigo,
			int cantidadCarpas, int tiempo) throws Exception {
		if (dao.traer(codigo) != null) {
			throw new Exception("Ya existe una unidad de venta con ese codigo : " + codigo);
		}
		UnidadVenta puestoDesarmable = new PuestoDesarmable(nombre, responsable, superficie, codigo, cantidadCarpas,
				tiempo);
		return dao.agregarUnidadVenta(puestoDesarmable);
	}

	public UnidadVenta traer(String codigo) {

		return dao.traer(codigo);
	}

	public UnidadVenta traerUnidadVentaYEmpleados(String codigo) {
		return dao.traerUnidadYEmpleados(codigo);
	}

	public void actualizar(UnidadVenta unidadVenta) {
		dao.actualizar(unidadVenta);
	}

	public List<UnidadVenta> traer() {

		return dao.traer();
	}

	public void eliminar(String codigo) throws Exception {
		UnidadVenta uv = dao.traer(codigo);
		if (uv == null) {
			throw new Exception("No existe unidad de venta con codigo " + codigo);
		}
		dao.eliminar(uv);
	}
	public int agregarUnidadVentaFoodTruckConPlatos(String nombre, Empleado responsable, double superficie,
			String codigo, String patente, boolean conexion,Set<Plato> platos)throws Exception {
		UnidadVenta foodTruck = new FoodTruck(nombre, responsable, superficie, codigo, patente, conexion);
		if (dao.traer(codigo) != null) {
			throw new Exception("Ya existe una unidad de venta con ese codigo : " + codigo);
		}
		foodTruck.setPlatos(platos);
		return dao.agregarUnidadVentaYPlatos(foodTruck);
	}
	public int agregarUnidadVenta(String nombre, Empleado responsable, double superficie, String codigo,
			int cantidadCarpas, int tiempo,Set<Plato> platos) throws Exception {
		if (dao.traer(codigo) != null) {
			throw new Exception("Ya existe una unidad de venta con ese codigo : " + codigo);
		}
		UnidadVenta puestoDesarmable = new PuestoDesarmable(nombre, responsable, superficie, codigo, cantidadCarpas,
				tiempo);
		puestoDesarmable.setPlatos(platos);
		return dao.agregarUnidadVenta(puestoDesarmable);
	}
	public double calcularTotalUnidadVenta(String codigoUnidadVenta) {
		double total=0;
		UnidadVenta u =dao.traerUnidadVentaYPedidosEitem(codigoUnidadVenta);
		for (Pedido p : u.getPedidos()) {
			total=total+p.calcularTotal();
		}
		return total;
	}

}
