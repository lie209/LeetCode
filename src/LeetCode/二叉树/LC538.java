package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.Node;
import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC538 implements LeetCodeBase
{
    List<TreeNode> nodeList=new ArrayList<>();
    public TreeNode convertBST(TreeNode root)
    {
        traversal(root);

        for (int i = 1; i < nodeList.size(); i++)
        {
            nodeList.get(i).val=nodeList.get(i-1).val+nodeList.get(i).val;
        }
        return root;

    }

    public void traversal(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        traversal(node.right);
        nodeList.add(node);
        traversal(node.left);
    }
    @Override
    public void test() {

    }

}
