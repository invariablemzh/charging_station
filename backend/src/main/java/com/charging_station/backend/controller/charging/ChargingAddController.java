package com.charging_station.backend.controller.charging;


import com.charging_station.backend.service.charging.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChargingAddController {
    @Autowired
    private AddService addService;

    @PostMapping("/charging/add/")
    public Map<String,String> add(@RequestParam Map<String,String> data){
        return addService.add(data);
    }
}
