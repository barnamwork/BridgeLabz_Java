package inheritance;

public class Animal {
    String name;
    int age;
    void makeSound(){
        System.out.println("Mai bohut baara jaanwar hu");
        System.out.println("My name is "+ name + " and my age is "+ age);
    }
}
class Dog extends Animal{

    @Override
    void makeSound(){
        System.out.println("Bow bow");
        System.out.println("My name is "+ name + " and my age is "+ age);
    }
}
class Cat extends Animal{

    @Override
    void makeSound(){
        System.out.println("Meow Meow");
        System.out.println("My name is "+ name + " and my age is "+ age);
    }
}
class Bird extends Animal{

    @Override
    void makeSound(){
        System.out.println("ku ku ");
        System.out.println("My name is "+ name + " and my age is "+ age);
    }
}
class Main{
    static void main() {
        Animal a = new Animal();
        Dog d = new Dog();
        Cat c = new Cat();
        Bird b = new Bird();
        a.name = "janwar";
        b.name="cock";
        c.name="pussy";
        d.name="kutte";

        b.age=1;
        c.age=5;
        d.age=10;
        a.makeSound();
        b.makeSound();
        c.makeSound();
        d.makeSound();
    }
}