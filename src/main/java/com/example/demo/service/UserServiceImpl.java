package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;
/*
 * 1.@Service--------使用@Service注解，让人知道这个是服务层
 * 2.extends ServiceImpl<UserMapper, User> ---继承和UserService类里面继承的方法一样，
 * 但是这里面还偷偷藏了UserService自定义的方法
 * 3.implements IUserService---实现接口
 * */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    //登录业务
    //登录校验业务
    //创建用户检查业务等等
}