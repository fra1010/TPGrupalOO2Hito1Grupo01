package test;

import datos.Empleado;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVentaEstrellaConEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		
		UnidadVenta unidad= abm.traerUnidadVentaEstrellaConEmpleados(1);
		System.out.println(unidad);

		System.out.println("Empleados : ");
		for (Empleado empleado : unidad.getEmpleados()) {
			System.out.println(empleado.toString());
		}
		
	}

}
