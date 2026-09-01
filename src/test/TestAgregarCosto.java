package test;

import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarCosto {

	public static void main(String[] args) {

		FestivalABM abmFestival = new FestivalABM();
		CostoABM abmCosto = new CostoABM();

		int idFestival = 1; //festival sin costo asignado

		try {
			Festival festival = abmFestival.traer(idFestival);

			if (festival == null) {
				System.out.println("No existe un Festival con id " + idFestival);
				return;
			}
			System.out.println("Costo a agregar a festival: " + festival);
			int idCosto = abmCosto.agregar(42, 54, 320, 220, festival);

			

			System.out.println("Costo agregado: " + abmFestival.traer(idFestival));

		} catch (Exception e) {
			System.out.println("ERROR al agregar el costo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
