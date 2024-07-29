package TicTacToe.Game;

import TicTacToe.Game.Controller.GameController;
import TicTacToe.Game.Model.Bot;
import TicTacToe.Game.Model.Enums.BotDifficultyLevel;
import TicTacToe.Game.Model.Enums.GameState;
import TicTacToe.Game.Model.Enums.PlayerType;
import TicTacToe.Game.Model.Game;
import TicTacToe.Game.Model.Player;
import TicTacToe.Game.Strategy.WinningStrategy.ColumnWinningStrategy;
import TicTacToe.Game.Strategy.WinningStrategy.DiagonalWinningStrategy;
import TicTacToe.Game.Strategy.WinningStrategy.RowWinningStrategy;
import TicTacToe.Game.Strategy.WinningStrategy.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(GameApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter board size :");
		int boardSize = sc.nextInt();

		System.out.println("Enter no of players :");

		int players = 0;
		try{
			players = sc.nextInt();
		}
		catch (Exception e){
			System.out.println("no of players should be less than board size");
		}

		System.out.println("Do you want to play with bot. If yes please type YES else NO:");
		String botRequest = sc.next();
		List<Player> playerList = new ArrayList<>();
		if(botRequest.equals("YES")){
			players--;
			Player p2 = new Bot("Intelligent Bot",'O',BotDifficultyLevel.EASY);
			playerList.add(p2);
		}
		for(int i=0;i<players;i++){
			System.out.println("Enter player "+i+1 +" name");
			String name = sc.next();
			System.out.println("Enter player symbol ");
			Character symbol = (char)sc.next().charAt(0);
			Player p1 = Player.getBuilder().setCharacter(symbol).setName(name).setPlayerType(PlayerType.HUMAN).build();
			playerList.add(p1);
		}

		List<WinningStrategy> winningStrategyList = new ArrayList<>();
		winningStrategyList.add(new RowWinningStrategy());
		winningStrategyList.add(new ColumnWinningStrategy());
		winningStrategyList.add(new DiagonalWinningStrategy());

		Game game = GameController.startGame(boardSize,playerList,winningStrategyList);

		while(game.getGameState() == GameState.IN_PROGRESS){
			GameController.printGame(game);
			GameController.makeMove(game);
		}
		GameController.printGame(game);

	}

}
