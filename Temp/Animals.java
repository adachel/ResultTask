package org.example;

public abstract class Animals {
    private String name;
    private String birthdate;

    public Animals(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public Animals() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    abstract public String addCommand(String command);

}
