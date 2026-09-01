package test;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestActualizarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		String codigo="ABCDEFGHIJ";
		UnidadVenta unidad= abm.traer(codigo);
		System.out.println(unidad.toString());
		System.out.println("--------------");
		System.out.println("se actuliza unidad nombre de unidad de venta");
		unidad.setNombre("Hamburguesa Express");
		abm.actualizar(unidad);
		System.out.println(abm.traer(codigo).toString());
		System.out.println();
	}

}
