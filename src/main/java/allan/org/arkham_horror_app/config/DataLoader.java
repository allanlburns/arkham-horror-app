package allan.org.arkham_horror_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DataSource dataSource; // Injected DataSource for your database connection

    @Override
    public void run(String... args) throws Exception {
        // Load and execute data.sql manually
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("data.sql"));
            System.out.println("Seed data loaded successfully from data.sql!");
        } catch (Exception e) {
            System.err.println("Failed to load seed data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

