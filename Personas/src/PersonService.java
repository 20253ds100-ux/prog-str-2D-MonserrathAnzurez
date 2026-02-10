import java.util.Scanner;
public class PersonService {

    public void alta(Scanner sc, Persona[] personas){
        InputDataValidator inputDataValidator = new InputDataValidator();
        System.out.println("ingresa el Id");
        int id=inputDataValidator.getIntNumber(sc, "Ingresa el id del nuevo usuario");

        if (id<=0){
            System.out.println("No puede ser 0, ni menor a 0");
            return;
        }
        if(existeId(personas, id)){
            System.out.println("Ese id ya existe");
            return;
        }
        System.out.println("Ingresa el nombre");
        String name = sc.next();
        if(name.trim().isEmpty()){
            System.out.println("El nombre no puede estar vacio");
            return;
        }
        for (int i=0; i< personas.length; i++){
            if(personas[i]==null){
                personas [i] =new Persona(id, name);
                System.out.println("Persona dada de alta exitosamente");
                return;
            }
        }
    }

    public void buscarPorId(Persona[] personas, int id){
        for (Persona p : personas) {
            if (p !=null && p.getId()== id && p.isActiva()) {
                System.out.println("ID: "+ p.getId()+" Nombre: "+p.getNombre());
                return;
            }
        }
        System.out.println("No encontrada o inactiva");
    }
    public void bajaLogica(Persona[] personas, int id){
        for(Persona p : personas){
            if(p!=null && p.getId() == id && p.isActiva()){
                p.setActiva(false);
                System.out.println("Persona dada de baja");
                return;
            }
            System.out.println("No encontrada o ya inactiva");
        }
    }
    public void listarActivas(Persona[] personas){
        for(Persona p : personas){
            if (p!=null && p.isActiva()){
                System.out.println("ID: "+p.getId()+" Nombre: "+p.getNombre());
            }
        }
    }
    public void actualizarNombre(Scanner sc, Persona[] personas, int id){
        for (Persona p : personas) {
            if (p !=null && p.getId()==id && p.isActiva()) {
                System.out.println("Nuevo nombre:");
                String nuevoNombre = sc.next();
                if (!nuevoNombre.trim().isEmpty()) {
                    p.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado");
                }
                return;
            }
        }
        System.out.println("No encontrada o inactiva");
    }


    private static boolean existeId(Persona [] personas, int id){
        for (Persona persona : personas){
            if(persona!=null && persona.getId()==id) {
                return true;
            }
        }
        return false;
    }
}
