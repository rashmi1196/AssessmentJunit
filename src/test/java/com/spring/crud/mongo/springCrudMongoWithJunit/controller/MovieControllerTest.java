package com.spring.crud.mongo.springCrudMongoWithJunit.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class MovieControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext employeeContext; // autowired the configuration


    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(employeeContext).build();

    }

    @Test
    public void verifyAllMovies() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andDo(print());
    }

    @Test
    public void verifyValidMovie() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.message").value("THE REQUEST CANNOT BE PLACED DUE TO MALFUNCTION SYNTAX"))
                .andDo(print());
    }

    @Test
    public void verifyDeleteById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void verifyInvalidDeleteById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("EMPLOYEE DOESN'T EXISTS"))
                .andDo(print());
    }
}
