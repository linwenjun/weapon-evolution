package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.equipment.IAttack;

public abstract class StateAttack implements IAttack {
    protected String type;

    public String getType() {
        return type;
    }

    public StateAttack update(StateAttack stateAttack) {
        return stateAttack;
    }
}
