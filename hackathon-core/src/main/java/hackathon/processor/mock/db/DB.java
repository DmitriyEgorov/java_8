package hackathon.processor.mock.db;

import java.util.List;

/**
 * @author Dmitriy
 * @since 14.09.2019
 */
public interface DB {

    String byId (Long id);

    List<String> findList ();
}
