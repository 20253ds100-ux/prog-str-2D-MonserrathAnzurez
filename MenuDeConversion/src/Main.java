import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        int cAF = 0;
        int totalConversiones = 0;
        int fAC = 0;
        int millasAKm = 0;
        int kmAMillas = 0;
        double valor, resultado;
        do {
            System.out.println("Menu de conversiones");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas ");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir ");
            System.out.print("Elige una opción (1-5): ");

            while (!sc.hasNextInt()) {
                System.out.println(" EL NUMERO NO ES NUMERICO");
                System.out.print("Elige una opción (1-5): ");
                sc.next();
            }
            opc = sc.nextInt();

            if (opc < 1 || opc > 5) {
                System.out.println(" opcion no valida.");
                continue;
            }




            switch (opc) {
                case 1: // °C a °F
                    valor = pedirNumero(sc, "Ingresa grados Celsius: ");
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println("Resultado: " + resultado + " °F");
                    cAF++;
                    totalConversiones++;
                    break;

                case 2: // °F a °C
                    valor = pedirNumero(sc, "Ingresa grados Fahrenheit: ");
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println("Resultado: " + resultado + " °C");
                    fAC++;
                    totalConversiones++;
                    break;


                case 3: // Km a Millas
                    valor = pedirNumero(sc, "Ingresa kilómetros: ");
                    resultado = valor * 0.621371;
                    System.out.println("Resultado: " + resultado + " millas");
                    kmAMillas++;
                    totalConversiones++;
                    break;


                case 4: // Millas a Km
                    valor = pedirNumero(sc, "Ingresa millas: ");
                    resultado = valor / 0.621371;
                    System.out.println("Resultado: " + resultado + " km");
                    millasAKm++;
                    totalConversiones++;
                    break;


                case 5:
                    System.out.println("Saliste");
                    break;
            }


        } while (opc != 5);

        System.out.println("RESUMEN DE CONVERSIONES");
        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("°C a °F: " + cAF);
        System.out.println("°F a °C: " + fAC);
        System.out.println("Km a Millas: " + kmAMillas);
        System.out.println("Millas a Km: " + millasAKm);


        sc.close();
    }

    /*
     * Pide los numeros.
     * Valida los numeros
     */
    public static double pedirNumero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println(" Debes ingresar valores validos.");
            System.out.print(mensaje);
            sc.next(); // limpia entrada
        }
        return sc.nextDouble();
    }
}

