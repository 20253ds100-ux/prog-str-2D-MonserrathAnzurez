import java.util.Scanner;
public class InputDataValidator {

    public int getIntNumber(Scanner sc, String msg){
        int value;
        while(true) {
            System.out.println(msg);
            try {
                value=sc.nextInt();
                return value;
            } catch (Exception e) {
                System.out.println("Numero invalido");
                sc.next();
            }
        }
    }
}