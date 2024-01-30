package ResultTaskApp.Database;

import ResultTaskApp.Animals.Animal;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<List<String>> animals = new ArrayList<>();
    private String FILE_PATH = "src/main/java/ResultTaskApp/Database/fileBase.txt";

    public Database(List<List<String>> animals, Path dir, Path file) {
        this.animals = animals;

    }
    public Database(List<List<String>> animals) {
        this.animals = animals;
    }
    public Database() {
    }

    public void addBase(String type, Animal animal, String commands){
        List<String> list = new ArrayList<>();
        list.add(type);
        list.add(animal.getName());
        list.add(animal.getBirthDate());
        list.add("commands: " + commands);
        animals.add(list);
    }
    public void changeBase(String type, List<List<String>> animals, String name, String newCommand){

        boolean temp = true;
        for (List<String> animal : animals) {
            if (animal.get(0).equals(type)) {
                if (animal.get(1).equals(name)) {
                    animal.set(3, animal.get(3) + ", " + newCommand);
                    temp = true;
                    break;
                } else temp = false;
            }
        }
        if (!temp){System.out.println("Такого животного нет");}
    }
    public void sortBase(){
        for (int j = 0; j < animals.size() - 1; j++) {
            for (int i = 0; i < animals.size() - 1; i++) {
                String beforeStr = animals.get(i).get(2);
                beforeStr = beforeStr.replace("-", "");
                String afterStr = animals.get(i + 1).get(2);
                afterStr = afterStr.replace("-", "");
                if (Integer.parseInt(beforeStr) > Integer.parseInt(afterStr)){
                    List<String> temp = new ArrayList<>();
                    temp = animals.get(i);
                    animals.set(i, animals.get(i + 1));
                    animals.set(i + 1, temp);
                }
            }
        }
    }
    public void viewBase(){
        for (List<String> animal : animals) {
            System.out.println();
            System.out.println(animal);
        }
    }
    public List<List<String>> base(){
         return animals;
    }

    public void saveFileBase(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (List<String> animal : animals) {
                writer.write(String.valueOf(animal));
                writer.newLine();
            }
            System.out.println("Данные сохранены.");
        } catch (IOException e) {
            System.out.println("Данные не сохранены: " + e.getMessage());
        }
    }
    public void viewFileBase(){
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println();
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Данные загружены успешно.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла с данными: " + e.getMessage());
        }
    }
}
