
package test;

import java.time.LocalDate;

import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestCargarDatos {

	public static void main(String[] args) {
	
        FestivalABM abmFestival = new FestivalABM();
        // CARGA DE FESTIVALES CON SU COSTO
        try {

            abmFestival.agregarConCosto("Festival Lanus", "Primavera", LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 25), 50, 30, 200, 500);
            abmFestival.agregarConCosto("Festival Lomas", "Invierno", LocalDate.of(2025, 7, 13), LocalDate.of(2025, 7, 18), 60, 15, 300, 450);
            abmFestival.agregarConCosto("Festival Ezeiza", "Verano", LocalDate.of(2025, 1, 22), LocalDate.of(2025, 1, 28), 70, 20, 250, 550);
            abmFestival.agregarConCosto("Festival Avellaneda", "Otoño", LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 19), 55, 10, 150, 600);
            abmFestival.agregarConCosto("Festival Quilmes", "Invierno", LocalDate.of(2025, 8, 19), LocalDate.of(2025, 1, 23), 50, 50, 350, 350);
        } catch (Exception e) {
            System.out.println("ERROR al agregar festival: " + e.getMessage());
            e.printStackTrace();
        }
		
		/*

		PlatoABM platoABM =  new PlatoABM();
		PedidoABM pedidoABM = new PedidoABM();
        ItemPedidoABM itemABM = new ItemPedidoABM();
        UnidadVentaABM unidadABM = new UnidadVentaABM();
        
     // TRAER UNA UNIDAD YA EXISTENTE
        UnidadVenta unidad = unidadABM.traer("UUUUUUUU");
		
		//AGERGAR PLATO
		int idPlato1;
		try {
			idPlato1 = platoABM.agregar("Hamburguesa", 25000, 15000, unidad);
		
		System.out.println("Plato agregado. ID: " + idPlato1);
		
		int idPlato2 = platoABM.agregar("Pizza", 22000, 10000, unidad);
		System.out.println("Plato agregado. ID: " + idPlato2);

		int idPlato3 = platoABM.agregar("Empanada", 3000, 1700, unidad);
		System.out.println("Plato agregado. ID: " + idPlato3);

        // AGREGAR PEDIDO
        int idPedido1 = pedidoABM.agregar(LocalDate.now(), unidad);
        System.out.println("Pedido agregado. ID: " + idPedido1);
        
        int idPedido2 = pedidoABM.agregar(LocalDate.now(), unidad);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}
