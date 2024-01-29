package ResultTaskApp.Animals;

public abstract class PackAnimals extends Animal {
    public PackAnimals(String name, String birthDate) {
        super(name, birthDate);
    }
    public PackAnimals() {
    }

    abstract public String addCommand(String command);
}
