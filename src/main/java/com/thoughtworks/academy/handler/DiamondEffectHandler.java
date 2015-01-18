package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.equipment.AbstractDiamond;
import com.thoughtworks.academy.equipment.Weapon;

public class DiamondEffectHandler extends GameHandler {

    public DiamondEffectHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(Player provider, Player receiver) {
        if (provider.isDead() || receiver.isDead() || provider.isLocked()) {
            return;
        }

        Weapon weapon = provider.getWeapon();

        if(null == weapon) {
            return;
        }

        AbstractDiamond diamond = weapon.getDiamond();

        if(null == diamond) {
            return;
        }

        diamond.actOnPlayers(provider, receiver);
    }
}
