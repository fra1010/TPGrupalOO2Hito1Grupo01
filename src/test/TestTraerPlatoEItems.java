package test;

import datos.ItemPedido;
import datos.Plato;
import negocio.PlatoABM;

public class TestTraerPlatoEItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoABM platoABM= new PlatoABM();
		
		Plato plato = platoABM.traerPlatoEItems(3);
		
		System.out.println("Plato:");
        System.out.println(plato.getNombre());
        
        System.out.println("Items:");

        for (ItemPedido item : plato.getItemsPedidos()) {
            System.out.println(item);
        }
	}

}
