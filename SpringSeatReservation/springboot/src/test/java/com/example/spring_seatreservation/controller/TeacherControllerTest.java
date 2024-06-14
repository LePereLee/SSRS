package com.example.spring_seatreservation.controller;

import com.example.spring_seatreservation.mapper.TeacherMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring_seatreservation.Bean.R;
import com.example.spring_seatreservation.mapper.TeacherMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherMapper teacherMapper;

    @InjectMocks
    private TeacherController teacherController;


    @BeforeEach
    void setUp() {
        System.out.println("----TeacherControllerTest start----");
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
        System.out.println("=====TeacherControllerTest end=====");
    }

    @Test
    void getReservation() throws Exception{
        // Mock data
        Map<String, Object> reservationData = new HashMap<>();
        reservationData.put("key1", "value1"); // Add sample data
        when(teacherMapper.getReservation()).thenAnswer(invocation -> reservationData);

        // Perform GET request and verify response
        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/getReservation"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("ok"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rows").value(reservationData));
    }

    @Test
    void getReservationNeedSub() {
    }

    @Test
    void subScore() {
    }
}