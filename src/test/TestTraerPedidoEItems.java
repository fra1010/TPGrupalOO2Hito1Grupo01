package test;

import datos.ItemPedido;
import datos.Pedido;
import negocio.PedidoABM;

public class TestTraerPedidoEItems {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            PedidoABM pedidoABM = new PedidoABM();

            Pedido pedido = pedidoABM.traerPedidoEItems(2);

            System.out.println("Pedido:");
            System.out.println(pedido);

            System.out.println("Items:");

            for (ItemPedido item : pedido.getItemsPedidos()) {
                System.out.println(item);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}