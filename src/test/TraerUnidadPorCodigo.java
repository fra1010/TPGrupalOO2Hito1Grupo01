package test;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TraerUnidadPorId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		String codigo="ABCDEFGHIJ";
//		String codigo2="HJKLMWXYZQ";
		System.out.println("Treaer unidad por id: ABCDEFGHIJ ");
		System.out.println(abm.traerUnidadVentaYEmpleados(codigo));
	
		System.out.println("---------------");
		System.out.println("Traer todas las unidades de venta");
		abm.traer().forEach(nombre -> System.out.println(nombre.toString()));
	}

}
