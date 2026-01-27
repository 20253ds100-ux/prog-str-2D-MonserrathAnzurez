import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main(String[] args){
        int opcion=0;
        double variableA = 0, VariableB = 0, resultado = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opcion (1 - 4)");
        System.out.println("1 - Sumar");
        System.out.println("2 _ Restar");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        opcion = scanner.nextInt();

        System.out.print("Ingresa el primer numero, por favor: ");
        variableA = scanner.nextDouble();

        System.out.print("Ingresa el segundo numero, por favor: ");
        VariableB = scanner.nextDouble();

        switch (opcion) {
            case 1:
                resultado = variableA + VariableB;
                System.out.println("\n Sumar");
                System.out.println("Valores ingresados: Numero 1 = " + variableA + ", Numero 2 = " + VariableB);
                System.out.println(" " + variableA + " + " + VariableB + " = " + resultado);
                break;

            case 2:
                resultado = variableA - VariableB;
                System.out.println("\n Restar");
                System.out.println("Valores ingresados: Numero 1  = " + variableA + ", Numero 2 = " + VariableB);
                System.out.println(" " + variableA + " - " + VariableB + " = " + resultado);
                break;

            case 3:
                resultado = variableA * VariableB;
                System.out.println("\n Multiplicar");
                System.out.println("Valores ingresados: Numero 1 = " + variableA + ", Numero 2 = " + VariableB);
                System.out.println(" " + variableA + " X " + VariableB + " = " + resultado);
                break;

            case 4:
                System.out.println("\n Dividir");
                System.out.println("Valores ingresados: Numero 1 = " + variableA + ", Numero 2 = " + VariableB);

                if (VariableB == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = variableA / VariableB;
                    System.out.println(" " + variableA + " / " + VariableB + " = " + resultado);
                }
                break;

            default:
                System.out.println("\n OPCIÓN INVÁLIDA");
                break;
        }
    }
}
