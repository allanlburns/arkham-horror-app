package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.Game;
import allan.org.arkham_horror_app.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/state")
    public Game getGameState() {
        return gameService.getCurrentGame();
    }
}