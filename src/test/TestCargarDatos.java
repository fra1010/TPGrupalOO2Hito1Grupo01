package test;

import java.time.LocalDate;

import datos.Pedido;
import datos.Plato;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestCargarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoABM platoABM =  new PlatoABM();
		PedidoABM pedidoABM = new PedidoABM();
        ItemPedidoABM itemABM = new ItemPedidoABM();
		
		//AGERGAR PLATO
		int idPlato1 = platoABM.agregar("Hamburguesa", 25000, 15000);
		System.out.println("Plato agregado. ID: " + idPlato1);
		
		int idPlato2 = platoABM.agregar("Pizza", 22000, 10000);
		System.out.println("Plato agregado. ID: " + idPlato2);

		int idPlato3 = platoABM.agregar("Empanada", 3000, 1700);
		System.out.println("Plato agregado. ID: " + idPlato3);

        // AGREGAR PEDIDO
        int idPedido1 = pedidoABM.agregar(LocalDate.now());
        System.out.println("Pedido agregado. ID: " + idPedido1);
        
        int idPedido2 = pedidoABM.agregar(LocalDate.now());
        System.out.println("Pedido agregado. ID: " + idPedido2);

        // TRAER PARA RELACIONAR
        Plato plato1 = platoABM.traer(idPlato1);
        Pedido pedido1 = pedidoABM.traer(idPedido1);
        
        Plato plato2 = platoABM.traer(idPlato2);
        Plato plato3 = platoABM.traer(idPlato3);
        Pedido pedido2 = pedidoABM.traer(idPedido2);

        // AGREGAR ITEM
        int idItem1 = itemABM.agregar(plato1, pedido1, 2);
        int idItem2 = itemABM.agregar(plato3, pedido1, 4);

        int idItem3 = itemABM.agregar(plato2, pedido2, 1);
        int idItem4 = itemABM.agregar(plato3, pedido2, 6);

        System.out.println("ItemPedido agregado. ID: " + idItem1);
        System.out.println("ItemPedido agregado. ID: " + idItem2);
        System.out.println("ItemPedido agregado. ID: " + idItem3);
        System.out.println("ItemPedido agregado. ID: " + idItem4);
    }
}