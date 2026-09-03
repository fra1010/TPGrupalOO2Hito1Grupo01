package test;

import java.time.LocalDate;

import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestCalcularTotalVendidoPorUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlatoABM platoABM =  new PlatoABM();
		PedidoABM pedidoABM = new PedidoABM();
        ItemPedidoABM itemABM = new ItemPedidoABM();
        UnidadVentaABM abm = new UnidadVentaABM();
        try {
			abm.agregarUnidadVenta("Taco Movil", null, 25.5, "ABCDEFGHIJ", "ABC-123", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //SE TRAE LA UNIDAD DE VENTA POR CODIGO
        UnidadVenta unidad = abm.traer("ABCDEFGHIJ");
		//AGERGAR PLATOS A LA UNIDAD DE VENTA
		int idPlato1 = platoABM.agregar("Hamburguesa", 25000, 15000,unidad);
		
		int idPlato2 = platoABM.agregar("Pizza", 22000, 10000,unidad);

		int idPlato3 = platoABM.agregar("Empanada", 3000, 1700,unidad);

        // AGREGAR PEDIDO
        int idPedido1 = pedidoABM.agregar(LocalDate.now(),unidad);
        int idPedido2 = pedidoABM.agregar(LocalDate.now(),unidad);

        // TRAER PARA RELACIONAR
        Plato plato1 = platoABM.traer(idPlato1);
        Pedido pedido1 = pedidoABM.traer(idPedido1);
        
        Plato plato2 = platoABM.traer(idPlato2);
        Plato plato3 = platoABM.traer(idPlato3);
        
        Pedido pedido2 = pedidoABM.traer(idPedido2);

        // AGREGAR ITEM
        itemABM.agregar(plato1, pedido1, 2);
        itemABM.agregar(plato3, pedido1, 4);

        itemABM.agregar(plato2, pedido2, 1);
        itemABM.agregar(plato3, pedido2, 6);
        // TOTAL VENDIDO POR UNIDAD DE VENTA
        System.out.println("Unidad De Venta" + unidad.getNombre());
        System.out.println("Total vendido por unidad:  "+ abm.calcularTotalUnidadVenta(unidad.getCodigo()));
	}

}
