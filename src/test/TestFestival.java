package test;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class TestFestival {

    public static void main(String[] args) {

        FestivalABM abm = new FestivalABM();

        try {
            LocalDate desde = LocalDate.of(2025, 2, 21);
            LocalDate hasta = LocalDate.of(2025, 9, 25);

            List<Festival> lista = abm.traerPorRangoDeFechas(desde, hasta);

            System.out.println("Festivales entre fechas " + desde + " - " + hasta);
            for (Festival f : lista) {
                System.out.println("  - " + f.getNombre() + " (" + f.getFechaInicio() + " a " + f.getFechaFin() + ")");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            String temporada = "Invierno";

            List<Festival> lista = abm.traerPorTemporada(temporada);

            System.out.println("Festivales para la temporada: " + temporada);
            for (Festival f : lista) {
                System.out.println("  - " + f.getNombre() + " (" + f.getFechaInicio() + " a " + f.getFechaFin() + ")");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            int costoMin = 100;
            int costoMax = 820;

            List<Festival> lista = abm.traerPorRangoDeCosto(costoMin, costoMax);

            System.out.println("Festivales con costo entre: " + costoMin + " - " + costoMax);
            for (Festival f : lista) {
                int total = f.getCosto().getCostoSuperficie() + f.getCosto().getCostoMontaje()
                        + f.getCosto().getCostoElectricidad() + f.getCosto().getSueldoBase();
                System.out.println("  - " + f.getNombre() + " - costo total: " + total);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}