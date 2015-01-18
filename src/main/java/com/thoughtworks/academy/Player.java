package com.thoughtworks.academy;

import com.thoughtworks.academy.attack.StateAttack;
import com.thoughtworks.academy.equipment.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Player {
    protected int defense;

    private String name;
    private int blood;
    private int attack;
    private StateAttack stateAttack;
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
    }

    public void setDefense(int value) {
        this.defense = value;
    }


    public void releaseStateAttack() {
        if(null == stateAttack) return;

        stateAttack.actOnReceiver(this);
    }

    public void addStateAttack(StateAttack stateAttack) {

        if(null != stateAttack) {
            Map<String, String> info = new HashMap<String, String>();
            info.put("receiver", name);
            Publisher.getInstance().notifyListeners(new GameMessage("beenAttackByFire", info));
        }

        if(null == this.stateAttack) {
            this.stateAttack = stateAttack;
        } else {
            this.stateAttack = this.stateAttack.update(stateAttack);
        }
    }

    public StateAttack getStateAttack() {
        return stateAttack;
    }

    public void setWeapon(Weapon weapon) {
        throw new RuntimeException();
    }

    public boolean isLive() {
        return blood > 0;
    }

    public boolean isDead() {
        return blood <= 0;
    }
}
