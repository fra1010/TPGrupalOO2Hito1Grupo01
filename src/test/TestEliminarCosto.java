package test;

import datos.Costo;
import negocio.CostoABM;

public class TestEliminarCosto {

    public static void main(String[] args) {

        CostoABM abmCosto = new CostoABM();

        int idCosto = 1; // id_costo == id_festival 

        try {
            Costo costo = abmCosto.traer(idCosto);

            if (costo == null) {
                System.out.println("No existe un Costo con id " + idCosto);
                return;
            }

            System.out.println("Costo a eliminar: " + costo);

            abmCosto.eliminar(idCosto);

            Costo verificacion = abmCosto.traer(idCosto);

            if (verificacion == null) {
                System.out.println("Costo con id " + idCosto + " eliminado correctamente.");
            } else {
                System.out.println("El costo sigue existiendo: " + verificacion);
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar el costo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
