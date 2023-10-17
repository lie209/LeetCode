package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;

public class LC106 implements LeetCodeBase
{
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        return buildTree(inorder,postorder,0,inorder.length-1,0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight)
    {
        if(inLeft>inRight||postLeft>postRight)
        {
            return null;
        }
        int rootVal = postorder[postRight];
        int rootIndex= Arrays.stream(inorder).boxed().toList().indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left=buildTree(inorder, postorder, inLeft, rootIndex-1, postLeft, postLeft+rootIndex-inLeft-1);
        root.right=buildTree(inorder, postorder, rootIndex+1, inRight, postLeft+rootIndex-inLeft, postRight-1);
        return root;
    }

    @Override
    public void test() {

    }
}
