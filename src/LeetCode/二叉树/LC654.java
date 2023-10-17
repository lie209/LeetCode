package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.Arrays;

public class LC654 implements LeetCodeBase
{
    public TreeNode constructMaximumBinaryTree(int[] nums)
    {
        if(nums.length==0)
        {
            return null;
        }
        //数组中的最大值
        int max= Arrays.stream(nums).max().getAsInt();
        int index=Arrays.stream(nums).boxed().toList().indexOf(max);
        int[] arr1 = new int[index];
        int[] arr2 = new int[nums.length-1-index];
        System.arraycopy(nums, 0,arr1,0,index);
        System.arraycopy(nums, index+1,arr2,0,arr2.length);
        //构造左子树
        TreeNode root=new TreeNode(max);
        root.left=constructMaximumBinaryTree(arr1);
        root.right=constructMaximumBinaryTree(arr2);
        return root;


    }




    @Override
    public void test() {

    }
}
