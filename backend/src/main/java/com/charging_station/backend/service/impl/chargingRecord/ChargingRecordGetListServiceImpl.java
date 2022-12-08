package com.charging_station.backend.service.impl.chargingRecord;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charging_station.backend.mapper.ChargingRecordMapper;
import com.charging_station.backend.pojo.ChargingRecord;
import com.charging_station.backend.pojo.Orderlist;
import com.charging_station.backend.pojo.User;
import com.charging_station.backend.service.chargingRecord.ChargingRecordGetListService;
import com.charging_station.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingRecordGetListServiceImpl implements ChargingRecordGetListService {
    @Autowired
    private ChargingRecordMapper chargingRecordMapper;

    @Override
    public List<ChargingRecord> getList() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        if(user.getId()==1||user.getId()==2||user.getId()==3) {
            QueryWrapper<ChargingRecord> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByAsc("id");
            return chargingRecordMapper.selectList(queryWrapper);
        } else{
            QueryWrapper<ChargingRecord> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", user.getId());
            return chargingRecordMapper.selectList(queryWrapper);
        }
    }
}
