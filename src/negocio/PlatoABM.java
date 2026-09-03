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

	public int agregar(String nombre, double precioDeVenta, double costoDePlato, UnidadVenta unidad) throws Exception {
		if(unidad == null) {
			throw new Exception("El plato debe pertenecer a una unidad de venta");
		}
		Plato p = new Plato(nombre, precioDeVenta, costoDePlato, unidad);
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
