package hackathon.controller;

import hackathon.model.TestResponse;
import hackathon.processor.mock.TestProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * test controller for application
 *
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
public class TestController {

    private final TestProcessor testProcessor;

    public TestController(TestProcessor testProcessor) {
        this.testProcessor = testProcessor;
    }

    @RequestMapping("/")
    public String sayHi() {
        return testProcessor.getHiMessage();
    }

    @RequestMapping("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestResponse> ping() {
        return ResponseEntity.ok(testProcessor.ping());
    }

    @RequestMapping("/ping/mock_db/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> mock_db(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testProcessor.mock_db(id));
    }
}
