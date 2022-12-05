package com.charging_station.backend.service.impl.charging;

import com.charging_station.backend.mapper.ChargingMapper;
import com.charging_station.backend.pojo.Charging;
import com.charging_station.backend.pojo.User;
import com.charging_station.backend.service.charging.UpdateService;
import com.charging_station.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChargingUpdateServiceImpl implements UpdateService {

    @Autowired
    private ChargingMapper chargingMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int charging_id = Integer.parseInt(data.get("chargingId"));
        String chargingState = data.get("chargingState");
        String runningState = data.get("runningState");
        String address = data.get("address");

        Charging charging = new Charging();
        charging = chargingMapper.selectById(charging_id);

        Map<String,String> map = new HashMap<>();

        if(user.getId()!=1&&user.getId()!=2&&user.getId()!=3){
            map.put("error_message","权限不足");
            return map;
        }
        if(!chargingState.equals("1")&&!chargingState.equals("0")){
            map.put("error_message","请输入正确的充电状态");
            return map;
        }

        if(!runningState.equals("1")&&!runningState.equals("0")){
            map.put("error_message","请输入正确的运转状态");
            return map;
        }

        Charging new_charging = new Charging(
                charging_id,
                Integer.parseInt(chargingState),
                Integer.parseInt(runningState),
                address,
                charging.getLastingTime()
        );

        chargingMapper.updateById(new_charging);
        map.put("error_message","success");
        return map;
    }
}
