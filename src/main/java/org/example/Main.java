package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Рекс");
        Cat cat = new Cat("Мурка");

        System.out.println(dog.makeSound());
        System.out.println(cat.makeSound());
    }
}
