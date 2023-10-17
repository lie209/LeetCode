package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

public class LC230 implements LeetCodeBase
{
    int count=0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root,k );
        return result;
    }

    public void traversal(TreeNode root,int k)
    {
        if(root==null||count>=k)
        {
            return;
        }
        traversal(root.left,k);
        if(count==k-1)
        {
            result=root.val;
            count++;
            return;
        }
        else
        {
            count++;
        }
        traversal(root.right,k);
        return;
    }
    @Override
    public void test() {

    }
}
