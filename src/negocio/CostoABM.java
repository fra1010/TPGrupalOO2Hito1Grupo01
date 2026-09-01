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

		List<Costo> listaCostos = traer();

		int i = 0;
		boolean found = false;
		int idCosto = 0;

		while (i < listaCostos.size() && !found) {

			if (listaCostos.get(i).getCostoMontaje() == c.getCostoMontaje()
					&& listaCostos.get(i).getCostoSuperficie() == c.getCostoSuperficie()
					&& listaCostos.get(i).getCostoElectricidad() == c.getCostoElectricidad()
					&& listaCostos.get(i).getSueldoBase() == c.getSueldoBase()) {

				found = true;
				idCosto = listaCostos.get(i).getIdCosto();
			}

			i++;
		}

		if (found) {
			throw new Exception("ERROR: ya existe un costo. ID: " + idCosto);
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
