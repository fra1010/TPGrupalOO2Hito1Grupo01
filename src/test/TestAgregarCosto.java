package test;

import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarCosto {
	public static void main(String[] args) {

		CostoABM abmCosto = new CostoABM();
		FestivalABM abmFestival = new FestivalABM();
		
		Festival f = abmFestival.traerFestivalyCosto(1);
		
		try {
			abmCosto.agregar(1, 33, 44, 55,f);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
