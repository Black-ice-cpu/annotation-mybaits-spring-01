package com.by.controller;

import com.alibaba.fastjson.JSON;
import com.by.dao.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired
    OrdersMapper ordersMapper;
    @RequestMapping("hello.do")
    public Object hello(){
        return JSON.toJSONString(ordersMapper.getOrdersByOid(1L));
    }
    @RequestMapping("hello1.do")
    public Object hello1(){
        return JSON.toJSONString(ordersMapper.getOrderDetailtByOid(1L));
    }
}
