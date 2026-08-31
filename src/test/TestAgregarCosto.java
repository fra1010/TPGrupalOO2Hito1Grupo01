package test;

import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarCosto {
	public static void main(String[] args) {

		FestivalABM abmFestival = new FestivalABM();
		Festival festival = abmFestival.traer(1);
		System.out.println(festival);

		CostoABM abmCosto = new CostoABM();

		try {
			abmCosto.agregar(1, 33, 44, 55, festival);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
