package com.charging_station.backend.controller.order;

import com.charging_station.backend.pojo.Orderlist;
import com.charging_station.backend.service.order.OrderlistGetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderGetListController {
    @Autowired
    private OrderlistGetListService orderListGetListService;

    @GetMapping("/orderlist/getlist/")
    public List<Orderlist> getList(){
        return orderListGetListService.getList();
    }
}
