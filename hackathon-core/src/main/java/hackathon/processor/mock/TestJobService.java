package hackathon.processor.mock;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Dmitriy
 * @since 21.09.2019
 */
@Service
public class TestJobService {

    private static final String MESSAGE = "Message at %s";

    public String getMessage () {
        return String.format(MESSAGE, new Date().toString());
    }
}
