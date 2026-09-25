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

		FestivalABM festivalABM = new FestivalABM();
		UnidadVentaABM unidadABM = new UnidadVentaABM();
		EmpleadoAbm empleadoABM = new EmpleadoAbm();
		PlatoABM platoABM = new PlatoABM();
		PedidoABM pedidoABM = new PedidoABM();
		ItemPedidoABM itemABM = new ItemPedidoABM();

		try {

			// ==================== FESTIVALES ====================

			festivalABM.agregarConCosto("Festival Lanus","Primavera",LocalDate.of(2025,9,21),LocalDate.of(2025,9,25),50,30,200,500);
			festivalABM.agregarConCosto("Festival Quilmes","Verano",LocalDate.of(2025,12,5),LocalDate.of(2025,12,10),60,20,250,550);
			festivalABM.agregarConCosto("Festival Avellaneda","Otono",LocalDate.of(2026,4,10),LocalDate.of(2026,4,14),55,15,180,450);
			festivalABM.agregarConCosto("Festival Moron","Invierno",LocalDate.of(2026,7,15),LocalDate.of(2026,7,20),65,25,300,600);

			Festival festivalLanus = festivalABM.traer(1);
			Festival festivalQuilmes = festivalABM.traer(2);
			Festival festivalAvellaneda = festivalABM.traer(3);
			Festival festivalMoron = festivalABM.traer(4);


			// ==================== RESPONSABLES ====================

			int idJose = empleadoABM.agregarEmpleadoCajero("Jose","Fernandez",3333546,LocalDate.of(1990,5,12),LocalDate.of(2018,6,15),"tarde",18);
			int idMaria = empleadoABM.agregarEmpleadoCajero("Maria","Lopez",3333547,LocalDate.of(1995,8,20),LocalDate.of(2020,3,10),"manana",16);
			int idDiego = empleadoABM.agregarEmpleadoCajero("Diego","Castro",3333548,LocalDate.of(1989,11,8),LocalDate.of(2017,8,5),"noche",22);
			int idLaura = empleadoABM.agregarEmpleadoCajero("Laura","Rojas",3333549,LocalDate.of(1993,2,18),LocalDate.of(2019,10,12),"tarde",19);

			Empleado jose = empleadoABM.traer(idJose);
			Empleado maria = empleadoABM.traer(idMaria);
			Empleado diego = empleadoABM.traer(idDiego);
			Empleado laura = empleadoABM.traer(idLaura);


			// ==================== UNIDADES DE VENTA ====================

			unidadABM.agregarUnidadVenta("Taco Movil",jose,25.5,"TACO-LANUS",festivalLanus,"LAN-101",true);
			unidadABM.agregarUnidadVenta("Parrilla Quilmes",maria,30,"PARRI-QUI",festivalQuilmes,"QUI-202",false);
			unidadABM.agregarUnidadVenta("Pasta al Paso",diego,22,"PASTA-AVE",festivalAvellaneda,"AVE-303",true);
			unidadABM.agregarUnidadVenta("Pizza Moron",laura,24,"PIZZA-MOR",festivalMoron,"MOR-404",false);

			UnidadVenta tacoMovil = unidadABM.traer("TACO-LANUS");
			UnidadVenta parrillaQuilmes = unidadABM.traer("PARRI-QUI");
			UnidadVenta pastaPaso = unidadABM.traer("PASTA-AVE");
			UnidadVenta pizzaMoron = unidadABM.traer("PIZZA-MOR");

			jose.setUnidadVenta(tacoMovil);
			maria.setUnidadVenta(parrillaQuilmes);
			diego.setUnidadVenta(pastaPaso);
			laura.setUnidadVenta(pizzaMoron);

			empleadoABM.actualizar(jose);
			empleadoABM.actualizar(maria);
			empleadoABM.actualizar(diego);
			empleadoABM.actualizar(laura);


			// ==================== EMPLEADOS ====================

			int idNicolas = empleadoABM.agregarEmpleadoCocinero("Nicolas","Armando",2551546,LocalDate.of(1992,2,10),LocalDate.of(2019,4,15),"mexicana","chef",22);
			int idLucas = empleadoABM.agregarEmpleadoCajero("Lucas","Ramirez",3333550,LocalDate.of(1998,7,14),LocalDate.of(2022,2,15),"tarde",14);

			int idPedro = empleadoABM.agregarEmpleadoCocinero("Pedro","Gomez",2551547,LocalDate.of(1988,11,3),LocalDate.of(2016,7,5),"carnes","chef",28);
			int idCarla = empleadoABM.agregarEmpleadoCajero("Carla","Moreno",3333551,LocalDate.of(1996,4,22),LocalDate.of(2021,3,10),"noche",15);

			int idJuan = empleadoABM.agregarEmpleadoCocinero("Juan","Perez",2551548,LocalDate.of(1995,8,15),LocalDate.of(2020,2,10),"pastas","ayudante",18);
			int idSofia = empleadoABM.agregarEmpleadoCajero("Sofia","Martinez",3333552,LocalDate.of(1999,9,25),LocalDate.of(2023,1,10),"manana",12);

			int idTomas = empleadoABM.agregarEmpleadoCocinero("Tomas","Benitez",2551549,LocalDate.of(1990,12,20),LocalDate.of(2017,9,10),"pizzas","chef",25);
			int idJulieta = empleadoABM.agregarEmpleadoCajero("Julieta","Molina",3333553,LocalDate.of(1995,5,17),LocalDate.of(2020,11,1),"tarde",17);

			Empleado nicolas = empleadoABM.traer(idNicolas);
			Empleado lucas = empleadoABM.traer(idLucas);
			Empleado pedro = empleadoABM.traer(idPedro);
			Empleado carla = empleadoABM.traer(idCarla);
			Empleado juan = empleadoABM.traer(idJuan);
			Empleado sofia = empleadoABM.traer(idSofia);
			Empleado tomas = empleadoABM.traer(idTomas);
			Empleado julieta = empleadoABM.traer(idJulieta);

			nicolas.setUnidadVenta(tacoMovil);
			lucas.setUnidadVenta(tacoMovil);
			pedro.setUnidadVenta(parrillaQuilmes);
			carla.setUnidadVenta(parrillaQuilmes);
			juan.setUnidadVenta(pastaPaso);
			sofia.setUnidadVenta(pastaPaso);
			tomas.setUnidadVenta(pizzaMoron);
			julieta.setUnidadVenta(pizzaMoron);

			empleadoABM.actualizar(nicolas);
			empleadoABM.actualizar(lucas);
			empleadoABM.actualizar(pedro);
			empleadoABM.actualizar(carla);
			empleadoABM.actualizar(juan);
			empleadoABM.actualizar(sofia);
			empleadoABM.actualizar(tomas);
			empleadoABM.actualizar(julieta);


			// ==================== PLATOS ====================

			int idTaco = platoABM.agregar("Taco de Carne",6500,2800,tacoMovil);
			int idBurrito = platoABM.agregar("Burrito Completo",8500,3800,tacoMovil);
			int idNachos = platoABM.agregar("Nachos con Queso",5000,2200,tacoMovil);

			int idParrillada = platoABM.agregar("Parrillada para Dos",28000,14000,parrillaQuilmes);
			int idChori = platoABM.agregar("Choripan",4500,2000,parrillaQuilmes);
			int idVacio = platoABM.agregar("Vacio con Papas",16000,7500,parrillaQuilmes);

			int idRavioles = platoABM.agregar("Ravioles con Tuco",9000,4000,pastaPaso);
			int idLasagna = platoABM.agregar("Lasagna",10500,4800,pastaPaso);
			int idFideos = platoABM.agregar("Fideos Bolognesa",8500,3700,pastaPaso);

			int idMuzzarella = platoABM.agregar("Pizza Muzzarella",9000,4000,pizzaMoron);
			int idNapolitana = platoABM.agregar("Pizza Napolitana",11000,5000,pizzaMoron);
			int idFugazzeta = platoABM.agregar("Pizza Fugazzeta",12000,5500,pizzaMoron);

			Plato taco = platoABM.traer(idTaco);
			Plato burrito = platoABM.traer(idBurrito);
			Plato nachos = platoABM.traer(idNachos);

			Plato parrillada = platoABM.traer(idParrillada);
			Plato chori = platoABM.traer(idChori);
			Plato vacio = platoABM.traer(idVacio);

			Plato ravioles = platoABM.traer(idRavioles);
			Plato lasagna = platoABM.traer(idLasagna);
			Plato fideos = platoABM.traer(idFideos);

			Plato muzzarella = platoABM.traer(idMuzzarella);
			Plato napolitana = platoABM.traer(idNapolitana);
			Plato fugazzeta = platoABM.traer(idFugazzeta);


			// ==================== PEDIDOS ====================

			int idPedido1 = pedidoABM.agregar(LocalDate.of(2025,9,21),tacoMovil);
			Pedido pedido1 = pedidoABM.traer(idPedido1);
			itemABM.agregar(taco,pedido1,2);
			itemABM.agregar(nachos,pedido1,1);
			pedidoABM.cerrarPedido(pedido1);

			int idPedido2 = pedidoABM.agregar(LocalDate.of(2025,9,23),tacoMovil);
			Pedido pedido2 = pedidoABM.traer(idPedido2);
			itemABM.agregar(burrito,pedido2,2);
			itemABM.agregar(taco,pedido2,1);
			pedidoABM.cerrarPedido(pedido2);


			int idPedido3 = pedidoABM.agregar(LocalDate.of(2025,12,5),parrillaQuilmes);
			Pedido pedido3 = pedidoABM.traer(idPedido3);
			itemABM.agregar(parrillada,pedido3,1);
			itemABM.agregar(chori,pedido3,2);
			pedidoABM.cerrarPedido(pedido3);

			int idPedido4 = pedidoABM.agregar(LocalDate.of(2025,12,8),parrillaQuilmes);
			Pedido pedido4 = pedidoABM.traer(idPedido4);
			itemABM.agregar(vacio,pedido4,2);
			itemABM.agregar(chori,pedido4,1);
			pedidoABM.cerrarPedido(pedido4);


			int idPedido5 = pedidoABM.agregar(LocalDate.of(2026,4,10),pastaPaso);
			Pedido pedido5 = pedidoABM.traer(idPedido5);
			itemABM.agregar(ravioles,pedido5,2);
			itemABM.agregar(lasagna,pedido5,1);
			pedidoABM.cerrarPedido(pedido5);

			int idPedido6 = pedidoABM.agregar(LocalDate.of(2026,4,12),pastaPaso);
			Pedido pedido6 = pedidoABM.traer(idPedido6);
			itemABM.agregar(fideos,pedido6,2);
			itemABM.agregar(ravioles,pedido6,1);
			pedidoABM.cerrarPedido(pedido6);


			int idPedido7 = pedidoABM.agregar(LocalDate.of(2026,7,15),pizzaMoron);
			Pedido pedido7 = pedidoABM.traer(idPedido7);
			itemABM.agregar(muzzarella,pedido7,2);
			itemABM.agregar(napolitana,pedido7,1);
			pedidoABM.cerrarPedido(pedido7);

			int idPedido8 = pedidoABM.agregar(LocalDate.of(2026,7,18),pizzaMoron);
			Pedido pedido8 = pedidoABM.traer(idPedido8);
			itemABM.agregar(fugazzeta,pedido8,1);
			itemABM.agregar(muzzarella,pedido8,2);
			pedidoABM.cerrarPedido(pedido8);


			System.out.println("========================================");
			System.out.println(" CARGA REALIZADA CON EXITO");
			System.out.println("========================================");
			System.out.println("Festivales: 4");
			System.out.println("Unidades de venta: 4");
			System.out.println("Empleados: 12");
			System.out.println("Platos: 12");
			System.out.println("Pedidos: 8");
			System.out.println("========================================");

		} catch (Exception e) {
			System.out.println("ERROR EN LA CARGA: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
