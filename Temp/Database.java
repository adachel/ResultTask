package org.example;

import java.util.*;

public class Database {
    List<List<String>> animals = new ArrayList<>();
    public void addAnimal(String type, Dog animal, String commands){
        List<String> list = new ArrayList<>();
        list.add(type);
        list.add(animal.getName());
        list.add(animal.getBirthdate());
        list.add("commands: " + commands);

        animals.add(list);
        System.out.println(animals);
    }
    public void addCommand(String name, String newCommand){
        boolean temp = true;
        for (List<String> animal : animals) {
            if (animal.get(1).equals(name)) {
                animal.set(3, animal.get(3) + ", " + newCommand);
                temp = true;
                break;
            } else temp = false;
        }
        if (!temp){System.out.println("Такого животного нет");}
        System.out.println(animals);
    }
    public void sortAnimal(){
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
        System.out.println(animals);
    }
    public void countAnimal(Dog animal){
        System.out.println("Всего животных в списке: " + animals.size());
    }
}
