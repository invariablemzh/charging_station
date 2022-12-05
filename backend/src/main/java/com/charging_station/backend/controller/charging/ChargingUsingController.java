package com.charging_station.backend.controller.charging;

import com.charging_station.backend.service.charging.UsingService;
import com.charging_station.backend.service.chargingRecord.ChargingRecordGetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChargingUsingController {
    @Autowired
    private UsingService usingService;

    @PostMapping("/charging/using/")
    public Map<String,String> using(@RequestParam Map<String,String> data){
        return usingService.using(data);
    }

}
