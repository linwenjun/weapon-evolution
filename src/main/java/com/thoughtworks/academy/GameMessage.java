package com.thoughtworks.academy;

import java.util.Map;

public class GameMessage {
    private String type;
    private Map<String, String> info;

    public GameMessage(String type, Map<String, String> info) {
        this.type = type;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public Map<String, String> getInfo() {
        return info;
    }
}
