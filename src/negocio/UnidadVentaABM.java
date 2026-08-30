package negocio;

import dao.UnidadVentaDao;
import datos.Empleado;
import datos.FoodTruck;
import datos.UnidadVenta;

public class UnidadVentaABM {

	UnidadVentaDao dao = new UnidadVentaDao();
	
	public int agregarUnidadVenta(String nombre, Empleado responsable, double superficie, 
            String codigo, String patente, boolean conexion) {
		UnidadVenta u= new FoodTruck(nombre, responsable, superficie, codigo, patente, conexion);
		
		return dao.agregarCliente(u);
	}
	
	public UnidadVenta traer(int idUnidadVenta){
		
		return dao.traer(idUnidadVenta);
		}
	
	public UnidadVenta traerUnidadVentaYEmpleados(int idUnidadVenta) {
		
		return dao.traerUnidadYEmpleados(idUnidadVenta);
	}
}
