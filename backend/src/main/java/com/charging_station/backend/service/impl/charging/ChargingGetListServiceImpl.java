package com.charging_station.backend.service.impl.charging;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charging_station.backend.mapper.ChargingMapper;
import com.charging_station.backend.pojo.Charging;
import com.charging_station.backend.service.charging.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingGetListServiceImpl implements GetListService {
    @Autowired
    private ChargingMapper chargingMapper;

    @Override
    public List<Charging> getList() {
        QueryWrapper<Charging> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("charging_id");
        return chargingMapper.selectList(queryWrapper);
    }
}
