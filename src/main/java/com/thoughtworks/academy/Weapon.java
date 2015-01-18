package com.thoughtworks.academy;

public class Weapon {

    private final int attackValue;
    private String name;
    private IAttack extraAttack;
    private double fireExtraAttackRate = 0.25;

    public Weapon(String name) {
        this(name, 10);
    }

    public Weapon(String name, int attackVal) {
        this.name = name;
        this.attackValue = attackVal;
    }

    public String getName() {
        return name;
    }

    public void addExtraAttack(IAttack attack) {
        this.extraAttack = attack;
    }

    public int getAttackValue() {
        return attackValue;
    }
}
