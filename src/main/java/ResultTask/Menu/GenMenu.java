package ResultTask.Menu;

import ResultTask.Database.Database;

import java.util.Scanner;

public class GenMenu {

    public void runGenMenu(){

        Database database = new Database();

        boolean temp = true;
        while (temp) {
            System.out.println("Выберите: 1 - Создать животное, 2 - Просмотр реестра 0 - Выход");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> {
                    AnimalMenu createAnimalMenu = new AnimalMenu();
                    createAnimalMenu.runAnumalMemu();
                }
                case "2" -> {
                    database.readDatabase();
                }
                default -> {
                    System.out.println("Введите корректный выбор");

                }
            }
        }
    }
    private String input () {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
