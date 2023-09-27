package com.jason.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestApiTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testInsertUser() throws Exception {
        // Perform the GET to check there are no entries
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().string("[]"));

        // Perform the POST to insert the user
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"jason\",\"email\":\"email\"}")
                        .characterEncoding("utf-8")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string("Created :User{id=1, name='jason', email='email'}"));

        // Perform the GET again and check the entry is there
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content()
                        .string("[{\"id\":1,\"name\":\"jason\",\"email\":\"email\"}]"));
    }
}