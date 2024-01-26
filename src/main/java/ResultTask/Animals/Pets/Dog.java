package ResultTask.Animals.Pets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dog extends Pets {

    public Dog(String nameAnimal, String birthDate) {
        super(nameAnimal, birthDate);
    }

    public Dog(String nameAnimal) {
        super(nameAnimal);
    }


    public List<String> commands(String command){
        List<String> commands = new ArrayList<>();
        commands.add(command);
        return commands;
    }

    public String addCommand(){
        System.out.println("Введите команды через пробел");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    @Override
    public String toString() {
        return "Cобакa: " + "Имя - " + super.nameAnimal + ", " + "Дата рождения: " + super.birthDate + "\n";
    }
}
