package model;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;

public class PersonList {

    private ArrayList<Person> people;
    private File data; // Carpeta de datos
    private File listJson; // archivo con los datos
    private File listCsv;

    public PersonList() {
        people = new ArrayList<>();
        File projectDir = new File(System.getProperty("user.dir"));
        data = new File(projectDir+"/src/main/resources/data/");
        listJson = new File(data.getAbsolutePath()+"/people.json");
        listCsv = new File(data.getAbsolutePath()+"/people.csv");
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

    public void cleanArray(){
        people.removeAll(people);
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
    }

    public void load() {

        // llamar a la librería que nos va ayudar a serializar la información
        Gson gson = new Gson();

        try {
            // File: data --> Donde se almacena la información
            // FileOutputStream: fos --> Enlazador de la información
            FileInputStream fis = new FileInputStream(this.listJson);
            // BufferWriter: writer --> Escritor de la información
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));


        } catch (FileNotFoundException e) {
            System.err.println("error 1");
        } catch (IOException e){
            System.err.println("error 2");
        }
    }

    public void saveCsvFile(){
        // Validar que los recursos existan
        createResources();

        // la cadena de texto con el formato que voy a guardar
        String dataCsv = "";

        // formatear la información que quiero guardar
        for (int i = 0; i < people.size(); i++) {
            dataCsv += people.get(i).getName() + "," + people.get(i).getAge()+ "," + people.get(i).getId() + "\n";
        }

        try {
            // File: data --> Donde se almacena la información
            // FileOutputStream: fos --> Enlazador de la información
            FileOutputStream fos = new FileOutputStream(this.listCsv);
            // BufferWriter: writer --> Escritor de la información
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            // Tomar la información y escribirla en el recurso
            writer.write(dataCsv);

            // Limpiar la información que esta almacenada en el escritor
            writer.flush();

            // cerrar el flujo de información
            writer.close();

        } catch (FileNotFoundException e) {
            System.err.println("error FileNotFoundException");
        } catch (IOException e){
            System.err.println("error IOException");
        }
    }

    public void loadCsvFile(){
        // la cadena de texto con el formato que voy a guardar
        String dataCsv = "";
        try {
            // File: data --> Donde se almacena la información
            // FileInputStream: fis --> Enlazador de la información
            FileInputStream fis = new FileInputStream(this.listCsv);
            // BufferReader: reader --> Lector de la información
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            // reader lee cada línea hasta llegar a null/fin del archivo
            // String line = reader.readLine();
            // String secondLine = reader.readLine();
            String line = "";

            while ( (line = reader.readLine()) != null ){
               dataCsv = line;
               String[] info = dataCsv.split(",");

               Person p = new Person(info[0], Integer.parseInt(info[1]), info[2]);
               people.add(p);
            }

        } catch (FileNotFoundException e) {
            System.err.println("error FileNotFoundException");
        } catch (IOException e){
            System.err.println("error IOException");
        }
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
