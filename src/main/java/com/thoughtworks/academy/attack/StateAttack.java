package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.equipment.IAttack;

public abstract class StateAttack implements IAttack {

    public abstract String getType();
    public abstract StateAttack update(StateAttack stateAttack);
}
