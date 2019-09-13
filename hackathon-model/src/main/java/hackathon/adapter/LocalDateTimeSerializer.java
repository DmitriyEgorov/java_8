package hackathon.adapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Date;

/**
 * @author Dmitriy
 * @since 01.06.2019
 */
public class LocalDateTimeSerializer extends StdSerializer<Date> {

    public LocalDateTimeSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(Date localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDateTime.toString());
    }
}
