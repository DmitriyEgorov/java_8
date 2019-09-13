package hackathon.adapter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dmitriy
 * @since 01.06.2019
 */
public class LocalDateTimeDeserializer extends StdDeserializer<Date> {

    protected LocalDateTimeDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("d MMM uuuu");
        try {
            return format.parse(jsonParser.readValueAs(String.class));
        } catch (ParseException e) {
            return null;
        }
    }
}
