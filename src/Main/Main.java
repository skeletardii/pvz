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
        game.add(new Sunflower(1, 2));
        game.add(new Sunflower(1, 3));
        game.add(new Sunflower(1, 4));

    }
}
