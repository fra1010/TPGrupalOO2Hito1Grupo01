package test;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class TestFestival {

	public static void main(String[] args) {

		FestivalABM abm = new FestivalABM();

		try {
			LocalDate desde = LocalDate.of(2025, 2, 21);
			LocalDate hasta = LocalDate.of(2025, 9, 25);

			List<Festival> lista = abm.traerPorRangoDeFechas(desde, hasta);

			System.out.println("Festivales entre fechas " + desde + " - " + hasta);
			for (Festival f : lista) {
				System.out.println("  - " + f.getNombre() + " (" + f.getFechaInicio() + " a " + f.getFechaFin() + ")");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			String temporada = "Invierno";

			List<Festival> lista = abm.traerPorTemporada(temporada);

			System.out.println("Festivales para la temporada: " + temporada);
			for (Festival f : lista) {
				System.out.println("  - " + f.getNombre() + " (" + f.getFechaInicio() + " a " + f.getFechaFin() + ")");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			int costoMin = 350;
			int costoMax = 5000;

			List<Festival> lista = abm.traerPorRangoDeCostoReal(costoMin, costoMax);

			System.out.println("Festivales con costo entre: " + costoMin + " - " + costoMax);

			for (Festival festival : lista) {
				double total = abm.calcularCostoReal(festival.getIdFestival());

				System.out.println("  - " + festival.getNombre() + " - costo total: " + total);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			String tipoUnidad = "FoodTruck";

			List<Festival> lista = abm.traerPorTipoUnidad(tipoUnidad);

			System.out.println("Festivales con unidades tipo " + tipoUnidad + ":");

			for (Festival festival : lista) {
				System.out.println("Festival: " + festival.getNombre() + " - Unidades: "
						+ festival.nombresUnidadesPorTipo(tipoUnidad));
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			int idFestival = 1;

			Festival festival = abm.traer(idFestival);
			double ganancia = abm.calcularGananciaEstimada(idFestival);

			System.out.println("Ganancia estimada del festival " + festival.getNombre() + ": " + ganancia);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}