import java.util.Scanner;

public class AlumnosService {
    public static void alta(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa ID:");
        int id = sc.nextInt();
        if (id <= 0) {
            System.out.println("ID invalido");
            return;
        }if (existeId(alumnos, id)) {
            System.out.println("Ese ID ya existe");
            return;
        }System.out.println("Ingresa nombre:");
        sc.nextLine();
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Nombre invalido");
            return;
        }
        System.out.println("ingresa el promedio:");
        double promedio = sc.nextDouble();
        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio fuera de rango");
            return;
        }for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno agregado");
                return;
            }
        }
        System.out.println("Arreglo lleno");
    }
    public static boolean existeId(Alumno[] alumnos, int id) {
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public static void buscarPorId(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa ID:");
        int id = sc.nextInt();
        for (Alumno a : alumnos) {
            if (a != null&& a.getId()== id &&a.isActivo()) {
                System.out.println("Encontrado -> " + a.getNombre() + " Promedio: " + a.getPromedio());
                return;
            }
        }
        System.out.println("no encotrado o inactivo");
    }

    public static void actualizarPromedio(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa ID:");
        int id = sc.nextInt();

        for (Alumno a : alumnos) {
            if (a != null && a.getId()==id && a.isActivo()) {
                System.out.println("Nuevo promedio:");
                double nuevo = sc.nextDouble();
                if (nuevo < 0 || nuevo > 10) {
                    System.out.println("Promedio invalido");
                    return;
                }
                a.setPromedio(nuevo);
                System.out.println("promedio actualizado");
                return;
            }
        }
        System.out.println("Alumno no encontrado o inactivo");
    }
    public static void bajaLogica(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa ID:");
        int id = sc.nextInt();

        for (Alumno a : alumnos) {
            if (a != null && a.getId()==id && a.isActivo()) {
                a.setActivo(false);
                System.out.println("alumno dado de baja");
                return;
            }
        }
        System.out.println("Alumno no encontrado");
    }
    public static void listarActivos(Alumno[] alumnos) {
        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                System.out.println("ID:" + a.getId() + " nombre: " + a.getNombre() +" Promedio: " + a.getPromedio());
            }
        }
    }
    public static void reportes(Alumno[] alumnos) {
        double suma = 0;
        int contador = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int buenos = 0;
        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                suma += a.getPromedio();
                contador++;
                if (a.getPromedio() >= 8.0) {
                    buenos++;
                }if (mayor == null || a.getPromedio() > mayor.getPromedio()) {
                    mayor = a;
                }
                if (menor == null || a.getPromedio() < menor.getPromedio()) {
                    menor = a;
                }
            }}if (contador == 0) {
            System.out.println("no hay alumnos activos");
            return;
        }
        System.out.println("Promedio general: " + (suma / contador));
        System.out.println("Mayor promedio: "+mayor.getId()+" "+ mayor.getNombre()+" "+ mayor.getPromedio());
        System.out.println("Menor promedio: "+menor.getId()+" " + menor.getNombre()+" " + menor.getPromedio());
        System.out.println("Alumnos con promedio >= 8: " + buenos);
    }
}