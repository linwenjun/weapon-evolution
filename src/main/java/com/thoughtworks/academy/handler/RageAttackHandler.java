package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.equipment.IDiamond;
import com.thoughtworks.academy.equipment.Weapon;

public class RageAttackHandler  extends GameHandler{

    public RageAttackHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(OrdinaryPlayer provider, OrdinaryPlayer receiver) {
        if (provider.isExhausted() || receiver.isDead()) return;

        Weapon weapon = provider.getWeapon();

        if(null == weapon) return;

        IDiamond diamond = weapon.getEffectiveDiamond();

        if(null == diamond || "Rage" != diamond.getType()) return;

        diamond.actOnPlayers(provider, receiver);
    }
}
