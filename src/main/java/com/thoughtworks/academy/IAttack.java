package com.thoughtworks.academy;

import java.util.Map;

public interface IAttack {
    void appendTo(Map<String, IAttack> attackList);
    void actOnReceiver(Player receiver);
}
