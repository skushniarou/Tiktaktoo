package skushniarou;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import skushniarou.Service.GameService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GameServiceTest {
    @Autowired
    private GameService gameService;

    @Test
    public void testCreateNewGame() {
        Game game = gameService.createNewGame();
        assertNotNull(game);
        Assertions.assertEquals("---------", game.getBoard());
        Assertions.assertEquals("X", game.getCurrentPlayer());
        Assertions.assertEquals(Status.IN_PROGRESS, game.getStatus());
    }

    @Test
    public void testMakeMove() {
        Game game = gameService.createNewGame();
        game = gameService.makeMove(game.getId(), 0, "X");
        Assertions.assertEquals("X--------", game.getBoard());
        Assertions.assertEquals("O", game.getCurrentPlayer());
        Assertions.assertEquals(Status.IN_PROGRESS, game.getStatus());
    }

    @Test
    public void testWinCondition() {
        Game game = gameService.createNewGame();
        game.setBoard("XX-OO----");
        game = gameService.makeMove(game.getId(), 2, "X");
        Assertions.assertEquals(Status.WIN, game.getStatus());
    }

    @Test
    public void testDrawCondition() {
        Game game = gameService.createNewGame();
        game.setBoard("XXOOXXOOX");
        game = gameService.makeMove(game.getId(), 8, "X");
        Assertions.assertEquals(Status.DRAW, game.getStatus());
    }
}