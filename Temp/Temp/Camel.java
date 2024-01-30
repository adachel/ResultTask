package ResultTaskApp.Animals;

public class Camel extends PackAnimals{
    public Camel(String name, String birthDate) {
        super(name, birthDate);
    }

    public Camel() {
    }

    @Override
    public String addCommand(String command) {
        return command;
    }
}
