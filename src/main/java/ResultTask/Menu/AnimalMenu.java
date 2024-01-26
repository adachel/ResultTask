package ResultTask.Menu;

import java.util.Scanner;
public class AnimalMenu extends GenMenu{

    public void runAnumalMemu(){
        boolean temp = true;
        while (temp) {

            System.out.println("Выберите тип животного:");
            System.out.println();
            System.out.println( "1 - собаки, 2 - кошки, 3 - хомяки, 4 - лошади, 5 - верблюды, 6 - ослы, " +
                                "0 - выход в главное меню");

            switch (input()) {
                case "0" -> temp = false;
                case "1" -> {
                    DogMenu dogMenu = new DogMenu();
                    dogMenu.runDogMemu();
                }
                case "2" -> {

                }
                case "3" -> {

                }
                case "4" -> {

                }
                case "5" -> {

                }
                case "6" -> {

                }

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
