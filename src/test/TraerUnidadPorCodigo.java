package test;

import java.util.List;
import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TraerUnidadPorCodigo {

    public static void main(String[] args) {
        UnidadVentaABM abm = new UnidadVentaABM();
        
        String codigo = "ABCDEFGYIJ";
        double precioDesde = 7800;
        double precioHasta = 12000;

        System.out.println("=== 1. PLATOS DE LA UNIDAD DE VENTA CODIGO: " + codigo + " ===");
        UnidadVenta unidad = abm.traerUnidadVentaYPlatos(codigo);

        if (unidad != null) {
            if (unidad.getPlatos().isEmpty()) {
                System.out.println("La unidad de venta no tiene platos registrados.");
            } else {
                for (Plato plato : unidad.getPlatos()) {
                    System.out.println(plato);
                }
            }

            

            List<Plato> platosFiltrados = abm.traerPlatosDesdeHasta(codigo, precioDesde, precioHasta);
            System.out.println("--------------------------------------------------");
            System.out.println("Platos filtrados precio desde " + precioDesde + " hasta " + precioHasta);
            if (platosFiltrados.isEmpty()) {
                System.out.println("No se encontraron platos dentro del rango especificado.");
            } else {
                for (Plato plato : platosFiltrados) {
                    System.out.println(plato);
                }
            }

        } else {
            System.out.println("No existe ninguna Unidad de Venta con el codigo: " + codigo);
        }
    }
}