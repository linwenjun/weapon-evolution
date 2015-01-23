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
    }

    public void attack(Person defender) {
        defender.beenAttack(strength);

        String defenderName = defender.getName();
        System.out.print(name + "攻击了" + defenderName + "," +
                defenderName + "受到了" + 10 + "点伤害," +
                defenderName + "剩余生命：" + defender.getHealth()+ "\n");
    }

    public boolean isLive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
