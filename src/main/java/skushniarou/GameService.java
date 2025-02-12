package skushniarou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game createNewGame() {
        Game game = new Game();
        game.setBoard("--X---O--");
        game.setCurrentPlayer("X");
        game.setStatus("IN_PROGRESS");
        return gameRepository.save(game);
    }

    public Optional<Game> getGame(Long id) {
        System.out.println("Spiel mit id: " + id + " gefunden");
        return gameRepository.findById(id);
    }

    public Game makeMove(Long gameId, int position, String player) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            if (game.getStatus().equals("IN_PROGRESS") && game.getCurrentPlayer().equals(player)) {
                String board = game.getBoard();
                if (board.charAt(position) == '-') {
                    board = board.substring(0, position) + player + board.substring(position + 1);
                    game.setBoard(board);
                    if (checkWin(board, player)) {
                        game.setStatus("END");
                    } else if (board.indexOf('-') == -1) {
                        game.setStatus("DRAW");
                    } else {
                        game.setCurrentPlayer(player.equals("X") ? "O" : "X");
                    }
                    return gameRepository.save(game);
                }
            }
        }
        throw new IllegalArgumentException("Invalid move");
    }

    private boolean checkWin(String board, String player) {
        // Check rows, columns, and diagonals for a win
        String line = player + player + player;
        return (board.substring(0, 3).equals(line) || board.substring(3, 6).equals(line) || board.substring(6, 9).equals(line) ||
                ("" + board.charAt(0) + board.charAt(3) + board.charAt(6)).equals(line) ||
                ("" + board.charAt(1) + board.charAt(4) + board.charAt(7)).equals(line) ||
                ("" + board.charAt(2) + board.charAt(5) + board.charAt(8)).equals(line) ||
                ("" + board.charAt(0) + board.charAt(4) + board.charAt(8)).equals(line) ||
                ("" + board.charAt(2) + board.charAt(4) + board.charAt(6)).equals(line));
    }
}