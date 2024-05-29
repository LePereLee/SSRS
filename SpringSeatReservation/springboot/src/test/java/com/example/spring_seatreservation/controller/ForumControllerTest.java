package com.example.spring_seatreservation.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.junit.jupiter.api.Assertions.*;

@RequestMapping("/forum")
class ForumControllerTest{
    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        System.out.println("-----ForumControllerTest start-----");
        // 构建mvc环境
        mvc = MockMvcBuilders.standaloneSetup(new ForumController()).build();
    }

    @AfterEach
    void tearDown() {
        System.out.println("======ForumControllerTest end======");
    }

    @Test
    void getArticle() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/getArticle")
                        // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        //.param("name", "Tom")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("Hello Tom!"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void insertArticle() {
    }

    @Test
    void insertComment() {
    }

    @Test
    void getComment() {
    }

    @Test
    void getAnnounce() {
    }
}