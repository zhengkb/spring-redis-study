package com.zkb.springredisstudy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("T_USER")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long uid;

    private String imei;
}
