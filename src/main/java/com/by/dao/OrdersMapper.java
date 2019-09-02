package com.by.dao;

import com.by.pojo.Orders;
import com.by.pojo.OrdersDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Mapper接口
 *
 * @author ice
 */
public interface OrdersMapper {
    /**
     * 根据id查询
     *
     * @param oid
     * @return
     */
    @Select(" select a.*  from orders as a  where a.oid=#{oid} ")
    @Results(value = {
            @Result(column = "oid", property = "oid"),
            @Result(column = "count ", property = "count"),
            @Result(column = "totalprice", property = "totalprice"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "state", property = "state"),
            @Result(column = "createtime", property = "createtime"),
            @Result(column = "modiftime", property = "modiftime"),
            @Result(column = "oid", property = "list", many = @Many(select = "com.by.dao.OrdersMapper.getOrderDetailtByOid"))
    })
    Orders getOrdersByOid(long oid);


    /**
     * 子查询
     *
     * @param oid
     * @return
     */
    @Results(value = {
            @Result(column = "did", property = "did"),
            @Result(column = "num", property = "num"),
            @Result(column = "price", property = "price"),
            @Result(column = "oid", property = "oid"),
            @Result(column = "bid", property = "bid")
    })
    @Select("select * from ordersdetail where oid=#{oid}")
    List<OrdersDetail> getOrderDetailtByOid(long oid);
}
