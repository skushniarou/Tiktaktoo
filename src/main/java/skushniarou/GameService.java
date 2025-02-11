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
        game.setBoard("---------");
        game.setCurrentPlayer("X");
        game.setStatus("IN_PROGRESS");
        return gameRepository.save(game);
    }

    public Optional<Game> getGame(Long id) {
        return gameRepository.findById(id);
    }
}
