package test;

import datos.Empleado;
import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVentaEstrellaConEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM abmFestival= new FestivalABM();
		Festival festival = abmFestival.traer(1);
		UnidadVenta unidad= abm.traerUnidadVentaEstrellaConEmpleados(festival);
		System.out.println(unidad);

		System.out.println("Empleados : ");
		for (Empleado empleado : unidad.getEmpleados()) {
			System.out.println(empleado.toString());
		}
		
	}

}
