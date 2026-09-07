package test;

import datos.Festival;
import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestTraerFestivalYUnidadesVenta {

	public static void main(String[] args) {

		FestivalABM abmFestival = new FestivalABM();
		UnidadVentaABM abmUnidad = new UnidadVentaABM();

		int idFestival = 1;

		try {
			// Trae el festival y muestra sus unidades actuales
			Festival f = abmFestival.traerFestivalYUnidadesVenta(idFestival);

			if (f == null) {
				System.out.println("No existe un Festival con id " + idFestival);
				return;
			}

			System.out.println("******Festival: " + f.getNombre() + " - " + f.getTemporada() + " ******");

			if (f.getUnidadesVenta() == null || f.getUnidadesVenta().isEmpty()) {
				System.out.println("El festival no tiene unidades de venta cargadas todavia.");
			} else {
				System.out.println("Unidades de venta existentes (" + f.getUnidadesVenta().size() + "):");
				for (UnidadVenta uv : f.getUnidadesVenta()) {
					System.out.println("- " + uv.getNombre() + " (codigo: " + uv.getCodigo() + ")");
				}
			}
			
			String codigoFT="FASDFFDF";
			String codigoPD="UUUUUUUU";
			
			
			// Agrega nuevas unidades de venta
			System.out.println("\n****** Agregando nuevas unidades de venta ******");

			int idFoodTruck = abmUnidad.agregarUnidadVenta("FOOD TRUCK 2", null, 25.5, codigoFT, "CAB-321", true);
			System.out.println("FoodTruck agregado. ID: " + idFoodTruck);

			int idPuestoDesarmable = abmUnidad.agregarUnidadVenta("PUESTO 4", null, 30.0, codigoPD, 4, 90);
			System.out.println("PuestoDesarmable agregado. ID: " + idPuestoDesarmable);

			// Asocio a un Festival
			abmFestival.asociarUnidadVenta(idFestival, codigoFT);
			abmFestival.asociarUnidadVenta(idFestival, codigoPD);
		
			System.out.println("\n****** Festival actualizado ******");

			Festival festActualizado = abmFestival.traerFestivalYUnidadesVenta(idFestival);

			if (festActualizado.getUnidadesVenta() != null && !festActualizado.getUnidadesVenta().isEmpty()) {
				System.out.println(
						"Cantidad unidades de venta del festival= " + festActualizado.getUnidadesVenta().size());
				for (UnidadVenta uv : festActualizado.getUnidadesVenta()) {
					if (uv instanceof FoodTruck) {
						FoodTruck ft = (FoodTruck) uv;
						System.out.println("- " + uv.getNombre() + " Codigo: " + uv.getCodigo()
								+ " - FoodTruck - Patente: " + ft.getPatente());
					} else if (uv instanceof PuestoDesarmable) {
						PuestoDesarmable pd = (PuestoDesarmable) uv;
						System.out.println("- " + uv.getNombre() + " Codigo: " + uv.getCodigo()
								+ " - PuestoDesarmable - Carpas: " + pd.getCantidadCarpas() );
					}
				}
			} else {
				System.out.println("El festival no tiene unidades de venta cargadas.");
			}

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}
}