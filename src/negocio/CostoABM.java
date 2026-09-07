package negocio;

import java.util.List;
import dao.CostoDao;
import datos.Costo;
import datos.Festival;

public class CostoABM {
	CostoDao dao = new CostoDao();

	public Costo traer(int idCosto) {
		return dao.traer(idCosto);
	}

	public List<Costo> traer() {
		return dao.traer();
	}

	public int agregar(int costoSuperficie, int costoMontaje, int costoElectricidad, int sueldoBase, Festival festival)
			throws Exception {

		Costo c = new Costo(costoSuperficie, costoMontaje, costoElectricidad, sueldoBase, festival);

		return agregar(c);
	}
	

	public int agregar(Costo c) throws Exception {

	    if (c.getFestival() == null) {
	        throw new Exception("El costo debe estar asociado a un festival.");
	    }

	    if (c.getFestival().getIdFestival() == 0) {
	        throw new Exception("El festival no esta guardado en la db");
	    }

	    Costo costo = dao.traer(c.getFestival().getIdFestival());
	    if (costo != null) {
	        throw new Exception("ERROR: el festival " + c.getFestival().getNombre()
	                + " ya tiene un costo asignado (ID " + costo.getIdCosto() + ").");
	    }

	    return dao.agregar(c);
	}

	public void modificar(Costo c) throws Exception {
		Costo existe = dao.traer(c.getIdCosto());
		if (existe == null) {
			throw new Exception("ERROR:  no existe costo con dicho ID " + c.getIdCosto());
		}

		dao.actualizar(c);
	}

	public void eliminar(int id) throws Exception {
		Costo c = dao.traer(id);
		if (c == null) {
			throw new Exception("ERROR: no existe costo con dicho ID");
		}
		dao.eliminar(c);
	}

}
