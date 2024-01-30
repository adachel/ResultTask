package ResultTaskApp.Animals;

public class Pets extends Animal {

    private static int counter = 0;
    public Pets(String name, String birthDate) {
        super(name, birthDate);
        counter ++;
    }
    public Pets() {
    }

    public String addCommand(String command) {
        return null;
    }

    public int getCounter(){
        return counter;
    }
}
