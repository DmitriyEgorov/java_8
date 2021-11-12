package hackathon.controller;

import hackathon.model.TestResponse;
import hackathon.processor.mock.TestProcessor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * test controller for application
 *
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestProcessor testProcessor;

    public TestController(TestProcessor testProcessor) {
        this.testProcessor = testProcessor;
    }

    @RequestMapping("")
    public String sayHi() {
        return testProcessor.getHiMessage();
    }

    @RequestMapping("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestResponse> ping() {
        return ResponseEntity.ok(testProcessor.ping());
    }

    @RequestMapping("/ping/mock_db")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<TestResponse>> mock_db() {
        return ResponseEntity.ok(testProcessor.mock_db());
    }

    @RequestMapping("/ping/mock_db/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestResponse> mock_db(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testProcessor.mock_db(id));
    }

    @RequestMapping(value = "/ping/report",
            produces = {"application/octet-stream"},
            method = RequestMethod.GET)
    ResponseEntity<Resource> getReport() {
        return ResponseEntity
                .ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "report.xlsx" + "\"")
                .body(new ByteArrayResource(testProcessor.getReport()));
    }
}
