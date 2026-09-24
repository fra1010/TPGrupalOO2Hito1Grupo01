package test;


import negocio.UnidadVentaABM;

public class TestCalcularRentabilidadNeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM UnidadVentaABM = new UnidadVentaABM();
		System.out.println("unidad codigo AGISHAEYFQ ganancia: " + UnidadVentaABM.calcularRentabilidadNeta("AGISHAEYFQ", 1));
		System.out.println("unidad codigo HJKLBXYZQ  ganancia: " + UnidadVentaABM.calcularRentabilidadNeta("HJKLBXYZQ", 1));
		System.out.println("unidad codigo ABCDEFGYIJ ganancia: " + UnidadVentaABM.calcularRentabilidadNeta("ABCDEFGYIJ", 1));

	}

}
