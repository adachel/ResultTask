package ResultTaskApp;

import ResultTaskApp.Animals.Animal;
import ResultTaskApp.Database.Database;

import java.util.List;

public class Controller {
    private final Database database = new Database();

    public List<List<String>> base(){
        return database.base();
    }
    public void addAnimal(String type, Animal animal, String commands){
        database.addBase(type, animal, commands);
    }

    public void addCommands(String type, List<List<String>> animals, String name, String newCommand){
        database.changeBase(type, animals, name, newCommand);
    }
    public void viewDatabase(){
        System.out.println();
        database.viewBase();
        System.out.println();
    }

    public void sortDatabase(){
        database.sortBase();
    }

    public void saveToFile(){
        database.saveFileBase();
    }



}
