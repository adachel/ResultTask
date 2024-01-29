package org.example;

import java.util.Scanner;

public class MenuDog {
    public void menu() {

        Dog dog = new Dog();
        Database database = new Database();

        Boolean temp = true;
        while (temp) {
            System.out.println( "Выберите: 1 - Создать собаку, 2 - Добавить команду, 3 - сортировать по дате рождения, " +
                                "4 - количество собак, 0 - Выход");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> {
                    String type = "Dog";
                    System.out.println("Имя собаки");
                    String name = input();
                    System.out.println("Дата рождения собаки");
                    String birthdate = input();
                    System.out.println("Команды");
                    String commands = input();

                    dog.setName(name);
                    dog.setBirthdate(birthdate);

                    database.addAnimal(type, dog, commands);
                }
                case "2" -> {
                    System.out.println("Имя собаки");
                    String name = input();
                    System.out.println("Новая команда");
                    String newCommand = input();

                    database.addCommand(name, newCommand);
                }
                case "3" -> {database.sortAnimal();}
                case "4" -> {database.countAnimal(dog);}
                default -> {System.out.println("Введите корректный выбор");}
            }
        }
    }
    private String input () {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}