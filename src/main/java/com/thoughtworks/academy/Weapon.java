package com.thoughtworks.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {

    private String name;
    private PhysicalAttack attack;
    private IAttack extraAttack;
    private double fireExtraAttackRate = 0.25;

    public Weapon(String name) {
        new Weapon(name, 10);
    }

    public Weapon(String name, int attackVal) {
        this.name = name;
        this.attack = new PhysicalAttack(attackVal);
    }

    public String getName() {
        return name;
    }

    public List<IAttack> getAttackList() {
        Random random = new Random();
        List<IAttack> result = new ArrayList<IAttack>();
        result.add(attack);
        if(null != extraAttack && random.nextDouble() < fireExtraAttackRate) {
            result.add(extraAttack);
        }
        return result;
    }

    public void addExtraAttack(IAttack attack) {
        this.extraAttack = attack;
    }
}
