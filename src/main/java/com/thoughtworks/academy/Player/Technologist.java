package com.thoughtworks.academy.player;

public abstract class Technologist extends Player {
    public Technologist(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public Technologist(String name) {
        super(name);
    }
}
