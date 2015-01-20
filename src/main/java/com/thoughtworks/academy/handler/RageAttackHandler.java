package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.equipment.AbstractDiamond;
import com.thoughtworks.academy.equipment.Weapon;

public class RageAttackHandler  extends GameHandler{

    public RageAttackHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(Player provider, Player receiver) {
        if (provider.isExhausted() || receiver.isDead()) return;

        Weapon weapon = provider.getWeapon();

        if(null == weapon) return;

        AbstractDiamond diamond = weapon.getEffectiveDiamond();

        if(null == diamond || "Rage" != diamond.getType()) return;

        diamond.actOnPlayers(provider, receiver);
    }
}