package com.thoughtworks.academy.equipment;

public class Weapon {

    private final int attackValue;
    private String name;
    private IAttack extraAttack;

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

    public IAttack getExtraAttack() {
        return extraAttack;
    }
}
