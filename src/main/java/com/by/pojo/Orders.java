package com.by.pojo;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Orders {

  private long oid;
  private long count;
  private double totalprice;
  private long uid;
  private long state;
  private Date createtime;
  private Date modiftime;

  private List<OrdersDetail> list;



}
