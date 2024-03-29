package com.examly.crm.controller;

import com.examly.crm.service.AnalyticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("https://8081-edfdbecdceefbfbcdcaeeaebabeaeaadbdbabf.project.examly.io")
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
