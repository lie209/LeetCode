package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

public class LC104 implements LeetCodeBase
{
    int maxDepth=0;
    public int maxDepth(TreeNode root)
    {
        traversal(root, 1);
        return maxDepth;

    }
    public void traversal(TreeNode root, int level)
    {
        if (root == null)
            return;
        maxDepth=Math.max(maxDepth, level);
        traversal(root.right, level + 1);
        traversal(root.left, level + 1);
    }
    @Override
    public void test() {

    }
}
