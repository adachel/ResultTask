package ResultTaskApp.Animals;

public class Cat extends Pets{
    public Cat(String name, String birthDate) {
        super(name, birthDate);
    }
    public Cat() {
    }

    @Override
    public String addCommand(String command) {
        return command;
    }
}
