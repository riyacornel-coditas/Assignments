package com.project.second.dtos;

import lombok.Data;

@Data
public class TableRequest {

    private Integer table_no;

    private String table_type;

    private Integer branch_id;

    private Integer restaurant_id;

    private Integer chef_id;
}
