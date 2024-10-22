package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

@Data
@Getter
@Setter
@TableName(value = "user")
public class User {
    @ApiModelProperty("用户的id")
    @TableId(value ="id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String name;
}
