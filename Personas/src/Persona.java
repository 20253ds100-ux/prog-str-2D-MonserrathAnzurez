public class Persona {
    private int id;
    private String name;
    private boolean isActive;

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = true;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return name;
    }

    public boolean isActiva() {
        return isActive;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public void setActiva(boolean isActive) {
        this.isActive= isActive;
    }
}