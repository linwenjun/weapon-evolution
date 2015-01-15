package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.Map;

public class Turn extends Publisher{
    private AttackManager attackManager;

    public Turn(AttackManager attackManager) {
        this.attackManager = attackManager;
    }

    public void process(Player provider, Player receiver) {
        provider.releaseStateAttack();

        Map<String, String> info = new HashMap<String, String>();
        info.put("provider", provider.getName());
        info.put("receiver", receiver.getName());
        notifyListeners(new GameMessage("attack", info));

        attackManager.add(provider.getAttackList());
        attackManager.actOnProvider(provider);
        attackManager.actOnReceiver(receiver);
    }
}
