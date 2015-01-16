package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.Map;

public class Speaker implements IListener {

    @Override
    public void update(GameMessage message) {

            Map<String, String> templateMap = new HashMap<String, String>();
            templateMap.put("die", "{{name}}被打败了。\n");
            templateMap.put("updateBlood", "{{name}}剩余生命：{{blood}}\n");
            templateMap.put("attack", "{{provider}}攻击了{{receiver}},");
            templateMap.put("beenAttack", "{{name}}受到了{{hurt}}点伤害,");

            String type = message.getType();
            Map info = message.getInfo();

            String template = templateMap.get(type);
            String result = StringUtil.replace(template, info);

            System.out.print(result);
    }
}
