package com.charging_station.backend.controller.charging;

import com.charging_station.backend.service.charging.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChargingDeleteController {
    @Autowired
    private RemoveService removeService;

    @PostMapping("/charging/delete/")
    Map<String,String> remove(@RequestParam Map<String,String> data){
        return removeService.remove(data);
    }
}
