package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;
import LeetCode.数据结构设计.TO35;
import com.sun.security.auth.NTNumericCredential;

public class LC450 implements LeetCodeBase
{


    public TreeNode deleteNode(TreeNode root, int key)
    {
        if(root==null)
        {
            return null;
        }
        if(key==root.val)
        {
            if(root.left==null && root.right==null)
            {
                return null;
            }
            if(root.right==null)
            {
                return root.left;
            }
            if(root.left==null)
            {
                return root.right;
            }
            TreeNode right=root.right;
            TreeNode left=root.left;
            TreeNode p=right;
            while (p.left!= null)
            {
                p=p.left;
            }
            p.left=left;
            root=root.right;
        }
        if(key>root.val)
        {

            root.right=deleteNode(root.right, key);
        }
        if(key<root.val)
        {
            root.left=deleteNode(root.left, key);
        }
        return root;
    }
    @Override
    public void test()
    {


    }
}
