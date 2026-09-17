package test;

import java.time.LocalDate;


import datos.Empleado;
import datos.Festival;
import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;
import negocio.EmpleadoAbm;
import negocio.FestivalABM;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class CargarTodosLosDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FestivalABM abmFestival = new FestivalABM();
        UnidadVentaABM abmUnidadVenta= new UnidadVentaABM();
        EmpleadoAbm empleado1 = new EmpleadoAbm();
        PlatoABM platoABM = new PlatoABM();
        PedidoABM pedidoABM = new PedidoABM();
        ItemPedidoABM itemABM = new ItemPedidoABM();
        try {

            abmFestival.agregarConCosto("Festival Lanus", "Primavera", LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 25), 50, 30, 200, 500);
            abmFestival.agregarConCosto("Festival Lomas", "Invierno", LocalDate.of(2025, 7, 13), LocalDate.of(2025, 7, 18), 60, 15, 300, 450);
            abmFestival.agregarConCosto("Festival Ezeiza", "Verano", LocalDate.of(2025, 1, 22), LocalDate.of(2025, 1, 28), 70, 20, 250, 550);
            abmFestival.agregarConCosto("Festival Avellaneda", "Otoño", LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 19), 55, 10, 150, 600);
            Festival festival= abmFestival.traer(1);
            int responsableId = empleado1.agregarEmpleadoCajero("Jose","Fernandez", 3333546,LocalDate.of(2000, 10, 6),LocalDate.of(2018, 6, 15),"tarde",15.5);
  	    	int responsableId2 = empleado1.agregarEmpleadoCajero("Maria","Lopez", 3333547,LocalDate.of(1998, 4, 20),LocalDate.of(2023, 1, 10),"manana",10);
  	    	int responsableId3 = empleado1.agregarEmpleadoCajero("Ana","Rodriguez", 3333548,LocalDate.of(1987, 11, 30),LocalDate.of(2012, 9, 1),"noche",25);
			Empleado responsable = empleado1.traer(responsableId);
			Empleado responsable2 = empleado1.traer(responsableId2);
			Empleado responsable3 = empleado1.traer(responsableId3);
  	    	abmUnidadVenta.agregarUnidadVenta("Taco Movil",responsable, 25.5, "ABCDEFGYIJ",festival, "ABC-123", true);
  	    	abmUnidadVenta.agregarUnidadVenta("Burger Express",responsable2, 18.0, "HJKLBXYZQ",festival, "XYZ-789", false);
  	    	abmUnidadVenta.agregarUnidadVenta("Puesto de Comidas",responsable3, 25.5, "AGISHAEYFQ",festival, 3, 120);
  	    	
  	    	UnidadVenta unidadVenta=abmUnidadVenta.traer("ABCDEFGYIJ");
  	    	UnidadVenta unidadVenta2=abmUnidadVenta.traer("HJKLBXYZQ");
  	    	UnidadVenta unidadVenta3=abmUnidadVenta.traer("AGISHAEYFQ");
  	    	responsable.setUnidadVenta(unidadVenta);
  	    	responsable2.setUnidadVenta(unidadVenta2);
  	    	responsable3.setUnidadVenta(unidadVenta3);
  	    	empleado1.actualizar(responsable);
  	    	empleado1.actualizar(responsable2);
  	    	empleado1.actualizar(responsable3);
  	    	// ---------------------------- cargamos datos ----------------------------
  	    	
  	    	int cocinero1 = empleado1.agregarEmpleadoCocinero("Nicolas","Armando",2551546,LocalDate.of(2000, 10, 6),LocalDate.of(2015, 3, 20),"fritos","chef",16);
  	    	int cocinero2 = empleado1.agregarEmpleadoCocinero("Juan","Perez",2551547,LocalDate.of(1995, 8, 15),LocalDate.of(2024, 2, 10),"pastas","ayudante",10);
  	    	int cocinero3 = empleado1.agregarEmpleadoCocinero("Pedro","Gomez", 2551548,LocalDate.of(1990, 12, 1),LocalDate.of(2021, 7, 5),"carnes","chef",20);

  	   	   
  	    	int cajero1 = empleado1.agregarEmpleadoCajero("Lucas","Ramirez", 3333549,LocalDate.of(1992, 7, 14),LocalDate.of(2010, 2, 15),"tarde",30);
  	    	int cajero2 = empleado1.agregarEmpleadoCajero("Carla","Moreno", 3333550,LocalDate.of(2001, 5, 22),LocalDate.of(2025, 3, 10),"manana",5);
  	    	int cajero3 = empleado1.agregarEmpleadoCajero("Diego","Castro", 3333551,LocalDate.of(1994, 11, 8),LocalDate.of(2019, 8, 5),"noche", 20);
  	    	int cajero4 = empleado1.agregarEmpleadoCajero("Valentina", "Rojas", 3333552,LocalDate.of(1985, 2, 28),LocalDate.of(2014, 10, 18),"manana",28);
  	    	
  	    	Empleado e1 = empleado1.traer(cocinero1);
  	    	Empleado e2 = empleado1.traer(cajero1);
  	    	Empleado e3 = empleado1.traer(cajero2);

  	    	Empleado e4 = empleado1.traer(cocinero2);
  	    	Empleado e5 = empleado1.traer(cajero3);

  	    	Empleado e6 = empleado1.traer(cocinero3);
  	    	Empleado e7 = empleado1.traer(cajero4);

  	    	e1.setUnidadVenta(unidadVenta);
  	    	e2.setUnidadVenta(unidadVenta);
  	    	e3.setUnidadVenta(unidadVenta);

  	    	e4.setUnidadVenta(unidadVenta2);
  	    	e5.setUnidadVenta(unidadVenta2);

  	    	e6.setUnidadVenta(unidadVenta3);
  	    	e7.setUnidadVenta(unidadVenta3);

  	    	empleado1.actualizar(e1);
  	    	empleado1.actualizar(e2);
  	    	empleado1.actualizar(e3);
  	    	empleado1.actualizar(e4);
  	    	empleado1.actualizar(e5);
  	    	empleado1.actualizar(e6);
  	    	empleado1.actualizar(e7);
  	   // ---------------------------- Carga de Platos ----------------------------
  	   			// Unidad Venta 1 (Taco Movil)
  	   			int idPlatounidad  = platoABM.agregar("Pizza", 22000, 10000, unidadVenta);
  	   			int idPlato2unidad = platoABM.agregar("pancho", 5000.00, 3000, unidadVenta);
  	   			int idPlato3unidad = platoABM.agregar("Milanesa con papas", 8500.00, 4200.00, unidadVenta);
  	   			int idPlato4unidad = platoABM.agregar("Ravioles con tuco", 7800.00, 3500.00, unidadVenta);
  	   			int idPlato5unidad = platoABM.agregar("Lomo a la plancha", 12000.00, 5800.00, unidadVenta);
  	   			int idPlato6unidad = platoABM.agregar("Pollo al horno con puré", 9000.00, 4300.00, unidadVenta);

  	   			// Unidad Venta 2 (Burger Express)
  	   			int idPlatounidad2  = platoABM.agregar("Hamburguesa Completa", 9500.00, 4100.00, unidadVenta2);
  	   			int idPlato2unidad2 = platoABM.agregar("Empanada de Carne", 1200.00, 500.00, unidadVenta2);
  	   			int idPlato3unidad2 = platoABM.agregar("Papas Bastón", 4500.00, 1800.00, unidadVenta2);
  	   			int idPlato4unidad2 = platoABM.agregar("Sánguche de Miga", 1800.00, 800.00, unidadVenta2);
  	   			int idPlato5unidad2 = platoABM.agregar("Tarta de Jamón y Queso", 6200.00, 2900.00, unidadVenta2);

  	   			// Unidad Venta 3 (Puesto de Comidas)
  	   			int idPlatounidad3  = platoABM.agregar("Provolone a la Quinta", 7500.00, 3200.00, unidadVenta3);
  	   			int idPlato2unidad3 = platoABM.agregar("Choripán de Campo", 3800.00, 1500.00, unidadVenta3);
  	   			int idPlato3unidad3 = platoABM.agregar("Tira de Asado", 14500.00, 7000.00, unidadVenta3);
  	   			int idPlato4unidad3 = platoABM.agregar("Vacio al Horno", 13800.00, 6500.00, unidadVenta3);
  	   			int idPlato5unidad3 = platoABM.agregar("Mollejas al Limón", 11000.00, 5200.00, unidadVenta3);

  	   			// ---------------------------- Carga Objetos Plato ----------------------------
  	   			Plato u1_p1 = platoABM.traer(idPlatounidad);  // Pizza
  	   			Plato u1_p2 = platoABM.traer(idPlato2unidad); // Pancho
  	   			Plato u1_p3 = platoABM.traer(idPlato3unidad); // Milanesa con papas
  	   			Plato u1_p4 = platoABM.traer(idPlato4unidad); // Ravioles con tuco
  	   			Plato u1_p5 = platoABM.traer(idPlato5unidad); // Lomo a la plancha
  	   			Plato u1_p6 = platoABM.traer(idPlato6unidad); // Pollo al horno con puré

  	   			Plato u2_p1 = platoABM.traer(idPlatounidad2);  // Hamburguesa Completa
  	   			Plato u2_p2 = platoABM.traer(idPlato2unidad2); // Empanada de Carne
  	   			Plato u2_p3 = platoABM.traer(idPlato3unidad2); // Papas Bastón
  	   			Plato u2_p4 = platoABM.traer(idPlato4unidad2); // Sánguche de Miga
  	   			Plato u2_p5 = platoABM.traer(idPlato5unidad2); // Tarta de Jamón y Queso

  	   			Plato u3_p1 = platoABM.traer(idPlatounidad3);  // Provolone a la Quinta
  	   			Plato u3_p2 = platoABM.traer(idPlato2unidad3); // Choripán de Campo
  	   			Plato u3_p3 = platoABM.traer(idPlato3unidad3); // Tira de Asado
  	   			Plato u3_p4 = platoABM.traer(idPlato4unidad3); // Vacio al Horno
  	   			Plato u3_p5 = platoABM.traer(idPlato5unidad3); // Mollejas al Limón

  	   			// -----------------------------------------------------------------------------
  	   			// UNIDAD DE VENTA 1: 4 PEDIDOS
  	   			// -----------------------------------------------------------------------------
  	   			// Pedido 1
  	   			int idPed1_U1 = pedidoABM.agregar(LocalDate.of(2025, 9, 21), unidadVenta);
  	   			Pedido ped1_U1 = pedidoABM.traer(idPed1_U1);
  	   			itemABM.agregar(u1_p1, ped1_U1, 2); // 2 Pizzas
  	   			itemABM.agregar(u1_p3, ped1_U1, 1); // 1 Milanesa con papas

  	   			// Pedido 2
  	   			int idPed2_U1 = pedidoABM.agregar(LocalDate.of(2025, 9, 22), unidadVenta);
  	   			Pedido ped2_U1 = pedidoABM.traer(idPed2_U1);
  	   			itemABM.agregar(u1_p2, ped2_U1, 3); // 3 Panchos
  	   			itemABM.agregar(u1_p4, ped2_U1, 2); // 2 Ravioles con tuco

  	   			// Pedido 3
  	   			int idPed3_U1 = pedidoABM.agregar(LocalDate.of(2025, 9, 23), unidadVenta);
  	   			Pedido ped3_U1 = pedidoABM.traer(idPed3_U1);
  	   			itemABM.agregar(u1_p5, ped3_U1, 1); // 1 Lomo a la plancha
  	   			itemABM.agregar(u1_p6, ped3_U1, 2); // 2 Pollo al horno con puré

  	   			// Pedido 4
  	   			int idPed4_U1 = pedidoABM.agregar(LocalDate.of(2025, 9, 24), unidadVenta);
  	   			Pedido ped4_U1 = pedidoABM.traer(idPed4_U1);
  	   			itemABM.agregar(u1_p1, ped4_U1, 1); // 1 Pizza
  	   			itemABM.agregar(u1_p2, ped4_U1, 2); // 2 Panchos
  	   			itemABM.agregar(u1_p3, ped4_U1, 1); // 1 Milanesa con papas

  	   			// -----------------------------------------------------------------------------
  	   			// UNIDAD DE VENTA 2: 4 PEDIDOS
  	   			// -----------------------------------------------------------------------------
  	   			// Pedido 1
  	   			int idPed1_U2 = pedidoABM.agregar(LocalDate.of(2025, 9, 21), unidadVenta2);
  	   			Pedido ped1_U2 = pedidoABM.traer(idPed1_U2);
  	   			itemABM.agregar(u2_p1, ped1_U2, 2); // 2 Hamburguesas Completas
  	   			itemABM.agregar(u2_p3, ped1_U2, 1); // 1 Papas Bastón

  	   			// Pedido 2
  	   			int idPed2_U2 = pedidoABM.agregar(LocalDate.of(2025, 9, 22), unidadVenta2);
  	   			Pedido ped2_U2 = pedidoABM.traer(idPed2_U2);
  	   			itemABM.agregar(u2_p2, ped2_U2, 12); // 12 Empanadas de Carne
  	   			itemABM.agregar(u2_p5, ped2_U2, 1);  // 1 Tarta de Jamón y Queso

  	   			// Pedido 3
  	   			int idPed3_U2 = pedidoABM.agregar(LocalDate.of(2025, 9, 23), unidadVenta2);
  	   			Pedido ped3_U2 = pedidoABM.traer(idPed3_U2);
  	   			itemABM.agregar(u2_p4, ped3_U2, 6); // 6 Sánguches de Miga
  	   			itemABM.agregar(u2_p3, ped3_U2, 2); // 2 Papas Bastón

  	   			// Pedido 4
  	   			int idPed4_U2 = pedidoABM.agregar(LocalDate.of(2025, 9, 24), unidadVenta2);
  	   			Pedido ped4_U2 = pedidoABM.traer(idPed4_U2);
  	   			itemABM.agregar(u2_p1, ped4_U2, 3); // 3 Hamburguesas Completas
  	   			itemABM.agregar(u2_p2, ped4_U2, 4); // 4 Empanadas de Carne

  	   			// -----------------------------------------------------------------------------
  	   			// UNIDAD DE VENTA 3: 4 PEDIDOS
  	   			// -----------------------------------------------------------------------------
  	   			// Pedido 1
  	   			int idPed1_U3 = pedidoABM.agregar(LocalDate.of(2025, 9, 21), unidadVenta3);
  	   			Pedido ped1_U3 = pedidoABM.traer(idPed1_U3);
  	   			itemABM.agregar(u3_p3, ped1_U3, 2); // 2 Tiras de Asado
  	   			itemABM.agregar(u3_p1, ped1_U3, 1); // 1 Provolone a la Quinta

  	   			// Pedido 2
  	   			int idPed2_U3 = pedidoABM.agregar(LocalDate.of(2025, 9, 22), unidadVenta3);
  	   			Pedido ped2_U3 = pedidoABM.traer(idPed2_U3);
  	   			itemABM.agregar(u3_p2, ped2_U3, 4); // 4 Choripanes de Campo
  	   			itemABM.agregar(u3_p5, ped2_U3, 1); // 1 Mollejas al Limón

  	   			// Pedido 3
  	   			int idPed3_U3 = pedidoABM.agregar(LocalDate.of(2025, 9, 23), unidadVenta3);
  	   			Pedido ped3_U3 = pedidoABM.traer(idPed3_U3);
  	   			itemABM.agregar(u3_p4, ped3_U3, 2); // 2 Vacíos al Horno
  	   			itemABM.agregar(u3_p1, ped3_U3, 2); // 2 Provolones a la Quinta

  	   			// Pedido 4
  	   			int idPed4_U3 = pedidoABM.agregar(LocalDate.of(2025, 9, 24), unidadVenta3);
  	   			Pedido ped4_U3 = pedidoABM.traer(idPed4_U3);
  	   			itemABM.agregar(u3_p3, ped4_U3, 1); // 1 Tira de Asado
  	   			itemABM.agregar(u3_p4, ped4_U3, 1); // 1 Vacío al Horno
  	   			itemABM.agregar(u3_p2, ped4_U3, 2); // 2 Choripanes de Campo

  	   			System.out.println("Carga de datos realizada con éxito.");
        } catch (Exception e) {
            System.out.println("ERROR al agregar festival: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
