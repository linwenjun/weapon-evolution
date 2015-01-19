package com.thoughtworks.academy.additionalAttackState;

import com.thoughtworks.academy.equipment.IAttack;

public abstract class AdditionalAttackState implements IAttack {

    public abstract String getType();
    public abstract AdditionalAttackState update(AdditionalAttackState additionalAttackState);
}
