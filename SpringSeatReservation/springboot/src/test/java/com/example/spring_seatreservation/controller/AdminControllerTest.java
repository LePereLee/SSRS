package com.example.spring_seatreservation.controller;

import com.example.spring_seatreservation.Bean.R;
import com.example.spring_seatreservation.mapper.AdminMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminMapper adminMapper;

    @Test
    void testUpdateSport() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("sportId", 1);
        requestMap.put("name", "更新的运动名称");

        mockMvc.perform(post("/admin/updateSport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

    @Test
    void testAddAnnounce() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("content", "新公告内容");

        given(adminMapper.addAnnounce(requestMap)).willReturn(true);

        mockMvc.perform(post("/admin/addAnnounce")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

    @Test
    void testGetUser() throws Exception {
        List<Map<String, Object>> users = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
        given(adminMapper.getUser()).willReturn(users);

        MvcResult mvcResult = mockMvc.perform(get("/admin/getUser"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("ok", new ObjectMapper().readValue(content, R.class).getStatus());
    }
}

// 测试 addSeat 方法
@Test
void testAddSeat() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("seatNum", 101);
    requestMap.put("status", "available");

    mockMvc.perform(post("/admin/addSeat")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ok"));
}

// 测试 deleteSeat 方法
@Test
void testDeleteSeat() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("seatNum", 101);

    mockMvc.perform(post("/admin/deleteSeat")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ok"));
}

// 测试 deleteArticle 方法
@Test
void testDeleteArticle() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("articleId", 1);

    mockMvc.perform(post("/admin/deleteArticle")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ok"));
}

// 测试 deleteAnnounce 方法
@Test
void testDeleteAnnounce() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("announceId", 1);

    mockMvc.perform(post("/admin/deleteAnnounce")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ok"));
}

// 测试 updatePwd 方法
@Test
void testUpdatePwd() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("userId", 1);
    requestMap.put("newPwd", "newPassword123");

    mockMvc.perform(post("/admin/updatePwd")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ok"));
}

// 测试 getTeacher 方法
@Test
void testGetTeacher() throws Exception {
    List<Map<String, Object>> teachers = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
    given(adminMapper.getTeacher()).willReturn(teachers);

    MvcResult mvcResult = mockMvc.perform(get("/admin/getTeacher"))
            .andExpect(status().isOk())
            .andReturn();

    String content = mvcResult.getResponse().getContentAsString();
    assertEquals("ok", new ObjectMapper().readValue(content, R.class).getStatus());
}

// 测试 getStatistics 方法
@Test
void testGetStatistics() throws Exception {
    List<Map<String, Object>> statistics = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
    given(adminMapper.getStatistics()).willReturn(statistics);
    given(adminMapper.getUserCounter()).willReturn(10L); // 假设用户总数为 10

    MvcResult mvcResult = mockMvc.perform(get("/admin/getStatistics"))
            .andExpect(status().isOk())
            .andReturn();

    String content = mvcResult.getResponse().getContentAsString();
    R response = new ObjectMapper().readValue(content, R.class);
    assertEquals("ok", response.getStatus());
    assertNotNull(response.getData().get("userCounter"));
    assertEquals(10L, response.getData().get("userCounter"));
    assertNotNull(response.getData().get("timeList"));
}
