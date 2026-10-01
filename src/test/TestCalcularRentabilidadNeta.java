package test;


import datos.Festival;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestCalcularRentabilidadNeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM UnidadVentaABM = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();
		Festival festival = festivalABM.traer(1);
		System.out.println(UnidadVentaABM.calcularRentabilidadNeta("AGISHAEYFQ", festival));
		
	}

}
