package TicTacToe.Game.Model;

import TicTacToe.Game.Model.Enums.CellState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private List<List<Cell>> boardGame;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        boardGame = new ArrayList<>();
        for(int i=0;i<dimension;i++){
            List<Cell> newList = new ArrayList<>();
            for(int j=0;j<dimension;j++){
                newList.add(new Cell(i,j));
            }
            boardGame.add(newList);
        }
    }
    public void print(){
        for(int i=0;i<dimension;i++){
            System.out.print("|   ");
            for(int j=0;j<dimension;j++){
                if(boardGame.get(i).get(j).getCellState() == CellState.EMPTY)
                    System.out.print("|| ");
                else
                    System.out.print(" "+boardGame.get(i).get(j).getPlayer().getSymbol().getPlayerSymbol()+" ");
            }
            System.out.println("   |");
        }
    }
}
