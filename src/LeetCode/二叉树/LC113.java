package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;
import java.util.List;

public class LC113
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        backTrack(root,targetSum,0,new ArrayList<>());
        return result;
    }

    public void backTrack(TreeNode node,int taget,int cur,List<Integer> list)
    {
        if(node==null)
        {
            return;
        }
        cur=cur+node.val;
        if(node.left==null&&node.right==null&&cur==taget)
        {
            result.add(new ArrayList<>(list));
        }
        list.add(node.val);
        backTrack(node.left,taget,cur,list);
        backTrack(node.right,taget,cur,list);
        list.remove(list.size()-1);
    }
}
