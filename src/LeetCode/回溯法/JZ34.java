package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class JZ34 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target)
    {
        if(root==null)
        {
            return result;
        }
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        dfs(root,target,root.val,list);
        return result;

    }

    public void dfs(TreeNode root, int target, int cur,List<Integer> list){
        if(cur==target&&root.left==null&&root.right==null)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        if(root.left!=null&&root.left.val+cur<=target)
        {
            list.add(root.left.val);
            dfs(root.left, target, cur+root.left.val,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null&&root.right.val+cur<=target)
        {
            list.add(root.right.val);
            dfs(root.right, target, cur+root.right.val,list);
            list.remove(list.size()-1);
        }
    }

    // 错误解法
    // 错误原因：
    // 1. 没有考虑根节点为空的情况)

    @Override
    public void test() {


    }
}
