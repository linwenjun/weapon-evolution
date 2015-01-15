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
        }
    }
}
