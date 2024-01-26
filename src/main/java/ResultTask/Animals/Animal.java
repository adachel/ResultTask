package ResultTask.Animals;

public abstract class Animal {
    protected String nameAnimal;
    protected String birthDate;

    public Animal(String nameAnimal, String birthDate) {
        this.nameAnimal = nameAnimal;
        this.birthDate = birthDate;
    }

    public Animal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
