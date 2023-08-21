package com.example.logtracer.strategy.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BasicStrategyOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BasicStrategyOrderController basicStrategyOrderController;

    @Test
    void testRequestSuccess() throws Exception {
        String itemId = "test";
        mockMvc.perform(MockMvcRequestBuilders.get("/strategy/basic/request")
                        .param("itemId", itemId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testRequestFail() {
        String itemId = "ex";
        assertThrows(Exception.class, () -> basicStrategyOrderController.request(itemId));
    }

}