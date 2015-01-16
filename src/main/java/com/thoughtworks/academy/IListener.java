package com.thoughtworks.academy;

import java.io.UnsupportedEncodingException;

public interface IListener {
    void update(GameMessage someThing) throws UnsupportedEncodingException;
}
