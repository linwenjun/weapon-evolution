package com.thoughtworks.academy.player;

import com.thoughtworks.academy.equipment.Weapon;

public class Mortal extends Player {

    public Mortal(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public Mortal(String name) {
        super(name);
    }

    @Override
    public void setWeapon(Weapon weapon) {
        throw new RuntimeException("Ordinary Player C");
    }
}
