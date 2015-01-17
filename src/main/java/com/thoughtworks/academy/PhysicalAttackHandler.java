package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhysicalAttackHandler extends Publisher {
    private Map<String, IAttack> attackList = new HashMap<String, IAttack>();

    public PhysicalAttackHandler() {
        this.addListener(new Speaker());
    }

    public void add(IAttack attack) {
        attack.appendTo(attackList);
    }

    public void add(List<IAttack> attackList) {

        for (IAttack attack : attackList) {
            this.add(attack);
        }
    }

    public Map<String, IAttack> getMap() {
        return attackList;
    }

    public void actOnReceiver(Player receiver) {
        for (String type : attackList.keySet()) {
            IAttack attack = attackList.get(type);
            attack.actOnReceiver(receiver);
        }

        attackList = new HashMap<String, IAttack>();
    }

    public void actOnPlayer(Player provider, Player receiver) {

        Map<String, String> info = new HashMap<String, String>();
        info.put("provider", provider.getName());
        info.put("receiver", receiver.getName());
        info.put("providerCareer", provider.getCareer());
        info.put("receiverCareer", receiver.getCareer());
        GameMessage gameMessage;

        if (null != provider.getWeapon()) {
            info.put("weapon", provider.getWeapon().getName());
            gameMessage = new GameMessage("attackWithWeapon", info);
        } else {
            gameMessage = new GameMessage("attack", info);
        }

        notifyListeners(gameMessage);

        this.actOnReceiver(receiver);
    }

    public void actOnPlayers(Player provider, Player receiver) {
        int hurtValue = provider.getAttack();
        receiver.beenAttack(hurtValue);
    }
}
