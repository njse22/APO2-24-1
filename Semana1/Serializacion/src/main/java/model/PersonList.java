package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class PersonList {

    private ArrayList<Person> people;
    private File data;
    private File listJson;

    public PersonList() {
        people = new ArrayList<>();
        File projectDir = new File(System.getProperty("user.dir"));
        data = new File(projectDir+"/src/main/resources/data/");
        listJson = new File(data.getAbsolutePath()+"people.json");
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

    public void save(){

        createResources();

        Gson gson = new Gson();
        String data = gson.toJson(people);
        System.out.println(data);

    }

}
