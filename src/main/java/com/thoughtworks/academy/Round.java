package com.thoughtworks.academy;

import com.thoughtworks.academy.equipment.FireDiamond;
import com.thoughtworks.academy.equipment.IDiamond;
import com.thoughtworks.academy.equipment.Weapon;
import com.thoughtworks.academy.handler.DiamondEffectHandler;
import com.thoughtworks.academy.handler.GameHandler;
import com.thoughtworks.academy.handler.PhysicalAttackHandler;
import com.thoughtworks.academy.handler.StateAttackHandler;

public class Round implements IListener {
    private Turn turn;
    private boolean isProcess = true;
    private Player p1;
    private Player p2;
    private int maxCount = 100;

    public Round(Player p1, Player p2) {

        this.p1 = p1;
        this.p2 = p2;

        DiamondEffectHandler diamondEffectHandler = new DiamondEffectHandler(null);
        GameHandler physicalAttackHandler = new PhysicalAttackHandler(diamondEffectHandler);
        GameHandler stateAttackHandler = new StateAttackHandler(physicalAttackHandler);

        this.turn = new Turn(stateAttackHandler);

        Publisher.getInstance().addListener(this);
    }

    public void start() {

        while (maxCount-- > 0) {
            if (!isProcess) {
                break;
            }

            turn.process(p1, p2);
            swap();
        }
    }

    private void swap() {
        Player temp = p1;
        p1 = p2;
        p2 = temp;
    }

    @Override
    public void update(GameMessage message) {
        if ("die" == message.getType()) {
            isProcess = false;
        }
    }

    public static void main(String[] args) {
        Soldier zhang = new Soldier("张三", 100, 12);
        Player li = new Player("李四", 90, 14);
        Weapon sword = new Weapon("金蛇剑", 10);
        IDiamond fireDiamond = new FireDiamond();

        sword.attachDiamond(fireDiamond);
        zhang.setWeapon(sword);

        Speaker speaker = new Speaker();
        Publisher.getInstance().addListener(speaker);

        Round round = new Round(zhang, li);
        round.start();
    }
}
