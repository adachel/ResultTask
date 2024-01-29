package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Dog extends Pets{

    public String addCommand(String command){
        return command;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + super.getName() + '\'' +
                ", birthdate='" + super.getBirthdate() + '\'' +
                '}';
    }
}
