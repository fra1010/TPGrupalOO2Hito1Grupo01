package negocio;

import dao.UnidadVentaDao;
import datos.Empleado;
import datos.FoodTruck;
import datos.UnidadVenta;

public class UnidadVentaABM {

	UnidadVentaDao dao = new UnidadVentaDao();
	
	public int agregarUnidadVenta(String nombre, Empleado responsable, double superficie, 
            String codigo, String patente, boolean conexion)throws Exception {
		UnidadVenta u= new FoodTruck(nombre, responsable, superficie, codigo, patente, conexion);
		
		return dao.agregarCliente(u);
	}
	
	public UnidadVenta traer(String codigo){
		
		return dao.traer(codigo);
		}
	
	public UnidadVenta traerUnidadVentaYEmpleados(String codigo) {
		
		return dao.traerUnidadYEmpleados(codigo);
	}
}
