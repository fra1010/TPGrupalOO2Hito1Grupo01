package test;

import java.util.HashSet;
import java.util.Set;

import datos.Plato;
import negocio.UnidadVentaABM;

public class TestAgregarUnidadVentaConPlatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		Set<Plato> listaDePlatos=new HashSet<>();
		listaDePlatos.add(new Plato("pancho", 5000.00, 3000));
		listaDePlatos.add(new Plato("Milanesa con papas", 8500.00, 4200.00));
		listaDePlatos.add(new Plato("Ravioles con tuco", 7800.00, 3500.00));
		listaDePlatos.add(new Plato("Lomo a la plancha", 12000.00, 5800.00));
		listaDePlatos.add(new Plato("Pollo al horno con puré", 9000.00, 4300.00));
		
		abm.agregarUnidadVentaFoodTruckConPlatos("Taco Movil", null, 25.5, "ABCDEFGHIJ", "ABC-123", true,listaDePlatos);

	}

}
