package test;

import java.time.LocalDate;

import datos.Festival;
import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestCalcularTotalVendidoPorUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

       
        UnidadVentaABM abm = new UnidadVentaABM();
        
        try {

	        UnidadVenta unidad = abm.traer("ABCDEFGYIJ");
	        UnidadVenta unidad2 = abm.traer("HJKLBXYZQ");
	        UnidadVenta unidad3 = abm.traer("AGISHAEYFQ");
	        double total =abm.calcularTotalUnidadVenta(unidad.getCodigo());
	        double total2 =abm.calcularTotalUnidadVenta(unidad2.getCodigo());
	        double total3 =abm.calcularTotalUnidadVenta(unidad3.getCodigo());
	        System.out.println("Unidad De Venta" + unidad.getNombre());
	        System.out.println("Total vendido por unidad:  "+total );
	        System.out.println("Unidad De Venta" + unidad2.getNombre());
	        System.out.println("Total vendido por unidad:  "+ total2);
	        System.out.println("Unidad De Venta" + unidad3.getNombre());
	        System.out.println("Total vendido por unidad:  "+ total3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}
