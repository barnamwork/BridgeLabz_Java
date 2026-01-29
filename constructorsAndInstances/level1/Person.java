package Level1;

import java.util.Scanner;

// Person class using copy constructor with Scanner

class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter age: ");
        int a = sc.nextInt();

        Person p1 = new Person(n, a);
        Person p2 = new Person(p1);

        p1.display();
        p2.display();
    }
}

