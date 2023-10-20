package com.example.treetest.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeList {
    private Integer tree_id;
    private String preorder_traversal_string;
}
