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
		
		
		try {
		    int idFestival = 1;
		    int top = 3; //cantidad de resultados

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
		    int idFestival = 1;

		    double ticketPromedio = abm.calcularTicketPromedio(idFestival);

		    System.out.println("Ticket promedio por pedido: " + ticketPromedio);

		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
		
		try {
			int idFestival = 1;
		    List<Object[]> comparacion = abm.compararGananciaPorTipoUnidad(idFestival);

		    System.out.println("Ganancia total por tipo de unidad de venta:");

		    for (Object[] fila : comparacion) {
		        Class<?> tipo = (Class<?>) fila[0];
		        double ganancia = ((Number) fila[1]).doubleValue();

		        System.out.println("  - " + tipo.getSimpleName() + ": " + ganancia);
		    }

		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

	}

}