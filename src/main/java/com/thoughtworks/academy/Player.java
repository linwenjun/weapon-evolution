package com.thoughtworks.academy;

import com.thoughtworks.academy.attachment.FireStateAttack;

import java.util.HashMap;
import java.util.Map;

public class Player {
    protected int defense;

    private String name;
    private int blood;
    private int attack;
    private FireStateAttack stateAttack;
    private Weapon weapon;

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

        Publisher publisher = Publisher.getInstance();
        Map<String, String> info = new HashMap<String, String>();
        info.put("name", name);
        info.put("blood", "" + blood);
        publisher.notifyListeners(new GameMessage("updateBlood", info));

        if(blood <= 0) {
            publisher.notifyListeners(new GameMessage("die", info));
        }
    }

    public void setDefense(int value) {
        this.defense = value;
    }


    public void releaseStateAttack() {
        if(null == stateAttack) return;

        stateAttack.actOnReceiver(this);
    }

    public void addStateAttack(FireStateAttack stateAttack) {
        if(null == this.stateAttack) {
            this.stateAttack = stateAttack;
        } else {
            this.stateAttack = (FireStateAttack)this.stateAttack.update(stateAttack);
        }
    }

    public void setWeapon(Weapon weapon) {
        throw new RuntimeException();
    }
}
