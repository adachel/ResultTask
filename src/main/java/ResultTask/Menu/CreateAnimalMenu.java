package ResultTask.Menu;

import ResultTask.Menu.PackAnimalsMenu.CreateCamelMenu;
import ResultTask.Menu.PackAnimalsMenu.CreateDonkeyMenu;
import ResultTask.Menu.PackAnimalsMenu.CreateHorseMenu;
import ResultTask.Menu.PetsMenu.CreateCatMenu;
import ResultTask.Menu.PetsMenu.CreateDogMenu;
import ResultTask.Menu.PetsMenu.CreateHamsterMenu;

import java.util.Scanner;
public class CreateAnimalMenu extends GenMenu{
//    Logs logs = new Logs();
//    private Controller controller = new Controller();

    public void runAnumalMemu() {
        boolean temp = true;
        while (temp) {
            System.out.println("Выберите тип животного:");
            System.out.println();
            System.out.println( "1 - собаки, 2 - кошки, 3 - хомяки, 4 - лошади, 5 - верблюды, 6 - ослы, " +
                                "0 - выход в главное меню");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> {
                    CreateDogMenu createDogMenu = new CreateDogMenu();
//                    logs.addMessage("Создать животное");
                    createDogMenu.createDog();
                }
                case "2" -> {
                    CreateCatMenu createCatMenu = new CreateCatMenu();
//                    logs.addMessage("Создать животное");
                    createCatMenu.createCat();
                }
                case "3" -> {
                    CreateHamsterMenu createHamsterMenu = new CreateHamsterMenu();
//                    logs.addMessage("Создать животное");
                    createHamsterMenu.createHamster();
                }
                case "4" -> {
                    CreateHorseMenu createHorseMenu = new CreateHorseMenu();
//                    logs.addMessage("Создать животное");
                    createHorseMenu.createHorse();
                }
                case "5" -> {
                    CreateCamelMenu createCamelMenu = new CreateCamelMenu();
//                    logs.addMessage("Создать животное");
                    createCamelMenu.createCamel();
                }
                case "6" -> {
                    CreateDonkeyMenu createDonkeyMenu = new CreateDonkeyMenu();
//                    logs.addMessage("Создать животное");
                    createDonkeyMenu.createDonkey();
                }
//                case "9" -> {
//                    GenMenu genMenu = new GenMenu();
//                    genMenu.runGenMenu();
//                    logs.addMessage("Создать животное");
//                }

                default -> {
                    System.out.println("Введите корректный выбор");
//                    logs.addMessage("Не корректный выбор");
                }
            }
        }
    }
    private String input() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
