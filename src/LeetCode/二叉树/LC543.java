package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

public class LC543 implements LeetCodeBase
{
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root)
    {
        traversal(root);
        return diameter;

    }
    public void traversal(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        int count=depthOfTreeLeft(root.left, 0)+depthOfTreeLeft(root.right, 0);
        System.out.println(count);
        diameter=Math.max(diameter,count);
        traversal(root.left);
        traversal(root.right);

        return ;
    }

    public int depthOfTreeLeft(TreeNode root,int depth)
    {
        if (root==null)
        {
            return depth;
        }
        int left=depthOfTreeLeft(root.left,depth+1);
        int right=depthOfTreeLeft(root.right,depth+1);
        return Math.max(left,right);
    }
    @Override
    public void test() {

    }
}
