package skushniarou.View;

import skushniarou.Game;

public class GameView {
    static void printBoard(Game currentGame) {
        String board = currentGame.getBoard();
        for (int i = 0; i < board.length(); i++) {
            System.out.print(board.charAt(i) == '-' ? "." : board.charAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
        }
    }
}