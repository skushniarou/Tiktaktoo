package skushniarou.View;

import skushniarou.Game;
import skushniarou.Service.GameService;
import skushniarou.Status;

import java.util.Scanner;

import static skushniarou.View.OtherView.printOneLineInfo;

public class GameConsole {
    private final GameService gameService;
    private Game currentGame;

    public GameConsole(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        currentGame = gameService.createNewGame();
        printOneLineInfo("New game started!");
        GameView.printBoard(currentGame);

        while (currentGame.getStatus() == Status.IN_PROGRESS) {
            printOneLineInfo("Current player: " + currentGame.getCurrentPlayer());
            printOneLineInfo("Enter position (1-9): ");
            int position = scanner.nextInt() - 1;
            try {
                currentGame = gameService.makeMove(currentGame.getId(), position, currentGame.getCurrentPlayer());
                GameView.printBoard(currentGame);
                if (currentGame.getStatus() != Status.IN_PROGRESS) {
                    printOneLineInfo("Game Over: " + currentGame.getStatus());
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}