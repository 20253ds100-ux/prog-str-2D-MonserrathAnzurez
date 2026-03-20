package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines();//Recupera las lineas del archivo
        List<String> result = new ArrayList<>();//El listado de resultado con el formato deseado
        for(String line : lines){
            if(line==null || line.isBlank()) continue; //Ignorar las lineas nulas

            String[] parts = line.split("," , -1);
            String name = parts[0].trim();//Obtiene el nombre del arreglo
            String correo = parts[1].trim();//Obtiene el correo del arreglo

            String edad = parts.length > 2 ? parts[2].trim() : "N/A";

            result.add(name+"-"+correo+ " - " + edad+ " años");//Se agrega a la lista de resultado con el formato deseado
        }
        return result;
    }

    public void addPerson(String name, String email, int edad) throws IOException {
        validatePerson(name, email, edad);
        String nameNoComa= name.replace(",", "");
        String emailNoComa= email.replace(",", "");
        repo.appendNewLine(nameNoComa+","+emailNoComa+ "," + edad);
    }

    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        List<String> lines = getAllCleanLines();
        if(index == -1){
            throw new IllegalArgumentException("El indice es invalido");
        }
        lines.set(index, name+","+email+","+edad);
        repo.appendAllLines(lines);
    }

    public void deletePerson(int index) throws IOException {
        List<String> lines = getAllCleanLines();
        lines.remove(index);
        repo.appendAllLines(lines);
    }

    private List<String> getAllCleanLines() throws IOException {
        List<String> lines=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : lines){
            if(line!=null && !line.isBlank()){
                cleanLines.add(line);
            }
        }return cleanLines;
    }

    private void validatePerson(String name, String email, int edad) {
        if (name==null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em=(email==null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || ! em.contains(".")){
            throw new IllegalArgumentException("El correo es invalido");
        }
        if (edad < 18){
            throw new IllegalArgumentException("Solo se aceptan mayores de edad");
        }
    }
}
