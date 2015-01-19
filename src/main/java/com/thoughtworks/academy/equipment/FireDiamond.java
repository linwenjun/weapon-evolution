package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.additionalAttackState.FireAttackState;

public class FireDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.addStateAttack(new FireAttackState());
    }

    @Override
    public String getType() {
        return "Fire";
    }
}
