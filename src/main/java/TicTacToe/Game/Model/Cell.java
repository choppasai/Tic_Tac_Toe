package TicTacToe.Game.Model;

import TicTacToe.Game.Model.Enums.CellState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;
    public Cell(int row,int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

}
