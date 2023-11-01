package com.example.treetest.controller;

import com.example.treetest.pojo.Result;
import com.example.treetest.service.TreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TreeController {
    @Autowired
    private TreeService treeService;

    //响应数据给前端处理的controller
    //这里是用路径变量的方式进行传值
    @GetMapping("/treeData/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("获得ID为{}这颗树的前序遍历字符串",id);
        String treeStr = treeService.getById(id);
        //RestController带有responseBody注解，会返回JSON格式数据
        return Result.success(treeStr);
    }
}
