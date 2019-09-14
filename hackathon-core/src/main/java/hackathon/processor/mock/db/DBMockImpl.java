package hackathon.processor.mock.db;

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
}
