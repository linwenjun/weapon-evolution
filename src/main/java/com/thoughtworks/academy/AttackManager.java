package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttackManager extends Publisher {
    private Map<String, IAttack> attackList = new HashMap<String, IAttack>();
    private GameMessage gameMessage;


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

    public void actOnReceiver(Player receiver) {

        for(String type : attackList.keySet()) {
            IAttack attack = attackList.get(type);
            attack.actOnReceiver(receiver);
        }

        attackList = new HashMap<String, IAttack>();
    }

    public void actOnPlayer(Player provider, Player receiver) {

        Map<String, String> info = new HashMap<String, String>();
        info.put("provider", provider.getName());
        info.put("receiver", receiver.getName());
        gameMessage = new GameMessage("attack", info);
        notifyListeners(gameMessage);

        this.actOnReceiver(receiver);
    }
}
