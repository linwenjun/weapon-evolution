package com.thoughtworks.academy.equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {
    private static final double FIGHT_RATE = 0.25;
    private final int attackValue;
    private String name;
    private List<AbstractDiamond> diamonds = new ArrayList<AbstractDiamond>();
    private AbstractDiamond effectiveDiamond;
    private boolean isEffectiveDiamondCreated = false;

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
        diamonds.add(diamond);
    }

    public AbstractDiamond getDiamond() {
        return diamonds.get(0);
    }

    public AbstractDiamond getEffectiveDiamond() {
        if(isEffectiveDiamondCreated) {
            return effectiveDiamond;
        }

        Random random = new Random();
        AbstractDiamond result = null;

        for (AbstractDiamond diamond : diamonds) {
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
}
