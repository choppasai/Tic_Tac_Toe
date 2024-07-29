package TicTacToe.Game.Model.Enums;

public enum PlayerType {
    HUMAN(null),
    EASY_BOT(BotDifficultyLevel.EASY),
    MEDIUM_BOT(BotDifficultyLevel.MEDIUM),
    HARD_BOT(BotDifficultyLevel.HARD);

    private BotDifficultyLevel botDifficultyLevel;
    PlayerType(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
