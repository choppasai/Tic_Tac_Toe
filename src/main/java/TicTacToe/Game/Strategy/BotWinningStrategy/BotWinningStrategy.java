package TicTacToe.Game.Strategy.BotWinningStrategy;

import TicTacToe.Game.Model.Board;
import TicTacToe.Game.Model.Move;

public interface BotWinningStrategy {
    Move makeMove(Board board);
}
