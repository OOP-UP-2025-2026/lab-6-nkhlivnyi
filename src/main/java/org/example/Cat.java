package ua.opnu;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    String makeSound() {
        return getName() + " каже: Мяу!";
    }
}
