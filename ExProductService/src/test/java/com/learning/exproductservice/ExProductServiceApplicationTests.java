package com.learning.exproductservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ExProductServiceApplicationTests {

//    @Autowired
//    public TestRestTemplate restTemplate;

    @Test
    @Disabled
    void test1(){
        //long ct=restTemplate.getForObject("http://localhost:8081/api/count", Long.class);
        //Assertions.assertEquals(ct,4);
    }

    @Autowired
    MockMvc mockMvc;

    @Test
    void test2() throws Exception{
        mockMvc.perform(get("/api/products")).andExpect(status().isOk());
    }
}
