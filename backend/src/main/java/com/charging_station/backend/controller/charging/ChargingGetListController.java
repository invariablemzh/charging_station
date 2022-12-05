package com.charging_station.backend.controller.charging;

import com.charging_station.backend.pojo.Charging;
import com.charging_station.backend.service.charging.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChargingGetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/charging/getlist/")
    public List<Charging> getList(){
        return getListService.getList();
    }
}
