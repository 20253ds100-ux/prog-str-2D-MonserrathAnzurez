import java.util.Scanner;
public class Calificaciones {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GradeService gradeService = new GradeService();

        /*El usuario ingresa:
        nombre del alumno (String) (no vacío)
3 calificaciones parciales (double) de 0 a 100
asistencia (int) de 0 a 100
entregaProyecto (boolean) true/false*/
        String nombre = leerTextoNoVacio(sc, "Dime tu nombre: ");
        double calificacion_1=leerDoubleEnRango(sc, "Ingresa la primera calificacion: ", 0, 100);
        double calificacion_2=leerDoubleEnRango(sc, "Ingresa la segunda calificacion: ", 0, 100);
        double calificacion_3=leerDoubleEnRango(sc, "Ingresa la tercera calificacion: ", 0, 100);
        int asistencia = leerIntEnRango(sc, "Ingresa cuanto tienes de asistencia (0-100)", 0, 100);
        boolean proyecto = leerBoolean(sc, "Dime si entregaste el proyecto (true - false): ");

        double promedio = gradeService.calcularPromedio(calificacion_1, calificacion_2, calificacion_3);
        double promedioFinal = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(promedioFinal, asistencia, proyecto);


        boleta1(nombre, calificacion_1, calificacion_2, calificacion_3, asistencia, proyecto, promedio, promedioFinal, estado);
    }

    //Input
    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String nombre = "";
        while (true) {
            System.out.println(msg);
            nombre = sc.nextLine();
            if (!nombre.isEmpty()) {
                return nombre;
            }
            System.out.println("Tienes que decir tu nombre");
        }
    }
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double nota1=0;
        while (true){
            System.out.println(msg);
            if(sc.hasNextDouble()){
                nota1=sc.nextDouble();
                if(nota1<=100 && nota1>=0){
                    return nota1;
                }
                System.out.println("El dato esta fuera del rango de "+min+ " a "+max);
            }else{
                System.out.println("El dato no es numerico");
                sc.next();
            }
        }
    }
    public static int leerIntEnRango(Scanner sc, String msg, int min, int max){
        int asistencia=0;
        while (true){
            System.out.println(msg);
            if(sc.hasNextInt()){
                asistencia=sc.nextInt();
                if(asistencia<=100 && asistencia>=0){
                    return asistencia;
                }
                System.out.println("El dato esta fuera del rango de "+min+ " a "+max);
            }else{
                System.out.println("El dato no es numerico");
                sc.next();
            }
        }
    }
    public static boolean leerBoolean(Scanner sc, String msg){
        System.out.println(msg);
        while (true){
            if(sc.hasNextBoolean()){
                return sc.nextBoolean();
            }else{
                System.out.println("El valor ingresado no es bool ");
                sc.next();
            }
        }
    }
    //Output
    public static void boleta1(String nombre, double calificacion_1, double calificacion_2, double calificacion_3, int asistencia, boolean proyecto, double promedio, double promedioFinal, String estado){
        System.out.println("Tu nombre es: "+nombre);
        System.out.println("Parcial 1: "+calificacion_1);
        System.out.println("Parcial 2: "+calificacion_2);
        System.out.println("Parcial 3: "+calificacion_3);
        System.out.println("Asistencia es: "+asistencia);
        System.out.println("Entrego proyecto: "+proyecto);
        System.out.println("Promedio: "+promedio);
        System.out.println("Promedio final: "+promedioFinal);
        System.out.println("Estado: "+estado);
    }
}
