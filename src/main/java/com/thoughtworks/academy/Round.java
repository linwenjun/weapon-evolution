package com.thoughtworks.academy;

import com.thoughtworks.academy.equipment.AbstractDiamond;
import com.thoughtworks.academy.equipment.FreezeDiamond;
import com.thoughtworks.academy.equipment.Weapon;
import com.thoughtworks.academy.handler.*;

public class Round implements IListener {
    private Turn turn;
    private boolean isProcess = true;
    private Player p1;
    private Player p2;
    private int maxCount = 100;

    public Round(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        GameHandler notifyReceiverBloodHandler = new NotifyReceiverBloodHandler(null);
        GameHandler diamondEffectHandler = new DiamondEffectHandler(notifyReceiverBloodHandler);
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
        Soldier chang = new Soldier("张三", 200, 12);
        Player lee = new Player("李四", 230, 14);
        Weapon sword = new Weapon("金蛇剑", 10);
        AbstractDiamond diamond = new FreezeDiamond();
//        IDiamond fireDiamond = new FireDiamond();

        sword.attachDiamond(diamond);
        chang.setWeapon(sword);

        Speaker speaker = new Speaker();
        Publisher.getInstance().addListener(speaker);

        Round round = new Round(chang, lee);
        round.start();
    }
}
