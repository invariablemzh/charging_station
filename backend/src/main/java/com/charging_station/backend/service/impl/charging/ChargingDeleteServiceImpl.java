package com.charging_station.backend.service.impl.charging;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charging_station.backend.mapper.ChargingMapper;
import com.charging_station.backend.pojo.Charging;
import com.charging_station.backend.pojo.User;
import com.charging_station.backend.service.charging.RemoveService;
import com.charging_station.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChargingDeleteServiceImpl implements RemoveService {
    @Autowired
    private ChargingMapper chargingMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int charging_id = Integer.parseInt(data.get("chargingId"));
        Map<String,String> map = new HashMap<>();

        if(user.getId()!=1&&user.getId()!=2&&user.getId()!=3){
            map.put("error_message","权限不足");
            return map;
        }

        QueryWrapper<Charging> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("charging_id",charging_id);
        if(!chargingMapper.exists(queryWrapper)){
            map.put("error_message","该充电桩已被删除");
        }

        chargingMapper.deleteById(charging_id);
        map.put("error_message","success");
        return map;
    }
}
