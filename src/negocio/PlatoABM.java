package negocio;

import java.util.List;

import dao.PlatoDao;
import datos.Plato;
import datos.UnidadVenta;

public class PlatoABM {
	
	PlatoDao dao = new PlatoDao();

	public Plato traer(int idPlato) {
		return dao.traer(idPlato);
	}

	public int agregar(String nombre, double precioDeVenta, double costoDePlato) {
		// Pendiente implementar lógica de negocio
		Plato p = new Plato(nombre, precioDeVenta, costoDePlato);
		return dao.agregar(p);
	}
	public int agregar(String nombre, double precioDeVenta, double costoDePlato,UnidadVenta unidadVenta) {
		// Pendiente implementar lógica de negocio
		Plato p = new Plato(nombre, precioDeVenta, costoDePlato,unidadVenta);
		return dao.agregar(p);
	}
	public void modificar(Plato p) {
		// Pendiente implementar lógica de negocio
		dao.actualizar(p);
	}

	public void eliminar(int idPlato) {
		// Pendiente implementar lógica de negocio
		Plato p = dao.traer(idPlato);
		dao.eliminar(p);
	}

	public List<Plato> traer() {
		return dao.traer();
	}
	
}
