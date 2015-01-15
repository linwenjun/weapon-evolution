package com.thoughtworks.academy;

public class Round implements IListener {
    private Turn turn;
    private boolean isProcess = true;
    private Player p1;
    private Player p2;
    private int maxCount = 100;

    public Round(Turn turn) {
        this.turn = turn;
    }

    public void start(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        p1.addListener(this);
        p2.addListener(this);

        while (maxCount-- > 0) {
            if (!isProcess) {
                break;
            }

            turn.process(this.p1, this.p2);
            swap();
        }
    }

    private void swap() {
        Player temp = p1;
        p1 = p2;
        p2 = temp;
    }

    @Override
    public void update(GameMessage message) {
        if ("die" == message.getType()) {
            isProcess = false;
        }
    }

    public static void main(String[] args) {
        Player z = new Player("张三", 100, 12);
        Player l = new Player("李四", 90, 14);
        Speaker speaker = new Speaker();
        AttackManager attackManager = new AttackManager();
        Turn turn = new Turn(attackManager);
        Round round = new Round(turn);

        z.addListener(speaker);
        l.addListener(speaker);

        round.start(z, l);
    }
}
