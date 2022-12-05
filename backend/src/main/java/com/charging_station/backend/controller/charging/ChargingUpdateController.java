package com.charging_station.backend.controller.charging;

import com.charging_station.backend.service.charging.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChargingUpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/charging/update/")
    Map<String,String> update(@RequestParam Map<String,String> data){
        return updateService.update(data);
    }
}
