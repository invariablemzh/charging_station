package com.charging_station.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charging_station.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface UserMapper extends BaseMapper<User> {


}
