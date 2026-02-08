import java.util.Scanner;
public class Calificaiones {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GradeService inputDataValidator = new GradeService();

        String nombre = inputDataValidator.leerStringNombre(sc, "Dime tu nombre: ");

                /*nombre del alumno (String) (no vacío)
3 calificaciones parciales (double) de 0 a 100
asistencia (int) de 0 a 100
entregaProyecto (boolean) true/false*/
    }
}
