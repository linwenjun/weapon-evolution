package com.thoughtworks.academy;

public class Turn {
    private AttackManager attackManager;

    public Turn(AttackManager attackManager) {
        this.attackManager = attackManager;
    }

    public void process(Player provider, Player receiver) {
        provider.releaseStateAttack();

        attackManager.add(provider.getAttackList());
        attackManager.actOnPlayer(provider, receiver);
    }
}
