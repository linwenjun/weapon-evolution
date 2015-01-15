package com.thoughtworks.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FireStateAttack extends StateAttack {
    private int TURN_COUNT = 3;
    private int hurtValue = 5;
    private List<Integer> multipleList = new ArrayList<Integer>();

    public FireStateAttack() {
        for(int i=0; i< TURN_COUNT; i++) {
            multipleList.add(1);
        }
    }

    @Override
    public void appendTo(Map<String, IAttack> attackList) {
//        nothing to do
    }

    @Override
    public void actOnReceiver(Player receiver) {
        receiver.beenAttack(hurtValue * multipleList.get(0));

        multipleList.remove(0);
        if(multipleList.size() == 0) {
            receiver.addStateAttack(null);
        }
    }

    public StateAttack update(FireStateAttack fireStateAttack) {
        if(null == fireStateAttack) {
            return null;
        }

        List<Integer> result = new  ArrayList<Integer>();
        for(int i=0; i<multipleList.size(); i++) {
            result.add(multipleList.get(i) + 1);
        };

        for(int i=multipleList.size(); i<3; i++) {
            result.add(1);
        }

        multipleList = result;

        return this;
    }
}
