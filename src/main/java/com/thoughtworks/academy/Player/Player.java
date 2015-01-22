package com.thoughtworks.academy.player;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.Publisher;
import com.thoughtworks.academy.additionalAttackState.AdditionalAttackState;
import com.thoughtworks.academy.additionalAttackState.BlankAttackState;
import com.thoughtworks.academy.equipment.Weapon;

import java.util.HashMap;
import java.util.Map;

public abstract class Player {
    protected final static String PLAYER = "普通人";
    protected final static String SOLDIER = "战士";
    protected final static String KNIGHT = "骑士";
    protected final static String ASSASSIN = "刺客";

    protected String name;
    protected int blood;
    protected int attack;
    protected int defense;
    protected boolean locked;
    protected boolean energy;
    protected Weapon weapon;

    private AdditionalAttackState additionalAttackState = new BlankAttackState();
    ;

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

    public void releaseStateAttack() {
        additionalAttackState.actOnReceiver(this);
    }

    public void attachAttackState(AdditionalAttackState newState) {

        String type = newState.getType();
        Map<String, String> info = new HashMap<String, String>();
        info.put("receiver", name);
        Publisher.getInstance().notifyListeners(new GameMessage("beenAttackBy" + type, info));

        additionalAttackState = additionalAttackState.turn(newState);
    }

    public AdditionalAttackState getAttackState() {
        return additionalAttackState;
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
        return PLAYER;
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

    public abstract void setWeapon(Weapon weapon);

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
        if (null != weapon) {
            weapon.restore();
        }
    }
}
