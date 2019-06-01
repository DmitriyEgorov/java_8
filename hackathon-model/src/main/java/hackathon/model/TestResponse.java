package hackathon.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hackathon.adapter.LocalDateTimeDeserializer;
import hackathon.adapter.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * model for test controller
 *
 * @author Dmitriy
 * @since 31.05.2019
 */
public class TestResponse {

    /* message */
    private String message;

    /* dateTime message */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTimeMessage;

    public TestResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTimeMessage() {
        return dateTimeMessage;
    }

    public void setDateTimeMessage(LocalDateTime dateTimeMessage) {
        this.dateTimeMessage = dateTimeMessage;
    }
}
