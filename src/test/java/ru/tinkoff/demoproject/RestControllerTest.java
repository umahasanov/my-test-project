package ru.tinkoff.demoproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.tinkoff.demoproject.controller.JsonController;

import java.util.logging.Logger;

/*@RunWith(SpringRunner.class)
@WebMvcTest(value = JsonController.class, secure = false)*/
public class RestControllerTest {

    /*@Autowired*/
    private MockMvc mockMvc;

    private Logger log = Logger.getLogger("RestControllerTest");

    /*@Test*/
    public void testJsonResponse() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/json//getLastClientProduct/3").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        log.info("Response: " + result.getResponse().getContentAsString());
    }
}
