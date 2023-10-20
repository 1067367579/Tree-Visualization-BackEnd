package com.example.treetest.controller;

import com.example.treetest.mapper.TreeMapper;
import com.example.treetest.pojo.TreeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreeDataController {
    @Autowired
    private TreeMapper treeMapper;

    @GetMapping("/treeData")
    public String getTreeData() {
        System.out.println("Get TreeData!");
        List<TreeList> treeLists = treeMapper.list();
        String treeData = "";
        for (TreeList treeList : treeLists) {
            treeData = treeList.getPreorder_traversal_string();
        }
        return "{\"treeData\": \"" + treeData + "\"}";
    }
}
