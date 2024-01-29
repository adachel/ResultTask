package ResultTaskApp.Menu;

import ResultTaskApp.Animals.Dog;
import ResultTaskApp.Controller;

import java.util.List;
import java.util.Scanner;

public class MainlMenu {
    Controller controller = new Controller();


    public void runMenu(){
        boolean temp = true;
        while (temp) {
            System.out.println("Меню:");

            System.out.println("1 - Добавить животное, 2 - Добавить команду, 3 - Список по дате рождения, 0 - Выход");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> { addAnimal(); }
                case "2" -> { addCommands(); }
                case "3" -> { controller.sortAnimal(); }
                default -> {
                    System.out.println("Введите корректный выбор");
                }
            }
        }
    }
    protected String input() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void addAnimal(){
        System.out.println("Введите имя животного:");
        String name = input();
        System.out.println("Введите дату рождения животного:");
        String birthDate = input();
        System.out.println("Введите команды, выполняемые животным");
        String command = input();

        typeAnimal(name, birthDate, command);
    }

    public void typeAnimal(String name, String birthDate, String command){
        System.out.println("Тип животного:");
        System.out.println("1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел, 0 - Выход");
        switch (input()) {
            case "1" -> {
                Dog dog = new Dog(name, birthDate);
                String commands = String.valueOf(dog.addCommand(command));
                controller.addAnimal("Dog", dog, commands);
            }
            case "2" -> {
            }
            default -> { System.out.println("Введите корректный выбор"); }
        }
    }

    public void addCommands(){
        System.out.println("Выберите тип животного:");
        String type = "";
        System.out.println("1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел, 0 - Выход");
        switch (input()) {
            case "1" -> { type = "Dog"; }
            case "2" -> {
            }
            default -> { System.out.println("Введите корректный выбор"); }
        }
        System.out.println("Введите имя животного:");
        String name = input();
        System.out.println("Новая команда");
        String newCommand = input();

        List<List<String>> animals = controller.animals();
        controller.addCommand(type, animals, name, newCommand);
    }



}
