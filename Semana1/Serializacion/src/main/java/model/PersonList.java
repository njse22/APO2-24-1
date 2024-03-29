package model;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import exceptions.DuplicatePersonException;
import exceptions.PersonDoesNotExist;

public class PersonList {

    private ArrayList<Person> people;
    private File data; // Carpeta de datos
    private File listJson; // archivo con los datos
    private File listCsv;

    public PersonList() {
        people = new ArrayList<>();
        File projectDir = new File(System.getProperty("user.dir"));
        // linux -> /home/i2t/Workspace/
        // Win -> C:\Users\i2t\Workspace\

        // win -> data = new File(projectDir+"\\src\\main\\resources\\data\\");

        data = new File(projectDir+"/src/main/resources/data/");
        listJson = new File(data.getAbsolutePath()+"/people.json");
        listCsv = new File(data.getAbsolutePath()+"/people.csv");
    }

    private void createResources() throws IOException {
        if(!data.exists()) {
            data.mkdir();
            if (!listJson.exists()) {

                listJson.createNewFile();
            }
        }
    }

    public void cleanArray(){
        people.removeAll(people);
    }

    // Declarar que este método puede lanzar una exception
    public void addPersonToList(String name, int age, String id) throws DuplicatePersonException{
        Person p = new Person(name, age, id);
        Person found = searchPersonById(p.getId());
        if(found == null)
            people.add(p);
        else {
            // Lanzar la exception propia
            throw new DuplicatePersonException("La persona con este identificador: "+ id + " ya esta registrada");
        }

    }

    public Person searchPersonById(String id){
        Person found = null;
        for (int i = 0; i <people.size(); i++) {
            if(people.get(i).getId().equals(id)){
                found = people.get(i);
            }
        }

        // Exception mal planteada
        // if(found == null){
        //     throw new PersonDoesNotExist("Esta persona no existe en la lista");
        // }

        return found;
    }

    public void addPetToPerson(String name, int age, int idx){
        Pet pet = new Pet(name, age);
        people.get(idx).setPet(pet);
    }

    public void save() {


        // llamar a la librería que nos va ayudar a serializar la información
        Gson gson = new Gson();
        // formatear la información (JSON)
        String dataJson = gson.toJson(people);

        try {
            // Validar que los recursos existan
            createResources();

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

        } catch ( FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
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

            String line = "";
            String dataJson = "";

            while ( (line = reader.readLine()) != null ){
                dataJson += line;
            }
            reader.close();

            people = gson.fromJson(dataJson, people.getClass());

        } catch (FileNotFoundException e) {
            System.err.println("error 1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCsvFile(){

        // la cadena de texto con el formato que voy a guardar
        String dataCsv = "";

        // formatear la información que quiero guardar
        for (int i = 0; i < people.size(); i++) {
            dataCsv += people.get(i).getName() + "," + people.get(i).getAge()+ "," + people.get(i).getId() + "\n";
        }

        try {
            // Validar que los recursos existan
            createResources();

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
