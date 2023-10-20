package com.example.treetest.mapper;

import com.example.treetest.pojo.TreeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeMapper {

    @Select("Select * from table_tree")
    public List<TreeList> list();
}
