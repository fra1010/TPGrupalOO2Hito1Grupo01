package test;

import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestEliminarUnidadVentaDeFestival {

    public static void main(String[] args) {

        FestivalABM abmFestival = new FestivalABM();
        UnidadVentaABM abmUnidad = new UnidadVentaABM();

        int idFestival = 1;
        String codigoUnidad = "FASDFFDF";

        try {
            // Estado inicial
            Festival f = abmFestival.traerFestivalYUnidadesVenta(idFestival);

            if (f == null) {
                throw new Exception("No existe un Festival con id " + idFestival);
            }

            System.out.println("Festival: " + f.getNombre());
            System.out.println("Unidades antes de eliminar: " + f.getUnidadesVenta().size() );
            for (UnidadVenta uv : f.getUnidadesVenta()) {
                System.out.println("- " + uv.getNombre() + " - Codigo: " + uv.getCodigo());
            }

            //Verifica que la unidad existe en la base
            UnidadVenta uv = abmUnidad.traer(codigoUnidad);

            if (uv == null) {
                throw new Exception("La unidad con codigo " + codigoUnidad + " no existe en la base");
            }

            // Vrificar que pertenece al festival
            if (!f.getUnidadesVenta().contains(uv)) {
                throw new Exception("La unidad con codigo " + codigoUnidad + " no pertenece a este festival");
            }

            // Elimina la unidad del festival
            abmFestival.eliminarUnidadVentaDeFestival(idFestival, codigoUnidad);
 

            //Verificacion que la unidad ya no existe en el festival
            Festival fActualizado = abmFestival.traerFestivalYUnidadesVenta(idFestival);

            System.out.println("\nFestival despues de eliminar");
            System.out.println("Unidades despues de eliminar: " + fActualizado.getUnidadesVenta().size());
            for (UnidadVenta u : fActualizado.getUnidadesVenta()) {
                System.out.println("- " + u.getNombre() + " - Codigo: " + u.getCodigo());
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}