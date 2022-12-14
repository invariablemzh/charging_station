package com.charging_station.backend.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Charging {
    @TableId(type = IdType.AUTO)
    private Integer chargingId;
    private Integer chargingState;
    private Integer runningState;
    private String address;
    private Long lastingTime;
}
