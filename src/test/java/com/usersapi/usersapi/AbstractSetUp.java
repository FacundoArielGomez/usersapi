package com.usersapi.usersapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = usersapi.class)
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public abstract class AbstractSetUp {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected  void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(obj);

        }
    protected <T> T mapFromJason(String json, Class<T> clazz) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, clazz);
    }
}
