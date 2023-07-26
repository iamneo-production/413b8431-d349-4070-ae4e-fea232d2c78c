package com.examly.springapp.controller;

import com.examly.springapp.service.AnalyticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8081")
public class AnalyticsController {

    @Autowired
    AnalyticalService analyticalService;

    @GetMapping("/analytics/emailCount")
    public int emailCount(){
        return analyticalService.emailCount();
    }

    @GetMapping("/analytics/smsCount")
    public int smsCount(){
        return analyticalService.smsCount();
    }
}
