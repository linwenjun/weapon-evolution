package com.thoughtworks.academy;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<IListener> listeners = new ArrayList<IListener>();

    public void addListener(IListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(GameMessage message) {
        for(IListener listener : listeners) {
            listener.update(message);
        }
    }
}
