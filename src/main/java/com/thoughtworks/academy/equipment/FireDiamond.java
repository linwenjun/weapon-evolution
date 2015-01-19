package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.additionalAttackState.FireAttackAdditionalState;

public class FireDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.addStateAttack(new FireAttackAdditionalState());
    }

    @Override
    public String getType() {
        return "Fire";
    }
}
