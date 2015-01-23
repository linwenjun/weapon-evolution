package com.thoughtworks.academy;

public class Game {
    private static Person p1;
    private static Person p2;

    public static void main(String[] args) {

        p1 = new Person("张三", 100, 13);
        p2 = new Person("李四", 100, 12);

        while (p1.isLive() && p2.isLive()) {
            p1.attack(p2);
            swap();
        }

        Person deadPerson = p1.isLive() ? p2 : p1;

        System.out.print(deadPerson.getName() + "被击败了。");
    }

    private static void swap() {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}
