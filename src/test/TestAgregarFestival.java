package test;

import java.time.LocalDate;

import negocio.FestivalABM;

public class TestAgregarFestival {

    public static void main(String[] args) {

        FestivalABM abmFestival = new FestivalABM();

        try {

            abmFestival.agregarConCosto("Festival Lanus", "Primavera", LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 25), 50, 30, 200, 500);
            abmFestival.agregarConCosto("Festival Lomas", "Invierno", LocalDate.of(2025, 7, 13), LocalDate.of(2025, 7, 18), 60, 15, 300, 450);
            abmFestival.agregarConCosto("Festival Ezeiza", "Verano", LocalDate.of(2025, 1, 22), LocalDate.of(2025, 1, 28), 70, 20, 250, 550);
            abmFestival.agregarConCosto("Festival Avellaneda", "Otoño", LocalDate.of(2025, 5, 14), LocalDate.of(2025, 5, 19), 55, 10, 150, 600);


        } catch (Exception e) {
            System.out.println("ERROR al agregar festival: " + e.getMessage());
            e.printStackTrace();
        }
    }
}