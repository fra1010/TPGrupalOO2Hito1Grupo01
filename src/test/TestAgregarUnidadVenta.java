package test;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestAgregarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		
		try {
			abm.agregarUnidadVenta("Taco Movil", null, 25.5, "ABCDEFGHIJ", "ABC-123", true);
  		    abm.agregarUnidadVenta("Burger Express",null, 18.0, "HJKLMWXYZQ", "XYZ-789", false);
  		    abm.agregarUnidadVenta("Puesto de Comidas",null, 25.5, "AGRSHAEYFQ", 3, 120);
  		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String codigo="ABCDEFGHIJ";
		String codigo2="HJKLMWXYZQ";
		System.out.println(abm.traerUnidadVentaYEmpleados(codigo));
		UnidadVenta u= abm.traerUnidadVentaYEmpleados(codigo2);
		System.out.println("---------------");
		abm.traer().forEach(nombre -> System.out.println(nombre.toString()));
		
	}

}
