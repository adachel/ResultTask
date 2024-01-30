package ResultTaskApp.Menu;

import ResultTaskApp.Animals.*;
import ResultTaskApp.Controller;

import java.util.List;
import java.util.Scanner;

public class MainlMenu {
    Controller controller = new Controller();
    public void runMenu(){
        boolean temp = true;
        while (temp) {
            System.out.println();
            System.out.println( "1 - Добавить животное");
            System.out.println( "2 - Добавить команду");
            System.out.println( "3 - Список по дате рождения");
            System.out.println( "4 - Количество домашних животных");
            System.out.println( "5 - Количество вьючных животных");
            System.out.println( "7 - Просмотр реестра");
            System.out.println();
            System.out.println( "8 - Сохранить реестр в файл");
            System.out.println( "9 - Просмотр файла реестра");
            System.out.println( "q - Выход");

            switch (input()) {
                case "q" -> temp = false;
                case "1" -> { addAnimal(); }
                case "2" -> { addCommands(); }
                case "3" -> { controller.sortDatabase(); }
                case "4" -> {
                    Pets pets = new Pets();
                    System.out.println("Домашних животных: " + pets.getCounter());
                }
                case "5" -> {
                    PackAnimals packAnimals = new PackAnimals();
                    System.out.println("Вьючных животных: " + packAnimals.getCounter());
                }
                case "6" -> {
                    Pets pets = new Pets();
                    PackAnimals packAnimals = new PackAnimals();
                    System.out.println("Всего животных: " + (pets.getCounter() + packAnimals.getCounter()));
                }
                case "7" -> { controller.viewDatabase(); }
                case "8" -> { controller.saveToFile(); }
                case "9" -> { controller.viewFileBase(); }
                default -> { System.out.println("Не корректный выбор! Выберите пункт меню."); }
            }
        }
    }
    private void addAnimal(){
        System.out.println("Введите имя животного:");
        String name = input();
        System.out.println("Введите дату рождения животного:");
        String birthDate = input();
        System.out.println("Введите команды, выполняемые животным");
        String command = input();

        typeAnimal(name, birthDate, command);
    }

    private void typeAnimal(String name, String birthDate, String command){
        System.out.println("Тип животного:");
        System.out.println("1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел");
        switch (input()) {
            case "1" -> {
                Dog dog = new Dog(name, birthDate);
                String commands = String.valueOf(dog.addCommand(command));
                controller.addAnimal("Dog", dog, commands);
            }
            case "2" -> {
                Cat cat = new Cat(name, birthDate);
                String commands = String.valueOf(cat.addCommand(command));
                controller.addAnimal("Cat", cat, commands);
            }
            case "3" -> {
                Hamster hamster = new Hamster(name, birthDate);
                String commands = String.valueOf(hamster.addCommand(command));
                controller.addAnimal("Hamster", hamster, commands);
            }
            case "4" -> {
                Horse horse = new Horse(name, birthDate);
                String commands = String.valueOf(horse.addCommand(command));
                controller.addAnimal("Horse", horse, commands);
            }
            case "5" -> {
                Camel camel = new Camel(name, birthDate);
                String commands = String.valueOf(camel.addCommand(command));
                controller.addAnimal("Camel", camel, commands);
            }
            case "6" -> {
                Donkey donkey = new Donkey(name, birthDate);
                String commands = String.valueOf(donkey.addCommand(command));
                controller.addAnimal("Donkey", donkey, commands);
            }

            default -> { System.out.println("Не корректный выбор! Выберите пункт меню."); }
        }
    }
    private void addCommands(){
        System.out.println("Выберите тип животного:");
        String type = "";
        System.out.println("1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел");
        switch (input()) {
            case "1" -> { type = "Dog"; }
            case "2" -> { type = "Cat"; }
            case "3" -> { type = "Hamster"; }
            case "4" -> { type = "Horse"; }
            case "5" -> { type = "Camel"; }
            case "6" -> { type = "Donkey"; }
            default -> { System.out.println("Не корректный выбор! Выберите пункт меню."); }
        }
        System.out.println("Введите имя животного:");
        String name = input();
        System.out.println("Новая команда");
        String newCommand = input();

        List<List<String>> animals = controller.base();
        controller.addCommands(type, animals, name, newCommand);
    }
    private String input() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
