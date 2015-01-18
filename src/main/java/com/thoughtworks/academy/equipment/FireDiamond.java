package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.attack.FireStateAttack;

public class FireDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.addStateAttack(new FireStateAttack());
    }
}
