package com.thoughtworks.academy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Publisher {
    protected int defense;

    private String name;
    private int blood;
    private int attack;
    private FireStateAttack stateAttack;

    public Player(String name, int blood, int attack) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
    }

    public Player(String name) {
        this(name, 100, 10);
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public int getAttack() {
        return attack;
    }

    public String getCareer() {
        return "普通人";
    }

    public int getDefense() {
        return 0;
    }

    public Weapon getWeapon() {
        return null;
    }

    public void beenAttack(int hurtValue) {
        blood -= hurtValue;

        Map<String, String> info = new HashMap<String, String>();

        info.put("name", name);
        info.put("blood", "" + blood);
        notifyListeners(new GameMessage("updateBlood", info));

        if(blood <= 0) {
            notifyListeners(new GameMessage("die", info));
        }
    }

    public void setDefense(int value) {
        this.defense = value;
    }


    public void releaseStateAttack() {
        if(null == stateAttack) return;

        stateAttack.actOnReceiver(this);
    }

    public List<IAttack> getAttackList() {
        List<IAttack> result = new ArrayList<IAttack>();
        result.add(new PhysicalAttack(attack));
        return result;
    }

    public void addStateAttack(FireStateAttack stateAttack) {
        if(null == this.stateAttack) {
            this.stateAttack = stateAttack;
        } else {
            this.stateAttack = (FireStateAttack)this.stateAttack.update(stateAttack);
        }
    }
}
