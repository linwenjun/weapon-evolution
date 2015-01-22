package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.player.Mortal;
import com.thoughtworks.academy.equipment.IDiamond;
import com.thoughtworks.academy.equipment.Weapon;
import com.thoughtworks.academy.player.Player;

public class DiamondEffectHandler extends GameHandler {

    public DiamondEffectHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(Player provider, Player receiver) {

        Weapon weapon = provider.getWeapon();

        if(null == weapon) return;

        IDiamond diamond = weapon.getEffectiveDiamond();

        if(null == diamond || "Rage" == diamond.getType()) return;

        diamond.actOnPlayers(provider, receiver);
    }
}
