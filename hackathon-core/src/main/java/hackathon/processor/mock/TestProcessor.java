package hackathon.processor.mock;

import hackathon.model.TestResponse;
import hackathon.processor.mock.db.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Test processor
 *
 * @author Dmitriy
 * @since 02.06.2019
 */
@Service
public class TestProcessor {

    private static final String HI_MESSAGE = "Alexander, Artem, Dmitriy and Mickhail say hi!";
    private static final String TEST_MESSAGE = "test success";
    private final DB db;

    public TestProcessor(DB db) {
        this.db = db;
    }

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
        responseBody.setDateTimeMessage(new Date());
        return responseBody;
    }

    /**
     * get Response entity for test controller
     *
     * @return Response entity for test controller
     */
    public TestResponse mock_db(Long id) {
        TestResponse testResponse = new TestResponse();
        testResponse.setMessage(db.byId(id));
        testResponse.setDateTimeMessage(new Date());
        return testResponse;
    }

    public List<TestResponse> mock_db() {
        List<TestResponse> testResponses = new ArrayList<>();
        for(String data : db.findList()) {
            TestResponse testResponse = new TestResponse();
            testResponse.setMessage(data);
            testResponse.setDateTimeMessage(new Date());
            testResponses.add(testResponse);
        }
        return testResponses;
    }

}
