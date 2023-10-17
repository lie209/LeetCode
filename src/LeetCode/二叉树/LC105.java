package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.Arrays;

public class LC105 implements LeetCodeBase
{

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return  buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft,int inRight)
    {
        if(preLeft>preRight||inLeft>inRight)
        {
            return null;
        }
        int rootVal=preorder[preLeft];
        //这一步实现了本次递归的操作，可以优化
        int rootIndex= Arrays.stream(inorder).boxed().toList().indexOf(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.left=buildTree(preorder,preLeft+1,preLeft+rootIndex-inLeft,inorder,inLeft,rootIndex-1);
        root.right=buildTree(preorder,preLeft+rootIndex-inLeft+1,preRight,inorder,rootIndex+1,inRight);
        return root;
    }

    @Override
    public void test() {

    }
}
