package com.thoughtworks.academy.equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {

    public static final int LONG_SIZE = 3;
    public static final int MEDIUM_SIZE = 2;
    public static final int SHORT_SIZE = 1;

    protected int size;

    private static final double FIGHT_RATE = 0.25;
    private final int attackValue;
    private String name;
    private List<IDiamond> diamonds = new ArrayList<IDiamond>();
    private IDiamond effectiveDiamond;
    private boolean isEffectiveDiamondCreated = false;

    public Weapon(String name, int attackVal) {
        this.name = name;
        this.attackValue = attackVal;
        size = MEDIUM_SIZE;
    }

    public String getName() {
        return name;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void attachDiamond(IDiamond diamond) {
        diamonds.add(diamond);
    }

    public IDiamond getEffectiveDiamond() {
        if(isEffectiveDiamondCreated) return effectiveDiamond;

        Random random = new Random();
        IDiamond result = null;

        for (IDiamond diamond : diamonds) {
            if (random.nextDouble() < FIGHT_RATE) {
                result = diamond;
                break;
            }
        }

        isEffectiveDiamondCreated = true;
        effectiveDiamond = result;
        return result;
    }

    public void restore() {
        isEffectiveDiamondCreated = false;
    }

    public int getSize() {
        return this.size;
    }
}
