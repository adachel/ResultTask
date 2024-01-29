package ResultTaskApp.Animals;

public abstract class Pets extends Animal {
    public Pets(String name, String birthDate) {
        super(name, birthDate);
    }
    public Pets() {
    }


    abstract public String addCommand(String command);
}
