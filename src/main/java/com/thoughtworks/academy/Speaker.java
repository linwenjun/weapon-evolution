package com.thoughtworks.academy;

import java.util.Map;

public class Speaker implements IListener {

    @Override
    public void update(GameMessage message) {

        String type = message.getType();
        Map info = message.getInfo();

        if("die" == type) {
            System.out.print(info.get("name") + "被打败了。\n");
        } else if("updateBlood" == type) {
            System.out.print(String.format("%s剩余生命：%s\n", info.get("name"), info.get("blood")));
        } else if("attack" == type) {
            System.out.print(String.format("%s攻击了%s,", info.get("provider"), info.get("receiver")));
        } else if("beenAttack" == type) {
            System.out.print(String.format("%s受到了%s点伤害,", info.get("name"), info.get("hurt")));
        }
    }
}
