package TicTacToe.Game.Model;

import TicTacToe.Game.Model.Enums.PlayerType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
@NoArgsConstructor
public class Player {
    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private static Scanner sc;
    private Player(PlayerBuilder playerBuilder) {
        this.symbol = new Symbol(playerBuilder.character);
        this.name = playerBuilder.name;
        this.playerType = playerBuilder.playerType;
        sc = new Scanner(System.in);
    }


    public static PlayerBuilder getBuilder(){
        return new PlayerBuilder();
    }
    public Move placeMove(Player player){
        System.out.println("select row: ");
        int row = sc.nextInt();
        System.out.println("select column: ");
        int col = sc.nextInt();
        return new Move(new Cell(row,col),player);
    }
    public static class PlayerBuilder{
        private Character character;
        private String name;
        private PlayerType playerType;


        public PlayerBuilder setCharacter(Character symbol) {
            this.character = symbol;
            return this;
        }

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder setPlayerType(PlayerType playerType) {
            this.playerType = playerType;
            return this;
        }

        public Player build(){
            return new Player(this);
        }


    }


}
