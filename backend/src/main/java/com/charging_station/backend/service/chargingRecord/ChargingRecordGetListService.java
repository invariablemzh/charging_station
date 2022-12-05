package com.charging_station.backend.service.chargingRecord;

import com.charging_station.backend.pojo.ChargingRecord;

import java.util.List;

public interface ChargingRecordGetListService {
    List<ChargingRecord> getList();
}
