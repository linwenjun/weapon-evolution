package com.thoughtworks.academy.player;

public abstract class ProfessionalPlayer extends Player {
    public ProfessionalPlayer(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public ProfessionalPlayer(String name) {
        super(name);
    }
}
