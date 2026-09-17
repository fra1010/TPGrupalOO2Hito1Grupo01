package test;

import negocio.UnidadVentaABM;

public class TestCalcularGananciaPlatosPorUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abmUnidadVenta= new UnidadVentaABM();
		String codigo = "ABCDEFGYIJ";
		String codigo2 ="HJKLBXYZQ";
		String codigo3 ="AGISHAEYFQ";

		double ganancia = abmUnidadVenta.calcularGananciaPlatosPorUnidadVenta(codigo);
		double ganancia2 = abmUnidadVenta.calcularGananciaPlatosPorUnidadVenta(codigo2);
		double ganancia3 = abmUnidadVenta.calcularGananciaPlatosPorUnidadVenta(codigo3);
		System.out.println("Ganancia de platos vendidos: " + ganancia  + " codigo unidad de venta: " + codigo);
		System.out.println("Ganancia de platos vendidos: " + ganancia2 + " codigo unidad de venta: " + codigo2);
		System.out.println("Ganancia de platos vendidos: " + ganancia3 + " codigo unidad de venta: " + codigo3);

	}

}
