package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.equipment.IAttack;

public abstract class StateAttack implements IAttack {
    protected String type;

    public String getType() {
        return type;
    }

    public abstract StateAttack update(StateAttack stateAttack);
}
