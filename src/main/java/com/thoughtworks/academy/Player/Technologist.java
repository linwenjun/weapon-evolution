package com.thoughtworks.academy.player;

import com.thoughtworks.academy.equipment.Weapon;

import java.util.Arrays;

public abstract class Technologist extends Player {
    protected int[] suitableWeaponSize;
    protected int[] bestWeaponSize;

    public Technologist(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public Technologist(String name) {
        super(name);
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
        if (0 > Arrays.binarySearch(this.suitableWeaponSize, weapon.getSize())) {
            throw(new RuntimeException("Unsuitable Weapon Size"));
        }
        this.weapon = weapon;
    }
}
