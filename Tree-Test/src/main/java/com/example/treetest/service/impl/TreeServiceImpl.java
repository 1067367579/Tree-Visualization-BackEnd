package com.example.treetest.service.impl;

import com.example.treetest.mapper.TreeMapper;
import com.example.treetest.pojo.MyTree;
import com.example.treetest.service.TreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public String getById(Integer id) {

        String treeStr = treeMapper.getById(id);

        log.info("获取出来的字符串是：{}",treeStr);

        //同时在本地控制台打印
        TreeOperate(treeStr);

        return treeStr;
    }

    public void TreeOperate(String treeInfo) {
        MyTree t = new MyTree(treeInfo);
        t.displayTree();
    }
}
