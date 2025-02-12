package skushniarou;

import java.util.Scanner;

public class GameConsole {
    private final GameService gameService;
    private Game currentGame;

    public GameConsole(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        currentGame = gameService.createNewGame();
        System.out.println("New game started!");
        GameView.printBoard(currentGame);

        while (currentGame.getStatus() == Status.IN_PROGRESS) {
            System.out.println("Current player: " + currentGame.getCurrentPlayer());
            System.out.print("Enter position (0-8): ");
            int position = scanner.nextInt();
            try {
                currentGame = gameService.makeMove(currentGame.getId(), position, currentGame.getCurrentPlayer());
                GameView.printBoard(currentGame);
                if (currentGame.getStatus() != Status.IN_PROGRESS) {
                    System.out.println("Game Over: " + currentGame.getStatus());
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}