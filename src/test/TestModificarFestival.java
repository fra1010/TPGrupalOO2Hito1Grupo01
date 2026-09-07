package test;

import java.time.LocalDate;

import datos.Festival;
import negocio.FestivalABM;

public class TestModificarFestival {

	public static void main(String[] args) {

		FestivalABM abm = new FestivalABM();

		int id = 2;

		try {
			Festival f = abm.traer(id);

			if (f == null) {
				System.out.println("No existe un Festival con id: " + id);
				return;
			}

			System.out.println("Antes de modificar: " + f);

			f.setNombre("Festival212");
			f.setTemporada("Primavera");
			f.setFechaInicio(LocalDate.of(2026, 6, 1));
			f.setFechaFin(LocalDate.of(2026, 8, 31));
			f.getCosto().setCostoElectricidad(1111);
			f.getCosto().setCostoMontaje(999);
			abm.modificar(f);

			Festival modificado = abm.traer(id);
			System.out.println("Despues de modificar: " + modificado);

		} catch (Exception e) {
			System.out.println("ERROR al modificar el festival: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
