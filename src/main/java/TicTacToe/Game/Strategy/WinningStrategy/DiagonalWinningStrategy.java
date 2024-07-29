package TicTacToe.Game.Strategy.WinningStrategy;

import TicTacToe.Game.Model.*;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{

    HashMap<Symbol,Integer> leftDiagonal = new HashMap<>();
    HashMap<Symbol,Integer> rightDiagonal = new HashMap<>();
    @Override
    public boolean isWon(Move move, Board board) {
        int size = board.getDimension();
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row == col){
            leftDiagonal.put(symbol,leftDiagonal.getOrDefault(symbol,0)+1);
            if(leftDiagonal.get(symbol) == size)
                return true;
        }
        if(row+col == size-1){
            rightDiagonal.put(symbol,rightDiagonal.getOrDefault(symbol,0)+1);
            return rightDiagonal.get(symbol) == size;
        }

        return false;
    }
}
