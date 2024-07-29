package TicTacToe.Game.Model;

import TicTacToe.Game.Factory.BotDifficultyFactoryMethod;
import TicTacToe.Game.Model.Enums.BotDifficultyLevel;
import TicTacToe.Game.Strategy.BotWinningStrategy.BotWinningStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botWinningStrategy;

    public Bot(String name,Character symbol,BotDifficultyLevel botDifficultyLevel){
        this.setName(name);
        this.setSymbol(new Symbol(symbol));
        this.botDifficultyLevel = BotDifficultyLevel.EASY;
        this.botWinningStrategy = BotDifficultyFactoryMethod.botDifficultyMethod(botDifficultyLevel);
    }

    public Move botMove(Board board){

        return botWinningStrategy.makeMove(board);
    }
}
