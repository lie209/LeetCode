package LeetCode.Common;

import LeetCode.Base.LeetCodeBase;
import com.sun.source.tree.NewArrayTree;

import java.util.*;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //广度优先搜索构造二叉树
    //将一个数组还原成完全二叉树
    public static TreeNode breadthFirstTrees(int[] list)
    {
        LinkedList<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> integerQueue= new LinkedList<>();
        for (int i:list)
        {
            integerQueue.offer(new TreeNode(i));
        }
        TreeNode treeNode=integerQueue.poll();
        queue.offer(treeNode);
        while (!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(!integerQueue.isEmpty())
            {
                node.left=integerQueue.poll();
                queue.offer(node.left);
            }
            if(!integerQueue.isEmpty())
            {
                node.right=integerQueue.poll();
                queue.offer(node.right);
            }
        }
        return treeNode;
    }

    //层次遍历二叉树
    public static List<Integer> breadthFirstTraverseList(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<Integer> result=new ArrayList<>();
        while (!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(node!=null)
            {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }


        }
        return result;
    }

    public static String breadthFirstTraverseString(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        String result="";
        while (!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(node!=null)
            {
                result+=node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }


        }
        return result;
    }



    //前序遍历
    public static void preorderTraverse(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        System.out.println(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }



    public static void test() {
        int[] list={1,2,4,7,3,5,6,8};
        TreeNode node=breadthFirstTrees(list);
//        breadthFirstTraverse(node);
    }
}
