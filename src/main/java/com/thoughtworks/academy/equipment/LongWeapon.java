package com.thoughtworks.academy.equipment;

public class LongWeapon extends Weapon{

    public LongWeapon(String name, int attackVal) {
        super(name, attackVal);
        size = LONG_SIZE;
    }
}
