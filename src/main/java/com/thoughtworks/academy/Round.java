package com.thoughtworks.academy;

import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.player.Soldier;
import com.thoughtworks.academy.equipment.*;
import com.thoughtworks.academy.handler.*;

public class Round implements IListener {
    private Turn turn;
    private boolean isProcess = true;
    private OrdinaryPlayer p1;
    private OrdinaryPlayer p2;
    private int maxCount = 100;

    public Round(OrdinaryPlayer p1, OrdinaryPlayer p2) {
        this.p1 = p1;
        this.p2 = p2;

        GameHandler notifyReceiverBloodHandler = new NotifyReceiverBloodHandler(null);
        GameHandler diamondEffectHandler = new DiamondEffectHandler(notifyReceiverBloodHandler);
        GameHandler physicalAttackHandler = new PhysicalAttackHandler(diamondEffectHandler);
        GameHandler stateAttackHandler = new StateAttackHandler(physicalAttackHandler);
        GameHandler rageAttackHandler = new RageAttackHandler(stateAttackHandler);

        this.turn = new Turn(rageAttackHandler);

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
        OrdinaryPlayer temp = p1;
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
        OrdinaryPlayer lee = new OrdinaryPlayer("李四", 230, 14);
        Weapon sword = new Weapon("金蛇剑", 10);

        sword.attachDiamond(new RageDiamond());
        sword.attachDiamond(new FireDiamond());
        sword.attachDiamond(new FreezeDiamond());
        chang.setWeapon(sword);

        Speaker speaker = new Speaker();
        Publisher.getInstance().addListener(speaker);

        Round round = new Round(chang, lee);
        round.start();
    }
}
