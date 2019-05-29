package hackathon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "test success";
    }
}
