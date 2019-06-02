package hackathon.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
