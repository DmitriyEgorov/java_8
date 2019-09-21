package hackathon.processor.mock;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/**
 * New Test job
 *
 * @author Dmitriy
 * @since 20.09.2019
 */
@Component
public class NewTestJob implements Job {
    private static final Logger LOGGER = getLogger(NewTestJob.class.getName());
    private static final String MESSAGE = "New Job %s";
    private final TestJobService testJobService;

    public NewTestJob() {
        this.testJobService = new TestJobService();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info(String.format(MESSAGE, testJobService.getMessage()));
    }
}
