package com.thoughtworks.academy.player;

import com.thoughtworks.academy.equipment.Weapon;

import java.util.Arrays;

public class Soldier extends ProfessionalPlayer {
    protected int[] suitableWeaponSize = new int[]{Weapon.MEDIUM_SIZE};
    protected int[] bestWeaponSize = new int[]{Weapon.MEDIUM_SIZE};

    public Soldier(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    @Override
    public String getCareer() {
        return SOLDIER;
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
        if (0 > Arrays.binarySearch(suitableWeaponSize, weapon.getSize())) {
            throw(new RuntimeException("Unsuitable Weapon Size"));
        }
        this.weapon = weapon;
    }
}
