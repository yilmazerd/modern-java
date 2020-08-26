package modernjavainaction.onlinetutorials.templatemethod;

import java.nio.file.StandardWatchEventKinds;

public abstract class Game
{
    public Game(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void run()
    {
        start();
        while (!haveWinner())
            takeTurn();
        System.out.println("Player " + getWinningPlayer() + " wins");
    }

    protected abstract int getWinningPlayer();
    protected abstract boolean haveWinner();
    protected abstract void start();
    protected abstract void takeTurn();
    protected int currentPlayer;
    protected final int numberOfPlayer;

}

class Chess extends Game{

    private int maxTurns = 10;
    private int turn = 1;

    public Chess() {
        super(2);
    }

    @Override
    public void run() {
        if (turn<maxTurns)
        super.run();
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }

    @Override
    protected boolean haveWinner() {
        return false;
    }

    @Override
    protected void start() {

    }

    @Override
    protected void takeTurn() {
        System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
    }
}

class Demo
{
    public static void main(String[] args) {
        new Chess().run();
    }
}