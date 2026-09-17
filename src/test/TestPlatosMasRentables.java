package test;

import java.time.LocalDate;
import java.util.List;

import datos.Plato;
import negocio.ItemPedidoABM;

public class TestPlatosMasRentables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ItemPedidoABM itemABM = new ItemPedidoABM();
		
		LocalDate desde = LocalDate.of(2025, 9, 1);
        LocalDate hasta = LocalDate.of(2026, 9, 30);
        
        int top = 5;

        List<Object[]> resultados;
		try {
			resultados = itemABM.traerPlatosMasRentables(desde, hasta, top);
		

        for (int i = 0; i < resultados.size(); i++) {

            Object[] fila = resultados.get(i);

            Plato plato = (Plato) fila[0];
            Double margenTotal = (Double) fila[1];

            System.out.println((i + 1) + ". " + plato.getNombre() + " - Margen generado: $" + margenTotal);
            }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
