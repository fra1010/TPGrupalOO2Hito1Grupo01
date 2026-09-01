package test;

import java.time.LocalDate;
import datos.Costo;
import negocio.FestivalABM;

public class TestAgregarFestival {

	public static void main(String[] args) {
	
		
		FestivalABM abm = new FestivalABM();
		Costo c = new Costo(11,22,33,44);
		int idFestivalUlt;
		try {
			idFestivalUlt = abm.agregar("Festival6","Verano", LocalDate.of(2026, 1, 3), LocalDate.now(),c);
			System.out.printf("Festival creado: %d", idFestivalUlt);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		

	
	}

}
