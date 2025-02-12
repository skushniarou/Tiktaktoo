package skushniarou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import skushniarou.Service.GameService;
import skushniarou.View.GameConsole;

@SpringBootApplication
public class tiktaktoo {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(tiktaktoo.class, args);
        GameService gameService = context.getBean(GameService.class);
        GameConsole consoleGame = new GameConsole(gameService);
        consoleGame.start();
    }
}