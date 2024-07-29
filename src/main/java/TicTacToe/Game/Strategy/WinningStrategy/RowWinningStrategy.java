package TicTacToe.Game.Strategy.WinningStrategy;

import TicTacToe.Game.Model.*;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    HashMap<Integer, Map<Symbol,Integer>> rowMap = new HashMap<>();
    @Override
    public boolean isWon(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowMap.containsKey(row)){
            rowMap.put(row,new HashMap<>());
        }
        Map<Symbol,Integer> map = rowMap.get(row);
        if(!map.containsKey(symbol)){
            rowMap.get(row).put(symbol,0);
        }

        rowMap.get(row).put(symbol,map.get(symbol)+1);
        int count = rowMap.get(row).get(symbol);
        if(count == board.getDimension())
            return true;
        return false;
    }
}
