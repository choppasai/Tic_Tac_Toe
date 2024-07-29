package TicTacToe.Game.Strategy.WinningStrategy;


import TicTacToe.Game.Model.*;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    HashMap<Integer, Map<Symbol,Integer>> colMap = new HashMap<>();
    @Override
    public boolean isWon(Move move, Board board) {

        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();


        if(!colMap.containsKey(col)){
            colMap.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> map = colMap.get(col);
        if(!map.containsKey(symbol)){
            colMap.get(col).put(symbol,0);
        }

        colMap.get(col).put(symbol,map.get(symbol)+1);
        int count = colMap.get(col).get(symbol);
        if(count == board.getDimension())
            return true;
        return false;
    }
}
