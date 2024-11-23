package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        @PostMapping("/upload")
    public Boolean uploadFile(@RequestParam("xlsxFile") MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            List<User> users = new ArrayList<>();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // 跳过标题行
                    continue;
                }

                User user = new User();
                // 假设 XLSX 文件的列顺序与 User 类的字段对应
                user.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
                user.setName(row.getCell(1).getStringCellValue());
                user.setPassword(row.getCell(2).getStringCellValue());
                user.setEmail(row.getCell(3).getStringCellValue());
                user.setSmh(row.getCell(4).getStringCellValue());
                user.setPa(row.getCell(5).getStringCellValue());
                user.setImportant(row.getCell(6).getStringCellValue());

                users.add(user);
            }

            // 保存用户到数据库
            return userService.saveAll(users);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
