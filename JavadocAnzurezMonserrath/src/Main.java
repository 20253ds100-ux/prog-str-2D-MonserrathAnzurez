import java.util.Scanner;

/**
 * Clase principal que contiene un menú en consola para realizar
 * diferentes cálculos matemáticos y conversiones.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu: Elige un opcion (1 - 5");
            System.out.println("1 - Calcular IMC");
            System.out.println("2 - Calcular area de un rectángulo");
            System.out.println("3 - Convertir °C a °F");
            System.out.println("4 - Calcular área de un círculo");
            System.out.println("5 - Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura (m): ");
                    double altura = scanner.nextDouble();
                    System.out.println("IMC: " + calcularIMC(peso, altura));
                    break;

                case 2:
                    System.out.print("Base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Altura: ");
                    double h = scanner.nextDouble();
                    System.out.println("Área del rectangulo: " + areaRectangulo(base, h));
                    break;

                case 3:
                    System.out.print("Temperatura en °C: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Temperatura en °F: " + convertirCelsiusAFahrenheit(celsius));
                    break;

                case 4:
                    System.out.print("Radio: ");
                    double radio = scanner.nextDouble();
                    System.out.println("Área del círculo: " + areaCirculo(radio));
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

            System.out.println();

        } while (opcion != 5);

        scanner.close();
    }
    /**
     * Calcula el indice de Masa Corporal (IMC) a partir del peso y la altura.
     *
     * @param peso <-- Peso de la persona en kilogramos
     * @param altura <-- Altura de la persona en metros
     * @return Valor del IMC calculado
     */
    public static double calcularIMC(double peso, double altura) {
        return peso/(altura * altura);
    }

    /**
     * Calcula el area de un rectangulo usando su base y altura.
     *
     * @param base --> Base del rectángulo
     * @param altura <-- Altura del rectangulo
     * @return Área total del rectángulo
     */
    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Calcula el área de un circulo a partir de su radio
     *
     * @param radio <-- Radio del círculo
     * @return Área del círculo calculada
     */
    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    /**
     * Convierte una temperatura de grados Celsius a Fahrenheit.
     *
     * @param celsius <-- Temperatura en grados Celsius
     * @return Temperatura convertida a grados Fahrenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius*1.8)+32;
    }
}