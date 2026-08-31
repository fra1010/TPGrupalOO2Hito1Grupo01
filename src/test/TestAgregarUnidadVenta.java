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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String codigo="ABCDEFGHIJ";
		String codigo2="HJKLMWXYZQ";
		System.out.println(abm.traerUnidadVentaYEmpleados(codigo));
		UnidadVenta u= abm.traerUnidadVentaYEmpleados(codigo2);
		System.out.println(u.toString());
		System.out.println(u.getEmpleados());
		
		
		
		
	}

}
