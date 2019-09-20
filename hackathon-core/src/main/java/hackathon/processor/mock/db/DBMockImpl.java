package hackathon.processor.mock.db;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy
 * @since 14.09.2019
 */
public class DBMockImpl implements DB {

    private static final String MESSAGE = "mock data %s";

    @Override
    public String byId(Long id) {
        return String.format(MESSAGE, id);
    }

    @Override
    public List<String> findList() {
        List<String> stringList = new ArrayList<>();
        stringList.add(String.format(MESSAGE, "1"));
        stringList.add(String.format(MESSAGE, "2"));
        return stringList;
    }

}
