package test;



import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestAgregarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		
		abm.agregarUnidadVenta("Taco Movil", null, 25.5, "FT-2026-001", "ABC-123", true);
		abm.agregarUnidadVenta("Burger Express",null, 18.0, "FT-2026-002", "XYZ-789", false);
		System.out.println(abm.traer(2).toString());
		UnidadVenta u= abm.traerUnidadVentaYEmpleados(2);
		System.out.println(u.toString());
		System.out.println(u.getEmpleados());
	}

}
