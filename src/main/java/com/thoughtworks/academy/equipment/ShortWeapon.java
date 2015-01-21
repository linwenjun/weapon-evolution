package com.thoughtworks.academy.equipment;

public class ShortWeapon extends Weapon{

    public ShortWeapon(String name, int attackVal) {
        super(name, attackVal);
        this.size = SHORT_SIZE;
    }
}
