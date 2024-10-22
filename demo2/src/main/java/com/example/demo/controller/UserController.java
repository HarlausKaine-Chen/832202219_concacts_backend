package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping()
    public  List<User> findAll(){
        return userService.list();
    }
    //查询全部的数据

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.getById(id);
    }
    //根据id查询一条记录

    @PostMapping
    public  Boolean add(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //新增和修改

    @DeleteMapping("/{id}")
    public  Boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }
    //根据id删除一条记录

//    @PostMapping("/update")
//    public Boolean update(@RequestBody User user){
//        return userService.updateById(user);
//    }


}
