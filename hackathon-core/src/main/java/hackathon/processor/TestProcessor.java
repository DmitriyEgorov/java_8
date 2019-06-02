package hackathon.processor;

import hackathon.model.TestResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Test processor
 *
 * @author Dmitriy
 * @since 02.06.2019
 */
@Service
public class TestProcessor {

    private static final String HI_MESSAGE = "Dmitriy, Mickhail and Sergey say hi!";
    private static final String TEST_MESSAGE = "test success";

    /**
     * get HI MESSAGE for test controller
     *
     * @return HI MESSAGE for test controller
     */
    public String getHiMessage() {
        return HI_MESSAGE;
    }

    /**
     * get Response entity for test controller
     *
     * @return Response entity for test controller
     */
    public TestResponse ping() {
        TestResponse responseBody = new TestResponse();
        responseBody.setMessage(TEST_MESSAGE);
        responseBody.setDateTimeMessage(LocalDateTime.now());
        return responseBody;
    }

}
