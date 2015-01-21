package com.thoughtworks.academy.additionalAttackState;

import com.thoughtworks.academy.player.Player;

public abstract class AdditionalAttackState {

    public abstract String getType();

    protected abstract AdditionalAttackState update(AdditionalAttackState additionalAttackState);

    public AdditionalAttackState turn(AdditionalAttackState newAttackState) {
        if (null != newAttackState && newAttackState.getType() != getType()) {
            return newAttackState;
        } else {
            return update(newAttackState);
        }
    }

    public abstract void actOnReceiver(Player player);
}
