package TicTacToe.Game.Controller;


import TicTacToe.Game.Model.Enums.GameState;
import TicTacToe.Game.Model.Game;
import TicTacToe.Game.Model.Player;
import TicTacToe.Game.Strategy.WinningStrategy.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class GameController {


    public static void gameCreation(){

    }

    public static Game startGame(int boardSize, List<Player> playerList, List<WinningStrategy> winningStrategyList) throws Exception {
        return Game.getBuilder().setDimension(boardSize)
                .setPlayers(playerList).setGameState(GameState.IN_PROGRESS)
                .setWinningStrategies(winningStrategyList).build();
    }
    public static void printGame(Game game){
        game.printBoard();
    }

    public static void makeMove(Game game){
        game.makeMove();
    }
}