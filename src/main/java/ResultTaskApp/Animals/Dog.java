package ResultTaskApp.Animals;

public class Dog extends Pets {
    public Dog(String name, String birthDate) {
        super(name, birthDate);
    }
    public Dog() {
    }


    @Override
    public String addCommand(String command) {
        return command;
    }
}
