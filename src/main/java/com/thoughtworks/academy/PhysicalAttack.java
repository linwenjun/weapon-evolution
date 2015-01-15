package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.Map;

public class PhysicalAttack extends Publisher implements IAttack {
    private int attack = 10;

    public PhysicalAttack() {
        addListener(new Speaker());
    }

    public PhysicalAttack(int attack) {
        this();
        this.attack = attack;
    }

    public void actOnReceiver(Player receiver) {
        int hurtValue = attack - receiver.getDefense();
        hurtValue = Math.max(0, hurtValue);

        Map<String, String> info = new HashMap<String, String>();
        info.put("name", receiver.getName());
        info.put("hurt", hurtValue + "");
        notifyListeners(new GameMessage("beenAttack", info));

        receiver.beenAttack(hurtValue);
    }

    @Override
    public void appendTo(Map<String, IAttack> attackList) {
        PhysicalAttack existAttack = (PhysicalAttack)attackList.get("physical");
        if(null == existAttack) {
            attackList.put("physical", this);
        } else {
            existAttack.setAttack(existAttack.getAttack() + this.getAttack());
        }
    }

    private void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }
}
