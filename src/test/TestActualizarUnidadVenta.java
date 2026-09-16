package test;

import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestActualizarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		String codigo="ABCDEFGYIJ";
		FestivalABM festivalAbm = new FestivalABM();
		Festival festival = festivalAbm.traer(1);
		UnidadVenta unidad= abm.traer(codigo);
		System.out.println(unidad.toString());
		System.out.println("--------------");
		System.out.println("se actuliza unidad nombre de unidad de venta");
		unidad.setFestival(festival);
		abm.actualizar(unidad);
		UnidadVenta unidadVenta = abm.traer(codigo);
		System.out.println(unidadVenta.toString());
		System.out.println(unidadVenta.getFestival().toString());
		
	}

}
