package com.thoughtworks.academy;

import com.thoughtworks.academy.additionalAttackState.AdditionalAttackState;
import com.thoughtworks.academy.equipment.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Player {
    protected int defense;

    private String name;
    private int blood;
    private int attack;
    private AdditionalAttackState additionalAttackState;
    protected Weapon weapon;
    private boolean locked;
    private Boolean energy;

    public Player(String name, int blood, int attack) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
        locked = false;
        energy = true;
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
        if(null == additionalAttackState) return;

        additionalAttackState.actOnReceiver(this);
    }

    public void addStateAttack(AdditionalAttackState additionalAttackState) {

        if(null != additionalAttackState) {
            String type = additionalAttackState.getType();
            Map<String, String> info = new HashMap<String, String>();
            info.put("receiver", name);
            Publisher.getInstance().notifyListeners(new GameMessage("beenAttackBy" + type, info));
        }

        if(null == this.additionalAttackState) {
            this.additionalAttackState = additionalAttackState;
        } else if(null != additionalAttackState) {
            this.additionalAttackState = this.additionalAttackState.update(additionalAttackState);
        } else {
            this.additionalAttackState = null;
        }
    }

    public void setWeapon(Weapon weapon) {
        throw new RuntimeException();
    }

    public boolean isDead() {
        return blood <= 0;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public Boolean hasEnergy() {
        return energy;
    }

    public void consumeEnergy() {
        energy = false;
    }

    public void giveEnergy() {
        energy = true;
    }

    public Boolean isExhausted() {
        return (!energy || locked || blood <= 0);
    }

    public void restore() {
        energy = true;
        locked = false;
        if(null != weapon) {
            weapon.restore();
        }
    }
}
