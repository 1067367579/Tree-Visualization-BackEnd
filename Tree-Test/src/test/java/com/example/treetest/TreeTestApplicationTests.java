package com.example.treetest;

import com.example.treetest.mapper.TreeMapper;
import com.example.treetest.pojo.MyTree;
import com.example.treetest.pojo.TreeList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TreeTestApplicationTests {

	@Autowired
	private TreeMapper treeMapper;
	@Test
	public void MyTreeTest()
	{
		List<TreeList> treeLists = treeMapper.list();
		for (TreeList treeInfo : treeLists) {
			TreeOperate(treeInfo.getPreorder_traversal_string());
		}
	}

	public void TreeOperate(String treeInfo)
	{
		MyTree t = new MyTree(treeInfo);
//		t.display();
//		System.out.println();
		t.displayTree();
	}
}
