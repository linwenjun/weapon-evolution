package com.thoughtworks.academy;

import java.util.Map;

public class FireAttack implements IAttack{
    @Override
    public void appendTo(Map<String, IAttack> attackList) {
        attackList.put("state", this);
    }

    public void actOnReceiver(Player receiver) {
        receiver.addStateAttack(new FireStateAttack());
    }
}
