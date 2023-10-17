package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.Arrays;

public class LC889 implements LeetCodeBase
{
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder)
    {
        return buildTree(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,int preLeft,int preRight, int inLeft, int inRight)
    {
        if(preLeft > preRight||inLeft>preRight)
        {
            return null;
        }
        if(preLeft==preRight)
        {
            return new TreeNode(preorder[preLeft]);
        }
        if(inLeft==inRight)
        {
            return new TreeNode(inorder[inLeft]);
        }
        int rootVal = preorder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int index= Arrays.stream(inorder).boxed().toList().indexOf(preorder[preLeft+1]);
        int size=index-inLeft+1;
        root.left= buildTree(preorder,inorder,preLeft+1,preLeft+size,inLeft,index);
        root.right=buildTree(preorder,inorder,preLeft+size+1,preRight,index+1,inRight-1);
        return root;
    }
    //获得左子树长度
    @Override
    public void test() {

    }
}
