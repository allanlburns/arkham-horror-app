package allan.org.arkham_horror_app;

import allan.org.arkham_horror_app.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArkhamHorrorAppApplication {

	public static void main(String[] args) {
			ConfigurableApplicationContext context = SpringApplication.run(ArkhamHorrorAppApplication.class, args);

			GameService gameService = context.getBean(GameService.class);
			gameService.initializeGame();
	}
}
