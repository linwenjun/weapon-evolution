package com.thoughtworks.academy;

public class Person {

    private String name;
    private int health;
    private int strength;

    public Person(String name, int health, int strength) {

        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public void beenAttack(int hurtValue) {

        health -= hurtValue;

        if(health <=0 ) {
            System.out.print(name + "被打败了.\n");
        }
    }

    public void attack(Person defender) {

        defender.beenAttack(strength);
    }

    public boolean isDead() {
        return health <= 0;
    }
}
