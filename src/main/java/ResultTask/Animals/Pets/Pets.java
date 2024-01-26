package ResultTask.Animals.Pets;

import ResultTask.Animals.Animal;

public abstract class Pets extends Animal {
    public Pets(String nameAnimal, String birthDate) {
        super(nameAnimal, birthDate);
    }

    public Pets(String nameAnimal) {
        super(nameAnimal);
    }
}
