package hackathon.processor.mock;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/**
 * Test job
 * @author Dmitriy
 * @since 20.09.2019
 */
@Component
public class TestJob implements Job {
    private static final Logger LOGGER = getLogger(TestJob.class.getName());
    private final TestJobService testJobService;

    public TestJob() {
        this.testJobService = new TestJobService();
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info(testJobService.getMessage());
    }
}
