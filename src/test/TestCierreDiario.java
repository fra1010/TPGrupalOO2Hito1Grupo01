package test;


import java.time.LocalDate;

import datos.UnidadVenta;
import negocio.PedidoABM;
import negocio.UnidadVentaABM;

public class TestCierreDiario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PedidoABM pedidoABM = new PedidoABM();
		UnidadVentaABM unidadABM = new UnidadVentaABM();
		UnidadVenta unidad = unidadABM.traer("ABCDEFGYIJ");
		
		
		try {
			Object[] cierre = pedidoABM.traerCierreDiario(unidad, LocalDate.of(2025, 9, 21));
			
			System.out.println("CIERRE DIARIO");
            System.out.println("Cantidad de pedidos: " + cierre[0]);
            System.out.println("Productos vendidos: " + cierre[1]);
            System.out.println("Facturación total: $" + cierre[2]);
            System.out.println("Costo total: $" + cierre[3]);
            System.out.println("Margen total: $" + cierre[4]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
