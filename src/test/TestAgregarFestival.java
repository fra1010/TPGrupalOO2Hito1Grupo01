package test;

import java.time.LocalDate;

import datos.Costo;
import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarFestival {

	public static void main(String[] args) {

		FestivalABM abmFestival = new FestivalABM();
		CostoABM abmCosto = new CostoABM();

		try {
			String nombre = "Festival222";
			String temporada = "Invierno";
			LocalDate fechaInicio = LocalDate.of(2026, 1, 12);
			LocalDate fechaFin = LocalDate.of(2026, 12, 31);

			int idFestival = abmFestival.agregar(nombre, temporada, fechaInicio, fechaFin);

			System.out.println("Festival agregado : " + abmFestival.traer(idFestival));

			Festival festival = abmFestival.traer(idFestival);//agrega costo a el nuevo festival

			int idCosto = abmCosto.agregar(1, 1, 2, 2, festival);

			System.out.println("Costo agregado: " + abmCosto.traer(idCosto));

			//Verificacion
			Festival nuevo = abmFestival.traerFestivalyCosto(idFestival);
			System.out.println("Festival con costo cargado: " + nuevo);

		} catch (Exception e) {
			System.out.println("ERROR al agregar festival/costo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}