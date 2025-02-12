package skushniarou.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skushniarou.Game;
import skushniarou.Service.GameService;

import java.util.Optional;

@RestController
@RequestMapping("/game")
class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/newGame")
    public Game createGame() {
        return gameService.createNewGame();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGame(@PathVariable Long id) {
        Optional<Game> game = gameService.getGame(id);
        if (game.isPresent()) {
            return ResponseEntity.ok(game.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found with id " + id);
        }
    }

    @PostMapping("/{id}/move")
    public ResponseEntity<?> makeMove(@PathVariable Long id, @RequestParam int position, @RequestParam String player) {
        try {
            Game game = gameService.makeMove(id, position, player);
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
