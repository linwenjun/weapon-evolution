package com.thoughtworks.academy.additionalAttackState;

import com.thoughtworks.academy.Player;

public class BlankAttackState extends AdditionalAttackState {
    @Override
    public String getType() {
        return "blank";
    }

    @Override
    protected AdditionalAttackState update(AdditionalAttackState additionalAttackState) {
        return this;
    }

    @Override
    public void actOnReceiver(Player receiver) {}
}
