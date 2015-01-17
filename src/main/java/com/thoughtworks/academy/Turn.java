package com.thoughtworks.academy;

public class Turn {
    private PhysicalAttackHandler physicalAttackHandler;

    public Turn(PhysicalAttackHandler physicalAttackHandler) {
        this.physicalAttackHandler = physicalAttackHandler;
    }

    public void process(Player provider, Player receiver) {
        provider.releaseStateAttack();

        physicalAttackHandler.add(provider.getAttackList());
        physicalAttackHandler.actOnPlayer(provider, receiver);
    }
}
