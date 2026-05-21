package com.project.second.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private Integer table_no;

    private String waiter;

    private List<OrderItemRequest> items;

    private boolean liquor_ordered;

    private boolean dissatisfied;

    private String restaurant_type;

    private Integer restaurant_id;

    private Integer branch_id;

}
