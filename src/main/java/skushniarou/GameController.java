package skushniarou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/games")
class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/newGame")
    public Game createGame() {
        return gameService.createNewGame();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }
}
