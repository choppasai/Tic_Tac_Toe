package TicTacToe.Game.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
@Getter
@Setter
public class Symbol {
    private Character playerSymbol;
    private ImageIcon avatar;

    public Symbol(Character character) {
        this.playerSymbol = character;
    }
}
