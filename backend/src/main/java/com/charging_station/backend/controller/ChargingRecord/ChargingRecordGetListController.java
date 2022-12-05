package com.charging_station.backend.controller.ChargingRecord;

import com.charging_station.backend.pojo.ChargingRecord;
import com.charging_station.backend.service.chargingRecord.ChargingRecordGetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChargingRecordGetListController {
    @Autowired
    private ChargingRecordGetListService chargingRecordGetListService;

    @GetMapping("/chargingRecord/getlist/")
    public List<ChargingRecord> getList(){
        return chargingRecordGetListService.getList();
    }

}
