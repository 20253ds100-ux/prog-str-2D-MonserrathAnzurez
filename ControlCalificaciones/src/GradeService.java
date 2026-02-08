import java.util.Scanner;
public class GradeService {
    public double calcularPromedio(double a, double b, double c) {
        double promedio=0;
        promedio=(a+b+c)/3;
        return promedio;
    }

    public double calcularFinal(double promedio, int asistencia){
        double promedioFinal=(promedio*0.7)+(asistencia *0.3);
        return promedioFinal;
    }

    public String determinarEstado(double promedioFinal, int asistencia, boolean entregoProyecto) {
        if(asistencia<80) {
            return "reprobado por asistencia";
        }if(!entregoProyecto) {
            return "Reprobado por proyecto";
        }if(promedioFinal>=70) {
            return "Aprobado";
        }else{
            return "Reprobado pro calificación";
        }
    }
}
