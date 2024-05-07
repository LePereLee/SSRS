package com.huawei.ibooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudyRoomController {
    @GetMapping(value = "/studyroom")
    public String studyroom() {
        return "studyroom";
    }
}
