package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.Node;
import LeetCode.Common.TreeNode;

//同LC538. Convert a doubly-linked list to a circular doubly-linked list
public class LC1038 implements LeetCodeBase
{
    //维护一个累加值
    int sum=0;
    public TreeNode bstToGst(TreeNode root)
    {
        traversal(root);
        return root;
    }

    public void traversal(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        traversal(node.right);
        sum=sum+node.val;
        node.val=sum;
        traversal(node.left);
        return;
    }
    @Override
    public void test()
    {

    }
}
