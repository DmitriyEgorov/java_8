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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        mvc.perform(MockMvcRequestBuilders.get("/test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("We are team of dream!")));
    }

    @Test
    public void testPing() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test/ping")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> assertTrue(mvcResult.getResponse().getContentAsString().contains("test success")));

    }

    @Test
    public void testPingMockDb() throws Exception {
        List<String> stringList = new ArrayList<>();
        stringList.add("mock data 1");
        stringList.add("mock data 2");
        mvc.perform(MockMvcRequestBuilders.get("/test/ping/mock_db")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(stringContainsInOrder(stringList)));

    }

    @Test
    public void testPingMockDbById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test/ping/mock_db/{id}", "56")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("mock data 56")));

    }

    @Test
    public void testPingMockDbById_incorrectId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test/ping/mock_db/{id}", "string")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

}
