package test;

import java.time.LocalDate;

import datos.Pedido;
import datos.Plato;
import negocio.EmpleadoAbm;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestCargarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoABM platoABM =  new PlatoABM();
		PedidoABM pedidoABM = new PedidoABM();
        ItemPedidoABM itemABM = new ItemPedidoABM();
		
        EmpleadoAbm empleadoABM = EmpleadoAbm.getInstance();

        
        // ------------------ AGREGAR COCINEROS ----------------------
        
        empleadoABM.agregarEmpleadoCocinero("Ramon","Perez",11111111,LocalDate.of(2000, 10, 6),LocalDate.of(2025, 10, 6),"fritos");
        System.out.println("Empleado agregado. ID: ");
       
        empleadoABM.agregarEmpleadoCocinero("Juan","Lopez",33333333,LocalDate.of(1998, 5, 15),LocalDate.of(2024, 3, 10),"parrilla");
        System.out.println("Empleado agregado. ID: ");
        
    
        empleadoABM.agregarEmpleadoCocinero("Pedro","Gonzalez",44444444,LocalDate.of(1997, 8, 20),LocalDate.of(2023, 6, 1),"fritos");
        System.out.println("Empleado agregado. ID: ");
       
        empleadoABM.agregarEmpleadoCocinero("Matias","Gomez",555555555,LocalDate.of(1997, 1, 14),LocalDate.of(2024, 3, 10),"parrilla");
        System.out.println("Empleado agregado. ID: ");
        
        // ------------------ AGREGAR CAJEROS ----------------------
        
        empleadoABM.agregarEmpleadoCajero("Martin","Gomez",22222222,LocalDate.of(1999,11,23),LocalDate.of(2023,2,5),"tarde");
        System.out.println("Empleado agregado. ID: ");

        empleadoABM.agregarEmpleadoCajero("Laura","Rodriguez",66666666,LocalDate.of(2001,4,12),LocalDate.of(2024,1,15),"mañana");
        System.out.println("Empleado agregado. ID: ");

        empleadoABM.agregarEmpleadoCajero("Sofia","Martinez",77777777,LocalDate.of(1998,9,30),LocalDate.of(2023,8,20),"tarde");
        System.out.println("Empleado agregado. ID: ");

        empleadoABM.agregarEmpleadoCajero("Diego","Fernandez",88888888,LocalDate.of(2000,12,5),LocalDate.of(2025,2,10),"noche");
        System.out.println("Empleado agregado. ID: ");

        
        
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