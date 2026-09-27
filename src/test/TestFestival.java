package test;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import negocio.FestivalABM;
import datos.UnidadVenta;

public class TestFestival {

	public static void main(String[] args) {

		FestivalABM abm = new FestivalABM();

		try {
			int idFestival = 1;

			Festival festival = abm.traer(idFestival);
			double ganancia = abm.calcularGananciaEstimada(idFestival);

			System.out.println("Ganancia estimada del festival " + festival.getNombre() + ": " + ganancia);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			int idFestival = 1;
			int top = 3; // cantidad de resultados

			List<Object[]> ranking = abm.traerUnidadesMasRentablesPorFestival(idFestival, top);

			System.out.println("Top " + top + " unidades mas rentables del festival:");

			for (Object[] fila : ranking) {
				UnidadVenta unidad = (UnidadVenta) fila[0];
				double ganancia = ((Number) fila[1]).doubleValue();

				System.out.println("  - " + unidad.getNombre() + " - ganancia: " + ganancia);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			int idFestival = 1;

			Object[] diaPico = abm.traerDiaDeMayorRecaudacion(idFestival);

			LocalDate fecha = (LocalDate) diaPico[0];
			double recaudacion = ((Number) diaPico[1]).doubleValue();

			System.out.println("Dia de mayor recaudacion: " + fecha + " - " + recaudacion);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			Festival festival = abm.traer(1);

			double ticket = abm.calcularTicketPromedio(festival);

			System.out.println("Ticket promedio del festival " + festival.getNombre() + ": " + ticket);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			Festival festival = abm.traer(1);

			List<Object[]> filas = abm.compararGananciaPorTipoUnidad(festival);

			System.out.println("Ganancia por tipo de unidad en " + festival.getNombre() + ":");

			for (Object[] fila : filas) {
				Class<?> tipo = (Class<?>) fila[0];
				double ganancia = ((Number) fila[1]).doubleValue();

				System.out.println("  - " + tipo.getSimpleName() + ": " + ganancia);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}