package hackathon.config;

import hackathon.processor.mock.TestProcessor;
import hackathon.processor.mock.db.DB;
import hackathon.processor.mock.db.DBMockImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * boot configuration
 *
 * @author Dmitriy
 * @since 29.05.2019
 */
@SpringBootApplication
@ComponentScan(basePackages = "hackathon")
@EnableWebMvc
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

    @Bean
    public DB db () {
        return new DBMockImpl();
    }

    @Bean
    public TestProcessor testProcessor(DB db) {
        return new TestProcessor(db);
    }
}
