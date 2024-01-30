package ResultTaskApp.Animals;

public class Horse extends PackAnimals{
    public Horse(String name, String birthDate) {
        super(name, birthDate);
    }

    public Horse() {
    }

    @Override
    public String addCommand(String command) {
        return command;
    }
}
