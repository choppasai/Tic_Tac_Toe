package TicTacToe.Game.Model;

import TicTacToe.Game.Exception.InvalidMoveException;
import TicTacToe.Game.Factory.BotDifficultyFactoryMethod;
import TicTacToe.Game.Model.Enums.BotDifficultyLevel;
import TicTacToe.Game.Model.Enums.CellState;
import TicTacToe.Game.Model.Enums.GameState;
import TicTacToe.Game.Model.Enums.PlayerType;
import TicTacToe.Game.Strategy.BotWinningStrategy.BotWinningStrategy;
import TicTacToe.Game.Strategy.WinningStrategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Getter
@Setter
public class Game {

    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextPlayerTurn;
    private List<Move> moves;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private Scanner sc;

    private Game(GameBuilder gameBuilder){
        board = new Board(gameBuilder.dimension);
        System.out.println(board.getDimension());
        players = gameBuilder.players;
        gameState = gameBuilder.gameState;
        winningStrategies = gameBuilder.winningStrategies;
        nextPlayerTurn = 0;
        moves = new ArrayList<>();
        sc = new Scanner(System.in);

    }
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }
    public void printBoard(){
        board.print();
    }
    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerTurn);

        System.out.println("this is "+players.get(nextPlayerTurn).getName() +"'s turn");
        Move move = null;
        if(currentPlayer.getPlayerType() == PlayerType.HUMAN){
            move = currentPlayer.placeMove(currentPlayer);
            try{
                validateMove(board,move);
            }
            catch (InvalidMoveException e){
                System.out.println(e.getMessage() +" please select correct cell");
                makeMove();
            }
        }
        else{
            move = ((Bot) currentPlayer).botMove(board);
        }

        nextPlayerTurn = (nextPlayerTurn+1) % players.size();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = move.getCell();
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);
        board.getBoardGame().get(row).set(col,cell);
        moves.add(new Move(cell,currentPlayer));

        if(checkWinner(board,move)){
            gameState = GameState.WON;
            winner = currentPlayer;
            System.out.println("Winner is "+ currentPlayer.getName());
        }
        else if(moves.size() == board.getDimension() * board.getDimension()){
            gameState = GameState.DRAW;
            System.out.println("Match is Draw ");
        }


    }

    private void validateMove(Board board,Move move) throws InvalidMoveException{
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(board.getBoardGame().get(row).get(col).getCellState() == CellState.FILLED
                || row >= board.getDimension() || col >= board.getDimension()
                || row < 0 || col < 0
        )
            throw new InvalidMoveException("invalid move");
    }
    public boolean checkWinner(Board board,Move move){
       for(WinningStrategy strategy : winningStrategies){
           if(strategy.isWon(move,board)){
               return true;
           }
       }
       return false;
    }

    public static class GameBuilder{
        private int dimension;
        private List<Player> players;
        private GameState gameState;
        private List<WinningStrategy> winningStrategies;


        public GameBuilder setDimension(int boardSize) {
            dimension = boardSize;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public void validate() throws Exception{

        }
        public Game build() throws Exception {
            validate();
            return new Game(this);
        }
    }

}
