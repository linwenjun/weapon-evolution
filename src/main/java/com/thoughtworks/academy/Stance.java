package com.thoughtworks.academy;

public class Stance {
    private static int count = 0;
    private int position;
    private int moveUnit;

    public Stance() {
        position = count % 2;
        moveUnit = count % 2 == 0 ? 1 : -1;
        count++;
    }

    public int getPosition() {
        return position;
    }

    public void stepForward() {
        position += moveUnit;
    }

    public void stepBack() {
        position -= moveUnit;
    }

    public int getDistance(Stance aStance) {
        return Math.abs(aStance.getPosition() - position);
    }
}