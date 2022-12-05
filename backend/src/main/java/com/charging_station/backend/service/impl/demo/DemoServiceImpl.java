package com.charging_station.backend.service.impl.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.charging_station.backend.mapper.ChargingMapper;
import com.charging_station.backend.pojo.Charging;
import com.charging_station.backend.service.demo.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private ChargingMapper chargingMapper;

    @Override
    public void demo() {
        Date date = new Date();
        long date_l = date.getTime();
        UpdateWrapper updateWrapper = new UpdateWrapper<>();
        updateWrapper.lt("lasting_time",date_l);
        updateWrapper.set("charging_state",0);
        chargingMapper.update(null, updateWrapper);

    }
}
