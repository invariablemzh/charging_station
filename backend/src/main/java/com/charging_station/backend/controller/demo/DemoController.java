package com.charging_station.backend.controller.demo;

import com.charging_station.backend.service.demo.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class DemoController {
    @Autowired
    private IDemoService demoService;

    @Scheduled(fixedRate = 60*1000)
    public void demo() {
        demoService.demo();
    }
}
