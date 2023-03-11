package com.company;

abstract class Animal {
    public String name;
    public String type;
    public int food = 100;
    public String location;
    Animal(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public abstract void makeNoise();
    public abstract void eat();
    public void sleep() {
        System.out.println(name + " " + type + " спит.");
        this.food -= 30;
    }
}
class Dog extends Animal {
    String breed;
    Dog(String name, String location, String breed) {
        super(name, location);
        this.breed = breed;
        this.type = "Собака";
    }
    @Override
    public void makeNoise() {
        System.out.println(name + " гавкает.");
        this.food -= 20;
    }
    @Override
    public void eat() {
        if (food > 100) {
            this.food = 100;
            System.out.println(name + " сыт.");
        }
        else {
            System.out.println(name + " ест собачий корм.");
            this.food += 30;
        }
    }
}
class Cat extends Animal {
    String breed;

    Cat(String name, String location, String breed) {
        super(name, location);
        this.breed = breed;
        this.type = "Кошка";
    }
    @Override
    public void makeNoise() {
        System.out.println(name + " мяукает.");
        this.food -= 10;
    }
    @Override
    public void eat() {
        if (food > 100) {
            this.food = 100;
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " ест кошачий корм.");
            this.food += 30;
        }
    }
}

class Horse extends Animal {

    int speed;

    Horse(String name, String location, int speed) {
        super(name, location);
        this.speed = speed;
        this.type = "Лошадь";
    }

    @Override
    public void makeNoise() {
        System.out.println(name + " бегает");
        this.food -= 10;
    }

    @Override
    public void eat() {
        if (food > 100) {
            this.food = 100;
            System.out.println(name + " сыто и больше не хочет есть");
        } else {
            System.out.println(name + " ест овёс.");
            this.food += 20;
        }
    }
}
class Veterinar {
    String name;
    Veterinar(String name) {
        this.name = name;
    }
    void treatAnimal(Animal animal) {
        System.out.println(animal.name + " пришел на приём с сытостью" + " " + animal.food + ", которого привезли из " + animal.location);
    }
}
public class Main {
    public static void main(String[] args) {
        Dog pushok = new Dog("Пушок", "будка", "дворовый");
        Cat barsik = new Cat("Барсик", "дом","манчкин");
        Horse boni = new Horse("Бони", "конюшня", 100);
        pushok.makeNoise();
        barsik.makeNoise();
        boni.makeNoise();
        pushok.sleep();
        barsik.sleep();
        boni.sleep();
        pushok.eat();
        barsik.eat();
        boni.eat();
        Veterinar ivan = new Veterinar("Иван");
        ivan.treatAnimal(pushok);
    }
}