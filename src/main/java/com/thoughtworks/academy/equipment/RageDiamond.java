package com.thoughtworks.academy.equipment;

public class RageDiamond extends AbstractDiamond {

    @Override
    protected void actOnProvider() {
        provider.consumeEnergy();
    }

    @Override
    protected void actOnReceiver() {
        int hurtValue = 3 * (provider.getAttack() - receiver.getDefense());
        receiver.beenAttack(hurtValue);
    }
}
