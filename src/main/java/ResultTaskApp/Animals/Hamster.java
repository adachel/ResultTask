package ResultTaskApp.Animals;

public class Hamster extends Pets {
    public Hamster(String name, String birthDate) {
        super(name, birthDate);
    }

    public Hamster() {
    }

    @Override
    public String addCommand(String command) {
        return command;
    }
}
