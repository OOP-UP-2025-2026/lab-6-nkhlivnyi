package ua.opnu;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    String makeSound() {
        return getName() + " каже: Гав-гав!";
    }
}
