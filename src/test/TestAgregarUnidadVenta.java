package test;




import java.time.LocalDate;

import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestAgregarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM abmFestival = new FestivalABM();
		CostoABM abmCosto = new CostoABM();
		
		// 1. Crear Festival
		String nombre = "Lollapalooza 2026";
		String temporada = "Primavera";
		LocalDate fechaInicio = LocalDate.of(2026, 3, 20);
		LocalDate fechaFin = LocalDate.of(2026, 3, 22);

		
		
		try {
			int idFestival = abmFestival.agregar(nombre, temporada, fechaInicio, fechaFin);
			Festival festival = abmFestival.traer(idFestival); // O el método que utilices para obtener la instancia

			// 2. Agregar Costo asociado al Festival
			// Campos: costoSuperficie, costoMontaje, costoElectricidad, sueldoBase, festival
			int idCosto = abmCosto.agregar(1500, 3000, 800, 500, festival);
			abm.agregarUnidadVenta("Taco Movil", null, 25.5, "ABCDEFGYIJ",festival, "ABC-123", true);
  		    abm.agregarUnidadVenta("Burger Express",null, 18.0, "HJKLBXYZQ",festival, "XYZ-789", false);
  		    abm.agregarUnidadVenta("Puesto de Comidas",null, 25.5, "AGISHAEYFQ",festival, 3, 120);
  		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
