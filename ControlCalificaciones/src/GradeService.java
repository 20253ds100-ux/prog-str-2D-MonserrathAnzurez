import java.util.Scanner;
public class GradeService {
    public String leerStringNombre(Scanner sc, String msg){
        String nombre;
        System.out.println(msg);
        if(sc.hasNextLine()){
            nombre=sc.nextLine();
            if(nombre.isEmpty()){
               System.out.println("Tienes que decir tu nombre");
            }
        }
    }
}
