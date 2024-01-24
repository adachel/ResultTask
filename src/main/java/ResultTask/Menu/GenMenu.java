package ResultTask.Menu;

import ResultTask.Logs.Logs;

import java.util.Scanner;

public class GenMenu {
    Logs logs = new Logs();
    public void runGenMenu() {
        logs.cleanFileLog();
        boolean temp = true;
        while (temp) {
            System.out.println("Выберите: 1 - Создать животное, 2 - Просмотр лог-фaйлa, 0 - Выход");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> {
                    CreateAnimalMenu createAnimalMenu = new CreateAnimalMenu();
//                    logs.addMessage("Создать животное");
                    createAnimalMenu.runAnumalMemu();
                }
                case "2" -> {
                    logs.addMessage("Просмотр логов.");
//                    String logs = Files.readString(logs.creatMessage());
                    System.out.println(logs);
                }
                default -> {
                    System.out.println("Введите корректный выбор");
                    logs.addMessage("Не корректный выбор");
                }
            }
        }
    }
    private String input () {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
