package com.charging_station.backend.service.impl.charging;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charging_station.backend.mapper.ChargingMapper;
import com.charging_station.backend.mapper.OrderlistMapper;
import com.charging_station.backend.mapper.UserMapper;
import com.charging_station.backend.pojo.Charging;
import com.charging_station.backend.pojo.Orderlist;
import com.charging_station.backend.pojo.User;
import com.charging_station.backend.service.charging.UsingService;
import com.charging_station.backend.service.impl.utils.UserDetailsImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChargingUsingServiceImpl implements UsingService {
    @Autowired
    private ChargingMapper chargingMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderlistMapper orderlistMapper;

    @Override
    public Map<String, String> using(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int chargingId = Integer.parseInt(data.get("chargingId"));
        int runningState = Integer.parseInt(data.get("runningState"));
        int time = Integer.parseInt(data.get("time"));
        Double money = Double.parseDouble(data.get("money"));

        Charging charging = chargingMapper.selectById(chargingId);

        Map<String,String> map = new HashMap<>();
        Date date = new Date();
        Long date_start = date.getTime();
        Long date_end = date_start + time * 60 * 1000;
        Date date_d = new Date(date_end);
        Long date_last = (date_end - date_start) / 1000 / 60 ;

        if(date_start<charging.getLastingTime()){
            map.put("error_message","该充电桩正在使用");
            return map;
        }
        if(runningState==0){
            map.put("error_message","该充电桩故障，维修人员正在紧急维修");
            return map;
        }
        if(user.getMoney()<money){
            map.put("error_message","余额不足");
            return map;
        }
        if(time<=0){
            map.put("error_message","请输入正确的充电时长");
            return map;
        }
        if(time>1440){
            map.put("error_message","超过充电最大时长");
            return map;
        }

        Double value = user.getMoney() - money;
        BigDecimal bg = new BigDecimal(value);
        double f = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        User new_user = new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                f
        );
        userMapper.updateById(new_user);

        Charging new_charging = new Charging(
                chargingId,
                1,
                1,
                charging.getAddress(),
                date_end
        );
        chargingMapper.updateById(new_charging);

        Orderlist new_orderlist = new Orderlist(
                user.getId(),
                null,
                chargingId,
                date,
                date_d,
                date_last,
                "微信支付",
                money
        );
        orderlistMapper.insert(new_orderlist);

        map.put("error_message","success");
        return map;
    }
}
