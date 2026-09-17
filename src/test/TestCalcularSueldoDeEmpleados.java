package test;


import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestCalcularSueldoDeEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abmUnidadVenta= new UnidadVentaABM();
		String codigo = "ABCDEFGYIJ";
		String codigo2 ="HJKLBXYZQ";
		String codigo3 ="AGISHAEYFQ";
		double total = abmUnidadVenta.totalSueldoEmpleados(codigo);
		double total2 = abmUnidadVenta.totalSueldoEmpleados(codigo2);
		double total3 = abmUnidadVenta.totalSueldoEmpleados(codigo3);
		System.out.println("Calcular total sueldo empleados por unidad de venta");
		System.out.println("Total sueldo de empleados "+ total +" unidad de venta con codigo: "+ codigo);
		System.out.println("Total sueldo de empleados "+ total2 +" unidad de venta con codigo: "+ codigo2);
		System.out.println("Total sueldo de empleados "+ total3 +" unidad de venta con codigo: "+ codigo3);
	}

}
