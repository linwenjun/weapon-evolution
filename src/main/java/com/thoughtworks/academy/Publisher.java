package com.thoughtworks.academy;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<IListener> listeners = new ArrayList<IListener>();

    private static Publisher instance;

    private Publisher() {};

    public void addListener(IListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(GameMessage message) {
        for(IListener listener : listeners) {
            try {
                listener.update(message);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }


    public static Publisher getInstance() {
        if(null == instance) {
            instance = new Publisher();
        }
        return instance;
    }

    public void removeAll() {
        listeners.removeAll(listeners);
    }
}
