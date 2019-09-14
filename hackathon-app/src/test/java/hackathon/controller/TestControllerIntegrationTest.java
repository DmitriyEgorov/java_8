package hackathon.controller;

import hackathon.config.HackathonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.constraints.AssertTrue;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration test for TestController
 *
 * @author Dmitriy
 * @since 31.05.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HackathonApplication.class)
@AutoConfigureMockMvc
public class TestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHi() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Alexander, Artem, Dmitriy and Mickhail say hi!")));
    }

    @Test
    public void testPing() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/ping")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test success")));

    }

}
