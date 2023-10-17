package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC101 implements LeetCodeBase
{

    List<String> sb=new ArrayList<>();
    public boolean isSymmetric(TreeNode root)
    {
        backTrack(root);
        System.out.println(sb);
        int i=0,j=sb.size()-1;
        while (i<=j)
        {
            if(!sb.get(i).equals(sb.get(j)))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    public void backTrack(TreeNode node)
    {
        if(node!=null&&node.left==null&&node.right==null)
        {
            sb.add(String.valueOf(node.val));
            return;
        }
        if(node==null)
        {
            sb.add("#");
            return;
        }
        backTrack(node.left);
        sb.add(String.valueOf(node.val));
        backTrack(node.right);
    }
    @Override
    public void test()
    {

    }
}
