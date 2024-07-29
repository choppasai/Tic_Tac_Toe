package TicTacToe.Game.Strategy.BotWinningStrategy;

import TicTacToe.Game.Model.Board;
import TicTacToe.Game.Model.Cell;

import TicTacToe.Game.Model.Enums.CellState;
import TicTacToe.Game.Model.Enums.PlayerType;
import TicTacToe.Game.Model.Move;
import TicTacToe.Game.Model.Player;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class EasyWinningStrategy implements BotWinningStrategy {

    @Override
    public Move makeMove(Board board) {
        int size = board.getDimension();
        for(List<Cell> cell : board.getBoardGame()){
            for(Cell subCell : cell){
                if(subCell.getCellState() == CellState.EMPTY)
                    return new Move(subCell,new Player());
            }
        }
        return null;
    }
}
