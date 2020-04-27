package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    private int turn;
    private int player1tally;
    private int player2tally;
    private int hold;
    private int die;

    public PigGameState(){
        turn = 0;
        player1tally = 0;
        player2tally = 0;
        hold = 0;
        die = 0;
    }

    public PigGameState(PigGameState pigState){
        player1tally = pigState.getPlayer1Tally();
        player2tally = pigState.getPlayer2Tally();
        hold = pigState.getHold();
        die = pigState.getDie();
    }

    public int getDie(){
        return die;
    }

    public int getHold(){
        return hold;
    }

    public int getPlayer1Tally(){
        return player1tally;
    }

    public int getPlayer2Tally(){
        return player2tally;
    }

    public void setHold(int hold){
        this.hold = hold;
    }

    public void setDie(int die){
        this.die = die;
    }

    public int getTurn(){
        return turn;
    }

    public void setTurn(int turn){
        this.turn = turn;
    }

    public void setPlayer1tally(int player1tally){
        this.player1tally = player1tally;
    }

    public void setPlayer2tally(int player2tally){
        this.player2tally = player2tally;
    }

}
