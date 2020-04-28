package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.gameConfiguration.GameConfig;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

import android.util.Log;

import java.util.*;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */
    private PigGameState confirmedState;
    public PigLocalGame() {
        //TODO  You will implement this constructor
        confirmedState = new PigGameState();
    }

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState toDeliver = new PigGameState(confirmedState);
        p.sendInfo(toDeliver);
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(confirmedState.getTurn() == playerIdx) {return true;}
        else
            {return false;}
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof  PigHoldAction){
            if(confirmedState.getTurn() == 0){
                confirmedState.setPlayer1Tally(confirmedState.getPlayer1Tally() + confirmedState.getHold());
            } else {
                confirmedState.setPlayer2Tally(confirmedState.getPlayer2Tally() + confirmedState.getHold());
            }
            confirmedState.setHold(0);
            if(players.length == 2){
                confirmedState.setTurn(1 - confirmedState.getTurn());
            }
            return true;
        } else if (action instanceof PigRollAction)
        {
            Random unknown = new Random();
            int dice = unknown.nextInt(6) + 1;
            if (dice != 1){
                confirmedState.setHold(dice + confirmedState.getHold());
                confirmedState.setDie(dice);
            } else {
                confirmedState.setHold(0);
                if(players.length == 2)
                {
                    confirmedState.setTurn(1 - confirmedState.getTurn());
                    confirmedState.setDie(dice);
                }
                return true;
            }
        }  else {return false;}//makeMove


    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver(){
        //TODO  You will implement this method
        String nameOfPlayer;
        if (confirmedState.getPlayer1Tally() >= 50){
            nameOfPlayer = "Player 1 wins!";
            return nameOfPlayer;
        }
        if (confirmedState.getPlayer2Tally() >= 50){
            nameOfPlayer = "Player 2 wins!";
            return nameOfPlayer;}
        return null;
    }
}
// class PigLocalGame
