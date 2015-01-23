package com.thoughtworks.academy;

public class Game {

    public Game(Person p1, Person p2) {

        while (p1.isLive() && p2.isLive()) {
            p1.attack(p2);
            Person temp = p1;
            p1 = p2;
            p2 = temp;
        }

        Person deadPerson = p1.isLive() ? p2 : p1;

        System.out.print(deadPerson.getName() + "被击败了。");
    }

    public static void main(String[] args) {
        Person chang = new Person("张三", 100, 10);
        Person lee = new Person("李四", 100, 12);
        new Game(chang, lee);
    }
}
