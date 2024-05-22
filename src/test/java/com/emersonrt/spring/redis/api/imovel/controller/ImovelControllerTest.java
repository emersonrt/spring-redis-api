package com.emersonrt.spring.redis.api.imovel.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ImovelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/imoveis"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].preco").value("250000.0"))
                .andExpect(jsonPath("$[0].area").value("120.5"))
                .andExpect(jsonPath("$[0].endereco").value("Rua das Flores, 123"));
    }

    @Test
    public void testFindById() throws Exception {
        long imovelId = 1L;

        mockMvc.perform(get("/imoveis/{id}", imovelId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.preco").value("250000.0"))
                .andExpect(jsonPath("$.area").value("120.5"))
                .andExpect(jsonPath("$.endereco").value("Rua das Flores, 123"));
    }

}