package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttackManager {
    Map<String, IAttack> attackList = new HashMap<String, IAttack>();

    public void add(IAttack attack) {
        attack.appendTo(attackList);
    }

    public void add(List<IAttack> attackList) {
        for(IAttack attack : attackList) {
            this.add(attack);
        }
    }

    public Map<String,IAttack> getMap() {
        return attackList;
    }

    public void actOnProvider(Player provider) {
    }

    public void actOnReceiver(Player receiver) {
        for(String type : attackList.keySet()) {
            IAttack attack = attackList.get(type);
            attack.actOnReceiver(receiver);
        }

        attackList = new HashMap<String, IAttack>();
    }
}
