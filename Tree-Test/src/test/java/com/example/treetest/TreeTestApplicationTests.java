package com.example.treetest;

import com.example.treetest.mapper.TreeMapper;
import com.example.treetest.pojo.MyTree;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TreeTestApplicationTests {

	@Autowired
	private TreeMapper treeMapper;
	@Test
	public void MyTreeTest()
	{
		Integer id = 1;
		String treeStr = treeMapper.getById(id);
		TreeOperate(treeStr);
	}

	public void TreeOperate(String treeInfo)
	{
		MyTree t = new MyTree(treeInfo);
//		t.display();
//		System.out.println();
		t.displayTree();
	}
}
