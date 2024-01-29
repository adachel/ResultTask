package ResultTaskApp;

import ResultTaskApp.Animals.Animal;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<List<String>> base = new ArrayList<>();
    public void addAnimal(String type, Animal animal, String commands){
        List<String> list = new ArrayList<>();
        list.add(type);
        list.add(animal.getName());
        list.add(animal.getBirthDate());
        list.add("commands: " + commands);
        base.add(list);
        System.out.println(base);
    }
    public void addCommand(String type, List<List<String>> animals, String name, String newCommand){
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
        System.out.println(animals);
    }
    public List<List<String>> animals(){
        return this.base;
    }
    public void sortAnimal(){
        for (int j = 0; j < base.size() - 1; j++) {
            for (int i = 0; i < base.size() - 1; i++) {
                String beforeStr = base.get(i).get(2);
                beforeStr = beforeStr.replace("-", "");
                String afterStr = base.get(i + 1).get(2);
                afterStr = afterStr.replace("-", "");
                if (Integer.parseInt(beforeStr) > Integer.parseInt(afterStr)){
                    List<String> temp = new ArrayList<>();
                    temp = base.get(i);
                    base.set(i, base.get(i + 1));
                    base.set(i + 1, temp);
                }
            }
        }
        System.out.println(base);
    }
}
