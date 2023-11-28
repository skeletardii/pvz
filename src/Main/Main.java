package Main;
import javax.swing.JFrame;

import Entities.Misc.*;
import Entities.Plants.*;
import GUI.*;
import GameUtils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame("The zombies are cumming");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        Game game = new Game(window,800,600);
        game.start();
        game.add(new GameUI(3));
        game.add(new Sunflower(1, 1));
        game.add(new Sunflower(2, 2));
        game.add(new Sunflower(5, 3));
        game.add(new Sunflower(1, 0));
        game.add(new Sunflower(6, 4));
        game.add(new Selector(game));
        game.add(new Sunflower(3,3));
    }
}
