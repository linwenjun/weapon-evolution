package com.thoughtworks.academy.equipment;

public class Weapon {

    private final int attackValue;
    private String name;
    private IAttack extraAttack;
    private AbstractDiamond diamond;

    public Weapon(String name, int attackVal) {
        this.name = name;
        this.attackValue = attackVal;
    }

    public String getName() {
        return name;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void attachDiamond(AbstractDiamond diamond) {
        this.diamond = diamond;
    }


    public AbstractDiamond getDiamond() {
        return diamond;
    }
}
