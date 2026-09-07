package test;

import datos.Festival;
import negocio.FestivalABM;

public class TestEliminarFestival {

	public static void main(String[] args) {

		FestivalABM abmFestival = new FestivalABM();

		int id = 3;

		try {
			Festival f = abmFestival.traer(id);

			if (f == null) {
				System.out.println("No existe un Festival con id " + id);
				return;
			}

			System.out.println("Festival a eliminar: " + f);

			abmFestival.eliminar(id);

			Festival verificacion = abmFestival.traer(id);

			if (verificacion == null) {
				System.out.println("Festival con id " + id + " eliminado correctamente.");
			} else {
				System.out.println("El festival sigue existiendo: " + verificacion);
			}

		} catch (Exception e) {
			System.out.println("ERROR al eliminar el festival: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
