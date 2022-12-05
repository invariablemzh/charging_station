package com.charging_station.backend;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
        //设置时间格式，为了 能转换成 字符串
        Date date = new Date();
        Long date_start = date.getTime();
        Long date_end = date_start + 60 * 1000;
        Date date_d = new Date(date_end);
        System.out.println(date);
        System.out.println(date_d);
    }

}
