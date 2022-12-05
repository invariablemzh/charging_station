package com.charging_station.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charging_station.backend.pojo.Charging;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChargingMapper extends BaseMapper<Charging> {

}
