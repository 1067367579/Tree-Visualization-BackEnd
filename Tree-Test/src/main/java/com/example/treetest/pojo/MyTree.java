package com.example.treetest.pojo;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
    }
}

public class MyTree {
    //根节点字段
    public TreeNode root;

    //构造函数
    public MyTree(String str)
    {
        //分割字符串
        String[] s = str.split("_");
        //字符串数组下标
        Integer []count = new Integer[1];
        count[0] = 0;
        root = createTree(s,count);
    }

    //根据字符串创建二叉树
    public TreeNode createTree(String[] s,Integer []count)
    {
        if("#".equals(s[count[0]]))
        {
            count[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s[count[0]]));
        count[0]++;
        root.left = createTree(s,count);
        root.right = createTree(s,count);
        return root;
    }

    //二叉树的前序遍历
    public void PreOrderTraverse(TreeNode t)
    {
         if(t == null)
        {
            return;
        }
        System.out.print(t.data+" ");
        PreOrderTraverse(t.left);
        PreOrderTraverse(t.right);
    }

    //二叉树图形化
    public void displayTree()
    {
        //确定二维数组的宽和高
        //由深度即可获取
        int width = 0;
        int height = 0;
        int depth = getDepth();
        int length = 1;
        //先获取最大连接线长度，通过深度可得
        for(int i=0;i<depth-2;i++)
        {
            length*=2;
            length++;
        }
        int len = length;

        for(int i=0;i<depth;i++)
        {
            if(i == 0)
            {
                width += 1;
                height += 1;
            }
            else
            {
                width += 2*(length+1);
                height += (length+1);
            }
            //连接线长度的递减从第2轮开始
            if(length>1&&i>=1)
            {
                length/=2;
            }
        }

        //先对s二维字符串数组进行初始化
        String[][] s = new String[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                s[i][j] = " ";
            }
        }

        //调用递归
        RecursiveShow(root,s,width/2,0,len);

        //获得s数组之后打印
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                System.out.print(s[i][j]);
            }
            System.out.println();
        }
    }

    //递归打印
    public void RecursiveShow(TreeNode t,String[][]s,int x,int y,int length)
    {
        //先判断是否为空
        if(t == null){return;}

        //不为空时，要打印，先打印当前节点
        s[y][x] = String.valueOf(t.data);

        //再打印左/右连接线,连接线长度每次递减2，直到为1

        //左的情况
        int i = 0;
        if(t.left!=null)
        {
            for(i = 1;i<=length;i++)
            {
                s[y+i][x-i] = "/";
            }
        }

        //左子树递归调用
        if(length>1)
        {
            RecursiveShow(t.left,s,x-i,y+i,length/2);
        }
        else
        {
            RecursiveShow(t.left,s,x-i,y+i,length);
        }

        //右的情况
        if(t.right!=null)
        {
            for(i = 1;i<=length;i++)
            {
                s[y+i][x+i] = "\\";
            }
        }

        //右子树递归调用
        if(length>1)
        {
            RecursiveShow(t.right,s,x+i,y+i,length/2);
        }
        else
        {
            RecursiveShow(t.right,s,x+i,y+i,length);
        }
    }

    //打印遍历结果
    public void display()
    {
        PreOrderTraverse(root);
    }

    //求树的深度，确定画板数组的大小
    public int getDepth()
    {
        int []max = new int[1];
        int depth = 1;
        RecursiveGetDepth(root,max,depth);
        return max[0];
    }

    //用递归方法求二叉树的深度
    public void RecursiveGetDepth(TreeNode t,int []max,int depth)
    {
        if(t == null)
        {
            return;
        }

        if(max[0]<depth)
        {
            max[0] = depth;
        }

        RecursiveGetDepth(t.left,max,depth+1);
        RecursiveGetDepth(t.right,max,depth+1);
    }
}
