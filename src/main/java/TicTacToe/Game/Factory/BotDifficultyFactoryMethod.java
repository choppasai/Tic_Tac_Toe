package TicTacToe.Game.Factory;

import TicTacToe.Game.Model.Enums.BotDifficultyLevel;
import TicTacToe.Game.Strategy.BotWinningStrategy.BotWinningStrategy;
import TicTacToe.Game.Strategy.BotWinningStrategy.EasyWinningStrategy;
import TicTacToe.Game.Strategy.BotWinningStrategy.HardWinningStrategy;
import TicTacToe.Game.Strategy.BotWinningStrategy.MediumWinningStrategy;

public class BotDifficultyFactoryMethod {
    public static BotWinningStrategy botDifficultyMethod(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel == BotDifficultyLevel.EASY){
            return new EasyWinningStrategy();
        }
        else if(botDifficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumWinningStrategy();
        }
        else if(botDifficultyLevel == BotDifficultyLevel.HARD){
            return new HardWinningStrategy();
        }
        return null;
    }
}
