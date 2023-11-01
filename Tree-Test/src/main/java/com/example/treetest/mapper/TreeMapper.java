package com.example.treetest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TreeMapper {

    //根据ID来返回树的前序遍历字符串
    @Select("Select preorder_traversal_string from tree where tree_id=#{id}")
    public String getById(Integer id);
}
