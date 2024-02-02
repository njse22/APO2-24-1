package model;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;

public class PersonList {

    private ArrayList<Person> people;
    private File data; // Carpeta de datos
    private File listJson; // archivo con los datos

    public PersonList() {
        people = new ArrayList<>();
        File projectDir = new File(System.getProperty("user.dir"));
        data = new File(projectDir+"/src/main/resources/data/");
        listJson = new File(data.getAbsolutePath()+"/people.json");
    }

    private void createResources(){
        if(!data.exists()) {
            data.mkdir();
            if (!listJson.exists()) {
                try {

                    listJson.createNewFile();

                } catch (IOException e) {

                    System.err.println("error");
                }
            }
        }
    }

    public void addPersonToList(String name, int age, String id){
        Person p = new Person(name, age, id);
        people.add(p);
    }

    public void addPetToPerson(String name, int age, int idx){
        Pet pet = new Pet(name, age);
        people.get(idx).setPet(pet);
    }

    public void save() {

        // Validar que los recursos existan
        createResources();

        // llamar a la librería que nos va ayudar a serializar la información
        Gson gson = new Gson();
        // formatear la información (JSON)
        String dataJson = gson.toJson(people);

        try {
            // File: data --> Donde se almacena la información
            // FileOutputStream: fos --> Enlazador de la información
            FileOutputStream fos = new FileOutputStream(this.listJson);
            // BufferWriter: writer --> Escritor de la información
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            // Tomar la información y escribirla en el recurso
            writer.write(dataJson);

            // Limpiar la información que esta almacenada en el escritor
            writer.flush();

            // cerrar el flujo de información
            writer.close();

        } catch (FileNotFoundException e) {
            System.err.println("error 1");
        } catch (IOException e){
            System.err.println("error 2");
        }

        System.out.println(data);

    }

}
