package com.thoughtworks.academy;

import com.thoughtworks.academy.equipment.Weapon;

public class Soldier extends Player {
    private Weapon weapon;

    public Soldier(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public Soldier(String name) {
        super(name);
    }

    @Override
    public String getCareer() {
        return "战士";
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
