package com.thoughtworks.academy.player;

import com.thoughtworks.academy.equipment.Weapon;

public class OrdinaryPlayer extends Player {

    public OrdinaryPlayer(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public OrdinaryPlayer(String name) {
        super(name);
    }

    @Override
    public void setWeapon(Weapon weapon) {
        throw new RuntimeException("Ordinary Player C");
    }
}
