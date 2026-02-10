import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        PersonService personService = new PersonService();
        InputDataValidator inputDataValidator = new InputDataValidator();
        int opc;
        do{
            System.out.println("Menu");
            System.out.println("1)Para alta");
            System.out.println("2)buscar por ID");
            System.out.println("3)Para Baja logica por id");
            System.out.println("4)listar activas");
            System.out.println("5)nombre por id");
            System.out.println("0)Para salir");
            opc=sc.nextInt();
            if(opc==0){
                System.out.println("Salir"); //Puse el if, porque si le daba 0 se ejecutaba tambien el default y salia "opcion ivalida"
            }else{
                switch (opc){
                    case 1:
                        personService.alta(sc, personas);
                        break;
                    case 2:
                        personService.buscarPorId(personas, inputDataValidator.getIntNumber(sc, "ID a buscar"));
                        break;
                    case 3:
                        personService.bajaLogica(personas, inputDataValidator.getIntNumber(sc, "ID a dar de baja"));
                        break;
                    case 4:
                        personService.listarActivas(personas);
                        break;
                    case 5:
                        personService.actualizarNombre(sc, personas, inputDataValidator.getIntNumber(sc, "Dime que ID quieres actualizar: "));
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }

        }while (opc!=0);
    }
}