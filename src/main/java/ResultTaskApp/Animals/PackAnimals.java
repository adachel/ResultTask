package ResultTaskApp.Animals;

import ResultTaskApp.Animals.Animal;

public class PackAnimals extends Animal {
    private static int counter = 0;
    public PackAnimals(String name, String birthDate) {
        super(name, birthDate);
        counter ++;
    }
    public PackAnimals() {
    }

    public String addCommand(String command) {
        return null;
    }

    public int getCounter(){
        return counter;
    }
}
