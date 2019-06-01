package hackathon.controller;

import hackathon.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;


/**
 * test controller for application
 *
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
public class TestController {

    private static final String HI_MESSAGE = "Dmitriy, Mickhail and Sergey say hi!";
    private static final String TEST_MESSAGE = "test success";

    @RequestMapping("/")
    public String sayHi() {
        return HI_MESSAGE;
    }

    @RequestMapping("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestResponse> ping() {
        TestResponse responseBody = new TestResponse();
        responseBody.setMessage(TEST_MESSAGE);
        responseBody.setDateTimeMessage(LocalDateTime.now());
        return ResponseEntity.ok(responseBody);
    }
}
