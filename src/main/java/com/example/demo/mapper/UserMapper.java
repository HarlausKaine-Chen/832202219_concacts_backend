package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import lombok.Getter;
import org.apache.ibatis.annotations.*;

import java.io.Reader;
import java.util.List;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/*
 * 1.使用@Mapper注解 ，代表这个接口被mybatis接管
 * 2.继承BaseMapper<属性类名>
 * */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
