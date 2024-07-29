package TicTacToe.Game.Strategy.WinningStrategy;

import TicTacToe.Game.Model.*;

public interface WinningStrategy {
    public boolean isWon(Move move,Board board);
}
