package com.example.treetest.controller;

import com.example.treetest.mapper.TreeMapper;
import com.example.treetest.pojo.MyTree;
import com.example.treetest.pojo.TreeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeMapper treeMapper;

    @GetMapping("/processTree")
    public String processTree() {
        List<TreeList> treeLists = treeMapper.list();
        for (TreeList treeInfo : treeLists) {
            TreeOperate(treeInfo.getPreorder_traversal_string());
        }
        return "success!";
    }

    public void TreeOperate(String treeInfo) {
        MyTree t = new MyTree(treeInfo);
        t.displayTree();
    }
}
