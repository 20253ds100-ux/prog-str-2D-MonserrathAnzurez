import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputDataValidator inputDataValidator = new InputDataValidator();
        ShippingCalculator calculator = new ShippingCalculator();
        // input

        double pesoKg = inputDataValidator.leerDoubleEnRango(sc,"Ingresa el peso en Kg", 0.1, 50);
        int distanciaKm = inputDataValidator.leerIntEnRango(sc, "Ingresa la distancia en Km", 1, 2000);
        int tipoServicio = inputDataValidator.leerIntEnRango(sc,"Ingresa el tipo de servicio 1) Estandar 2) Express", 1, 2);

        boolean esZonaRemota = inputDataValidator.leerBoolean(sc,"Es zona remota?");

        // process
        double subtotal = calculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calculator.calcularIVA(subtotal);
        double total = calculator.calcularTotal(subtotal, iva);
        // output
        ticket1(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, total, calculator);
    }

    public static void ticket1(int tipoServicio, double pesoKg, int distanciaKm, boolean esZonaRemota, double subtotal, double iva, double total, ShippingCalculator calculator) {
        String servicio = calculator.tipoServicio(tipoServicio);
        System.out.println("PesoKg: " +pesoKg);
        System.out.println("DistanciaKm " +distanciaKm);
        System.out.println("tipoServicio: "+ servicio);
        System.out.println("esZonaRemota: "+esZonaRemota);
        System.out.println("Subtotal: "+subtotal);
        System.out.println("IVA: "+ iva);
        System.out.println("Total a pagar: "+total);

    }
}
