package ResultTaskApp.Animals;

public class Donkey extends PackAnimals {
    public Donkey(String name, String birthDate) {
        super(name, birthDate);
    }

    public Donkey() {
    }

    @Override
    public String addCommand(String command) {
        return command;
    }
}
