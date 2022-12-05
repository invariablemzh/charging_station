package com.charging_station.backend.service.impl.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charging_station.backend.mapper.OrderlistMapper;
import com.charging_station.backend.pojo.Orderlist;
import com.charging_station.backend.pojo.User;
import com.charging_station.backend.service.impl.utils.UserDetailsImpl;
import com.charging_station.backend.service.order.OrderlistGetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderlistGetListServiceImpl implements OrderlistGetListService {

    @Autowired
    private OrderlistMapper orderListMapper;

    @Override
    public List<Orderlist> getList() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        QueryWrapper<Orderlist> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getId());

        return orderListMapper.selectList(queryWrapper);

    }
}
