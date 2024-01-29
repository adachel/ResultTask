package ResultTaskApp.Menu;

import ResultTaskApp.Animals.Dog;
import ResultTaskApp.Controller;

import java.util.Scanner;

public class AnimalMenu{
    Controller controller = new Controller();
    public void runMenu(String name, String birthDate, String command){
//        boolean temp = true;
//        while (temp) {
            System.out.println("Тип животного:");
            System.out.println("1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел, 0 - Выход");
            switch (input()) {
//                case "0" -> temp = false;
                case "1" -> {
                    Dog dog = new Dog(name, birthDate);
                    String commands = String.valueOf(dog.addCommand(command));
                    controller.addAnimal("Dog", dog, commands);
                }
                case "2" -> {
                    controller.sortAnimal();
                }
                default -> {
                    System.out.println("Введите корректный выбор");
                }
            }
//        }
    }
    protected String input() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
