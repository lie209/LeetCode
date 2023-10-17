package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;
import com.sun.security.auth.NTNumericCredential;

import java.util.*;

public class LC652 implements LeetCodeBase
{
    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root)
    {
        traversal(root);
        return result;

    }

    public String traversal(TreeNode root)
    {
        if(root==null) {
            return "#";
        }
        //加空格防止1 11 #和11 1 #这种情况
        String str=root.val+" "+traversal(root.left)+" "+traversal(root.right);
        //题目要求返回一颗子树即可

        if(map.containsKey(str)&&map.get(str)==1)
        {
            result.add(root);
            map.replace(str,map.get(str)+1);
        }
        if(!map.containsKey(str))
        {
            map.put(str,1);
        }
        return str;
    }

    @Override
    public void test()
    {
        int[] list=new int[]{1,2,3,4,-300,2,4,-300,-300,4};
//        TreeNode root=breadthFirstTrees(list);
//        System.out.println(breadthFirstTraverseString(root));
    }
}
