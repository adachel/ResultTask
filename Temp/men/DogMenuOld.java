package ResultTask.Menu;

import ResultTask.Animals.Pets.Dog;
import ResultTask.Database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DogMenu extends AnimalMenu{


    Database database = new Database();
    public void runDogMemu(){
        boolean temp = true;
        while (temp) {

            System.out.println( "1 - добавить собаку, 2 - добавить команду, 0 - выход");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> {
                    System.out.println("Введите имя животного:");
                    String name = input();
                    System.out.println("Введите дату рождения животного:");
                    String birthDate = input();
                    System.out.println("Введите команды через пробел");
                    String command = input();


                    Dog dog = new Dog(name, birthDate);
                    String commands = String.valueOf(dog.commands(command));

                    List<String> list = new ArrayList<>();
                    list.add("Dog");
                    list.add(dog.getNameAnimal());
                    list.add(dog.getBirthDate());
                    list.add(commands);
                    database.addDatabase(list);
                }
                case "2" -> {
                    System.out.println("Введите имя животного:");
                    String name = input();
                    System.out.println("Введите новую команду:");
                    String newCommand = input();
                    Dog dog = new Dog(name);
                    dog.commands(newCommand);



                }


                default -> {
                    System.out.println("Введите корректный выбор");
                }
            }
        }
    }
    private String input() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
