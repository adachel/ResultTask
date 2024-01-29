package ResultTaskApp.Animals;

public abstract class Animal {
    private String name;
    private String birthDate;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    public Animal() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    abstract public String addCommand(String command);

}
