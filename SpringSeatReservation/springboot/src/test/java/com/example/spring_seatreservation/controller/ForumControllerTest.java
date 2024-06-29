package com.example.spring_seatreservation.controller;

import com.example.spring_seatreservation.Bean.R;
import com.example.spring_seatreservation.mapper.ForumMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ForumController.class)
class ForumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ForumMapper forumMapper;

    // 测试 getArticle 方法
    @Test
    void testGetArticle() throws Exception {
        List<Map<String, Object>> articles = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
        given(forumMapper.getArticle()).willReturn(articles);

        mockMvc.perform(get("/forum/getArticle"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows").isNotEmpty());
    }

    // 测试 insertArticle 方法
    @Test
    void testInsertArticle() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("title", "新文章标题");
        requestMap.put("content", "新文章内容");

        mockMvc.perform(post("/forum/insertArticle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // 测试 insertComment 方法
    @Test
    void testInsertComment() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("articleId", 1);
        requestMap.put("content", "新评论内容");

        mockMvc.perform(post("/forum/insertComment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // 测试 getComment 方法
    @Test
    void testGetComment() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("articleId", 1);
        List<Map<String, Object>> comments = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
        given(forumMapper.getComment(requestMap)).willReturn(comments);

        mockMvc.perform(post("/forum/getComment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows").isNotEmpty());
    }

    // 测试 getAnnounce 方法
    @Test
    void testGetAnnounce() throws Exception {
        List<Map<String, Object>> announcements = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
        given(forumMapper.getAnnounce()).willReturn(announcements);

        mockMvc.perform(get("/forum/getAnnounce"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows").isNotEmpty());
    }
}