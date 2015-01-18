package com.thoughtworks.academy;

import java.util.HashMap;
import java.util.Map;

public class Speaker implements IListener {

    @Override
    public void update(GameMessage message) {

            Map<String, String> templateMap = new HashMap<String, String>();
            templateMap.put("die", "{{name}}被打败了。\n");
            templateMap.put("updateBlood", "{{name}}剩余生命：{{blood}}\n");
            templateMap.put("attack", "{{providerCareer}}{{provider}}攻击了{{receiverCareer}}{{receiver}},");
            templateMap.put("attackWithWeapon", "{{providerCareer}}{{provider}}用{{weapon}}攻击了{{receiverCareer}}{{receiver}},");
            templateMap.put("beenAttack", "{{name}}受到了{{hurt}}点伤害,");
            templateMap.put("attackWithFire", "{{receiver}}受到{{hurt}}点火焰伤害,{{receiver}}剩余生命：{{blood}}\n");
            templateMap.put("beenAttackByFire", "{{receiver}}着火了,");

            String type = message.getType();
            Map info = message.getInfo();

            String template = templateMap.get(type);
            String result = StringUtil.replace(template, info);

            System.out.print(result);
    }
}
