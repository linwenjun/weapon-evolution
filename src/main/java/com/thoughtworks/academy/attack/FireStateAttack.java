package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.Publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FireStateAttack extends StateAttack {
    private int TURN_COUNT = 3;
    private int hurtValue = 5;
    private List<Integer> multipleList = new ArrayList<Integer>();
    protected String type = "fire";

    public FireStateAttack() {
        for(int i=0; i< TURN_COUNT; i++) {
            multipleList.add(1);
        }
    }

    @Override
    public void actOnReceiver(Player receiver) {
        int hurtVal = hurtValue * multipleList.get(0);
        receiver.beenAttack(hurtVal);

        Map<String, String> info = new HashMap<String, String>();
        info.put("receiver", receiver.getName());
        info.put("hurt", hurtVal + "");

        GameMessage gameMessage = new GameMessage("attackWithFire", info);
        Publisher.getInstance().notifyListeners(gameMessage);

        multipleList.remove(0);
        if(multipleList.size() == 0) {
            receiver.addStateAttack(null);
        }
    }

    public StateAttack update(FireStateAttack fireStateAttack) {

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

    public String getType() {
        return "fire";
    }
}
