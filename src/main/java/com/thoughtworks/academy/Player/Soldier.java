package com.thoughtworks.academy.player;

import com.thoughtworks.academy.equipment.Weapon;

public class Soldier extends Technologist {

    public Soldier(String name, int blood, int attack) {
        super(name, blood, attack);
        suitableWeaponSize = new int[]{Weapon.MEDIUM_SIZE};
        bestWeaponSize = new int[]{Weapon.MEDIUM_SIZE};
    }

    @Override
    public String getCareer() {
        return SOLDIER;
    }
}
