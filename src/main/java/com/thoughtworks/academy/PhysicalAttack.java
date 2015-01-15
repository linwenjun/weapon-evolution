package com.thoughtworks.academy;

import java.util.Map;

public class PhysicalAttack implements IAttack {
    private int attack = 10;

    public PhysicalAttack() {}

    public PhysicalAttack(int attack) {
        this.attack = attack;
    }

    public void actOnReceiver(Player receiver) {
        int hurtValue = attack - receiver.getDefense();
        hurtValue = Math.max(0, hurtValue);
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
