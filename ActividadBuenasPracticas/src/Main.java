import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numero = pedirEntero(sc);
        int resultado = sumarHastaN(numero);
        System.out.println("La suma de los números del 1 al " + numero + " es: " + resultado);
        sc.close();
    }
    public static int pedirEntero(Scanner scanner) {
        System.out.print("Ingrese un número (Por favor que sea entero): ");
        return scanner.nextInt();
    }
    public static int sumarHastaN(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
        return suma;
    }
}