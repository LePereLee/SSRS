package com.example.spring_seatreservation.controller;

import com.example.spring_seatreservation.Bean.R;
import com.example.spring_seatreservation.mapper.TeacherMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TeacherController.class)
class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherMapper teacherMapper;

    // 测试 getReservation 方法
    @Test
    void testGetReservation() throws Exception {
        List<Map<String, Object>> reservations = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
        given(teacherMapper.getReservation()).willReturn(reservations);

        mockMvc.perform(get("/teacher/getReservation"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows").isNotEmpty());
    }

    // 测试 getReservationNeedSub 方法
    @Test
    void testGetReservationNeedSub() throws Exception {
        List<Map<String, Object>> reservations = List.of(new HashMap<>(), new HashMap<>()); // 模拟数据
        given(teacherMapper.getReservationNeedSub()).willReturn(reservations);

        mockMvc.perform(get("/teacher/getReservationNeedSub"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows").isNotEmpty());
    }

    // 测试 subScore 方法
    @Test
    void testSubScore() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("studentId", "123");
        requestMap.put("score", 95);

        mockMvc.perform(post("/teacher/subScore")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("ok"));

        // 验证 teacherMapper.subScore(map) 是否被调用
        verify(teacherMapper).subScore(requestMap);
        // 验证 teacherMapper.subReservationScore(map) 是否被调用
        verify(teacherMapper).subReservationScore(requestMap);
    }
}