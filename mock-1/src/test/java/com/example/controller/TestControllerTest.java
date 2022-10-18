package com.example.controller;


import com.example.model.People;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

    /**
     * 在具有spring上下文的环境中使用,因为@MockBean是spring提供的
     * org.springframework.boot.test.mock.mockito.MockBean;
     */
    @MockBean
    private TestController testController;


    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void testTestControllerSuccess() throws Exception {
        mockTestControllerProcess();
        this.mockMvc.perform(get("/test"))
                .andDo(print())
                .andExpect(status().isOk())
//                {"id":6,"name":"cc"},{"id":7,"name":"dd"}
                .andExpect(jsonPath("$.[0].id").value(6))
                .andExpect(jsonPath("$.[0].name").value("cc"))
        ;
    }

    @Test
    public void testTestControllerFail() throws Exception {
        mockTestControllerProcessWithException();
        try {
            this.mockMvc.perform(get("/test")).andDo(print());
        } catch (Exception e) {
            assertTrue(e.getCause().getMessage().equals("Something bad happened."));
        }
    }

    private void mockTestControllerProcess(){
        List<People> peoples = Arrays.asList(new People(6, "cc"), new People(7, "dd"));
        when(testController.getPeoples()).thenReturn(ResponseEntity.ok(peoples));
    }

    private void mockTestControllerProcessWithException(){
        List<People> peoples = Arrays.asList(new People(6, "cc"), new People(7, "dd"));
        when(testController.getPeoples()).thenThrow(new RuntimeException("Something bad happened."));
    }
}
